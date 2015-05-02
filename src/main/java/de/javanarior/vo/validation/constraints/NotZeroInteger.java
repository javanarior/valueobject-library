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
 * Reports a error if the Integer to check is not zero.
 */
public class NotZeroInteger extends AbstractContraint<Integer> {

    /**
     * Reports a error if the Integer to check is not zero.
     */
    public NotZeroInteger() {
        super(null);
    }

    /**
     * Reports a error if the Integer to check is not zero. The
     * {@code customMessage} is provided in the result in case of an error.
     *
     * @param customMessage
     *            - message to use for constraint violations.
     */
    public NotZeroInteger(String customMessage) {
        super(customMessage);
    }

    @Override
    public ConstraintCheckResult check(Integer toValidate) {
        if (toValidate.intValue() != 0) {
            return ConstraintCheckResult.SUCCESS;
        }
        return new ConstraintCheckResult(getMessage());
    }

}
