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
public class ByteCodeGenerator {

    private static final int OBJECT_PRIMITIVE_SIZE = 2;
    private static final int DOUBLE_SIZE = 3;
    private static final String GENERATED_VO_INDICATOR = "$VO$";
    private static final String CONTRUCTOR = "<init>";

    private final Class<?> superClass;
    private final Class<?> technicalType;

    /**
     * Create a new ByteCodeGenerator instance.
     * @param type
     * @param class1
     */
    public ByteCodeGenerator(Class<? extends Comparable> technicalType, Class<? extends AbstractValue> wrapperClass) {
        this.technicalType = technicalType;
        this.superClass = wrapperClass;
    }

    static String generateImplementationClassName(Class<?> valueType) {
        String name = Type.getInternalName(valueType);
        return name + GENERATED_VO_INDICATOR + Integer.toHexString(name.hashCode());
    }

    String implementationClassName(Class<?> valueType) {
        return ByteCodeGenerator.generateImplementationClassName(valueType);
    }

    String interfaceName(Class<?> valueType) {
        return Type.getInternalName(valueType);
    }

    String binaryClassName(Class<?> valueType) {
        return implementationClassName(valueType).replace('/', '.');
    }

    String parentClassName() {
        return Type.getInternalName(superClass);
    }

    String[] implementedInterfaces(Class<?> valueType) {
        return new String[] { interfaceName(valueType) };
    }

    String methodDescriptor(Class<?> type) {
        return "(" + getType(type) + ")V";
    }

    String addTypeSignature(String type) {
        return "L" + type + ";";
    }

    int getILOADOpCode(Class<?> type) {
        return Type.getType(technicalType).getOpcode(Opcodes.ILOAD);
    }

    int getStackSize(String desc) {
        switch (desc.charAt(0)) {
            case 'D':
            case 'J':
                return DOUBLE_SIZE;
            default:
                return OBJECT_PRIMITIVE_SIZE;
        }
    }

    private String addTypeDiscriptor(Class<?> type) {
        return Type.getDescriptor(type);
    }

    private String getType(Class<?> type) {
        return Type.getType(type).toString();
    }

    /* CHECKSTYLE:OFF */
    public ByteCodeContainer generate(Class<?> valueType) {
        /* CHECKSTYLE:ON */

        ClassWriter classWriter = new ClassWriter(0);
        MethodVisitor methodVisitor;

        classWriter.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, implementationClassName(valueType), "L" + parentClassName() + "<"
                        + addTypeDiscriptor(valueType) + ">;" + addTypeDiscriptor(valueType),
                        parentClassName(), implementedInterfaces(valueType));

        methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, CONTRUCTOR, methodDescriptor(technicalType), null, null);
        methodVisitor.visitCode();
        Label l0 = new Label();
        methodVisitor.visitLabel(l0);
        methodVisitor.visitLineNumber(8, l0);
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
        methodVisitor.visitVarInsn(getILOADOpCode(technicalType), 1);
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, parentClassName(), CONTRUCTOR, methodDescriptor(technicalType),
                        false);
        Label l1 = new Label();
        methodVisitor.visitLabel(l1);
        methodVisitor.visitLineNumber(9, l1);
        methodVisitor.visitInsn(Opcodes.RETURN);
        Label l2 = new Label();
        methodVisitor.visitLabel(l2);
        methodVisitor.visitLocalVariable("this", addTypeSignature(implementationClassName(valueType)), null, l0, l2, 0);
        methodVisitor.visitLocalVariable("value", getType(technicalType), null, l0, l2, 1);
        int stackSize = getStackSize(Type.getDescriptor(technicalType));
        methodVisitor.visitMaxs(stackSize, stackSize);
        methodVisitor.visitEnd();
        classWriter.visitEnd();

        return new ByteCodeContainer(binaryClassName(valueType), classWriter.toByteArray());
    }

}
