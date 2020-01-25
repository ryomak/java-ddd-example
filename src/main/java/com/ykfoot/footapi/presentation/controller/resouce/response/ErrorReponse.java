package com.ykfoot.footapi.presentation.controller.resouce.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorReponse {
    private String errorCode;
    private String errorMessage;
}
