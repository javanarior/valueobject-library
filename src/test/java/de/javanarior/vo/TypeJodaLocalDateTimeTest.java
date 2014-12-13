package de.javanarior.vo;

import org.joda.time.LocalDateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.javanarior.vo.generator.helper.JodaLocalDateTimeType;

@Test
public class TypeJodaLocalDateTimeTest {

    public void testCreateDateTime() {
        LocalDateTime now = LocalDateTime.now();
        JodaLocalDateTimeType value = TypeJodaLocalDateTime.create(JodaLocalDateTimeType.class, now);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), now);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateDateTimeNull() {
        TypeJodaLocalDateTime.create(JodaLocalDateTimeType.class, null);
    }

}
