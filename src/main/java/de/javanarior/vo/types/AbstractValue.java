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
 * @param <T>
 *            the value type
 */
public abstract class AbstractValue<T extends Value<T>> implements Value<T> {

    private final Class<T> metaType;

    /**
     * Create a value type with {@code metaType}.
     *
     * @param metaType
     *            - the value type
     */
    protected AbstractValue(Class<T> metaType) {
        super();
        this.metaType = metaType;
    }

    @Override
    public abstract Object getValue();

    @Override
    public abstract int compareTo(T other);

    @Override
    public int hashCode() {
        return 107 * metaType.getName().hashCode();
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
        AbstractValue<?> other = (AbstractValue<?>)object;
        if (metaType == null) {
            if (other.metaType != null) {
                return false;
            }
        } else if (!metaType.equals(other.metaType)) {
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
    public char asChar() {
        throw new UnsupportedOperationException("Method asChar is only supported by CharWrapper.");
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
    public Character asCharacter() {
        throw new UnsupportedOperationException("Method asCharacter is only supported by CharWrapper.");
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
        return getClass().getSimpleName()+ "=" + getValue();
    }

    public Class<T> getMetaType() {
        return metaType;
    }

}
