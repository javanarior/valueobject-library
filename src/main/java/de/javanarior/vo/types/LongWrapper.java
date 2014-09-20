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
 * Wrapper for Long values.
 *
 * @param <V>
 *            the value type
 */
public abstract class LongWrapper<V extends Value<V, Long>> extends AbstractValue<V, Long> {

    private final long value;

    /**
     * Create Long Type with long value.
     *
     * @param value
     *            - value for the object
     */
    public LongWrapper(long value) {
        super();
        this.value = value;
    }

    @Override
    public Long getValue() {
        return asLong();
    }

    @Override
    public int hashCode() {
        return (int)(31 * super.hashCode() + value);
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
        LongWrapper<?> other = (LongWrapper<?>)obj;
        if (value != other.value) {
            return false;
        }
        return true;
    }

    @Override
    public Long asLong() {
        return Long.valueOf(value);
    }

    @Override
    public long asPrimitiveLong() {
        return value;
    }

    @Override
    public int compareTo(V other) {
        return asLong().compareTo(other.getValue());
    }

}
