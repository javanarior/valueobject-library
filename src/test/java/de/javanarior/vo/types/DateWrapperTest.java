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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import de.javanarior.vo.types.helper.DateValue;
import de.javanarior.vo.types.helper.OtherDateValue;

@Test
public class DateWrapperTest {

    static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

    private Date oneValue;
    private DateValue one;
    private DateValue two;
    private DateValue anotherOne;
    private OtherDateValue otherTypeOne;

    @BeforeClass
    public void setUp() throws ParseException {
        oneValue = DATE_FORMATTER.parse("2014-10-20");
        one = new DateValue(oneValue);
        two = new DateValue(DATE_FORMATTER.parse("2014-10-21"));
        anotherOne = new DateValue(oneValue);
        otherTypeOne = new OtherDateValue(oneValue);
    }

    public void testDateWrapperNullArgument() {
        try {
            new DateValue(null);
            fail("Null should not be allowed as value.");
        } catch (IllegalArgumentException exception) {
            assertNotNull(exception.getMessage());
            assertFalse(exception.getMessage().isEmpty());
        }
    }

    public void testEqualsForDifferentTypes() {
        assertFalse(one.equals(otherTypeOne));
        assertFalse(otherTypeOne.equals(one));
    }

    public void testAsString() {
        assertEquals(one.asString(), oneValue.toString());
        assertEquals(oneValue.toString(), one.asString());
    }

    public void testCompareTo() {
        assertEquals(one.compareTo(anotherOne), 0);
        assertTrue(one.compareTo(two) < 0);
        assertTrue(two.compareTo(one) > 0);
    }

    public void testGetValue() {
        assertEquals(one.getValue(), oneValue);
    }

}
