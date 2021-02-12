package com.example.assignment_abhishek.Controller;

import com.example.assignment_abhishek.Exception.DataNotFoundException;
import com.example.assignment_abhishek.Exception.DatabaseException;
import com.example.assignment_abhishek.ResponseDTO.CardDetailsDTO;
import com.example.assignment_abhishek.ResponseDTO.VerifyCardRequestLogDTO;
import com.example.assignment_abhishek.RestController.CardSchemeRESTController;
import com.example.assignment_abhishek.Service.CardSchemeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CardSchemeController {

    Logger logger = LoggerFactory.getLogger(CardSchemeRESTController.class);

    @Autowired
    private CardSchemeService cardSchemeService;

    @GetMapping("/verify/{cardNo}")
    public ModelAndView verifyCard(@PathVariable("cardNo") String cardNo) throws HttpStatusCodeException {
        ModelAndView mv=new ModelAndView();
        logger.info("CardSchemeController.verifyCardNumber called for Card number : {}",cardNo);
        CardDetailsDTO cardDetailsDTO =null;
        try {
            cardDetailsDTO = cardSchemeService.verifyCardNumber(cardNo);
        }
        catch(HttpStatusCodeException e){
            mv.addObject("errorStatusText",e.getStatusText());
            mv.addObject("errorStatusCode",e.getStatusCode());
            mv.setViewName("error");
            return mv;
        }
        mv.addObject("cardDetails",cardDetailsDTO);
        mv.setViewName("verify");
        return mv;
    }
    @GetMapping("/stats")
    public ModelAndView getCardStatistics(@RequestParam("start") int start,@RequestParam("limit") int limit)  throws DataNotFoundException, DatabaseException {
        ModelAndView mv=new ModelAndView();
        VerifyCardRequestLogDTO verifyCardRequestLogDTO=null;
        logger.info("CardSchemeRESTController.getCardLogDetail called for start : {} and limit : {}",start,limit);
        try {
            verifyCardRequestLogDTO = cardSchemeService.getCardsLogDetail(start, limit);
        }
        catch(DataNotFoundException e){
            mv.addObject("errorStatusText",e.getMessage());
            mv.addObject("errorStatusCode", HttpStatus.BAD_REQUEST);
            mv.setViewName("error");
            return mv;
        }catch(DatabaseException e){
            mv.addObject("errorStatusText",e.getMessage());
            mv.addObject("errorStatusCode", HttpStatus.BAD_GATEWAY);
            mv.setViewName("error");
            return mv;
        }
        int startIndex=((start)*limit)+1;
        int endIndex=((start+1)*limit) + limit;
        mv.addObject("startIndex",startIndex);
        mv.addObject("endIndex",endIndex);
        mv.addObject("totalSize",verifyCardRequestLogDTO.getSize());
        mv.addObject("verifyCardRequestLog",verifyCardRequestLogDTO.getPayload());
        mv.setViewName("stats");
        return mv;
    }
}
