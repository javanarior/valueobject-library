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

import org.testng.annotations.Test;

import de.javanarior.vo.types.helper.DoubleValue;
import de.javanarior.vo.types.helper.OtherDoubleValue;

@Test
public class DoubleWrapperTest {

    private static final Double ONE_VALUE = Double.valueOf(1.1);
    private static final DoubleValue ONE = new DoubleValue(1.1);
    private static final OtherDoubleValue OTHER_TYPE_ONE = new OtherDoubleValue(1.1);

    public void testEqualsForDifferentTypes() {
        assertFalse(ONE.equals(OTHER_TYPE_ONE));
        assertFalse(OTHER_TYPE_ONE.equals(ONE));
    }

    public void testAsPrimitiveDouble() {
        assertEquals(ONE.asPrimitiveDouble(), 1.1, 0.001);
        assertEquals(1.1, ONE.asPrimitiveDouble(), 0.001);
    }

    public void testAsDouble() {
        assertEquals(ONE.asDouble(), ONE_VALUE);
        assertEquals(ONE_VALUE, ONE.asDouble());
    }

    public void testgetValue() {
        assertEquals(ONE.getValue(), ONE_VALUE);
    }

}
