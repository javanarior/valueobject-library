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

import java.math.BigInteger;

import org.testng.Assert;
import org.testng.annotations.Test;

import de.javanarior.vo.example.types.BigIntegerType;

@Test
public class TypeBigIntegerTest {

    public void testCreateBigInteger() {
        BigIntegerType value = TypeBigInteger.create(BigIntegerType.class, new BigInteger("2"));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), new BigInteger("2"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateBigIntegerNull() {
        TypeBigInteger.create(BigIntegerType.class, (BigInteger)null);
    }

    public void testCreateInteger() {
        BigIntegerType value = TypeBigInteger.create(BigIntegerType.class, Integer.valueOf(2));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), BigInteger.valueOf(2));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateIntegerNull() {
        TypeBigInteger.create(BigIntegerType.class, (Integer)null);
    }

    public void testCreateIntegerPrimitive() {
        BigIntegerType value = TypeBigInteger.create(BigIntegerType.class, 2);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), BigInteger.valueOf(2));
    }

    public void testCreateLong() {
        BigIntegerType value = TypeBigInteger.create(BigIntegerType.class, Long.valueOf(2));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), BigInteger.valueOf(2));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateLongNull() {
        TypeBigInteger.create(BigIntegerType.class, (Long)null);
    }

    public void testCreateLongPrimitive() {
        BigIntegerType value = TypeBigInteger.create(BigIntegerType.class, 2L);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), BigInteger.valueOf(2L));
    }

    public void testCreateString() {
        BigIntegerType value = TypeBigInteger.create(BigIntegerType.class, "2");
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), new BigInteger("2"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateStringNull() {
        TypeBigInteger.create(BigIntegerType.class, (String)null);
    }

}
