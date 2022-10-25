package com.Himanshu.TTN.SpringRestApiExample.InternalizationandHateos;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavaController {
    private MessageSource messageSource;
    public JavaController(MessageSource messageSource){
        this.messageSource=messageSource;
    }
    @GetMapping("/hello")
    public String returnInternalization(){

       return messageSource.getMessage("good.morning.message",null,LocaleContextHolder.getLocale());

    }
}
