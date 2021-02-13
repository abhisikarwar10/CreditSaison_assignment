package com.example.assignment_abhishek.RestController;

import com.example.assignment_abhishek.Exception.DataNotFoundException;
import com.example.assignment_abhishek.Exception.DatabaseException;
import com.example.assignment_abhishek.Exception.InvalidPageOrLimitException;
import com.example.assignment_abhishek.ResponseDTO.CardDetailsDTO;
import com.example.assignment_abhishek.ResponseDTO.VerifyCardRequestLogDTO;
import com.example.assignment_abhishek.Service.CardSchemeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

@RestController
@RequestMapping("/card-scheme")
public class CardSchemeRESTController {

    Logger logger = LoggerFactory.getLogger(CardSchemeRESTController.class);


    @Autowired
    private CardSchemeService cardSchemeService;

    @GetMapping (value="/verify/{cardNo}",produces ="application/json")
    public ResponseEntity<?> verifyCardNumber(@PathVariable("cardNo") String cardNo) throws HttpStatusCodeException {
        logger.info("CardSchemeRESTController.verifyCardNumber called for Card number : {}",cardNo);
        CardDetailsDTO cardDetailsDTO =null;
        try {
            cardDetailsDTO = cardSchemeService.verifyCardNumber(cardNo);
        }
        catch(HttpStatusCodeException e){
            return new ResponseEntity(e.getStatusText(),e.getStatusCode());
        }
        return new ResponseEntity<CardDetailsDTO>(cardDetailsDTO, HttpStatus.OK);

    }
    @GetMapping(value="/stats",produces ="application/json")
    public ResponseEntity<?> getCardLogDetail(@RequestParam("start") int start, @RequestParam("limit") int limit) throws DataNotFoundException, DatabaseException {
        if(start<1 || limit<1){
            InvalidPageOrLimitException e=new InvalidPageOrLimitException();
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        logger.info("CardSchemeRESTController.getCardLogDetail called for start : {} and limit : {}",start,limit);
        VerifyCardRequestLogDTO verifyCardRequestLogDTO=null;
        try {
            verifyCardRequestLogDTO = cardSchemeService.getCardsLogDetail(start, limit);
        }
        catch(DataNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        catch(DatabaseException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<VerifyCardRequestLogDTO>(verifyCardRequestLogDTO,HttpStatus.OK);
    }
}
