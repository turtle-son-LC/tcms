package org.edu.tcms.domain;

import lombok.Data;

@Data
public class ResultResponse {
    private Integer code;
    private String message;
    private Object data;

    public static ResultResponse success(Object data) {
        ResultResponse response = new ResultResponse();
        response.setCode(200);
        response.setMessage("SUCCESS");
        response.setData(data);
        return response;
    }

    public static ResultResponse badRequest(String message) {
        ResultResponse response = new ResultResponse();
        response.setCode(400);
        response.setMessage(message);
        return response;
    }
}
