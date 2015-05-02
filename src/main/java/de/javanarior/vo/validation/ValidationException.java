/*
 * Copyright (C) 2015 Sven von Pluto - javanarior (a) gmail dot com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.javanarior.vo.validation;


/**
 * Indicates a failure at validation.
 */
public class ValidationException extends RuntimeException {

    /**
     * Indicates a failure at validation.
     * You should check if the result has errors before create a validation
     * exception.
     *
     * @param result
     *            - validation result from a which a validation exception should
     *            be created.
     */
    public ValidationException(ValidatorResult result) {
        this(result.getMessage(), result.getException());
    }

    private ValidationException() {
        super();
    }

    private ValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    private ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    private ValidationException(String message) {
        super(message);
    }

    private ValidationException(Throwable cause) {
        super(cause);
    }

}
