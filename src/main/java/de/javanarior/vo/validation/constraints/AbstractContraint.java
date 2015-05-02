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
 * Base class for default and custom {@link Constraint}s.
 */
public abstract class AbstractContraint<T extends Comparable<?>> implements Constraint<T> {

    private final String message;

    /**
     * Create a new AbstractContraint instance.
     */
    public AbstractContraint(String customerMessage) {
        this.message = customerMessage;
    }

    /**
     * Returns a message to use in the {@link ConstraintCheckResult}.
     * If a custom message is not provided, a default message will be generated.
     *
     * @return a failure message for the result
     */
    protected String getMessage() {
        if (message == null) {
            return "value violate " + contraintName();
        } else {
            return message;
        }
    }

    /**
     * Returns the simple class name of the constraint.
     *
     * @return name of constraint
     */
    protected String contraintName() {
        return getClass().getSimpleName();
    }

}
