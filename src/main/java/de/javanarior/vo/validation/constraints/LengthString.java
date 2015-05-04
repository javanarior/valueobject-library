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
 * Reports a error if the length of the value is shorter than or longer then the
 * specified
 * limits.
 */
public class LengthString extends AbstractContraint<String> {

    private final int min;
    private final int max;

    /**
     * Reports a error if the length of the value is not between including
     * {@code minimum} and
     * including {@code maximum}.
     *
     * @param minimum
     *            - minimum length of the value
     * @param maximum
     *            - maximum length of the value
     */
    public LengthString(int minimum, int maximum) {
        super(null);
        this.min = minimum;
        this.max = maximum;
    }

    /**
     * Reports a error if the length of the value is not between including
     * {@code minimum} and
     * including {@code maximum}. The {@code customMessage} is
     * provided in the result in case of an error.
     *
     * @param minimum
     *            - minimum length of the value
     * @param maximum
     *            - maximum length of the value
     * @param customMessage
     *            - message to use for constraint violations.
     */
    public LengthString(int minimum, int maximum, String customMessage) {
        super(customMessage);
        this.min = minimum;
        this.max = maximum;
    }

    @Override
    public ConstraintCheckResult check(String toValidate) {
        if (toValidate.length() >= min && toValidate.length() <= max) {
            return ConstraintCheckResult.SUCCESS;
        }
        return new ConstraintCheckResult(getMessage());
    }

}
