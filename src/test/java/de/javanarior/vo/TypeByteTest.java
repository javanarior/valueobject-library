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

import de.javanarior.vo.example.types.ByteType;
import de.javanarior.vo.types.NullObject;

@Test
public class TypeByteTest {

    public void testCreateByte() {
        ByteType value = TypeByte.create(ByteType.class, Byte.valueOf("2"));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Byte.valueOf("2"));
    }

    public void testValueByte() {
        ByteType value = TypeByte.value(ByteType.class, Byte.valueOf("2"));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Byte.valueOf("2"));
    }
    public void testValueNullSafeCreateByte() {
        ByteType value = TypeByte.valueNullSafe(ByteType.class, Byte.valueOf("2"));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Byte.valueOf("2"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateByteNull() {
        TypeByte.create(ByteType.class, (Byte)null);
    }

    public void testValueByteNull() {
        ByteType value = TypeByte.value(ByteType.class, (Byte)null);
        assertNull(value);
    }

    public void testValueNullSafeByteNull() {
        ByteType value = TypeByte.valueNullSafe(ByteType.class, (Byte)null);
        assertNotNull(value);
        assertTrue(value instanceof NullObject);
    }

    public void testCreateBytePrimitive() {
        ByteType value = TypeByte.create(ByteType.class, (byte)2);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Byte.valueOf("2"));
    }

    public void testValueBytePrimitive() {
        ByteType value = TypeByte.value(ByteType.class, (byte)2);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Byte.valueOf("2"));
    }

    public void testCreateString() {
        ByteType value = TypeByte.create(ByteType.class, "2");
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Byte.valueOf("2"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateStringNull() {
        TypeByte.create(ByteType.class, (String)null);
    }

}
