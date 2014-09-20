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

import java.math.BigInteger;

/**
 * Wrapper for BigInteger values.
 *
 * @param <V>
 *            the value type
 */
public abstract class BigIntegerWrapper<V extends Value<V, BigInteger>> extends AbstractValue<V, BigInteger> {

    private final BigInteger value;

    /**
     * Create BigInteger Type from BigInteger value.
     *
     * @param value
     *            - value for the object
     */
    public BigIntegerWrapper(BigInteger value) {
        super();
        this.value = value;
    }

    @Override
    public BigInteger getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + value.hashCode();
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
        BigIntegerWrapper<?> other = (BigIntegerWrapper<?>)obj;
        if (value == null) {
            if (other.value != null) {
                return false;
            }
        } else if (!value.equals(other.value)) {
            return false;
        }
        return true;
    }

    @Override
    public BigInteger asBigInteger() {
        return value;
    }

    @Override
    public String asString() {
        return value.toString();
    }

    @Override
    public int compareTo(V other) {
        return getValue().compareTo(other.getValue());
    }

}
