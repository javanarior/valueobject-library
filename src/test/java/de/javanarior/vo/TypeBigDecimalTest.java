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

import java.math.BigDecimal;
import java.math.BigInteger;

import org.testng.Assert;
import org.testng.annotations.Test;

import de.javanarior.vo.example.types.BigDecimalType;

@Test
public class TypeBigDecimalTest {

    public void testCreateBigDecimal() {
        BigDecimalType value = TypeBigDecimal.create(BigDecimalType.class, new BigDecimal(2.2));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), new BigDecimal(2.2));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateBigDecimalNull() {
        TypeBigDecimal.create(BigDecimalType.class, (BigDecimal)null);
    }

    public void testCreateBigInteger() {
        BigDecimalType value = TypeBigDecimal.create(BigDecimalType.class, new BigInteger("2"));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), new BigDecimal("2"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateBigIntegerNull() {
        TypeBigDecimal.create(BigDecimalType.class, (BigInteger)null);
    }

    public void testCreateInteger() {
        BigDecimalType value = TypeBigDecimal.create(BigDecimalType.class, Integer.valueOf(2));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), new BigDecimal(2));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateIntegerNull() {
        TypeBigDecimal.create(BigDecimalType.class, (Integer)null);
    }

    public void testCreateIntegerPrimitive() {
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

    public void testCreateString() {
        BigDecimalType value = TypeBigDecimal.create(BigDecimalType.class, "2.2");
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), new BigDecimal("2.2"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateStringNull() {
        TypeBigDecimal.create(BigDecimalType.class, (String)null);
    }

}
