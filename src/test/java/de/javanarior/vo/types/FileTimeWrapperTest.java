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
package de.javanarior.vo.types;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.nio.file.attribute.FileTime;

import org.joda.time.DateTime;
import org.testng.annotations.Test;

import de.javanarior.vo.types.helper.FileTimeValue;
import de.javanarior.vo.types.helper.OtherFileTimeValue;

@Test
public class FileTimeWrapperTest {

    private static final FileTime ONE_VALUE = FileTime.fromMillis(new DateTime("2014-10-20").getMillis());
    private static final FileTimeValue ONE = new FileTimeValue(FileTime.fromMillis(
                    new DateTime("2014-10-20").getMillis()));
    private static final FileTimeValue TWO = new FileTimeValue(FileTime.fromMillis(
                    new DateTime("2014-10-21").getMillis()));
    private static final FileTimeValue ANOTHER_ONE = new FileTimeValue(FileTime.fromMillis(
                    new DateTime("2014-10-20").getMillis()));
    private static final OtherFileTimeValue OTHER_TYPE_ONE = new OtherFileTimeValue(FileTime.fromMillis(
                    new DateTime("2014-10-20").getMillis()));

    public void testJodaDateTimeWrapperNullArgument() {
        try {
            new FileTimeValue(null);
            fail("Null should not be allowed as value.");
        } catch (IllegalArgumentException exception) {
            assertNotNull(exception.getMessage());
            assertFalse(exception.getMessage().isEmpty());
        }
    }

    public void testEqualsForDifferentTypes() {
        assertFalse(ONE.equals(OTHER_TYPE_ONE));
        assertFalse(OTHER_TYPE_ONE.equals(ONE));
    }

    public void testAsString() {
        assertEquals(ONE.asString(), ONE_VALUE.toString());
        assertEquals(ONE_VALUE.toString(), ONE.asString());
    }

    public void testCompareTo() {
        assertEquals(ONE.compareTo(ANOTHER_ONE), 0);
        assertTrue(ONE.compareTo(TWO) < 0);
        assertTrue(TWO.compareTo(ONE) > 0);
    }

    public void testGetValue() {
        assertEquals(ONE.getValue(), ONE_VALUE);
    }

}
