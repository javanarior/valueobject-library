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

import org.testng.annotations.Test;

import de.javanarior.vo.types.helper.ByteValue;
import de.javanarior.vo.types.helper.OtherByteValue;

@Test
public class ByteWrapperTest {

    private static final Byte ONE_VALUE = Byte.valueOf("1");
    private static final ByteValue ONE = new ByteValue((byte)1);
    private static final ByteValue TWO = new ByteValue((byte)2);
    private static final ByteValue ANOTHER_ONE = new ByteValue((byte)1);
    private static final OtherByteValue OTHER_TYPE_ONE = new OtherByteValue((byte)1);

    public void testEqualsForDifferentTypes() {
        assertFalse(ONE.equals(OTHER_TYPE_ONE));
        assertFalse(OTHER_TYPE_ONE.equals(ONE));
    }

    public void testAsPrimitiveByte() {
        assertEquals(ONE.asPrimitiveByte(), (byte)1);
        assertEquals((byte)1, ONE.asPrimitiveByte());
    }

    public void testAsByte() {
        assertEquals(ONE.asByte(), ONE_VALUE);
        assertEquals(ONE_VALUE, ONE.asByte());
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
