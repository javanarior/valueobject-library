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
package de.javanarior.vo.types;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import org.joda.time.LocalDateTime;
import org.testng.annotations.Test;

import de.javanarior.vo.types.helper.JodaLocalDateTimeValue;
import de.javanarior.vo.types.helper.OtherJodaLocalDateTimeValue;

@Test
public class JodaLocalDateTimeWrapperTest {

    private static final LocalDateTime ONE_VALUE = new LocalDateTime("2014-10-20T12:13:14");
    private static final JodaLocalDateTimeValue ONE = new JodaLocalDateTimeValue(new LocalDateTime(
                    "2014-10-20T12:13:14"));
    private static final OtherJodaLocalDateTimeValue OTHER_TYPE_ONE = new OtherJodaLocalDateTimeValue(
                    new LocalDateTime("2014-10-20T12:13:14"));

    public void testJodaDateTimeWrapperNullArgument() {
        try {
            new JodaLocalDateTimeValue(null);
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

    public void testGetValue() {
        assertEquals(ONE.getValue(), ONE_VALUE);
    }

}
