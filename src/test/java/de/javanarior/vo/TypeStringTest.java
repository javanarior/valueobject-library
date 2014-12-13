package de.javanarior.vo;

import org.testng.Assert;
import org.testng.annotations.Test;

import de.javanarior.vo.example.types.StringType;

@Test
public class TypeStringTest {

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

    @Test(expectedExceptions=IllegalArgumentException.class)
    public void testCreateObjectNull() {
        TypeString.create(StringType.class, (Object)null);
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

    @Test(expectedExceptions=IllegalArgumentException.class)
    public void testCreateStringNull() {
        TypeString.create(StringType.class, (String)null);
    }


}
