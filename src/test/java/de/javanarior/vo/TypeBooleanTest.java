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

import de.javanarior.vo.example.types.BooleanType;
import de.javanarior.vo.types.NullObject;

@Test
public class TypeBooleanTest {

    public void testCreateBoolean() {
        BooleanType value = TypeBoolean.create(BooleanType.class, Boolean.TRUE);
        assertNotNull(value);
        assertEquals(value.getValue(), Boolean.TRUE);
    }

    public void testValueBoolean() {
        BooleanType value = TypeBoolean.value(BooleanType.class, Boolean.TRUE);
        assertNotNull(value);
        assertEquals(value.getValue(), Boolean.TRUE);
    }

    public void testValueNullSafeBoolean() {
        BooleanType value = TypeBoolean.valueNullSafe(BooleanType.class, Boolean.TRUE);
        assertNotNull(value);
        assertEquals(value.getValue(), Boolean.TRUE);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateBooleanNull() {
        TypeBoolean.create(BooleanType.class, (Boolean)null);
    }

    public void testValueBooleanNull() {
        BooleanType value = TypeBoolean.value(BooleanType.class, (Boolean)null);
        assertNull(value);
    }

    public void testValueNullSafeBooleanNull() {
        BooleanType value = TypeBoolean.valueNullSafe(BooleanType.class, (Boolean)null);
        assertNotNull(value);
        assertTrue(value instanceof NullObject);
    }

    public void testCreateBooleanPrimitive() {
        BooleanType value = TypeBoolean.create(BooleanType.class, true);
        assertNotNull(value);
        assertEquals(value.getValue(), Boolean.TRUE);
    }

    public void testValueBooleanPrimitive() {
        BooleanType value = TypeBoolean.value(BooleanType.class, true);
        assertNotNull(value);
        assertEquals(value.getValue(), Boolean.TRUE);
    }

    public void testNullValueString() {
        BooleanType value = TypeBoolean.create(BooleanType.class, "true");
        assertNotNull(value);
        assertEquals(value.getValue(), Boolean.TRUE);
    }

    // @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNullValueStringIllegal() {
        TypeBoolean.create(BooleanType.class, "trus");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNullValueStringNull() {
        TypeBoolean.create(BooleanType.class, (String)null);
    }

}
