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

import org.objectweb.asm.Type;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import de.javanarior.utils.lang.ByteCodeClassLoader;
import de.javanarior.utils.lang.GeneratedClass;
import de.javanarior.vo.generator.helper.IntType;
import de.javanarior.vo.generator.helper.StringType;
import de.javanarior.vo.types.IntWrapper;
import de.javanarior.vo.types.StringWrapper;

@Test
public class ByteCodeGeneratorTest {

    public void testImplementedInterfaces() {
        ByteCodeGenerator generator = new ByteCodeGenerator(IntType.class, Integer.class, IntWrapper.class);
        Assert.assertEquals(generator.implementedInterfaces()[0], IntType.class.getName().replace('.', '/'));
    }

    // public void testTechnicalType() {
    // ByteCodeGenerator generator = new ByteCodeGenerator(IntType.class,
    // Integer.class, IntWrapper.class);
    // Assert.assertEquals(generator.technicalType(), "I");
    // }

    public void testParentClassName() {
        ByteCodeGenerator generator = new ByteCodeGenerator(IntType.class, Integer.class, IntWrapper.class);
        Assert.assertEquals(generator.parentClassName(), IntWrapper.class.getName().replace('.', '/'));
    }

    public void testImplementationClassName() {
        ByteCodeGenerator generator = new ByteCodeGenerator(IntType.class, Integer.class, IntWrapper.class);
        String implementedInterfaceName = IntType.class.getName().replace(".", "/");
        String generatedNamePart = "$VO$" + Integer.toHexString(implementedInterfaceName.hashCode());
        Assert.assertEquals(generator.implementationClassName(), implementedInterfaceName + generatedNamePart);
        System.out.println(implementedInterfaceName + generatedNamePart);
        Assert.assertTrue(generator.implementationClassName().matches(implementedInterfaceName + "\\$VO\\$[0-9a-f]+"));
    }

    public void testInterfaceName() {
        ByteCodeGenerator generator = new ByteCodeGenerator(IntType.class, Integer.class, IntWrapper.class);
        Assert.assertEquals(generator.interfaceName(), IntType.class.getName().replace(".", "/"));
    }

    public void testBinaryClassName() {
        ByteCodeGenerator generator = new ByteCodeGenerator(IntType.class, Integer.class, IntWrapper.class);
        Assert.assertEquals(generator.binaryClassName(), generator.implementationClassName().replace('/', '.'));
    }

    public void testMethodDescriptor() {
        ByteCodeGenerator generator = new ByteCodeGenerator(IntType.class, Integer.class, IntWrapper.class);
        Assert.assertEquals(generator.methodDescriptor(Integer.TYPE), "(" + Type.getType(Integer.TYPE) + ")V");
    }

    @DataProvider(name = "getWrapper")
    public Object[][] getWrapper() throws Exception {
        // @formatter:off
        return new Object[][] {
                {IntType.class, Integer.TYPE, IntWrapper.class },
                {StringType.class, String.class, StringWrapper.class }
        };
        // @formatter:on
    }

    @Test(dataProvider = "getWrapper")
    public void testGenerate(Class<?> interfaze, Class<?> technicalType, Class<?> superClass) throws Exception {
        ByteCodeGenerator generator = new ByteCodeGenerator(interfaze, technicalType, superClass);
        GeneratedClass generatedClass = generator.generate();
        ByteCodeClassLoader classLoader = ByteCodeClassLoader.getClassLoader();
        Class<?> load = classLoader.load(generatedClass);
        Assert.assertNotNull(load);
        // load.newInstance();
    }

    // @SuppressWarnings("unchecked")
    // private static <T extends Value<?,T>> T invokeConstructor(Class<? extends
    // T> clazz, Class<?>[] parameterTypes, int value) {
    // Constructor<?> constructor;
    // try {
    // constructor = clazz.getConstructor(parameterTypes);
    // return (T)constructor.newInstance(value);
    // } catch (NoSuchMethodException | InstantiationException |
    // IllegalAccessException | SecurityException
    // | IllegalArgumentException | InvocationTargetException exception) {
    // // TODO Change RuntimeExpection
    // throw new RuntimeException(exception);
    // }
    // }
}
