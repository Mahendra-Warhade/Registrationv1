package com.api.Payload;

import java.util.Date;

public class ErroDto {

    private String massage;
    private Date date;
    private String uri;

    public ErroDto(String massage, Date date, String uri) {
        this.massage = massage;
        this.date = date;
        this.uri = uri;
    }

    public String getMassage() {
        return massage;
    }

    public Date getDate() {
        return date;
    }

    public String getUri() {
        return uri;
    }
}
