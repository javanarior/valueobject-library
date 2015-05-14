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

import java.util.Date;

/**
 * Wrapper for java.util.Date values.
 *
 * @param <V>
 *            the value type
 */
public abstract class DateWrapper<V extends Value<V, Date>> extends AbstractValue<V, Date> {

    private final long value;

    /**
     * Create Date Type from Date value.
     *
     * @param value
     *            - value for the object
     */
    public DateWrapper(Date value) {
        super();
        this.value = assertNotNull(value).getTime();
    }

    @Override
    public Date getValue() {
        return new Date(value);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (int)(value ^ (value >>> 32));
        return result;
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
        DateWrapper<?> other = (DateWrapper<?>)obj;
        if (value != other.value) {
            return false;
        }
        return true;
    }

}
