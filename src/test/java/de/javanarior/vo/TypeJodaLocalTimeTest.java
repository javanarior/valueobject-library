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

import org.joda.time.LocalTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.javanarior.vo.example.types.JodaLocalTimeType;
import de.javanarior.vo.types.NullObject;

@Test
public class TypeJodaLocalTimeTest {

    public void testCreate() {
        LocalTime now = LocalTime.now();
        JodaLocalTimeType value = TypeJodaLocalTime.create(JodaLocalTimeType.class, now);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), now);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateNull() {
        TypeJodaLocalTime.create(JodaLocalTimeType.class, null);
    }

    public void testValue() {
        LocalTime now = LocalTime.now();
        JodaLocalTimeType value = TypeJodaLocalTime.value(JodaLocalTimeType.class, now);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), now);
    }

    public void testValueNull() {
        JodaLocalTimeType value = TypeJodaLocalTime.value(JodaLocalTimeType.class, null);
        Assert.assertNull(value);
    }

    public void testValueNullSafe() {
        LocalTime now = LocalTime.now();
        JodaLocalTimeType value = TypeJodaLocalTime.valueNullSafe(JodaLocalTimeType.class, now);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), now);
    }

    public void testValueNullSafeNull() {
        JodaLocalTimeType value = TypeJodaLocalTime.valueNullSafe(JodaLocalTimeType.class, null);
        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof NullObject);
    }

}
