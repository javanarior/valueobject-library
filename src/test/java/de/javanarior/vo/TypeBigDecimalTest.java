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

import java.math.BigDecimal;
import java.math.BigInteger;

import org.testng.Assert;
import org.testng.annotations.Test;

import de.javanarior.vo.example.types.BigDecimalType;
import de.javanarior.vo.types.NullObject;

@Test
public class TypeBigDecimalTest {

    public void testCreate() {
        BigDecimalType value = TypeBigDecimal.create(BigDecimalType.class, new BigDecimal(2.2));
        assertNotNull(value);
        assertEquals(value.getValue(), new BigDecimal(2.2));
    }

    public void testValue() {
        BigDecimalType value = TypeBigDecimal.value(BigDecimalType.class, new BigDecimal(2.2));
        assertNotNull(value);
        assertEquals(value.getValue(), new BigDecimal(2.2));
    }

    public void testValueNullSafe() {
        BigDecimalType value = TypeBigDecimal.valueNullSafe(BigDecimalType.class, new BigDecimal(2.2));
        assertNotNull(value);
        assertEquals(value.getValue(), new BigDecimal(2.2));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNullValueBigDecimalNull() {
        TypeBigDecimal.create(BigDecimalType.class, (BigDecimal)null);
    }

    public void testValueNull() {
        BigDecimalType value = TypeBigDecimal.value(BigDecimalType.class, (BigDecimal)null);
        assertNull(value);
    }

    public void testValueNullSafeNull() {
        BigDecimalType value = TypeBigDecimal.valueNullSafe(BigDecimalType.class, (BigDecimal)null);
        assertNotNull(value);
        assertTrue(value instanceof NullObject);
    }

    public void testNullValueBigInteger() {
        BigDecimalType value = TypeBigDecimal.create(BigDecimalType.class, new BigInteger("2"));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), new BigDecimal("2"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNullValueBigIntegerNull() {
        TypeBigDecimal.create(BigDecimalType.class, (BigInteger)null);
    }

    public void testNullValueInteger() {
        BigDecimalType value = TypeBigDecimal.create(BigDecimalType.class, Integer.valueOf(2));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), new BigDecimal(2));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNullValueIntegerNull() {
        TypeBigDecimal.create(BigDecimalType.class, (Integer)null);
    }

    public void testNullValueIntegerPrimitive() {
        BigDecimalType value = TypeBigDecimal.create(BigDecimalType.class, 2);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), new BigDecimal(2));
    }

    public void testCreateLong() {
        BigDecimalType value = TypeBigDecimal.create(BigDecimalType.class, Long.valueOf(2));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), new BigDecimal(2));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateLongNull() {
        TypeBigDecimal.create(BigDecimalType.class, (Long)null);
    }

    public void testCreateLongPrimitive() {
        BigDecimalType value = TypeBigDecimal.create(BigDecimalType.class, 2L);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), new BigDecimal(2L));
    }

    public void testValueDoublePrimitive() {
        BigDecimalType value = TypeBigDecimal.value(BigDecimalType.class, 2.2);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), new BigDecimal("2.2"));
    }

    public void testValueLongPrimitive() {
        BigDecimalType value = TypeBigDecimal.value(BigDecimalType.class, 2L);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), new BigDecimal(2L));
    }

    public void testValueLongPrimitiveWithScale() {
        BigDecimalType value = TypeBigDecimal.value(BigDecimalType.class, 22L, 1);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), new BigDecimal("2.2"));
    }

    public void testNullValueString() {
        BigDecimalType value = TypeBigDecimal.create(BigDecimalType.class, "2.2");
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), new BigDecimal("2.2"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNullValueStringNull() {
        TypeBigDecimal.create(BigDecimalType.class, (String)null);
    }

}
