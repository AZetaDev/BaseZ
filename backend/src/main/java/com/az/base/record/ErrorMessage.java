package com.az.base.record;

import java.time.LocalDateTime;

public record ErrorMessage(int status, String message, String errorCode, String errorDetails, String requestUri, LocalDateTime timestamp) {
}
