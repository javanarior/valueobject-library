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
package de.javanarior.vo;

import org.testng.Assert;
import org.testng.annotations.Test;

import de.javanarior.vo.example.types.StringType;
import de.javanarior.vo.types.NullObject;
import de.javanarior.vo.validation.ValidationException;
import de.javanarior.vo.validation.constraints.LengthString;
import de.javanarior.vo.validation.constraints.NoOpConstraint;
import de.javanarior.vo.validation.constraints.NotNullConstraint;

@Test
public class TypeStringTest {

    public void testNullValueStringNullString() {
        StringType value = TypeString.create(StringType.class, "null");
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "null");
    }

    public void testNullValueStringNull() {
        StringType value = TypeString.create(StringType.class, (String)null);
        Assert.assertNull(value);
    }

    public void testNullValueNullSafeNotNull() {
        StringType value = TypeString.createNullSafe(StringType.class, "testme");
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "testme");
    }

    public void testNullValueNullSafeStringNull() {
        StringType value = TypeString.createNullSafe(StringType.class, (String)null);
        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof NullObject);
    }

    public void testNullValueNullSafeStringNullString() {
        StringType value = TypeString.createNullSafe(StringType.class, "null");
        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof NullObject);
    }

    public void testNullValueNoConstraintViolation() {
        StringType value = TypeString.create(StringType.class, "test", new LengthString(1, 4));
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "test");
    }

    public void testNullValueConstraintViolation() {
        try {
            TypeString.create(StringType.class, "", new LengthString(1, 4));
        } catch (ValidationException exception) {
            Assert.assertEquals(exception.getMessage(), "value violate LengthString");
        }
    }

    public void testNullValueNullSafeNoConstraintViolation() {
        StringType value = TypeString.createNullSafe(StringType.class, "testme", new NotNullConstraint<String>());
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "testme");
    }

    public void testNullValueNullSafeConstraintViolation() {
        try {
            TypeString.createNullSafe(StringType.class, (String)null, new NotNullConstraint<String>());
        } catch (ValidationException exception) {
            Assert.assertEquals(exception.getMessage(), "value violate NotNullConstraint");
        }
    }

    public void testNullValueBoolean() {
        StringType value = TypeString.create(StringType.class, true);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "true");
    }

    public void testNullValueByte() {
        StringType value = TypeString.create(StringType.class, (byte)1);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "1");
    }

    public void testNullValueChar() {
        StringType value = TypeString.create(StringType.class, 'A');
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "A");
    }

    public void testNullValueDouble() {
        StringType value = TypeString.create(StringType.class, 2.2);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "2.2");
    }

    public void testNullValueFloat() {
        StringType value = TypeString.create(StringType.class, (float)2.2);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "2.2");
    }

    public void testNullValueInt() {
        StringType value = TypeString.create(StringType.class, 2);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "2");
    }

    public void testNullValueLong() {
        StringType value = TypeString.create(StringType.class, 2L);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "2");
    }

    public void testNullValueObject() {
        StringType value = TypeString.create(StringType.class, new Object());
        Assert.assertNotNull(value);
        Assert.assertTrue(value.getValue().matches("java\\.lang\\.Object.*"));
    }

    public void testNullValueObjectNull() {
        StringType value = TypeString.create(StringType.class, (Object)null);
        Assert.assertNull(value);
    }

    public void testNullValueShort() {
        StringType value = TypeString.create(StringType.class, (short)2);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "2");
    }

    public void testNullValueString() {
        StringType value = TypeString.create(StringType.class, "testme");
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "testme");
    }

    public void testNullValueStringNoOpConstraint() {
        StringType value = TypeString.create(StringType.class, "testme", new NoOpConstraint<String>());
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "testme");
    }

    public void testNullValueStringEmpty() {
        StringType value = TypeString.create(StringType.class, "");
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "");
    }

}
