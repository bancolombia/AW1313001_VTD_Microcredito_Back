package com.bancolombia.microcredito.domain.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseService implements Serializable {

    private static final long serialVersionUID = -8080481644749614741L;
    private String status;
    private Object output;
    private String detail;

    public ResponseService(Object output){
        this.output = output;
    }
}
