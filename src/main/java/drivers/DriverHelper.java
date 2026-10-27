package drivers;

import org.openqa.selenium.WebDriver;

public class DriverHelper {

    public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        threadLocal.set(driver);
    }
    public static WebDriver getDriver() {
        return threadLocal.get();
    }
}
