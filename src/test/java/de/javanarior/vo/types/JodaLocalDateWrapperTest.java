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
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.joda.time.LocalDate;
import org.testng.annotations.Test;

import de.javanarior.vo.types.helper.JodaLocalDateValue;
import de.javanarior.vo.types.helper.OtherJodaLocalDateValue;

@Test
public class JodaLocalDateWrapperTest {

    private static final LocalDate ONE_VALUE = new LocalDate("2014-10-20");
    private static final JodaLocalDateValue ONE = new JodaLocalDateValue(new LocalDate("2014-10-20"));
    private static final JodaLocalDateValue TWO = new JodaLocalDateValue(new LocalDate("2014-10-21"));
    private static final JodaLocalDateValue ANOTHER_ONE = new JodaLocalDateValue(new LocalDate("2014-10-20"));
    private static final OtherJodaLocalDateValue OTHER_TYPE_ONE = new OtherJodaLocalDateValue(new LocalDate("2014-10-20"));

    public void testJodaDateTimeWrapperNullArgument() {
        try {
            new JodaLocalDateValue(null);
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
