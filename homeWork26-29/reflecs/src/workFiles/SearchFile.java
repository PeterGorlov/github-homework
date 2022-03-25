package workFiles;

import anotation.Start;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SearchFile {
    private final int LENGTH_DIRECTORY = 37;
    private final int EXPANSION_FILE = 5; //.java
    public static final String PATH_DIRECTORY = "/home/peter/IdeaProjects/reflecs/src"; //LENGTH_DIRECTORY

    public List<Class> addClassList(File rootFile) {
        List<String> list = new ArrayList<>();
        if (PATH_DIRECTORY.equals(String.valueOf(rootFile))) {
            addClassList(rootFile, list);
        } else {
            System.out.println("No correctly Path");
        }
        List<String> rtcp = replaceToClassPath(list);
        return replaceToClassList(rtcp);
    }

    private List<String> addClassList(File rootFile, List<String> fileList) {
        if (rootFile.isDirectory()) {
            File[] directoryFiles = rootFile.listFiles();
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        addClassList(file, fileList);
                    } else {
                        if (file.getName().toLowerCase().endsWith(".java")) {
                            fileList.add(String.valueOf(file)
                                    .substring(LENGTH_DIRECTORY,
                                            String.valueOf(file).length() - EXPANSION_FILE));
                        }
                    }
                }
            }
        }
        return fileList;
    }


    private List<String> replaceToClassPath(List<String> list) {
        List<String> listNew = new ArrayList<>();
        for (String s : list) {
            s = s.replace('/', '.');
            listNew.add(s);
        }
        return listNew;
    }

    private List<Class> replaceToClassList(List<String> list) {
        List<Class> classes = new ArrayList<>();
        for (String path : list) {
            try {
                Class<?> clazz = Class.forName(path);
                Annotation annotations = clazz.getAnnotation(Start.class);
                if (annotations instanceof Start) {
                    classes.add(clazz);
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        classes.sort(comparator);
        return classes;
    }

    static Comparator<Class> comparator = new Comparator<>() {
        @Override
        public int compare(Class o1, Class o2) {
            try {
                Class<?> c1 = Class.forName(o1.getName());
                Class<?> c2 = Class.forName(o2.getName());
                int p1 = c1.getAnnotation(Start.class).priority();
                int p2 = c2.getAnnotation(Start.class).priority();
                if (p1 > p2) {
                    return 1;
                } else {
                    return -1;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return 0;
        }
    };
}
