package com.aggredi;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Serik Idrissov
 * 12/26/15
 */
public class CustomClassLoader extends ClassLoader {

    private String pathToFile;

    public CustomClassLoader(ClassLoader parent, String pathToFile) {
        super(parent);
        this.pathToFile = pathToFile;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> aClass = null;
        try {
            aClass = findClass(name);
        } catch (ClassNotFoundException e) {

        }
        if (aClass != null) {
            return aClass;
        }

        try {

            aClass = super.loadClass(name);
        } catch (ClassNotFoundException e) {

        }
        if (aClass != null) {
            return aClass;
        }

        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Paths.get(pathToFile));

        } catch (IOException e) {
            e.printStackTrace();
        }

        if(bytes == null)
            throw new ClassNotFoundException();
        return defineClass(name, bytes, 0, bytes.length);

    }


}
