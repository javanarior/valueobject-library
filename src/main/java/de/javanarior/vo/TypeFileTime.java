/*
 * Copyright (C) 2015 Sven von Pluto - javanarior (a) gmail dot com
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

import java.nio.file.attribute.FileTime;

import de.javanarior.utils.lang.reflect.Invoker;
import de.javanarior.vo.generator.TypeGenerator;
import de.javanarior.vo.types.FileTimeWrapper;
import de.javanarior.vo.types.Value;

/**
 * Factory to create Joda DateTime based Value Objects.
 */
public final class TypeFileTime {

    @SuppressWarnings("rawtypes")
    private static final Class<FileTimeWrapper> WRAPPER_CLASS = FileTimeWrapper.class;
    private static final Class<FileTime> TECHNICAL_TYPE = FileTime.class;

    private TypeFileTime() {
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
    public static <V extends Value<V, FileTime>> V create(Class<V> type, FileTime value) {
        Class<V> classObject = TypeGenerator.generate(type, TECHNICAL_TYPE, WRAPPER_CLASS);
        return invokeConstructor(classObject, assertNotNull(value));
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
    private static <V extends Value<V, FileTime>> V invokeConstructor(Class<V> objectClass, FileTime value) {
        return Invoker.invokeConstructor(objectClass, FileTime.class, value);
    }

}
