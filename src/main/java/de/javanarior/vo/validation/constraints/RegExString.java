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

import java.util.regex.Pattern;

/**
 * Reports a error if the value does not match the regular expression.
 */
public class RegExString extends AbstractContraint<String> {

    private final Pattern regex;

    /**
     * Reports a error if the value does not match the regular expression.
     *
     * @param regularExpression
     *            - regular expression to use in check
     */
    public RegExString(String regularExpression) {
        super(null);
        this.regex = Pattern.compile(regularExpression);
    }

    /**
     * Reports a error if the value does not match the regular expression.
     *
     * @param regularExpression
     *            - regular expression to use in check
     * @param flags
     *            - match flags
     * @see Pattern#compile(String, int)
     */
    public RegExString(String regularExpression, int flags) {
        super(null);
        this.regex = Pattern.compile(regularExpression, flags);
    }

    /**
     * Reports a error if the value does not match the regular expression. The
     * {@code customMessage} is
     * provided in the result in case of an error.
     *
     * @param regularExpression
     *            - regular expression to use in check
     * @param customMessage
     *            - message to use for constraint violations.
     */
    public RegExString(String regularExpression, String customMessage) {
        super(customMessage);
        this.regex = Pattern.compile(regularExpression);
    }

    /**
     * Reports a error if the value does not match the regular expression. The
     * {@code customMessage} is
     * provided in the result in case of an error.
     *
     * @param regularExpression
     *            - regular expression to use in check
     * @param flags
     *            - match flags
     * @param customMessage
     *            - message to use for constraint violations.
     * @see Pattern#compile(String, int)
     */
    public RegExString(String regularExpression, int flags, String customMessage) {
        super(customMessage);
        this.regex = Pattern.compile(regularExpression, flags);
    }

    @Override
    public ConstraintCheckResult check(String toValidate) {
        if (regex.matcher(toValidate).matches()) {
            return ConstraintCheckResult.SUCCESS;
        }
        return new ConstraintCheckResult(getMessage());
    }

}
