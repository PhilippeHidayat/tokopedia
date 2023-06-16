package com.tokopedia.assignment.payloads.response;

public class MessageResponse {
    private Boolean result;
    private String message;
    
    public MessageResponse(Boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
}
