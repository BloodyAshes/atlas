package counter;

import io.qameta.allure.Step;
import org.testng.Assert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;



public class WriteFile {

    private static final File methodsTest = new File("src/test/TestMethods.txt");

    @Step("Method writes test methods witch had been saved to {Map<String, String> map}")
    public static void writeToFile(HashSet<String> setList) {
        try {
            FileWriter fileWriter = new FileWriter(methodsTest);
            for (String testMethod : setList) {
                fileWriter.write(testMethod);
            }
            System.out.println("File written");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Step("Method returns methods from the file")
    public static File getMethodsFile() {
        return methodsTest;
    }
}
