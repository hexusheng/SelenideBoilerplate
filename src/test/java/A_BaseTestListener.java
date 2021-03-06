import helpers.Driver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class A_BaseTestListener implements ITestListener {

    @Attachment(value = "error screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) Driver.currentDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestStart(ITestResult TestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult TestResult) {

    }

    @Override
    public void onTestFailure(ITestResult TestResult)
    {
        takeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult TestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult TestResult) {
        takeScreenshot();
    }

    @Override
    public void onStart(ITestContext TestContext) {

    }

    @Override
    public void onFinish(ITestContext TestContext) {

    }

}
