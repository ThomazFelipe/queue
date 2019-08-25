package com.unitri.tcc.queue.service.impl;

import com.unitri.tcc.queue.service.SmsService;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsServiceImpl implements SmsService {

    private static final String TWILIO_ACCOUNT_SID = "AC44cba8b0f1daad15e7fcfd278c83806f";
    private static final String TWILIO_AUTH_TOKEN = "2dbe68a5177c48ba5b4181e6a99ccb26";
    private static final String TWILIO_NUMBER = "+15005550006";

    @Override
    public void sendTwilio(String message, String number){
        Twilio.init( TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN );

        Message msg = Message.creator( new PhoneNumber( number ),
                new PhoneNumber( TWILIO_NUMBER ),
                message ).create();

        System.out.println( msg.getSid() );
    }

}
