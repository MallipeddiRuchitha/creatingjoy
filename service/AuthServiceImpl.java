package com.technocrats.creatingjoy.service;

import com.technocrats.creatingjoy.config.TwilioConfig;
import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {


    private final TwilioConfig twilioConfig;

    @Autowired
    public AuthServiceImpl(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }

    @Override
    public Boolean sendToken(String to, String channel) {
        try {
            Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
            Verification verification = Verification.creator(twilioConfig.getPathServiceSid(), to, channel).create();
            log.info("Verification status {}", verification.getStatus());
            return true;
        } catch (Exception exception) {
            log.info("{}",to);
            log.info("{}",channel);
            log.info("{}",twilioConfig.getAccountSid());
            log.info("{}",twilioConfig.getAuthToken());
            log.info("{}",twilioConfig.getPathServiceSid());
            log.error(exception.getMessage());
            return false;
        }



    }

    @Override
    public Boolean verifyToken(String code, String to) {
        try {
            Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
            VerificationCheck verificationCheck = VerificationCheck.creator(twilioConfig.getPathServiceSid(), code).setTo(to).create();
            log.info("Verification Check status {}", verificationCheck.getStatus());
            if (verificationCheck.getStatus().equals("approved")) {
                return true;
            } else if (verificationCheck.getStatus().equals("pending")) {

                return false;
            } else {
                return false;
            }
        } catch (Exception exception) {
            log.error(exception.getMessage());
            return false;
        }
    }
}
