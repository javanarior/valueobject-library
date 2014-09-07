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

import de.javanarior.vo.types.helper.BooleanValue;
import de.javanarior.vo.types.helper.OtherBooleanValue;

@Test
public class BooleanWrapperTest {

    private static final BooleanValue ONE = new BooleanValue(true);
    private static final BooleanValue TWO = new BooleanValue(false);
    private static final BooleanValue ANOTHER_ONE = new BooleanValue(true);
    private static final OtherBooleanValue OTHER_TYPE_ONE = new OtherBooleanValue(true);

    public void testEqualsForDifferentTypes() {
        assertFalse(ONE.equals(OTHER_TYPE_ONE));
        assertFalse(OTHER_TYPE_ONE.equals(ONE));
    }

    public void testPrimitiveBoolean() {
        assertEquals(ONE.asPrimitiveBoolean(), true);
        assertEquals(true, ONE.asPrimitiveBoolean());
    }

    public void testAsBoolean() {
        assertEquals(ONE.asBoolean(), Boolean.TRUE);
        assertEquals(Boolean.TRUE, ONE.asBoolean());
    }

    public void testCompareTo() {
        assertEquals(ONE.compareTo(ANOTHER_ONE), 0);
        assertTrue(ONE.compareTo(TWO) > 0);
        assertTrue(TWO.compareTo(ONE) < 0);
    }

    public void testGetValue() {
        assertEquals(ONE.getValue(), Boolean.TRUE);
    }
}
