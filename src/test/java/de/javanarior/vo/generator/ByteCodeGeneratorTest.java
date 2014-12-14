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
package de.javanarior.vo.generator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.objectweb.asm.Type;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import de.javanarior.utils.lang.ByteCodeClassLoader;
import de.javanarior.utils.lang.ByteCodeContainer;
import de.javanarior.utils.lang.reflect.Invoker;
import de.javanarior.vo.example.types.BigDecimalType;
import de.javanarior.vo.example.types.BigIntegerType;
import de.javanarior.vo.example.types.BooleanType;
import de.javanarior.vo.example.types.ByteType;
import de.javanarior.vo.example.types.CharType;
import de.javanarior.vo.example.types.DateType;
import de.javanarior.vo.example.types.DoubleType;
import de.javanarior.vo.example.types.IntType;
import de.javanarior.vo.example.types.JodaDateTimeType;
import de.javanarior.vo.example.types.JodaLocalDateTimeType;
import de.javanarior.vo.example.types.JodaLocalDateType;
import de.javanarior.vo.example.types.JodaLocalTimeType;
import de.javanarior.vo.example.types.LongType;
import de.javanarior.vo.example.types.ShortType;
import de.javanarior.vo.example.types.StringType;
import de.javanarior.vo.types.AbstractValue;
import de.javanarior.vo.types.BigDecimalWrapper;
import de.javanarior.vo.types.BigIntegerWrapper;
import de.javanarior.vo.types.BooleanWrapper;
import de.javanarior.vo.types.ByteWrapper;
import de.javanarior.vo.types.CharWrapper;
import de.javanarior.vo.types.DateWrapper;
import de.javanarior.vo.types.DoubleWrapper;
import de.javanarior.vo.types.IntWrapper;
import de.javanarior.vo.types.JodaDateTimeWrapper;
import de.javanarior.vo.types.JodaLocalDateTimeWrapper;
import de.javanarior.vo.types.JodaLocalDateWrapper;
import de.javanarior.vo.types.JodaLocalTimeWrapper;
import de.javanarior.vo.types.LongWrapper;
import de.javanarior.vo.types.ShortWrapper;
import de.javanarior.vo.types.StringWrapper;
import de.javanarior.vo.types.Value;
import de.javanarior.vo.types.helper.IntValue;

@Test
public class ByteCodeGeneratorTest {

    public void testImplementedInterfaces() {
        Assert.assertEquals(ByteCodeGenerator.implementedInterfaces(IntType.class)[0],
                        IntType.class.getName().replace('.', '/'));
    }

    public void testParentClassName() {
        Assert.assertEquals(ByteCodeGenerator.parentClassName(IntWrapper.class),
                        IntWrapper.class.getName().replace('.', '/'));
    }

    public void testImplementationClassName() {
        String implementedInterfaceName = IntType.class.getName().replace(".", "/");
        String generatedNamePart = "$VO$" + Integer.toHexString(implementedInterfaceName.hashCode());
        Assert.assertEquals(ByteCodeGenerator.implementationClassName(IntType.class), implementedInterfaceName
                        + generatedNamePart);
        Assert.assertTrue(ByteCodeGenerator.implementationClassName(IntType.class).matches(
                        implementedInterfaceName + "\\$VO\\$[0-9a-f]+"));
    }

    public void testImplementationClassNameIsEqualForEqualTypes() {
        String implementationClassName1 = ByteCodeGenerator.implementationClassName(IntType.class);
        String implementationClassName2 = ByteCodeGenerator.implementationClassName(IntType.class);
        Assert.assertEquals(implementationClassName1, implementationClassName2);
    }

    public void testInterfaceName() {
        Assert.assertEquals(ByteCodeGenerator.interfaceName(IntType.class), IntType.class.getName().replace(".", "/"));
    }

    public void testBinaryClassName() {
        Assert.assertEquals(ByteCodeGenerator.binaryClassName(IntType.class),
                        ByteCodeGenerator.implementationClassName(IntType.class).replace('/', '.'));
    }

    public void testMethodDescriptor() {
        Assert.assertEquals(ByteCodeGenerator.methodDescriptor(Integer.TYPE), "(" + Type.getType(Integer.TYPE) + ")V");
    }

    public void testAddTypeSignature() {
        Assert.assertEquals(ByteCodeGenerator.addTypeSignature(Integer.TYPE.toString()), "Lint;");
    }

    public void testGetILOADOpCodeForInt() {
        Assert.assertEquals(ByteCodeGenerator.getILOADOpCode(Integer.TYPE), 21);
    }

    public void testGetILOADOpCodeForInteger() {
        Assert.assertEquals(ByteCodeGenerator.getILOADOpCode(Integer.class), 25);
    }

    @DataProvider(name = "getWrapper")
    public Object[][] getWrapper() {
        // @formatter:off
        return new Object[][] {
                {BigDecimalType.class, BigDecimal.class, BigDecimalWrapper.class , new BigDecimal("2.2")},
                {BigIntegerType.class, BigInteger.class, BigIntegerWrapper.class , new BigInteger("2")},
                {BooleanType.class, Boolean.TYPE, BooleanWrapper.class , Boolean.TRUE},
                {ByteType.class, Byte.TYPE, ByteWrapper.class , Byte.valueOf("1")},
                {CharType.class, Character.TYPE, CharWrapper.class , Character.valueOf('Z')},
                {DateType.class, Date.class, DateWrapper.class , new Date()},
                {DoubleType.class, Double.TYPE, DoubleWrapper.class , Double.valueOf(2.2)},
                {IntType.class, Integer.TYPE, IntWrapper.class , Integer.valueOf(12)},
                {JodaDateTimeType.class, DateTime.class, JodaDateTimeWrapper.class , new DateTime()},
                {JodaLocalDateTimeType.class, LocalDateTime.class, JodaLocalDateTimeWrapper.class ,
                 new LocalDateTime()},
                {JodaLocalDateType.class, LocalDate.class, JodaLocalDateWrapper.class , new LocalDate()},
                {JodaLocalTimeType.class, LocalTime.class, JodaLocalTimeWrapper.class , new LocalTime()},
                {LongType.class, Long.TYPE, LongWrapper.class , Long.valueOf("21")},
                {ShortType.class, Short.TYPE, ShortWrapper.class , Short.valueOf("2")},
                {StringType.class, String.class, StringWrapper.class, "TestMe" }
        };
        // @formatter:on
    }

    @Test(dataProvider = "getWrapper")
    public void testGenerate(Class<?> interfaze, Class<? extends Comparable<?>> technicalType,
                    Class<? extends AbstractValue<?, ?>> superClass, Object value)
                    throws Exception {
        ByteCodeContainer generatedClass = ByteCodeGenerator.generate(interfaze, technicalType, superClass);
        ByteCodeClassLoader classLoader = ByteCodeClassLoader.getClassLoader();
        Class<?> load = classLoader.load(generatedClass);
        Assert.assertNotNull(load);
        Value<?, ?> valueObject = (Value<?, ?>)Invoker.invokeConstructor(load, technicalType, value);
        Assert.assertEquals(valueObject.getValue(), value);
    }

    public void testGenerateWithClassAsType() {
        try {
            ByteCodeGenerator.generate(IntValue.class, Integer.TYPE, IntWrapper.class);
        } catch (IllegalArgumentException exception) {
            Assert.assertEquals(exception.getMessage(),
                            "Could not generate implementation for class " + IntValue.class.getName()
                                            + ". Please provide interface");
        }
    }

}
