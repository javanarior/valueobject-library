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

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Base class for value objects.
 *
 * @param <V>
 *            the value type
 * @param <T>
 *            the technical type to which the value type is mapped
 */
public abstract class AbstractValue<V extends Value<V, T>, T extends Comparable<T>> extends
                SpeakingComparableAdapter<V> implements Value<V, T> {

    @Override
    public abstract T getValue();

    @Override
    public int hashCode() {
        return 107 * getClass().hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean asPrimitiveBoolean() {
        return asBoolean().booleanValue();
    };

    @Override
    public byte asPrimitiveByte() {
        return asByte().byteValue();
    }

    @Override
    public short asPrimitiveShort() {
        return asShort().shortValue();
    }

    @Override
    public int asInt() {
        return asInteger().intValue();
    }

    @Override
    public long asPrimitiveLong() {
        return asLong().longValue();
    };

    @Override
    public double asPrimitiveDouble() {
        return asDouble().doubleValue();
    };

    @Override
    public Boolean asBoolean() {
        return Boolean.valueOf(asString());
    }

    @Override
    public Byte asByte() {
        return Byte.valueOf(asString());
    }

    @Override
    public Short asShort() {
        return Short.valueOf(asString());
    }

    @Override
    public Integer asInteger() {
        return Integer.valueOf(asString());
    }

    @Override
    public Long asLong() {
        return Long.valueOf(asString());
    }

    @Override
    public Double asDouble() {
        return Double.valueOf(asString());
    }

    @Override
    public String asString() {
        return String.valueOf(getValue());
    }

    @Override
    public BigInteger asBigInteger() {
        return BigInteger.valueOf(asPrimitiveLong());
    }

    @Override
    public BigDecimal asBigDecimal() {
        return BigDecimal.valueOf(asPrimitiveDouble());
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "=" + getValue();
    }

    @Override
    public int compareTo(V other) {
        return getValue().compareTo(other.getValue());
    }

}
