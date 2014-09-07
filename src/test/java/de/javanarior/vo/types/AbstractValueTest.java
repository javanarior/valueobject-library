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
import java.math.BigInteger;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class AbstractValueTest {

    private AbstractValueImpl testee;

    @BeforeMethod
    public void setUp() {
        testee = new AbstractValueImpl(AbstractValueImpl.class, "12");
    }

    public void testAsBoolean() {
        testee = new AbstractValueImpl(AbstractValueImpl.class, "true");
        Boolean asBoolean = testee.asBoolean();
        assertEquals(asBoolean.getClass(), Boolean.class);
        assertEquals(asBoolean, Boolean.TRUE);
    }

    public void testAsPrimitiveBoolean() {
        testee = new AbstractValueImpl(AbstractValueImpl.class, "true");
        boolean asBoolean = testee.asPrimitiveBoolean();
        assertEquals(asBoolean, true);
    }

    public void testAsByte() {
        Byte asByte = testee.asByte();
        assertEquals(asByte.getClass(), Byte.class);
        assertEquals(asByte, Byte.valueOf("12"));
    }

    public void testAsPrimitiveByte() {
        byte asByte = testee.asPrimitiveByte();
        assertEquals(asByte, (byte)12);
    }

    public void testAsShort() {
        Short asShort = testee.asShort();
        assertEquals(asShort.getClass(), Short.class);
        assertEquals(asShort, Short.valueOf("12"));
    }

    public void testAsPrimitiveShort() {
        short asShort = testee.asPrimitiveShort();
        assertEquals(asShort, (short)12);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testAsCharacter() {
        testee.asCharacter();
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testAsChar() {
        testee.asChar();
    }

    public void testAsInteger() {
        Integer asInteger = testee.asInteger();
        assertEquals(asInteger.getClass(), Integer.class);
        assertEquals(asInteger, Integer.valueOf(12));
    }

    public void testAsInt() {
        int asInt = testee.asInt();
        assertEquals(asInt, 12);
    }

    public void testAsLong() {
        Long asLong = testee.asLong();
        assertEquals(asLong.getClass(), Long.class);
        assertEquals(asLong, Long.valueOf(12));
    }

    public void testAsPrimitiveLong() {
        long asLong = testee.asPrimitiveLong();
        assertEquals(asLong, 12);
    }

    public void testAsDouble() {
        Double asDouble = testee.asDouble();
        assertEquals(asDouble.getClass(), Double.class);
        assertEquals(asDouble, Double.valueOf(12));
    }

    public void testAsPrimitiveDouble() {
        double asDouble = testee.asPrimitiveDouble();
        assertEquals(asDouble, 12, 0.001);
    }

    public void testAsString() {
        String asString = testee.asString();
        assertEquals(asString.getClass(), String.class);
        assertEquals(asString, "12");
    }

    public void testAsBigInteger() {
        BigInteger asBigInteger = testee.asBigInteger();
        assertEquals(asBigInteger.getClass(), BigInteger.class);
        assertEquals(asBigInteger, BigInteger.valueOf(12L));
    }

    public void testAsBigDecimal() {
        BigDecimal asBigDecimal = testee.asBigDecimal();
        assertEquals(asBigDecimal.getClass(), BigDecimal.class);
        assertEquals(asBigDecimal, BigDecimal.valueOf(12.0));
    }

    public void testIsNull() {
        assertFalse(testee.isNull());
    }

    public void testEquals() {
        AbstractValueImpl otherValue = new AbstractValueImpl(AbstractValueImpl.class, "12");
        assertTrue(testee.equals(otherValue));
        assertTrue(otherValue.equals(testee));
    }

    public void testEqualsSameObject() {
        assertTrue(testee.equals(testee));
    }

    public void testEqualsForDifferentTypes() {
        OtherAbstractValueImpl otherValue = new OtherAbstractValueImpl(OtherAbstractValueImpl.class, "12");
        assertFalse(testee.equals(otherValue));
        assertFalse(otherValue.equals(testee));
    }

    public void testToString() {
        assertEquals(testee.toString(), "AbstractValueImpl=12");
    }

    private static class AbstractValueImpl extends AbstractValue<AbstractValueImpl> {

        private Object value;
        protected AbstractValueImpl(Class<AbstractValueImpl> metaType, Object value) {
            super(metaType);
            this.value = value;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public int compareTo(AbstractValueImpl other) {
            return 0;
        }
    }

    private static class OtherAbstractValueImpl extends AbstractValue<OtherAbstractValueImpl> {

        private Object value;
        protected OtherAbstractValueImpl(Class<OtherAbstractValueImpl> metaType, Object value) {
            super(metaType);
            this.value = value;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public int compareTo(OtherAbstractValueImpl other) {
            return 0;
        }
    }
}
