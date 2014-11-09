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

/**
 * Generate a implementation of a value object interface.
 */
public class ByteCodeGenerator implements Opcodes {

    private static final String GENERATED_VO_INDICATOR = "$VO$";
    private static final String CONTRUCTOR = "<init>";

    private final Class<?> implementedInterface;
    private final Class<?> superClass;
    private final Class<?> technicalType;

    public ByteCodeGenerator(Class<?> interfaceType, Class<?> type, Class<?> superClass) {
        this.implementedInterface = interfaceType;
        this.technicalType = type;
        this.superClass = superClass;
    }

    String implementationClassName() {
        String name = Type.getInternalName(implementedInterface);
        return name + GENERATED_VO_INDICATOR + Integer.toHexString(name.hashCode());
    }

    String interfaceName() {
        return Type.getInternalName(implementedInterface);
    }

    String binaryClassName() {
        return implementationClassName().replace('/', '.');
    }

    String parentClassName() {
        return Type.getInternalName(superClass);
    }

    String[] implementedInterfaces() {
        return new String[] { interfaceName() };
    }

    String methodDescriptor(Class<?> type) {
        return "(" + getType(type) + ")V";
    }

    String addTypeSignature(String type) {
        return "L" + type + ";";
    }

    private String addTypeDiscriptor(Class<?> type) {
        return Type.getDescriptor(type);
    }

    private String getType(Class<?> type) {
        return Type.getType(type).toString();
    }

    /* CHECKSTYLE:OFF */
    public ByteCodeContainer generate() {

        ClassWriter classWriter = new ClassWriter(0);
        MethodVisitor methodVisitor;

        classWriter.visit(V1_7, ACC_PUBLIC + ACC_SUPER, implementationClassName(), "L" + parentClassName() + "<"
                        + addTypeDiscriptor(implementedInterface) + ">;" + addTypeDiscriptor(implementedInterface),
                        parentClassName(), implementedInterfaces());

        methodVisitor = classWriter.visitMethod(ACC_PUBLIC, CONTRUCTOR, methodDescriptor(technicalType), null, null);
        methodVisitor.visitCode();
        Label l0 = new Label();
        methodVisitor.visitLabel(l0);
        methodVisitor.visitLineNumber(8, l0);
        methodVisitor.visitVarInsn(ALOAD, 0);
        methodVisitor.visitVarInsn(ILOAD, 1);
        methodVisitor.visitMethodInsn(INVOKESPECIAL, parentClassName(), CONTRUCTOR, methodDescriptor(technicalType),
                        false);
        Label l1 = new Label();
        methodVisitor.visitLabel(l1);
        methodVisitor.visitLineNumber(9, l1);
        methodVisitor.visitInsn(RETURN);
        Label l2 = new Label();
        methodVisitor.visitLabel(l2);
        methodVisitor.visitLocalVariable("this", addTypeSignature(implementationClassName()), null, l0, l2, 0);
        methodVisitor.visitLocalVariable("value", getType(technicalType), null, l0, l2, 1);
        methodVisitor.visitMaxs(2, 2);
        methodVisitor.visitEnd();
        classWriter.visitEnd();

        return new ByteCodeContainer(binaryClassName(), classWriter.toByteArray());
    }
    /* CHECKSTYLE:ON */
}
