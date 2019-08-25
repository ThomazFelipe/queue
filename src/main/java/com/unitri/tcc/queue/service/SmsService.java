package com.unitri.tcc.queue.service;

public interface SmsService {
    void sendTwilio(String message, String number);
}
