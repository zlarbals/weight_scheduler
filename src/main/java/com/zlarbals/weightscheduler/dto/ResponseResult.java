package com.zlarbals.weightscheduler.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseResult<T> {

    private HttpStatus httpStatus;

    private T response;

}
