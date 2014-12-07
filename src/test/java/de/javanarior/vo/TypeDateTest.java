package de.javanarior.vo;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import de.javanarior.vo.generator.helper.DateType;

@Test
public class TypeDateTest {

    public void testCreateDate() {
        Date date = new Date();
        DateType value = TypeDate.create(DateType.class, date);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue(), date);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateDateNull() {
        TypeDate.create(DateType.class, null);
    }

    public void testCreateLong() {
        long time = new Date().getTime();
        DateType value = TypeDate.create(DateType.class, time);
        Assert.assertNotNull(value);
        Assert.assertEquals(value.getValue().getTime(), time);
    }

}
