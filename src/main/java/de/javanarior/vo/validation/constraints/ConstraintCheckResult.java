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
package de.javanarior.vo.validation.constraints;


/**
 * Result of {@link Constraint#check(Comparable)}. A result could contain a
 * error
 * but does not have to. If the result has an error could be queried with
 * {@link #hasErrors()}.
 * In case of an error information about could be retrieved with
 * {@link #getMessage()}, {@link #getValue()} and {@link #getException()}. If a
 * information is not available the method will return null.
 */
public class ConstraintCheckResult {

    /**
     * A {@linkplain ConstraintCheckResult} which indicates Success.
     */
    public static final ConstraintCheckResult SUCCESS = new ConstraintCheckResult();

    private final String message;
    private final Comparable<?> valueObjecte;
    private final Throwable exception;

    /**
     * Create a ConstraintCheckResult which indicates a successful check.
     */
    private ConstraintCheckResult() {
        this(null, null, null);
    }

    /**
     * Create a ConstraintCheckResult which indicates a error.
     *
     * @param message
     *            - error message
     */
    public ConstraintCheckResult(String message) {
        this(message, null, null);
    }

    /**
     * Create a ConstraintCheckResult which indicates a error.
     *
     * @param message
     *            - error message
     * @param value
     *            - which cause the error
     */
    public ConstraintCheckResult(String message, Comparable<?> value) {
        this(message, value, null);
    }

    /**
     * Create a ConstraintCheckResult which indicates a error.
     *
     * @param message
     *            - error message
     * @param value
     *            - which cause the error
     * @param execption
     *            - which occur at validation
     */
    public ConstraintCheckResult(String message, Comparable<?> value, Throwable execption) {
        super();
        this.valueObjecte = value;
        this.message = message;
        this.exception = execption;
    }

    /**
     * Returns a message for the error. If no message if available
     * null will be returned.
     *
     * @return the message if available, null otherwise
     */
    public String getMessage() {
        return message;
    }

    /**
     * Returns the checked value. If the value is not available {@code null}
     * will be returned.
     *
     * @return the value to validate if available, null otherwise
     */
    public Comparable<?> getValue() {
        return valueObjecte;
    }

    /**
     * Returns a exception which occur at the check. If no exception happens
     * {@code null} will be returned.
     *
     * @return exception if available, null otherwise
     */
    public Throwable getException() {
        return exception;
    }

    /**
     * Return true if the result is a error.
     *
     * @return true if the result has a error, false otherwise
     */
    public boolean hasErrors() {
        return message != null;
    }

}
