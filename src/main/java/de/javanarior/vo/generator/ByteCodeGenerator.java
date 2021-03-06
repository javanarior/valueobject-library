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

import java.lang.reflect.Modifier;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import de.javanarior.utils.lang.ByteCodeContainer;
import de.javanarior.vo.types.AbstractValue;

/**
 * Generate a implementation of a value object interface.
 */
public final class ByteCodeGenerator {

    private static final int OBJECT_PRIMITIVE_SIZE = 2;
    private static final int DOUBLE_SIZE = 3;
    private static final String GENERATED_VO_INDICATOR = "$VO$";
    private static final String CONSTRUCTOR = "<init>";

    private ByteCodeGenerator() {
    }

    static String generateImplementationClassName(Class<?> valueType) {
        String name = Type.getInternalName(valueType);
        return name + GENERATED_VO_INDICATOR + Integer.toHexString(name.hashCode());
    }

    static String implementationClassName(Class<?> valueType) {
        return ByteCodeGenerator.generateImplementationClassName(valueType);
    }

    static String interfaceName(Class<?> valueType) {
        return Type.getInternalName(valueType);
    }

    static String binaryClassName(Class<?> valueType) {
        return implementationClassName(valueType).replace('/', '.');
    }

    static String parentClassName(Class<?> superClass) {
        return Type.getInternalName(superClass);
    }

    static String[] implementedInterfaces(Class<?> valueType) {
        return new String[] { interfaceName(valueType) };
    }

    static String methodDescriptor(Class<?> type) {
        return "(" + getType(type) + ")V";
    }

    static String addTypeSignature(String type) {
        return "L" + type + ";";
    }

    static int getILOADOpCode(Class<?> type) {
        return Type.getType(type).getOpcode(Opcodes.ILOAD);
    }

    static int getStackSize(String desc) {
        switch (desc.charAt(0)) {
            case 'D':
            case 'J':
                return DOUBLE_SIZE;
            default:
                return OBJECT_PRIMITIVE_SIZE;
        }
    }

    static String addTypeDiscriptor(Class<?> type) {
        return Type.getDescriptor(type);
    }

    static String getType(Class<?> type) {
        return Type.getType(type).toString();
    }

    /**
     * Generate a implementation of a value object.
     *
     * @param valueType
     *            - value object type
     * @param technicalType
     *            - to which the value object is mapped
     * @param wrapperClass
     *            - abstract wrapper class, correspond to the technical type
     * @return class name and byte code in a container
     */
    /* CHECKSTYLE:OFF */
    public static ByteCodeContainer generate(Class<?> valueType, Class<? extends Comparable<?>> technicalType,
                    @SuppressWarnings("rawtypes") Class<? extends AbstractValue> wrapperClass) {
        /* CHECKSTYLE:ON */

        if (!isInterface(valueType)) {
            throw new IllegalArgumentException("Could not generate implementation for class " + valueType.getName()
                            + ". Please provide interface");
        }

        ClassWriter classWriter = new ClassWriter(0);
        MethodVisitor methodVisitor;

        classWriter.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, implementationClassName(valueType), "L"
                        + parentClassName(wrapperClass) + "<"
                        + addTypeDiscriptor(valueType) + ">;" + addTypeDiscriptor(valueType),
                        parentClassName(wrapperClass), implementedInterfaces(valueType));

        methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, CONSTRUCTOR, methodDescriptor(technicalType), null,
                        null);
        methodVisitor.visitCode();
        Label label0 = new Label();
        methodVisitor.visitLabel(label0);
        /* CHECKSTYLE:OFF */
        methodVisitor.visitLineNumber(8, label0);
        /* CHECKSTYLE:ON */
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
        methodVisitor.visitVarInsn(getILOADOpCode(technicalType), 1);
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, parentClassName(wrapperClass), CONSTRUCTOR,
                        methodDescriptor(technicalType),
                        false);
        Label label1 = new Label();
        methodVisitor.visitLabel(label1);
        /* CHECKSTYLE:OFF */
        methodVisitor.visitLineNumber(9, label1);
        /* CHECKSTYLE:ON */
        methodVisitor.visitInsn(Opcodes.RETURN);
        Label label2 = new Label();
        methodVisitor.visitLabel(label2);
        methodVisitor.visitLocalVariable("this", addTypeSignature(implementationClassName(valueType)), null, label0,
                        label2, 0);
        methodVisitor.visitLocalVariable("value", getType(technicalType), null, label0, label2, 1);
        int stackSize = getStackSize(Type.getDescriptor(technicalType));
        methodVisitor.visitMaxs(stackSize, stackSize);
        methodVisitor.visitEnd();
        classWriter.visitEnd();

        return new ByteCodeContainer(binaryClassName(valueType), classWriter.toByteArray());
    }

    private static boolean isInterface(Class<?> valueType) {
        return Modifier.isInterface(valueType.getModifiers());
    }

}
