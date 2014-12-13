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
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import de.javanarior.vo.types.helper.OtherStringValue;
import de.javanarior.vo.types.helper.OtherStringValueNullObject;
import de.javanarior.vo.types.helper.StringValue;
import de.javanarior.vo.types.helper.StringValueNullObject;

@Test
public class NullObjectTest {

    protected static final StringValue STRING_NULL_OBJECT = new StringValueNullObject();
    protected static final StringValue OTHER_STRING_NULL_OBJECT = new StringValueNullObject();
    protected static final OtherStringValue OTHER_TYPE_NULL_OBJECT = new OtherStringValueNullObject();

    public void testIsNull() {
        assertTrue(STRING_NULL_OBJECT.isNull());
    }

    @SuppressWarnings("boxing")
    public void testHashCodeNotEqualsForDifferentTypes() {
        assertNotEquals(STRING_NULL_OBJECT.hashCode(), OTHER_TYPE_NULL_OBJECT.hashCode());
    }

    public void testHashCodeEqualsForEqualTypes() {
        assertEquals(STRING_NULL_OBJECT.hashCode(), OTHER_STRING_NULL_OBJECT.hashCode());
    }

    public void testEqualsForDifferentTypes() {
        assertFalse(STRING_NULL_OBJECT.equals(OTHER_TYPE_NULL_OBJECT));
        assertFalse(OTHER_TYPE_NULL_OBJECT.equals(STRING_NULL_OBJECT));
    }

    public void testEqualsForEqualTypes() {
        assertTrue(STRING_NULL_OBJECT.equals(STRING_NULL_OBJECT));
        assertTrue(STRING_NULL_OBJECT.equals(OTHER_STRING_NULL_OBJECT));
        assertTrue(OTHER_STRING_NULL_OBJECT.equals(STRING_NULL_OBJECT));
    }

    public void testEqualsForNull() {
        assertTrue(STRING_NULL_OBJECT.equals(null));
    }

    public void testGetValue() {
        assertNull(STRING_NULL_OBJECT.getValue());
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testCompareTo() {
        STRING_NULL_OBJECT.compareTo(OTHER_STRING_NULL_OBJECT);
    }
}
