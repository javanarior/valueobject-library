package de.javanarior.vo;

import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.javanarior.vo.generator.helper.JodaDateTimeType;

@Test
public class TypeJodaDateTimeTest {

    public void testCreateDateTime() {
        DateTime now = DateTime.now();
        JodaDateTimeType value = TypeJodaDateTime.create(JodaDateTimeType.class, now);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), now);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateDateTimeNull() {
        TypeJodaDateTime.create(JodaDateTimeType.class, null);
    }

}
