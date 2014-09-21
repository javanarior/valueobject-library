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

import java.math.BigInteger;

import org.testng.Assert;
import org.testng.annotations.Test;

import de.javanarior.vo.types.helper.BigIntegerValue;
import de.javanarior.vo.types.helper.OtherBigIntegerValue;

@Test
public class BigIntegerWrapperTest {

    private static final BigInteger ONE_VALUE = BigInteger.valueOf(1L);
    private static final BigIntegerValue ONE = new BigIntegerValue(ONE_VALUE);
    private static final BigIntegerValue TWO = new BigIntegerValue(BigInteger.valueOf(2L));
    private static final BigIntegerValue ANOTHER_ONE = new BigIntegerValue(ONE_VALUE);
    private static final OtherBigIntegerValue OTHER_TYPE_ONE = new OtherBigIntegerValue(ONE_VALUE);

    public void testBigIntegerWrapperNullArgument() {
        try {
            new BigIntegerValue(null);
            fail("Null should not be allowed as value.");
        } catch (IllegalArgumentException exception) {
            assertNotNull(exception.getMessage());
            assertTrue(!exception.getMessage().isEmpty());
        }
    }

    public void testEqualsForDifferentTypes() {
        assertFalse(ONE.equals(OTHER_TYPE_ONE));
        assertFalse(OTHER_TYPE_ONE.equals(ONE));
    }

    public void testAsBigInteger() {
        assertEquals(ONE.asBigInteger(), ONE_VALUE);
        assertEquals(ONE_VALUE, ONE.asBigInteger());
    }

    public void testCompareTo() {
        assertEquals(ONE.compareTo(ANOTHER_ONE), 0);
        assertTrue(ONE.compareTo(TWO) < 0);
        assertTrue(TWO.compareTo(ONE) > 0);
    }

    public void testAsString() {
        assertEquals(ONE.asString(), "1");
    }

    public void testGetValue() {
        assertEquals(ONE.getValue(), ONE_VALUE);
    }

}
