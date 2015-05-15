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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import de.javanarior.vo.example.types.StringType;
import de.javanarior.vo.types.NullObject;
import de.javanarior.vo.validation.constraints.NoOpConstraint;
import de.javanarior.vo.validation.constraints.NotNullConstraint;

@Test
public class TypeStringTest {

    public void testCreateBoolean() {
        StringType value = TypeString.create(StringType.class, true);
        assertNotNull(value);
        assertEquals(value.getValue(), "true");
    }

    public void testCreateByte() {
        StringType value = TypeString.create(StringType.class, (byte)1);
        assertNotNull(value);
        assertEquals(value.getValue(), "1");
    }

    public void testCreateChar() {
        StringType value = TypeString.create(StringType.class, 'A');
        assertNotNull(value);
        assertEquals(value.getValue(), "A");
    }

    public void testValueChar() {
        StringType value = TypeString.value(StringType.class, 'A');
        assertNotNull(value);
        assertEquals(value.getValue(), "A");
    }

    public void testCreateDouble() {
        StringType value = TypeString.create(StringType.class, 2.2);
        assertNotNull(value);
        assertEquals(value.getValue(), "2.2");
    }

    public void testCreateFloat() {
        StringType value = TypeString.create(StringType.class, (float)2.2);
        assertNotNull(value);
        assertEquals(value.getValue(), "2.2");
    }

    public void testCreateInt() {
        StringType value = TypeString.create(StringType.class, 2);
        assertNotNull(value);
        assertEquals(value.getValue(), "2");
    }

    public void testCreateLong() {
        StringType value = TypeString.create(StringType.class, 2L);
        assertNotNull(value);
        assertEquals(value.getValue(), "2");
    }

    public void testCreateObject() {
        StringType value = TypeString.create(StringType.class, new Object());
        assertNotNull(value);
        assertTrue(value.getValue().matches("java\\.lang\\.Object.*"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateObjectNull() {
        TypeString.create(StringType.class, (Object)null);
    }

    public void testCreateShort() {
        StringType value = TypeString.create(StringType.class, (short)2);
        assertNotNull(value);
        assertEquals(value.getValue(), "2");
    }

    public void testCreateString() {
        StringType value = TypeString.create(StringType.class, "testme");
        assertNotNull(value);
        assertEquals(value.getValue(), "testme");
    }

    public void testValueStringConstraint() {
        StringType value = TypeString.value(StringType.class, "testme", new NoOpConstraint<String>(),
                        new NotNullConstraint<String>());
        assertNotNull(value);
        assertEquals(value.getValue(), "testme");
    }

    public void testValueString() {
        StringType value = TypeString.value(StringType.class, "testme");
        assertNotNull(value);
        assertEquals(value.getValue(), "testme");
    }

    public void testValueNullSafeString() {
        StringType value = TypeString.valueNullSafe(StringType.class, "testme");
        assertNotNull(value);
        assertEquals(value.getValue(), "testme");
    }

    public void testCreateStringEmpty() {
        StringType value = TypeString.create(StringType.class, "");
        assertNotNull(value);
        assertEquals(value.getValue(), "");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateStringNull() {
        TypeString.create(StringType.class, (String)null);
    }

    public void testValueNull() {
        StringType value = TypeString.value(StringType.class, (String)null);
        assertNull(value);
    }

    public void testValueNullSafeNull() {
        StringType value = TypeString.valueNullSafe(StringType.class, (String)null);
        assertNotNull(value);
        assertTrue(value instanceof NullObject);
    }

}
