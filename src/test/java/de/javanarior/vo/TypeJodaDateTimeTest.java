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

import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.javanarior.vo.example.types.JodaDateTimeType;

@Test
public class TypeJodaDateTimeTest {

    public void testCreate() {
        DateTime now = DateTime.now();
        JodaDateTimeType value = TypeJodaDateTime.create(JodaDateTimeType.class, now);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), now);
    }

    public void testValue() {
        DateTime now = DateTime.now();
        JodaDateTimeType value = TypeJodaDateTime.value(JodaDateTimeType.class, now);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), now);
    }

    public void testValueNullSafe() {
        DateTime now = DateTime.now();
        JodaDateTimeType value = TypeJodaDateTime.valueNullSafe(JodaDateTimeType.class, now);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), now);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateNull() {
        TypeJodaDateTime.create(JodaDateTimeType.class, null);
    }

    public void testValueNull() {
        TypeJodaDateTime.value(JodaDateTimeType.class, null);
    }

    public void testValueNullSafeNull() {
        TypeJodaDateTime.valueNullSafe(JodaDateTimeType.class, null);
    }

}
