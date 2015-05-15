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

import java.nio.file.attribute.FileTime;

import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.javanarior.vo.example.types.FileTimeType;
import de.javanarior.vo.example.types.JodaDateTimeType;

@Test
public class TypeFileTimeTest {

    public void testCreateDateTime() {
        FileTime millis = FileTime.fromMillis(DateTime.now().getMillis());
        FileTimeType value = TypeFileTime.create(FileTimeType.class, millis);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), millis);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateDateTimeNull() {
        TypeJodaDateTime.create(JodaDateTimeType.class, null);
    }

}
