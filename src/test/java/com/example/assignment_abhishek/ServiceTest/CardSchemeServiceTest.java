package com.example.assignment_abhishek.ServiceTest;

import com.example.assignment_abhishek.Repository.VerifyCardRequestLogRepo;
import com.example.assignment_abhishek.ResponseDTO.BankDTO;
import com.example.assignment_abhishek.ResponseDTO.BinListResponseDTO;
import com.example.assignment_abhishek.ResponseDTO.CardDetailsDTO;
import com.example.assignment_abhishek.ResponseDTO.CardDetailsPayloadDTO;
import com.example.assignment_abhishek.Service.CardSchemeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;

@RunWith(MockitoJUnitRunner.class)
public class CardSchemeServiceTest {

    @Value("https://lookup.binlist.net/")
    String binListURL;

    @Mock
    private RestTemplate restTemplate;


    @InjectMocks
    @Spy
    private CardSchemeService cardSchemeService;


    @MockBean
    private VerifyCardRequestLogRepo verifyCardRequestLogRepo;

    @Test
    public void verifyCardNumberTest() throws HttpStatusCodeException{

        String cardNo="123";

        CardDetailsDTO expectedDto = new CardDetailsDTO();
        CardDetailsPayloadDTO payload = new CardDetailsPayloadDTO();
        payload.setBank("ABC");
        payload.setScheme("DEF");
        payload.setType("GHI");
        expectedDto.setPayload(payload);
        expectedDto.setSuccess(true);

        BinListResponseDTO binListResponse = new BinListResponseDTO();
        binListResponse.setScheme("DEF");
        BankDTO bank = new BankDTO();
        bank.setName("ABC");
        binListResponse.setBank(bank);
        binListResponse.setType("GHI");

        ResponseEntity<BinListResponseDTO> responseTest=new ResponseEntity<BinListResponseDTO>(binListResponse,HttpStatus.OK);

        doNothing().when(cardSchemeService).logVerifyCardRequest(cardNo);
        Mockito.when(restTemplate.exchange(binListURL + cardNo,HttpMethod.GET, null,BinListResponseDTO.class)).thenReturn(responseTest);
        CardDetailsDTO cardDetailsDTO= cardSchemeService.verifyCardNumber(cardNo);

        Assert.assertEquals(expectedDto.isSuccess(), cardDetailsDTO.isSuccess());
        Assert.assertEquals(expectedDto.getPayload().getBank(), cardDetailsDTO.getPayload().getBank());
        Assert.assertEquals(expectedDto.getPayload().getScheme(), cardDetailsDTO.getPayload().getScheme());
        Assert.assertEquals(expectedDto.getPayload().getType(), cardDetailsDTO.getPayload().getType());



    }

}
