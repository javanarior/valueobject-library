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

import org.joda.time.LocalDateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.javanarior.vo.example.types.JodaLocalDateTimeType;
import de.javanarior.vo.types.NullObject;

@Test
public class TypeJodaLocalDateTimeTest {

    public void testCreate() {
        LocalDateTime now = LocalDateTime.now();
        JodaLocalDateTimeType value = TypeJodaLocalDateTime.create(JodaLocalDateTimeType.class, now);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), now);
    }

    public void testValue() {
        LocalDateTime now = LocalDateTime.now();
        JodaLocalDateTimeType value = TypeJodaLocalDateTime.value(JodaLocalDateTimeType.class, now);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), now);
    }

    public void testValueNullSafe() {
        LocalDateTime now = LocalDateTime.now();
        JodaLocalDateTimeType value = TypeJodaLocalDateTime.valueNullSafe(JodaLocalDateTimeType.class, now);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), now);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateNull() {
        TypeJodaLocalDateTime.create(JodaLocalDateTimeType.class, null);
    }

    public void testValueNull() {
        JodaLocalDateTimeType value = TypeJodaLocalDateTime.value(JodaLocalDateTimeType.class, null);
        Assert.assertNull(value);
    }

    public void testValueNullSafeNull() {
        JodaLocalDateTimeType value = TypeJodaLocalDateTime.valueNullSafe(JodaLocalDateTimeType.class, null);
        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof NullObject);
    }

}
