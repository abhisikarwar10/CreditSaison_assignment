package com.example.assignment_abhishek.Response;


import java.io.Serializable;

public class CardDetails implements Serializable {

    private static final long serialVersionUID = 23423475823572345L;

    private boolean success = false;

    private CardDetailsPayload payload;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public CardDetailsPayload getPayload() {
        return payload;
    }

    public void setPayload(CardDetailsPayload payload) {
        this.payload = payload;
    }

}
