package com.example.assignment_abhishek.Service;

import com.example.assignment_abhishek.Exception.DataNotFoundException;
import com.example.assignment_abhishek.Exception.DatabaseException;
import com.example.assignment_abhishek.Model.VerifyCardRequestLog;
import com.example.assignment_abhishek.Repository.VerifyCardRequestLogRepo;
import com.example.assignment_abhishek.ResponseDTO.BinListResponseDTO;
import com.example.assignment_abhishek.ResponseDTO.CardDetailsDTO;
import com.example.assignment_abhishek.ResponseDTO.CardDetailsPayloadDTO;
import com.example.assignment_abhishek.ResponseDTO.VerifyCardRequestLogDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CardSchemeService {

    @Value("${binlist.url}")
    String binListURL;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    VerifyCardRequestLogRepo verifyCardRequestLogRepo;

    Logger logger = LoggerFactory.getLogger(CardSchemeService.class);

    public CardDetailsDTO verifyCardNumber(String cardNo) throws HttpStatusCodeException {
        ResponseEntity<BinListResponseDTO> response;
        BinListResponseDTO binListResponseDTO = null;
        logVerifyCardRequest(cardNo);
        logger.info("CardSchemeService.verifyCardNumber called for cardNo :{} ", cardNo);
        try {
            response = restTemplate.exchange(binListURL + cardNo, HttpMethod.GET, null, BinListResponseDTO.class);
            binListResponseDTO = response.getBody();
        } catch (HttpStatusCodeException e) {
            logger.error("API call to {}{} failed", binListURL, cardNo);
            throw e;
        }
        logger.info("Response recieved is : {}", binListResponseDTO.toString());
        return convertBinListApiResponseToCardDetails(binListResponseDTO);

    }


    /*
    Implemented pagination in order to reduce the query time
    and enhance performance as, in spite of fetching all the data,
    we only fetch a small chunk of data — amounting to less query time.

    Therefore i assumed start to be a page number as it was not specified
    in the assignment.

    Data will be fetched in descending order of page-hits as shown in the assignment.

     */
    public VerifyCardRequestLogDTO getCardsLogDetail(int start, int limit) throws DataNotFoundException,DatabaseException {
        Pageable pageRequest = PageRequest.of(start, limit);
        VerifyCardRequestLogDTO verifyCardRequestLogDTO=new VerifyCardRequestLogDTO();
        Page<Map<String, Object>> page = verifyCardRequestLogRepo.getVerifyCardRequestLogsCountGroupedByCardNumber(pageRequest);
        logger.info("CardSchemeService.getCardsLogDetail called for start :{} limit :{} ", start,limit);
        if(page==null){
            logger.error("CardSchemeService.getCardsLogDetail : Database connection error occurred");
            throw new DatabaseException();
        }else if(page.getSize()<1){
            logger.error("CardSchemeService.getCardsLogDetail : Data Not found for given values");
            throw new DataNotFoundException();
        }else{
            verifyCardRequestLogDTO.setStart(start);
            verifyCardRequestLogDTO.setLimit(limit);
            verifyCardRequestLogDTO.setSize(page.getTotalElements());
            Map<String, String> data = new ConcurrentHashMap<>();
            for(Map<String, Object> o:page){
                data.put(String.valueOf(o.get("cardNumber")), String.valueOf(o.get("count")));
            }
            verifyCardRequestLogDTO.setPayload(data);

        }

        return verifyCardRequestLogDTO;
    }

    public CardDetailsDTO convertBinListApiResponseToCardDetails(BinListResponseDTO binListResponseDTO) {
        CardDetailsDTO cardDetailsDTO = new CardDetailsDTO();
        logger.info("CardSchemeService.convertBinListApiResponseToCardDetails called binListResponseDTO{} ", binListResponseDTO);
        CardDetailsPayloadDTO cardDetailsPayloadDTO = new CardDetailsPayloadDTO();
        if (binListResponseDTO != null) {
            cardDetailsPayloadDTO.setScheme(binListResponseDTO.getScheme() == null ? "" : binListResponseDTO.getScheme());
            cardDetailsPayloadDTO.setBank(binListResponseDTO.getBank() == null ? "" : binListResponseDTO.getBank().getName());
            cardDetailsPayloadDTO.setType(binListResponseDTO.getType() == null ? "" : binListResponseDTO.getType());
            cardDetailsDTO.setSuccess(true);
            cardDetailsDTO.setPayload(cardDetailsPayloadDTO);

        }
        return cardDetailsDTO;
    }

    public void logVerifyCardRequest(String cardNo) {
        logger.info("CardSchemeService.logVerifyCardRequest called for card no: ", cardNo);
        VerifyCardRequestLog verifyCardRequestLog = new VerifyCardRequestLog();
        verifyCardRequestLog.setCardNumber(cardNo);
        verifyCardRequestLogRepo.save(verifyCardRequestLog);


    }
}
