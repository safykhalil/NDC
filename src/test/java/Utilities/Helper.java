package Utilities;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {
    public static void capturescreenshot(SHAFT.GUI.WebDriver driver, String screenshotname) {
        Path dest = Paths.get(".//Screenshots", screenshotname);
        try {
            Files.createDirectories(dest.getParent());
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("failure , screenshot takes" + e.getMessage());
        }
    }
}


