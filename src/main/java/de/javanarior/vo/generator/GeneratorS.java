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
package de.javanarior.vo.generator;

import de.javanarior.utils.lang.ByteCodeClassLoader;
import de.javanarior.utils.lang.ByteCodeContainer;
import de.javanarior.vo.types.AbstractValue;
import de.javanarior.vo.types.Value;

/**
 *
 */
public class GeneratorS {

    /**
     * Create a new Generator instance.
     */
    private GeneratorS() {
    }

    public static <V extends Value<V, T>, T extends Comparable<T>> Class<V> generateS(Class<V> type,
                    Class<? extends Comparable<?>> technicalType, Class<? extends AbstractValue> wrapperClass) {
        ByteCodeContainer generatedClass = ByteCodeGeneratorS.generate(type, technicalType, wrapperClass);
        return (Class<V>)ByteCodeClassLoader.getClassLoader().load(generatedClass);
    }
}
