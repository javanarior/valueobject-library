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

import java.math.BigInteger;

import de.javanarior.utils.lang.reflect.Invoker;
import de.javanarior.vo.generator.TypeGenerator;
import de.javanarior.vo.types.BigIntegerWrapper;
import de.javanarior.vo.types.Value;

/**
 * Factory to create BigInteger based Value Objects.
 */
public class TypeBigInteger {

    @SuppressWarnings("rawtypes")
    private static final Class<BigIntegerWrapper> WRAPPER_CLASS = BigIntegerWrapper.class;
    private static final Class<BigInteger> TECHNICAL_TYPE = BigInteger.class;

    private TypeBigInteger() {
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
    public static <V extends Value<V, BigInteger>> V create(Class<V> type, BigInteger value) {
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
    public static <V extends Value<V, BigInteger>> V create(Class<V> type, int value) {
        return create(type, BigInteger.valueOf(value));
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
    public static <V extends Value<V, BigInteger>> V create(Class<V> type, Integer value) {
        return create(type, BigInteger.valueOf(assertNotNull(value).intValue()));
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
    public static <V extends Value<V, BigInteger>> V create(Class<V> type, long value) {
        return create(type, BigInteger.valueOf(value));
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
    public static <V extends Value<V, BigInteger>> V create(Class<V> type, Long value) {
        return create(type, BigInteger.valueOf((assertNotNull(value).longValue())));
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
    public static <V extends Value<V, BigInteger>> V create(Class<V> type, String value) {
        return create(type, new BigInteger(assertNotNull(value)));
    }

    private static <V extends Value<V, BigInteger>> V invokeConstructor(Class<V> objectClass, BigInteger value) {
        return Invoker.invokeConstructor(objectClass, TECHNICAL_TYPE, value);
    }

}
