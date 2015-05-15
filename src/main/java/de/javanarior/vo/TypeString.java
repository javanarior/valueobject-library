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
import de.javanarior.vo.types.AbstractValue;
import de.javanarior.vo.types.StringWrapper;
import de.javanarior.vo.types.Value;
import de.javanarior.vo.validation.ValidationException;
import de.javanarior.vo.validation.Validator;
import de.javanarior.vo.validation.ValidatorFactory;
import de.javanarior.vo.validation.ValidatorResult;
import de.javanarior.vo.validation.constraints.Constraint;

/**
 * Factory to create String based Value Objects.
 */
public final class TypeString {

    @SuppressWarnings("rawtypes")
    private static final Class<StringWrapper> WRAPPER_CLASS = StringWrapper.class;
    private static final Class<String> TECHNICAL_TYPE = String.class;

    private TypeString() {
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
    public static <V extends Value<V, String>> V create(Class<V> type, String value) {
        Class<V> classObject = TypeGenerator.generate(type, TECHNICAL_TYPE, WRAPPER_CLASS);
        return invokeConstructor(classObject, assertNotNull(value));
    }

    @SafeVarargs
    public static <V extends Value<V, String>> V value(Class<V> type, String value,
                    Constraint<String>... constraints) {
        Validator<String> validator = ValidatorFactory.create(constraints);
        ValidatorResult result = validator.validate(value);
        if (result.hasErrors()) {
            throw new ValidationException(result);
        }
        if (value == null) {
            return null;
        }
        Class<V> classObject = TypeGenerator.generate(type, TECHNICAL_TYPE, WRAPPER_CLASS);
        return invokeConstructor(classObject, value);
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
    public static <V extends Value<V, String>> V value(Class<V> type, String value) {
        if (value == null) {
            return null;
        }
        Class<V> classObject = TypeGenerator.generate(type, TECHNICAL_TYPE, WRAPPER_CLASS);
        return invokeConstructor(classObject, value);
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
     * @see TypeString#nullValue(Class)
     */
    public static <V extends Value<V, String>> V valueNullSafe(Class<V> type, String value) {
        if (value == null) {
            return nullValue(type);
        }
        Class<V> classObject = TypeGenerator.generate(type, TECHNICAL_TYPE, WRAPPER_CLASS);
        return invokeConstructor(classObject, value);
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
    public static <V extends Value<V, String>> V create(Class<V> type, Object value) {
        return create(type, AbstractValue.assertNotNull(value).toString());
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
    public static <V extends Value<V, String>> V create(Class<V> type, boolean value) {
        return create(type, String.valueOf(value));
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
    public static <V extends Value<V, String>> V create(Class<V> type, byte value) {
        return create(type, String.valueOf(value));
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
    public static <V extends Value<V, String>> V create(Class<V> type, char value) {
        return create(type, String.valueOf(value));
    }

    /**
     * Create value object of {@code type} with {@code value}.
     *
     * @param <V>
     *            - the value type
     * @param type
     *            - object type
     * @param value
     *            - value for the object
     * @return value object
     */
    public static <V extends Value<V, String>> V value(Class<V> type, char value) {
        return create(type, String.valueOf(value));
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
    public static <V extends Value<V, String>> V create(Class<V> type, double value) {
        return create(type, String.valueOf(value));
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
    public static <V extends Value<V, String>> V create(Class<V> type, float value) {
        return create(type, String.valueOf(value));
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
    public static <V extends Value<V, String>> V create(Class<V> type, int value) {
        return create(type, String.valueOf(value));
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
    public static <V extends Value<V, String>> V create(Class<V> type, long value) {
        return create(type, String.valueOf(value));
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
    public static <V extends Value<V, String>> V create(Class<V> type, short value) {
        return create(type, String.valueOf(value));
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
    public static <V extends Value<V, String>> V nullValue(Class<V> type) {
        return TypeNull.create(type, TECHNICAL_TYPE);
    }

    private static <V extends Value<V, String>> V invokeConstructor(Class<V> objectClass, String value) {
        return Invoker.invokeConstructor(objectClass, String.class, value);
    }

}
