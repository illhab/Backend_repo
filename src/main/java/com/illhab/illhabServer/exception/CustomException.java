package com.illhab.illhabServer.exception;

import com.illhab.illhabServer.entity.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomException extends RuntimeException {

    ErrorCode errorCode;
}