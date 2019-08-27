package com.unitri.tcc.queue.data.dto;

public class SmsData {

    private String number;
    private String message;
    private Long queuePosition;
    private Long eventId;
    private Long userPasswordNumber;

    public SmsData(String number, String message, Long queuePosition) {
        this.number = number;
        this.message = message;
        this.queuePosition = queuePosition;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getQueuePosition() {
        return queuePosition;
    }

    public void setQueuePosition(Long queuePosition) {
        this.queuePosition = queuePosition;
    }

    public Long getEventId() {
        return eventId;
    }

    public SmsData setEventId(Long eventId) {
        this.eventId = eventId;
        return this;
    }

    public Long getUserPasswordNumber() {
        return userPasswordNumber;
    }

    public SmsData setUserPasswordNumber(Long userPasswordNumber) {
        this.userPasswordNumber = userPasswordNumber;
        return this;
    }
}
