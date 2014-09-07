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
import static org.testng.Assert.assertTrue;

import java.math.BigDecimal;

import org.testng.annotations.Test;

import de.javanarior.vo.types.helper.BigDecimalValue;
import de.javanarior.vo.types.helper.OtherBigDecimalValue;

@Test
public class BigDecimalWrapperTest {

    private static final BigDecimal ONE_VALUE = BigDecimal.valueOf(1.1);
    private static final BigDecimalValue ONE = new BigDecimalValue(ONE_VALUE);
    private static final BigDecimalValue TWO = new BigDecimalValue(BigDecimal.valueOf(2.2));
    private static final BigDecimalValue ANOTHER_ONE = new BigDecimalValue(ONE_VALUE);
    private static final OtherBigDecimalValue OTHER_TYPE_ONE = new OtherBigDecimalValue(ONE_VALUE);

    public void testEqualsForDifferentTypes() {
        assertFalse(ONE.equals(OTHER_TYPE_ONE));
        assertFalse(OTHER_TYPE_ONE.equals(ONE));
    }

    public void testAsBigDecimal() {
        assertEquals(ONE.asBigDecimal(), ONE_VALUE);
        assertEquals(ONE_VALUE, ONE.asBigDecimal());
    }

    public void testCompareTo() {
        assertEquals(ONE.compareTo(ANOTHER_ONE), 0);
        assertTrue(ONE.compareTo(TWO) < 0);
        assertTrue(TWO.compareTo(ONE) > 0);
    }

    public void testAsString() {
        assertEquals(ONE.asString(), "1.1");
    }

    public void testGetValue() {
        assertEquals(ONE.getValue(), ONE_VALUE);
    }

}
