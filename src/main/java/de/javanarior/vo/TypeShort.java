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
import de.javanarior.utils.lang.reflect.Invoker;
import de.javanarior.vo.generator.TypeGenerator;
import de.javanarior.vo.types.ShortWrapper;
import de.javanarior.vo.types.Value;

/**
 * Factory to create Short based Value Objects.
 */
public class TypeShort {

    @SuppressWarnings("rawtypes")
    private static final Class<ShortWrapper> WRAPPER_CLASS = ShortWrapper.class;
    private static final Class<Short> TECHNICAL_TYPE = Short.TYPE;

    private TypeShort() {
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
    public static <V extends Value<V, Short>> V create(Class<V> type, Short value) {
        Class<V> generated = TypeGenerator.generate(type, TECHNICAL_TYPE, WRAPPER_CLASS);
        return invokeConstructor(generated, assertNotNull(value));
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
    public static <V extends Value<V, Short>> V create(Class<V> type, short value) {
        return create(type, Short.valueOf(value));
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
    public static <V extends Value<V, Short>> V create(Class<V> type, String value) {
        return create(type, Short.valueOf(assertNotNull(value)));
    }

    private static <V extends Value<V, Short>> V invokeConstructor(Class<V> objectClass, Short value) {
        return Invoker.invokeConstructor(objectClass, value);
    }

}
