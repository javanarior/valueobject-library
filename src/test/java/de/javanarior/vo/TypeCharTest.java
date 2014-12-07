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

import org.testng.Assert;
import org.testng.annotations.Test;

import de.javanarior.vo.generator.helper.CharType;

@Test
public class TypeCharTest {

    public void testCreateCharacter() {
        CharType value = TypeChar.create(CharType.class, Character.valueOf('A'));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Character.valueOf('A'));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateCharacterNull() {
        TypeChar.create(CharType.class, (Character)null);
    }

    public void testCreateChar() {
        CharType value = TypeChar.create(CharType.class, 'A');
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Character.valueOf('A'));
    }

}
