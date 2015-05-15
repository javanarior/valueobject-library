/*
 * Copyright (C) 2015 Sven von Pluto - javanarior (a) gmail dot com
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

import java.nio.file.attribute.FileTime;

import org.joda.time.DateTime;
import org.testng.annotations.Test;

import de.javanarior.vo.example.types.FileTimeType;
import de.javanarior.vo.example.types.JodaDateTimeType;
import de.javanarior.vo.types.NullObject;

@Test
public class TypeFileTimeTest {

    public void testCreate() {
        FileTime millis = FileTime.fromMillis(DateTime.now().getMillis());
        FileTimeType value = TypeFileTime.create(FileTimeType.class, millis);
        assertNotNull(value);
        assertEquals(value.getValue(), millis);
    }

    public void testValue() {
        FileTime millis = FileTime.fromMillis(DateTime.now().getMillis());
        FileTimeType value = TypeFileTime.value(FileTimeType.class, millis);
        assertNotNull(value);
        assertEquals(value.getValue(), millis);
    }

    public void testValueNullSafe() {
        FileTime millis = FileTime.fromMillis(DateTime.now().getMillis());
        FileTimeType value = TypeFileTime.valueNullSafe(FileTimeType.class, millis);
        assertNotNull(value);
        assertEquals(value.getValue(), millis);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateDateTimeNull() {
        TypeJodaDateTime.create(JodaDateTimeType.class, null);
    }

    public void testValueNull() {
        FileTimeType value = TypeFileTime.value(FileTimeType.class, null);
        assertNull(value);
    }

    public void testValueNullSafeNull() {
        FileTimeType value = TypeFileTime.valueNullSafe(FileTimeType.class, null);
        assertNotNull(value);
        assertTrue(value instanceof NullObject);
    }

}
