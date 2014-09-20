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
 * Wrapper for Short values.
 *
 * @param <V>
 *            the value type
 */
public abstract class ShortWrapper<V extends Value<V, Short>> extends AbstractValue<V, Short> {

    private final short value;

    /**
     * Create Short Type with short value.
     *
     * @param value
     *            - value for the object
     */
    public ShortWrapper(short value) {
        super();
        this.value = value;
    }

    @Override
    public Short getValue() {
        return asShort();
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + value;
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
        ShortWrapper<?> other = (ShortWrapper<?>)obj;
        if (value != other.value) {
            return false;
        }
        return true;
    }

    @Override
    public Short asShort() {
        return Short.valueOf(value);
    }

    @Override
    public short asPrimitiveShort() {
        return value;
    }

    @Override
    public int compareTo(V other) {
        return getValue().compareTo(other.getValue());
    }

}
