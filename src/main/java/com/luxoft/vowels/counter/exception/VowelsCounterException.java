package com.luxoft.vowels.counter.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VowelsCounterException extends RuntimeException {
    private static final long serialVersionUID = 1864279416517596302L;

    public VowelsCounterException(String message) {
        super(message);
    }
}
