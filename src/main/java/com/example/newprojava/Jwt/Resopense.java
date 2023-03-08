package com.example.newprojava.Jwt;

import com.example.newprojava.pojo.User;
import lombok.Data;



@Data
public class Resopense {

    private int status;
    private String message;
    private int code;
    private String error;
    private com.example.newprojava.resClass.Data data;


    public Resopense(int status, String message, int code, String error) {
        this.status = status;
        this.message = message;
        this.code = code;
        this.error = error;

    }

    public Resopense() {

    }

    @Override
    public String toString() {
        return "Resopense{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", code=" + code +
                ", error='" + error + '\'' +
                ", data=" + data +
                '}';
    }
}

