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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import de.javanarior.vo.validation.constraints.ConstraintCheckResult;

/**
 * Result of Validation.
 */
public class ValidatorResult {

    private Set<ConstraintCheckResult> errors = new HashSet<>();
    private Throwable lastThrowable;
    private String lastMessage;
    private Comparable<?> lastValue;

    /**
     * @param checkResult
     */
    public void add(ConstraintCheckResult checkResult) {
        if (checkResult.hasErrors()) {
            lastThrowable = checkResult.getException();
            lastValue = checkResult.getValue();
            lastMessage = checkResult.getMessage();
            errors.add(checkResult);
        }
    }

    /**
     * @return
     */
    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    /**
     * @return
     */
    public Throwable getException() {
        return lastThrowable;
    }

    /**
     * @return
     */
    public String getMessage() {
        return lastMessage;
    }

    public Comparable<?> getValue() {
        return lastValue;
    }

    /**
     * All errors of Validation.
     *
     * @return errors of validation
     */
    public Set<ConstraintCheckResult> getErrors() {
        return Collections.unmodifiableSet(errors);
    }

}
