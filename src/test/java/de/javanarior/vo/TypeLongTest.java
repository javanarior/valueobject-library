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

import de.javanarior.vo.example.types.LongType;
import de.javanarior.vo.types.NullObject;

@Test
public class TypeLongTest {

    public void testNullValueLong() {
        LongType value = TypeLong.create(LongType.class, Long.valueOf(2));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Long.valueOf(2));
    }

    public void testValueLong() {
        LongType value = TypeLong.value(LongType.class, Long.valueOf(2));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Long.valueOf(2));
    }

    public void testValueNullSafeLong() {
        LongType value = TypeLong.valueNullSafe(LongType.class, Long.valueOf(2));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Long.valueOf(2));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNullValueLongNull() {
        LongType value = TypeLong.create(LongType.class, (Long)null);
        Assert.assertNull(value);
    }

    public void testValueLongNull() {
        LongType value = TypeLong.value(LongType.class, (Long)null);
        Assert.assertNull(value);
    }

    public void testValueNullSafeLongNull() {
        LongType value = TypeLong.valueNullSafe(LongType.class, (Long)null);
        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof NullObject);
    }

    public void testNullValueLongPrimitive() {
        LongType value = TypeLong.create(LongType.class, 2L);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Long.valueOf(2));
    }

    public void testValueLongPrimitive() {
        LongType value = TypeLong.value(LongType.class, 2L);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Long.valueOf(2));
    }

}
