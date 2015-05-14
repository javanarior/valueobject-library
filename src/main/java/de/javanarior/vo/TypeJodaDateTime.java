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

import org.joda.time.DateTime;

import de.javanarior.utils.lang.reflect.Invoker;
import de.javanarior.vo.generator.TypeGenerator;
import de.javanarior.vo.types.JodaDateTimeWrapper;
import de.javanarior.vo.types.Value;

/**
 * Factory to create Joda DateTime based Value Objects.
 */
public final class TypeJodaDateTime {

    @SuppressWarnings("rawtypes")
    private static final Class<JodaDateTimeWrapper> WRAPPER_CLASS = JodaDateTimeWrapper.class;
    private static final Class<DateTime> TECHNICAL_TYPE = DateTime.class;

    private TypeJodaDateTime() {
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
    @Deprecated
    public static <V extends Value<V, DateTime>> V create(Class<V> type, DateTime value) {
        Class<V> classObject = TypeGenerator.generate(type, TECHNICAL_TYPE, WRAPPER_CLASS);
        return invokeConstructor(classObject, assertNotNull(value));
    }

    /**
     * Create value object of {@code type} with {@code value}. If {@code value}
     * is {@code null}, {@code null} will be returned.
     *
     * @param <V>
     *            - the value type
     * @param type
     *            - object type
     * @param value
     *            - value for the object
     * @return value object or {@code null} if {@code value} is {@code null}
     */
    public static <V extends Value<V, DateTime>> V value(Class<V> type, DateTime value) {
        if (value == null) {
            return null;
        }
        Class<V> classObject = TypeGenerator.generate(type, TECHNICAL_TYPE, WRAPPER_CLASS);
        return invokeConstructor(classObject, assertNotNull(value));
    }

    /**
     * Create value object of {@code type} with {@code value}. If {@code value}
     * is {@code null} a Null Object will be returned.
     *
     * @param <V>
     *            - the value type
     * @param type
     *            - object type
     * @param value
     *            - value for the object
     * @return value object or null object if {@code value} is {@code null}
     * @see TypeJodaDateTime#nullValue(Class)
     */
    public static <V extends Value<V, DateTime>> V valueNullSafe(Class<V> type, DateTime value) {
        if (value == null) {
            return nullValue(type);
        }
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
    public static <V extends Value<V, DateTime>> V nullValue(Class<V> type) {
        return TypeNull.create(type, TECHNICAL_TYPE);
    }

    private static <V extends Value<V, DateTime>> V invokeConstructor(Class<V> objectClass, DateTime value) {
        return Invoker.invokeConstructor(objectClass, DateTime.class, value);
    }

}
