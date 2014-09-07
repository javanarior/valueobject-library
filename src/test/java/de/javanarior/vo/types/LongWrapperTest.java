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

import de.javanarior.vo.types.helper.LongValue;
import de.javanarior.vo.types.helper.OtherLongValue;

@Test
public class LongWrapperTest {

    private static final Long ONE_VALUE = Long.valueOf(1);
    private static final LongValue ONE = new LongValue(1L);
    private static final LongValue TWO = new LongValue(2);
    private static final LongValue ANOTHER_ONE = new LongValue(1);
    private static final OtherLongValue OTHER_TYPE_ONE = new OtherLongValue(1L);

    public void testEqualsForDifferentTypes() {
        assertFalse(ONE.equals(OTHER_TYPE_ONE));
        assertFalse(OTHER_TYPE_ONE.equals(ONE));
    }

    public void testAsPrimitiveLong() {
        assertEquals(ONE.asPrimitiveLong(), 1);
        assertEquals(1, ONE.asPrimitiveLong());
    }

    public void testAsLong() {
        assertEquals(ONE.asLong(), ONE_VALUE);
        assertEquals(ONE_VALUE, ONE.asLong());
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
