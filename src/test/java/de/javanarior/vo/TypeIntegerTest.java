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

import de.javanarior.vo.example.types.IntType;

@Test
public class TypeIntegerTest {

    public void testCreateInteger() {
        IntType value = TypeInteger.create(IntType.class, Integer.valueOf(2));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Integer.valueOf(2));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateIntegerNull() {
        TypeInteger.create(IntType.class, (Integer)null);
    }

    public void testCreateInt() {
        IntType value = TypeInteger.create(IntType.class, 2);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Integer.valueOf(2));
    }

    public void testCreateString() {
        IntType value = TypeInteger.create(IntType.class, "2");
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Integer.valueOf(2));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateStringNull() {
        TypeInteger.create(IntType.class, (String)null);
    }

}
