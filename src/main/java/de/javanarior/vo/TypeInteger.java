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
import de.javanarior.vo.types.IntWrapper;
import de.javanarior.vo.types.Value;

/**
 *.
 */
public class TypeInteger {

    @SuppressWarnings("rawtypes")
    private static final Class<IntWrapper> WRAPPER_CLASS = IntWrapper.class;
    private static final Class<? extends Comparable<?>> TECHNICAL_TYPE = Integer.TYPE;

    private TypeInteger() {
        /* Factory Class */
    }

    public static <V extends Value<V, Integer>> V create(Class<V> type, int value) {
        Class<V> generated = TypeGenerator.generate(type, TECHNICAL_TYPE, WRAPPER_CLASS);
        return invokeIntConstructor(generated, assertNotNull(value));
    }

    public static <V extends Value<V, Integer>> V create(Class<V> type, String value) {
        return create(type, Integer.valueOf(assertNotNull(value)));
    }

    public static <V extends Value<V, Integer>> V create(Class<V> type, Integer value) {
        return create(type, assertNotNull(value).intValue());
    }

    @SuppressWarnings("unchecked")
    private static <V extends Value<V, Integer>> V invokeIntConstructor(Class<V> objectClass, int value) {
        return (V)Invoker.invokeConstructor(objectClass, Integer.TYPE, value);
    }

}
