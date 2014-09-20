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
 * Wrapper for Character values.
 *
 * @param <V>
 *            the value type
 */
public abstract class CharWrapper<V extends Value<V, Character>> extends AbstractValue<V, Character> {

    private final char value;

    /**
     * Create Character Type with char value.
     *
     * @param value
     *            - value for the object
     */
    public CharWrapper(char value) {
        super();
        this.value = value;
    }

    @Override
    public Object getValue() {
        return asCharacter();
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CharWrapper<?> other = (CharWrapper<?>)obj;
        if (value != other.value) {
            return false;
        }
        return true;
    }

    /**
     * Returns the value as primitive char.
     *
     * @return primitive char
     */
    public char asChar() {
        return value;
    }

    /**
     * Return the value as Character object.
     *
     * @return Character object
     */
    public Character asCharacter() {
        return Character.valueOf(value);
    }

    @Override
    public int compareTo(V other) {
        return asCharacter().compareTo((Character)other.getValue());
    }

}
