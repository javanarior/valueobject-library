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
package de.javanarior.vo.types;

/**
 * Generic Null Object.
 *
 * @param <V>
 *            the value type
 * @param <T>
 *            the technical type to which the value type is mapped
 */
public abstract class NullObject<V extends Value<V, T>, T extends Comparable<T>> extends AbstractValue<V, T> {

    @Override
    public int hashCode() {
        return 15077 + getClass().hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return true;
        }
        return super.equals(object);
    }

    @Override
    public int compareTo(V other) {
        throw new UnsupportedOperationException("Null Object are not comparable with other objects.");
    }

    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public T getValue() {
        return null;
    }

}
