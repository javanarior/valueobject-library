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

import java.math.BigDecimal;
import java.math.BigInteger;

import de.javanarior.utils.compare.SpeakingComparable;

/**
 * Description of value objects.
 *
 * @param <V>
 *            the value type
 * @param <T>
 *            the technical type to which the value type is mapped
 */
public interface Value<V extends Value<V, T>, T extends Comparable<T>> extends SpeakingComparable<V> {

    /**
     * Returns the value as Object.
     *
     * @return value as object
     */
    T getValue();

    /**
     * Returns true if the object is a null object.
     *
     * @return true if object is null, false otherwise
     */
    boolean isNull();

    /**
     * Returns the value as primitive boolean.
     *
     * @return primitive boolean
     */
    boolean asPrimitiveBoolean();

    /**
     * Returns the value as primitive short.
     *
     * @return primitive short
     */
    byte asPrimitiveByte();

    /**
     * Returns the value as primitive short.
     *
     * @return primitive short
     */
    short asPrimitiveShort();

    /**
     * Returns the value as primitive int.
     *
     * @return primitive int
     */
    int asInt();

    /**
     * Returns the value as primitive long.
     *
     * @return primitive long
     */
    long asPrimitiveLong();

    /**
     * Returns the value as primitive double.
     *
     * @return primitive double
     */
    double asPrimitiveDouble();

    /**
     * Return the value as Boolean object.
     *
     * @return Boolean object
     */
    Boolean asBoolean();

    /**
     * Return the value as Byte object.
     *
     * @return Byte object
     */
    Byte asByte();

    /**
     * Return the value as Short object.
     *
     * @return Short object
     */
    Short asShort();

    /**
     * Return the value as Integer object.
     *
     * @return Integer object
     */
    Integer asInteger();

    /**
     * Return the value as Long object.
     *
     * @return Long object
     */
    Long asLong();

    /**
     * Return the value as Double object.
     *
     * @return Double object
     */
    Double asDouble();

    /**
     * Return the value as String object.
     *
     * @return String object
     */
    String asString();

    /**
     * Return the value as BigInteger object.
     *
     * @return BigInteger object
     */
    BigInteger asBigInteger();

    /**
     * Return the value as BigDecimal object.
     *
     * @return BigDecimal object
     */
    BigDecimal asBigDecimal();

    @Override
    int compareTo(V other);

    @Override
    boolean equals(Object other);

    @Override
    int hashCode();

}
