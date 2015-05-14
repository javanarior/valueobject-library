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

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import de.javanarior.vo.example.types.CharType;
import de.javanarior.vo.types.NullObject;

@Test
public class TypeCharTest {

    public void testNullValueCharacter() {
        CharType value = TypeChar.create(CharType.class, Character.valueOf('A'));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Character.valueOf('A'));
    }

    public void testValueCharacter() {
        CharType value = TypeChar.value(CharType.class, Character.valueOf('A'));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Character.valueOf('A'));
    }

    public void testValueNullSafeCharacter() {
        CharType value = TypeChar.valueNullSafe(CharType.class, Character.valueOf('A'));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Character.valueOf('A'));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNullValueCharacterNull() {
        TypeChar.create(CharType.class, (Character)null);
    }

    public void testValueCharacterNull() {
        CharType value = TypeChar.value(CharType.class, (Character)null);
        assertNull(value);
    }

    public void testValueNullSafeCharacterNull() {
        CharType value = TypeChar.valueNullSafe(CharType.class, (Character)null);
        assertNotNull(value);
        assertTrue(value instanceof NullObject);
    }

    public void testNullValueChar() {
        CharType value = TypeChar.create(CharType.class, 'A');
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Character.valueOf('A'));
    }

    public void testValueChar() {
        CharType value = TypeChar.value(CharType.class, 'A');
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Character.valueOf('A'));
    }

}
