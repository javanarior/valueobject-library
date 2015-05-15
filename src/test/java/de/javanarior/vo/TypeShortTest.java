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

import de.javanarior.vo.example.types.ShortType;
import de.javanarior.vo.types.NullObject;

@Test
public class TypeShortTest {

    public void testCreate() {
        ShortType value = TypeShort.create(ShortType.class, Short.valueOf("2"));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Short.valueOf("2"));
    }

    public void testValue() {
        ShortType value = TypeShort.value(ShortType.class, Short.valueOf("2"));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Short.valueOf("2"));
    }

    public void testValueNullSafe() {
        ShortType value = TypeShort.valueNullSafe(ShortType.class, Short.valueOf("2"));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Short.valueOf("2"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateNull() {
        TypeShort.create(ShortType.class, (Short)null);
    }

    public void testValueNull() {
        ShortType value = TypeShort.value(ShortType.class, (Short)null);
        Assert.assertNull(value);
    }

    public void testValueNullSafeNull() {
        ShortType value = TypeShort.valueNullSafe(ShortType.class, (Short)null);
        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof NullObject);
    }

    public void testCreatePrimitiveShort() {
        ShortType value = TypeShort.create(ShortType.class, (short)2);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Short.valueOf("2"));
    }

    public void testValuePrimitiveShort() {
        ShortType value = TypeShort.value(ShortType.class, (short)2);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Short.valueOf("2"));
    }

}
