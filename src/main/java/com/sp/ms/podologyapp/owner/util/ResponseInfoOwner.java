package com.sp.ms.podologyapp.owner.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
public class ResponseInfoOwner<E> {
	
    @JsonInclude(Include.NON_NULL)
    private String responseCode;
    @JsonInclude(Include.NON_NULL)
    private String responseMessage;
    @JsonInclude(Include.NON_NULL)
    private E responseData;
}
