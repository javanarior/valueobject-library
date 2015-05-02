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
 * A {@link Constraint} which will always return {@link ConstraintCheckResult#SUCCESS}.
 */
public class NoOpConstraint<T extends Comparable<?>> implements Constraint<T> {

    @Override
    public ConstraintCheckResult check(T toValidate) {
        return ConstraintCheckResult.SUCCESS;
    }

}
