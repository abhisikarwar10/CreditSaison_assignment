package com.example.assignment_abhishek.ResponseDTO;


import java.io.Serializable;

public class CardDetailsDTO implements Serializable {

    private static final long serialVersionUID = 23423475823572345L;

    private boolean success = false;

    private CardDetailsPayloadDTO payload;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public CardDetailsPayloadDTO getPayload() {
        return payload;
    }

    public void setPayload(CardDetailsPayloadDTO payload) {
        this.payload = payload;
    }

}
