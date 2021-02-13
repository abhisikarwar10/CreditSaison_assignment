package com.example.assignment_abhishek.ControllerTest;

import com.example.assignment_abhishek.Model.VerifyCardRequestLog;
import com.example.assignment_abhishek.ResponseDTO.CardDetailsDTO;
import com.example.assignment_abhishek.ResponseDTO.CardDetailsPayloadDTO;
import com.example.assignment_abhishek.ResponseDTO.VerifyCardRequestLogDTO;
import com.example.assignment_abhishek.RestController.CardSchemeRESTController;
import com.example.assignment_abhishek.Service.CardSchemeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@WebMvcTest(CardSchemeRESTController.class)
public class CardSchemeRESTControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardSchemeService service;

    Logger logger = LoggerFactory.getLogger(CardSchemeRESTControllerTest.class);

    @Test
    public void verifyCardNumberTest() throws Exception{

        String cardNo="253633";
        logger.info("Performing verifyCardNumberTest inside CardDetailControllerTest");

        CardDetailsDTO dto = new CardDetailsDTO();
        dto.setSuccess(true);
        CardDetailsPayloadDTO payload=new CardDetailsPayloadDTO();
        payload.setBank("ABC");
        payload.setType("DEF");
        payload.setScheme("GHI");
        dto.setPayload(payload);


        String expectedOutput = "{\n" +
                "    \"success\": true,\n" +
                "    \"payload\": {\n" +
                "        \"scheme\": \"GHI\",\n" +
                "        \"type\": \"DEF\",\n" +
                "        \"bank\": \"ABC\"\n" +
                "    }\n" +
                "}";
        Mockito.when(service.verifyCardNumber(cardNo)).thenReturn(dto);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/card-scheme/verify/"+cardNo);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        JSONAssert.assertEquals(expectedOutput, mvcResult.getResponse().getContentAsString(), false);




    }

    @Test
    public void getCardLogDetailTest() throws Exception{

        int start = 0;
        int limit = 3;
        logger.info("Performing getCardLogDetailTest inside CardDetailControllerTest");

        VerifyCardRequestLogDTO dto = new VerifyCardRequestLogDTO();
        dto.setSuccess(true);
        dto.setStart(1);
        dto.setLimit(3);
        dto.setSize(1);
        Map<String, String> payload = new HashMap<>();
        payload.put("2234234", "22");
        dto.setPayload(payload);


        String expectedOutput = "{\n" +
                "    \"success\": true,\n" +
                "    \"start\": 1,\n" +
                "    \"limit\": 3,\n" +
                "    \"size\": 1,\n" +
                "    \"payload\": {\n" +
                "        \"2234234\": \"22\"\n" +
                "    }\n" +
                "}";
        Mockito.when(service.getCardsLogDetail(start,limit)).thenReturn(dto);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/card-scheme/stats?start="+start+"&limit="+limit);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        JSONAssert.assertEquals(expectedOutput, mvcResult.getResponse().getContentAsString(), false);



    }



}
