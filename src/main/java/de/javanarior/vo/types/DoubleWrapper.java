/*
 * Copyright (C) 2014 Sven von Pluto - javanarior (a) gmail dot com
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
package de.javanarior.vo.types;

/**
 * Wrapper for Double values.
 *
 * @param <T>
 *            the value type
 */
public abstract class DoubleWrapper<T extends Value<T>> extends AbstractValue<T> {

    private final double value;

    /**
     * Create Double Type with double value.
     *
     * @param value
     *            - value for the object
     */
    public DoubleWrapper(double value) {
        super();
        this.value = value;
    }

    @Override
    public Object getValue() {
        return asDouble();
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(value);
        return 31 * super.hashCode() + (int)(temp ^ (temp >>> 32));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DoubleWrapper<?> other = (DoubleWrapper<?>)obj;
        if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value)) {
            return false;
        }
        return true;
    }

    @Override
    public Double asDouble() {
        return Double.valueOf(value);
    }

    @Override
    public double asPrimitiveDouble() {
        return value;
    }

    @Override
    public int compareTo(T other) {
        return asDouble().compareTo(other.asDouble());
    }

}
