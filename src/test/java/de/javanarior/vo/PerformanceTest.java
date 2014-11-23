package de.javanarior.vo;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import de.javanarior.vo.generator.helper.StringType;

@Test
public class PerformanceTest {

    private List<WeakReference<StringType>> list;

    /**
     *
     */
    private static final int MAX = 100_000_000;

    @BeforeMethod
    public void setUp() throws Exception {
        list = new ArrayList<WeakReference<StringType>>(MAX);
        System.out.println("Waiting for input...");
        System.in.read();
        System.out.println("Thanks!");
    }

    public void testStatic() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < MAX; i++) {
            StringType value = TypeStringS.create(StringType.class, i);
            list.add(new WeakReference<StringType>(value));
        }
        long end = System.currentTimeMillis();
        System.out.println("Static: "  + (end - start));
    }

    public void testInstance() {
        long start = System.currentTimeMillis();
        TypeString factory = new TypeString();
        for (int i = 0; i < MAX; i++) {
            StringType value = factory.create(StringType.class, i);
            list.add(new WeakReference<StringType>(value));
        }
        long end = System.currentTimeMillis();
        System.out.println("Instance: "  + (end - start));
    }
}
