package de.javanarior.vo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import de.javanarior.vo.generator.helper.IntType;

@Test
public class TypeFactoryIntegerTest {

    private TypeFactoryInteger<IntType> factory;

    @BeforeMethod
    public void setUp() {
        this.factory = new TypeFactoryInteger<IntType>();
    }

    public void testCreate() {
        TypeFactoryInteger<IntType> f = new TypeFactoryInteger<IntType>();
        IntType value = f.create(IntType.class, 2);
        Assert.assertEquals(value.asInt(), 2);
    }
}
