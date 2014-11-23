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

import de.javanarior.utils.lang.ByteCodeClassLoader;
import de.javanarior.utils.lang.ByteCodeContainer;
import de.javanarior.vo.generator.ByteCodeGenerator;
import de.javanarior.vo.generator.Generator;
import de.javanarior.vo.types.IntWrapper;
import de.javanarior.vo.types.Value;

/**
 * .
 */
public class TypeFactoryInteger2 {

    private static final ByteCodeGenerator BYTE_CODE_GENERATOR = new ByteCodeGenerator(Integer.TYPE, IntWrapper.class);
    private static final Generator GENERATOR = new Generator(Integer.TYPE, IntWrapper.class);

    /**
     * Create a new TypeInteger instance.
     */
    public TypeFactoryInteger2() {
        // TODO 15.11.2014: Auto-generated constructor stub
    }

    public <T> T create1(Class<T> valueType, int value) {
        ByteCodeContainer generated = BYTE_CODE_GENERATOR.generate(valueType);
        Class<T> typeClass = loadClass(generated);
        return invokeConstructor(typeClass, new Class[] { Integer.TYPE }, value);
    }

    /**
     * @param generated
     * @return
     */
    private <T> Class<T> loadClass(ByteCodeContainer generated) {
        return (Class<T>)ByteCodeClassLoader.getClassLoader().load(generated);
    }

    private <T> T invokeConstructor(Class<?> clazz, Class<?>[] parameterTypes, int value) {
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
