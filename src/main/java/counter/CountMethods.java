package counter;

import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashSet;

import static counter.WriteFile.writeToFile;

public class CountMethods {

    public static void countMethods (String className) throws ClassNotFoundException{
         Class<?> cls = Class.forName(className);
        HashSet<String> usedMethods = new HashSet<>();
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                usedMethods.add(method.getName() + ", ");
            }
            writeToFile(usedMethods);
        }
    }
}
