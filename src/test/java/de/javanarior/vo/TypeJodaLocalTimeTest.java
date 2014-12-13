package de.javanarior.vo;

import org.joda.time.LocalTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.javanarior.vo.generator.helper.JodaLocalTimeType;

@Test
public class TypeJodaLocalTimeTest {

    public void testCreateDateTime() {
        LocalTime now = LocalTime.now();
        JodaLocalTimeType value = TypeJodaLocalTime.create(JodaLocalTimeType.class, now);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), now);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateDateTimeNull() {
        TypeJodaLocalTime.create(JodaLocalTimeType.class, null);
    }

}
