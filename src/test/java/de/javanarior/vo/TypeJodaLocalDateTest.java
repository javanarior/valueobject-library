package de.javanarior.vo;

import org.joda.time.LocalDate;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.javanarior.vo.example.types.JodaLocalDateType;

@Test
public class TypeJodaLocalDateTest {

    public void testCreateDateTime() {
        LocalDate now = LocalDate.now();
        JodaLocalDateType value = TypeJodaLocalDate.create(JodaLocalDateType.class, now);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), now);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateDateTimeNull() {
        TypeJodaLocalDate.create(JodaLocalDateType.class, null);
    }

}
