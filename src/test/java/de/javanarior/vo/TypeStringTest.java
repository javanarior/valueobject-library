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
import de.javanarior.vo.validation.constraints.NoOpConstraint;
import de.javanarior.vo.validation.constraints.NotNullConstraint;
import de.javanarior.vo.validation.constraints.PositiveInteger;

@Test
public class TypeStringTest {

    public void testCreateStringNoOpConstraintNotNull() {
        StringType value = TypeString.create(StringType.class, "testme", new NoOpConstraint<String>());
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "testme");
    }

    public void testCreateStringNoOpConstraintNull() {
        StringType value = TypeString.create(StringType.class, (String)null, new NoOpConstraint<String>());
        Assert.assertNull(value);
    }

    public void testCreateStringNotNullConstraintNotNull() {
        StringType value = TypeString.create(StringType.class, "testme", new NotNullConstraint<String>());
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "testme");
    }

    public void testCreateStringNotNullConstraintNull() {
        try {
            TypeString.create(StringType.class, (String)null, new NotNullConstraint<String>());
        } catch (ValidationException exception) {
            Assert.assertEquals(exception.getMessage(), "value violate NotNullConstraint");
        }
    }

    public void testCreateNullSafeStringNoOpConstraintNotNull() {
        StringType value = TypeString.createNullSafe(StringType.class, "testme", new NoOpConstraint<String>());
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "testme");
    }

    public void testCreateNullSafeStringNoOpConstraintNull() {
        StringType value = TypeString.createNullSafe(StringType.class, (String)null, new NoOpConstraint<String>());
        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof NullObject);
    }

    public void testCreateNullSafeStringNotNullConstraintNotNull() {
        StringType value = TypeString.createNullSafe(StringType.class, "testme", new NotNullConstraint<String>());
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "testme");
    }

    public void testCreateNullSafeStringNotNullConstraintNull() {
        try {
            TypeString.createNullSafe(StringType.class, (String)null, new NotNullConstraint<String>());
        } catch (ValidationException exception) {
            Assert.assertEquals(exception.getMessage(), "value violate NotNullConstraint");
        }
    }

    public void testCreateBoolean() {
        StringType value = TypeString.create(StringType.class, true);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "true");
    }

    public void testCreateByte() {
        StringType value = TypeString.create(StringType.class, (byte)1);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "1");
    }

    public void testCreateChar() {
        StringType value = TypeString.create(StringType.class, 'A');
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "A");
    }

    public void testCreateDouble() {
        StringType value = TypeString.create(StringType.class, 2.2);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "2.2");
    }

    public void testCreateFloat() {
        StringType value = TypeString.create(StringType.class, (float)2.2);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "2.2");
    }

    public void testCreateInt() {
        StringType value = TypeString.create(StringType.class, 2);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "2");
    }

    public void testCreateLong() {
        StringType value = TypeString.create(StringType.class, 2L);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "2");
    }

    public void testCreateObject() {
        StringType value = TypeString.create(StringType.class, new Object());
        Assert.assertNotNull(value);
        Assert.assertTrue(value.getValue().matches("java\\.lang\\.Object.*"));
    }

    public void testCreateObjectNull() {
        StringType value = TypeString.create(StringType.class, (Object)null);
        Assert.assertNull(value);
    }

    public void testCreateShort() {
        StringType value = TypeString.create(StringType.class, (short)2);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "2");
    }

    public void testCreateString() {
        StringType value = TypeString.create(StringType.class, "testme");
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "testme");
    }

    public void testCreateStringEmpty() {
        StringType value = TypeString.create(StringType.class, "");
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), "");
    }

    public void testCreateStringNull() {
        StringType value = TypeString.create(StringType.class, (String)null);
        Assert.assertNull(value);
    }

}
