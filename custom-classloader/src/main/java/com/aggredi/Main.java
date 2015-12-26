package com.aggredi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Serik Idrissov
 * 12/26/15
 */
public class Main {

    public static void main(String[] args) {
        CustomClassLoader customClassLoader =
                new CustomClassLoader(Main.class.getClassLoader(), "/home/serik/projects/classloader-example/custom-classloader/src/main/resources/second/Semaphore.class");
        try {
            Class<?> aClass = customClassLoader.loadClass("com.aggredi.Semaphore");
            Object o = aClass.newInstance();
            Method lever = o.getClass().getMethod("lever");
            lever.invoke(o);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
