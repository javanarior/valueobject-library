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
package de.javanarior.vo;

import static de.javanarior.vo.types.AbstractValue.assertNotNull;

import org.joda.time.LocalTime;

import de.javanarior.utils.lang.reflect.Invoker;
import de.javanarior.vo.generator.TypeGenerator;
import de.javanarior.vo.types.JodaLocalTimeWrapper;
import de.javanarior.vo.types.Value;

/**
 * Factory to create Joda LocalDateTime based Value Objects.
 */
public final class TypeJodaLocalTime {

    @SuppressWarnings("rawtypes")
    private static final Class<JodaLocalTimeWrapper> WRAPPER_CLASS = JodaLocalTimeWrapper.class;
    private static final Class<LocalTime> TECHNICAL_TYPE = LocalTime.class;

    private TypeJodaLocalTime() {
        /* Factory Class */
    }

    /**
     * Create value object with {@code type} and {@code value}.
     *
     * @param <V>
     *            - the value type
     * @param type
     *            - object type
     * @param value
     *            - value for the object
     * @return value object
     */
    public static <V extends Value<V, LocalTime>> V create(Class<V> type, LocalTime value) {
        Class<V> classObject = TypeGenerator.generate(type, TECHNICAL_TYPE, WRAPPER_CLASS);
        return invokeConstructor(classObject, assertNotNull(value));
    }

    /**
     * Create a Null Object of {@code type}.
     *
     * @param <V>
     *            - the value type
     * @param type
     *            - object type
     * @return null object of {@code type}
     */
    public static <V extends Value<V, LocalTime>> V create(Class<V> type) {
        return TypeNull.create(type, TECHNICAL_TYPE);
    }

    private static <V extends Value<V, LocalTime>> V invokeConstructor(Class<V> objectClass, LocalTime value) {
        return Invoker.invokeConstructor(objectClass, LocalTime.class, value);
    }

}
