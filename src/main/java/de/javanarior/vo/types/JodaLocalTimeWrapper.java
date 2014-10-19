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

import org.joda.time.LocalTime;


/**
 * Wrapper for Joda LocalTime values.
 *
 * @param <V>
 *            the value type
 */
public abstract class JodaLocalTimeWrapper<V extends Value<V, LocalTime>> extends
                AbstractValue<V, LocalTime> {

    private final LocalTime value;

    /**
     * Create LocalTime Type from LocalTime value.
     *
     * @param value
     *            - value for the object
     */
    public JodaLocalTimeWrapper(LocalTime value) {
        super();
        this.value = assertNotNull(value);
    }

    @Override
    public LocalTime getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        JodaLocalTimeWrapper<?> other = (JodaLocalTimeWrapper<?>)obj;
        if (!value.equals(other.value)) {
            return false;
        }
        return true;
    }

    @Override
    public String asString() {
        return value.toString();
    }

}
