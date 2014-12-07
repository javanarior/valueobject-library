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

import java.util.Date;

import de.javanarior.utils.lang.reflect.Invoker;
import de.javanarior.vo.generator.TypeGenerator;
import de.javanarior.vo.types.DateWrapper;
import de.javanarior.vo.types.Value;

/**
 * Factory to create Date based Value Objects.
 */
public class TypeDate {

    @SuppressWarnings("rawtypes")
    private static final Class<DateWrapper> WRAPPER_CLASS = DateWrapper.class;
    private static final Class<Date> TECHNICAL_TYPE = Date.class;

    private TypeDate() {
        /* Factory Class */
    }

    /**
     * Create value object with {@code type} and {@code value}.
     *
     * @param V
     *            - the value type
     * @param type
     *            - object type
     * @param value
     *            - value for the object
     * @return value object
     */
    public static <T extends Value<T, Date>> T create(Class<T> type, Date value) {
        Class<T> classObject = TypeGenerator.generate(type, TECHNICAL_TYPE, WRAPPER_CLASS);
        return invokeConstructor(classObject, assertNotNull(value));
    }

    /**
     * Create value object with {@code type} and {@code value}.
     *
     * @param V
     *            - the value type
     * @param type
     *            - object type
     * @param value
     *            - value for the object
     * @return value object
     */
    public static <T extends Value<T, Date>> T create(Class<T> type, long value) {
        return create(type, new Date(value));
    }

    /**
     * Create value object with {@code type} and {@code value}.
     *
     * @param V
     *            - the value type
     * @param type
     *            - object type
     * @param value
     *            - value for the object
     * @return value object
     */
    @SuppressWarnings("unchecked")
    private static <T extends Value<T, Date>> T invokeConstructor(Class<T> objectClass, Date value) {
        return (T)Invoker.invokeConstructor(objectClass, Date.class, value);
    }

}
