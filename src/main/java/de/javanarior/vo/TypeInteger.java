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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import de.javanarior.vo.generator.ByteCodeGenerator;
import de.javanarior.vo.generator.Generator;
import de.javanarior.vo.generator.GeneratorS;
import de.javanarior.vo.types.IntWrapper;
import de.javanarior.vo.types.Value;

/**
 *.
 */
public class TypeInteger {

    private static final ByteCodeGenerator BYTE_CODE_GENERATOR = new ByteCodeGenerator(Integer.TYPE, IntWrapper.class);
    private static final Generator GENERATOR = new Generator(Integer.TYPE, IntWrapper.class);

    /**
     * Create a new TypeInteger instance.
     */
    public TypeInteger() {
        // TODO 15.11.2014: Auto-generated constructor stub
    }

    public static <T extends Value<T, Integer>> T create(Class<T> type, int value) {
        // ByteCodeGenerator generator = new ByteCodeGenerator(clazz,
        // Integer.TYPE, IntWrapper.class);
        // return generator.generate().;
        Class<?> generated = GeneratorS.generateS(type, Integer.TYPE, IntWrapper.class);
        return invokeConstructor(generated, new Class[] { Integer.TYPE }, value);
    }

    public static <T extends Value<T, Integer>> T create(Class<T> type, String value) {
        // ByteCodeGenerator generator = new ByteCodeGenerator(clazz,
        // Integer.TYPE, IntWrapper.class);
        // return generator.generate().;
        return create(type, Integer.valueOf(value).intValue());
    }

//    public static <T extends Value<T, Integer>> T createG(Class<T> type, int value) {
//        Class<?> generated = GeneratorS.generate(type, Integer.TYPE, IntWrapper.class);
//        return invokeConstructor(generated, new Class[] { Integer.TYPE }, value);
//    }

    private static <T extends Value<T, Integer>> T invokeConstructor(Class<?> clazz,
                    Class<?>[] parameterTypes, int value) {
        Constructor<?> constructor;
        try {
            constructor = clazz.getConstructor(parameterTypes);
            return (T)constructor.newInstance(value);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | SecurityException
                        | IllegalArgumentException | InvocationTargetException exception) {
            // TODO Change RuntimeExpection
            throw new RuntimeException(exception);
        }
    }
}
