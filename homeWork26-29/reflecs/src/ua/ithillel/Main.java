package ua.ithillel;

import anotation.Start;
import workFiles.SearchFile;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        SearchFile searchFile = new SearchFile();
        List<Class> classList = searchFile.addClassList(new File("/home/peter/IdeaProjects/reflecs/src"));
        for (Class clasName : classList) {
            String name = clasName.getName();
            try {

                Class<?> c = Class.forName(name);
                Start annotation = c.getAnnotation(Start.class);
                String methodInAnnotation = annotation.method();
                Constructor<?> cons = c.getConstructor();
                Object obj = cons.newInstance();
                Method method = obj.getClass().getMethod(methodInAnnotation);
                method.invoke(obj);

            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }


}
