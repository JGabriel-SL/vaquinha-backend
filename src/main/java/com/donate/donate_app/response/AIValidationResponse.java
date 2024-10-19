package com.donate.donate_app.response;

public class AIValidationResponse {
    private String motive;
    private String validate;

    public AIValidationResponse() {}

    public AIValidationResponse(String motive, String validate) {
        this.motive = motive;
        this.validate = validate;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }
}
