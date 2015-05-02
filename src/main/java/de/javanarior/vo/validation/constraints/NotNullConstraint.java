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
 * Reports a error if the {@link Comparable} is null.
 */
public class NotNullConstraint<T extends Comparable<?>> extends AbstractContraint<T> {

    /**
     * Reports a error if the {@link Comparable} is null.
     */
    public NotNullConstraint() {
        this(null);
    }

    /**
     * Reports a error if the {@link Comparable} is null.The
     * {@code customMessage} is provided in the result in case of an error.
     *
     * @param customMessage
     *            - message to use for constraint violations.
     */
    public NotNullConstraint(String customerMessage) {
        super(customerMessage);
    }

    @Override
    public ConstraintCheckResult check(T toValidate) {
        if (toValidate == null) {
            return new ConstraintCheckResult(getMessage());
        }
        return ConstraintCheckResult.SUCCESS;
    }

}
