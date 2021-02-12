package com.example.assignment_abhishek.Response;

import java.io.Serializable;
import java.util.Map;

public class VerifyCardRequestLogDTO implements Serializable {

    private static final long serialVersionUID = 7266499263545723L;

    private boolean success = false;

    private int start;

    private int limit;

    private long size;

    private Map<String, String> payload;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Map<String, String> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, String> payload) {
        this.payload = payload;
    }


}

