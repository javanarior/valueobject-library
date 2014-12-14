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
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import de.javanarior.vo.types.helper.BigDecimalValue;
import de.javanarior.vo.types.helper.BigIntegerValue;
import de.javanarior.vo.types.helper.BooleanValue;
import de.javanarior.vo.types.helper.ByteValue;
import de.javanarior.vo.types.helper.CharValue;
import de.javanarior.vo.types.helper.DateValue;
import de.javanarior.vo.types.helper.DoubleValue;
import de.javanarior.vo.types.helper.IntValue;
import de.javanarior.vo.types.helper.JodaDateTimeValue;
import de.javanarior.vo.types.helper.JodaLocalDateTimeValue;
import de.javanarior.vo.types.helper.JodaLocalDateValue;
import de.javanarior.vo.types.helper.JodaLocalTimeValue;
import de.javanarior.vo.types.helper.LongValue;
import de.javanarior.vo.types.helper.ShortValue;
import de.javanarior.vo.types.helper.StringValueImpl;

/* CHECKSTYLE:OFF */
@Test
public class WrapperTest {
    /* CHECKSTYLE:ON */

    /* CHECKSTYLE:OFF */
    @DataProvider(name = "getValue")
    public Object[][] getWrapper() throws ParseException {
        /* CHECKSTYLE:ON */
        /* @formatter:off */
        return new Object[][] {
            {new BigDecimalValue(BigDecimal.valueOf(1.1)), new BigDecimalValue(BigDecimal.valueOf(1.1)),
             new BigDecimalValue(BigDecimal.valueOf(2.2))}
          , {new BigIntegerValue(BigInteger.valueOf(1)), new BigIntegerValue(BigInteger.valueOf(1)),
             new BigIntegerValue(BigInteger.valueOf(2))}
          , {new BooleanValue(true), new BooleanValue(true), new BooleanValue(false)}
          , {new ByteValue((byte)1), new ByteValue((byte)1), new ByteValue((byte)2)}
          , {new CharValue('1'), new CharValue('1'), new CharValue('2')}
          , {new DoubleValue(1.1), new DoubleValue(1.1), new DoubleValue(2.2)}
          , {new IntValue(1), new IntValue(1), new IntValue(2)}
          , {new LongValue(1L), new LongValue(1L), new LongValue(2L)}
          , {new ShortValue((short)1), new ShortValue((short)1), new ShortValue((short)2)}
          , {new StringValueImpl("one"), new StringValueImpl("one"), new StringValueImpl("two")}
          , {new DateValue(LocalDate.parse("2014-10-20").toDate()), new DateValue(LocalDate.parse("2014-10-20").toDate()),
             new DateValue(LocalDate.parse("2014-10-21").toDate())}
          , {new JodaDateTimeValue(new DateTime("2014-10-20")), new JodaDateTimeValue(new DateTime("2014-10-20")),
             new JodaDateTimeValue(new DateTime("2014-10-21"))}
          , {new JodaLocalDateTimeValue(new LocalDateTime("2014-10-20")), new JodaLocalDateTimeValue(
              new LocalDateTime("2014-10-20")), new JodaLocalDateTimeValue(new LocalDateTime("2014-10-21"))}
          , {new JodaLocalDateValue(new LocalDate("2014-10-20")), new JodaLocalDateValue(
              new LocalDate("2014-10-20")), new JodaLocalDateValue(new LocalDate("2014-10-21"))}
          , {new JodaLocalTimeValue(new LocalTime("12:13:14")), new JodaLocalTimeValue(
              new LocalTime("12:13:14")), new JodaLocalTimeValue(new LocalTime("14:13:12"))}
        };
        /* @formatter:on */
    }

    @SuppressWarnings("boxing")
    @Test(dataProvider = "getValue")
    public void testHashCodeNotEqualForDifferentValues(Value<?, ?> one, Value<?, ?> anotherOne, Value<?, ?> two) {
        assertNotEquals(one.hashCode(), two.hashCode());
        assertNotEquals(anotherOne.hashCode(), two.hashCode());
    }

    @Test(dataProvider = "getValue")
    public void testHashCodeEqualForEqualValues(Value<?, ?> one, Value<?, ?> anotherOne, Value<?, ?> two) {
        assertNotSame(one, anotherOne);
        assertEquals(one.hashCode(), anotherOne.hashCode());
        assertEquals(one.hashCode(), one.hashCode());
    }

    @Test(dataProvider = "getValue")
    public void testEqualsForDifferentValues(Value<?, ?> one, Value<?, ?> anotherOne, Value<?, ?> two) {
        assertFalse(one.equals(two));
        assertFalse(two.equals(one));
    }

    @Test(dataProvider = "getValue")
    public void testEqualsForEqualValues(Value<?, ?> one, Value<?, ?> anotherOne, Value<?, ?> two) {
        assertNotSame(one, anotherOne);
        assertTrue(one.equals(anotherOne));
        assertTrue(anotherOne.equals(one));
        assertTrue(one.equals(one));
    }

    @Test(dataProvider = "getValue")
    public void testEqualsForNull(Value<?, ?> one, Value<?, ?> anotherOne, Value<?, ?> two) {
        assertFalse(one.equals(null));
    }

}
