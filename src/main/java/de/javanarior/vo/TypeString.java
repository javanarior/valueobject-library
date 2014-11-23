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

/**
 *
 */
public class TypeString {

    @SuppressWarnings("rawtypes")
    private static final Class<StringWrapper> WRAPPER_CLASS = StringWrapper.class;
    private static final Class<? extends Comparable<?>> TECHNICAL_TYPE = String.class;

    private TypeString() {
        /* Factory Class */
    }

    public static <T extends Value<T, String>> T create(Class<T> type, String value) {
        Class<T> classObject = TypeGenerator.generate(type, TECHNICAL_TYPE, WRAPPER_CLASS);
        return invokeStringConstructor(classObject, assertNotNull(value));
    }

    public static <T extends Value<T, String>> T create(Class<T> type, Object value) {
        return create(type, AbstractValue.assertNotNull(value).toString());
    }

    public static <T extends Value<T, String>> T create(Class<T> type, boolean value) {
        return create(type, String.valueOf(value));
    }

    public static <T extends Value<T, String>> T create(Class<T> type, byte value) {
        return create(type, String.valueOf(value));
    }

    public static <T extends Value<T, String>> T create(Class<T> type, char value) {
        return create(type, String.valueOf(value));
    }

    public static <T extends Value<T, String>> T create(Class<T> type, double value) {
        return create(type, String.valueOf(value));
    }

    public static <T extends Value<T, String>> T create(Class<T> type, float value) {
        return create(type, String.valueOf(value));
    }

    public static <T extends Value<T, String>> T create(Class<T> type, int value) {
        return create(type, String.valueOf(value));
    }

    public static <T extends Value<T, String>> T create(Class<T> type, long value) {
        return create(type, String.valueOf(value));
    }

    public static <T extends Value<T, String>> T create(Class<T> type, short value) {
        return create(type, String.valueOf(value));
    }

    @SuppressWarnings("unchecked")
    private static <T extends Value<T, String>> T invokeStringConstructor(Class<T> objectClass, String value) {
        return (T)Invoker.invokeConstructor(objectClass, String.class, value);
    }
}
