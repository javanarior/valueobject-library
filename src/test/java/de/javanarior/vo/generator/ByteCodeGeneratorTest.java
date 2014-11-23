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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
import de.javanarior.vo.generator.helper.BigDecimalType;
import de.javanarior.vo.generator.helper.BigIntegerType;
import de.javanarior.vo.generator.helper.BooleanType;
import de.javanarior.vo.generator.helper.ByteType;
import de.javanarior.vo.generator.helper.CharType;
import de.javanarior.vo.generator.helper.DateType;
import de.javanarior.vo.generator.helper.DoubleType;
import de.javanarior.vo.generator.helper.IntType;
import de.javanarior.vo.generator.helper.JodaDateTimeType;
import de.javanarior.vo.generator.helper.JodaLocalDateTimeType;
import de.javanarior.vo.generator.helper.JodaLocalDateType;
import de.javanarior.vo.generator.helper.JodaLocalTimeType;
import de.javanarior.vo.generator.helper.LongType;
import de.javanarior.vo.generator.helper.ShortType;
import de.javanarior.vo.generator.helper.StringType;
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

@Test
public class ByteCodeGeneratorTest {

//    public void testImplementedInterfaces() {
//        ByteCodeGenerator generator = new ByteCodeGenerator(IntType.class, Integer.class, IntWrapper.class);
//        Assert.assertEquals(generator.implementedInterfaces()[0], IntType.class.getName().replace('.', '/'));
//    }
//
//    public void testParentClassName() {
//        ByteCodeGenerator generator = new ByteCodeGenerator(IntType.class, Integer.class, IntWrapper.class);
//        Assert.assertEquals(generator.parentClassName(), IntWrapper.class.getName().replace('.', '/'));
//    }
//
//    public void testImplementationClassName() {
//        ByteCodeGenerator generator = new ByteCodeGenerator(IntType.class, Integer.class, IntWrapper.class);
//        String implementedInterfaceName = IntType.class.getName().replace(".", "/");
//        String generatedNamePart = "$VO$" + Integer.toHexString(implementedInterfaceName.hashCode());
//        Assert.assertEquals(generator.implementationClassName(), implementedInterfaceName + generatedNamePart);
//        Assert.assertTrue(generator.implementationClassName().matches(implementedInterfaceName + "\\$VO\\$[0-9a-f]+"));
//    }
//
//    public void testImplementationClassNameIsEqualForEqualTypes() {
//        ByteCodeGenerator generator1 = new ByteCodeGenerator(IntType.class, Integer.class, IntWrapper.class);
//        String implementationClassName1 = generator1.implementationClassName();
//        ByteCodeGenerator generator2 = new ByteCodeGenerator(IntType.class, Integer.class, IntWrapper.class);
//        String implementationClassName2 = generator2.implementationClassName();
//        Assert.assertEquals(implementationClassName1, implementationClassName2);
//    }
//
//    public void testInterfaceName() {
//        ByteCodeGenerator generator = new ByteCodeGenerator(IntType.class, Integer.class, IntWrapper.class);
//        Assert.assertEquals(generator.interfaceName(), IntType.class.getName().replace(".", "/"));
//    }
//
//    public void testBinaryClassName() {
//        ByteCodeGenerator generator = new ByteCodeGenerator(IntType.class, Integer.class, IntWrapper.class);
//        Assert.assertEquals(generator.binaryClassName(), generator.implementationClassName().replace('/', '.'));
//    }
//
//    public void testMethodDescriptor() {
//        ByteCodeGenerator generator = new ByteCodeGenerator(IntType.class, Integer.class, IntWrapper.class);
//        Assert.assertEquals(generator.methodDescriptor(Integer.TYPE), "(" + Type.getType(Integer.TYPE) + ")V");
//    }
//
//    public void testAddTypeSignature() {
//        ByteCodeGenerator generator = new ByteCodeGenerator(IntType.class, Integer.class, IntWrapper.class);
//        Assert.assertEquals(generator.addTypeSignature(Integer.TYPE.toString()), "Lint;");
//    }
//
//    public void testGetILOADOpCodeForInt() {
//        ByteCodeGenerator generator = new ByteCodeGenerator(IntType.class, Integer.TYPE, IntWrapper.class);
//        Assert.assertEquals(generator.getILOADOpCode(Integer.TYPE), 21);
//    }
//
//    public void testGetILOADOpCodeForInteger() {
//        ByteCodeGenerator generator = new ByteCodeGenerator(StringType.class, String.class, StringWrapper.class);
//        Assert.assertEquals(generator.getILOADOpCode(Integer.class), 25);
//    }

    @DataProvider(name = "getWrapper")
    public Object[][] getWrapper() {
        // @formatter:off
        return new Object[][] {
                {BigDecimalType.class, BigDecimal.class, BigDecimalWrapper.class , new BigDecimal("2.2")},
                {BigIntegerType.class, BigInteger.class, BigIntegerWrapper.class , new BigInteger("2")},
                {BooleanType.class, Boolean.TYPE, BooleanWrapper.class , true},
                {ByteType.class, Byte.TYPE, ByteWrapper.class , (byte)1},
                {CharType.class, Character.TYPE, CharWrapper.class , 'Z'},
                {DateType.class, Date.class, DateWrapper.class , new Date()},
                {DoubleType.class, Double.TYPE, DoubleWrapper.class , Double.valueOf(2.2)},
                {IntType.class, Integer.TYPE, IntWrapper.class , 12},
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
    public void testGenerate(Class<?> interfaze, Class<? extends Comparable> technicalType, Class<? extends AbstractValue> superClass, Object value)
                    throws Exception {
        ByteCodeGenerator generator = new ByteCodeGenerator(technicalType, superClass);
        ByteCodeContainer generatedClass = generator.generate(interfaze);
        ByteCodeClassLoader classLoader = ByteCodeClassLoader.getClassLoader();
        Class<?> load = classLoader.load(generatedClass);
        Assert.assertNotNull(load);
        Value<?, ?> valueObject = invokeConstructor(load, value, new Class[] { technicalType });
        Assert.assertEquals(valueObject.getValue(), value);
    }

    private Value<?, ?> invokeConstructor(Class<?> load, Object value, Class<?>[] parameterTypes) {
        try {
            Constructor<?> constructor = load.getConstructor(parameterTypes);
            return (Value<?, ?>)constructor.newInstance(value);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                        | IllegalArgumentException | InvocationTargetException exception) {
            throw new IllegalStateException(exception);
        }
    }

}
