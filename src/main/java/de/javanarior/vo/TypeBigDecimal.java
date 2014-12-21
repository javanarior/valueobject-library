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

import java.math.BigDecimal;
import java.math.BigInteger;

import de.javanarior.utils.lang.reflect.Invoker;
import de.javanarior.vo.generator.TypeGenerator;
import de.javanarior.vo.types.BigDecimalWrapper;
import de.javanarior.vo.types.Value;

/**
 * Factory to create BigDecimal based Value Objects.
 * Due to the unpredictable results of {@link BigDecimal#BigDecimal(double)}
 * there is no
 * factory method to create BigDecimals from double values.
 */
public final class TypeBigDecimal {

    @SuppressWarnings("rawtypes")
    private static final Class<BigDecimalWrapper> WRAPPER_CLASS = BigDecimalWrapper.class;
    private static final Class<BigDecimal> TECHNICAL_TYPE = BigDecimal.class;

    private TypeBigDecimal() {
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
    public static <V extends Value<V, BigDecimal>> V create(Class<V> type, BigDecimal value) {
        Class<V> generated = TypeGenerator.generate(type, TECHNICAL_TYPE, WRAPPER_CLASS);
        return invokeConstructor(generated, assertNotNull(value));
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
    public static <V extends Value<V, BigDecimal>> V create(Class<V> type, BigInteger value) {
        Class<V> generated = TypeGenerator.generate(type, TECHNICAL_TYPE, WRAPPER_CLASS);
        return invokeConstructor(generated, new BigDecimal(assertNotNull(value)));
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
    public static <V extends Value<V, BigDecimal>> V create(Class<V> type, int value) {
        return create(type, new BigDecimal(value));
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
    public static <V extends Value<V, BigDecimal>> V create(Class<V> type, Integer value) {
        return create(type, new BigDecimal(assertNotNull(value).intValue()));
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
    public static <V extends Value<V, BigDecimal>> V create(Class<V> type, long value) {
        return create(type, BigDecimal.valueOf(value));
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
    public static <V extends Value<V, BigDecimal>> V create(Class<V> type, Long value) {
        return create(type, new BigDecimal(assertNotNull(value).longValue()));
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
    public static <V extends Value<V, BigDecimal>> V create(Class<V> type, String value) {
        return create(type, new BigDecimal(assertNotNull(value)));
    }

    private static <V extends Value<V, BigDecimal>> V invokeConstructor(Class<V> objectClass, BigDecimal value) {
        return Invoker.invokeConstructor(objectClass, TECHNICAL_TYPE, value);
    }

}
