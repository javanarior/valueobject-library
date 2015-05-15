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

import de.javanarior.vo.validation.constraints.Constraint;

/**
 * Default Validator for Value Objects.
 * This Validator uses {@link Constraint}s to validate values.
 */
class ConstraintValidator<T extends Comparable<T>> implements Validator<T> {

    private Constraint<T>[] constraints;

    ConstraintValidator(Constraint<T>[] constraints) {
        this.constraints = constraints;
    }

    @Override
    public ValidatorResult validate(T value) {
        ValidatorResult result = new ValidatorResult();
        for (Constraint<T> constraint : constraints) {
            result.add(constraint.check(value));
        }
        return result;
    }

}
