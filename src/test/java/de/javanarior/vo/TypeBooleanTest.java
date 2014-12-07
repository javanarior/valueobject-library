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

import de.javanarior.vo.generator.helper.BooleanType;

@Test
public class TypeBooleanTest {

    public void testCreateBoolean() {
        BooleanType value = TypeBoolean.create(BooleanType.class, Boolean.TRUE);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Boolean.TRUE);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateBooleanNull() {
        TypeBoolean.create(BooleanType.class, (Boolean)null);
    }

    public void testCreateBooleanPrimitive() {
        BooleanType value = TypeBoolean.create(BooleanType.class, true);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Boolean.TRUE);
    }

    public void testCreateString() {
        BooleanType value = TypeBoolean.create(BooleanType.class, "true");
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), Boolean.TRUE);
    }

//    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateStringIllegal() {
        TypeBoolean.create(BooleanType.class, "trus");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateStringNull() {
        TypeBoolean.create(BooleanType.class, (String)null);
    }

}
