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
 * Defines a constraint which must be fulfilled by a value.
 * If the constraint is fulfilled simple return a
 * {@link ConstraintCheckResult#SUCCESS}. To indicating a error provide at least
 * a message with the result. The
 * message, or exceptions if available, could be retrieved from the
 * {@linkplain ValidationException}.
 */
public interface Constraint<T extends Comparable<?>> {

    /**
     * Check the {@code toValidate}.
     *
     * If the constraint is fulfilled return {@link ConstraintCheckResult#SUCCESS}.
     * To report errors create ConstraintCheckResult and provide and least a message.
     * Implementors of this method have not to return {@code null}.
     *
     * @param toValidate
     *            - value to check
     * @return result of the check
     */
    ConstraintCheckResult check(T toValidate);

}
