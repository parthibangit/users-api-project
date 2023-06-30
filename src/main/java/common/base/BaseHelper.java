package common.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import common.configuration.ExtentReportConfig;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseHelper extends ExtentReportConfig {

    public ExtentReportConfig reportConfig = new ExtentReportConfig();
    public ExtentReports extentReports;
    public ExtentTest extentTest;
    public ExtentTest extentNode;


    @BeforeSuite
    public void initReport() {
        extentReports = reportConfig.setUpReport();
    }

    @BeforeTest
    public void createTest() {
        extentTest = reportConfig.newTest(extentReports);
    }

    @AfterSuite
    public void updateReport() {
        reportConfig.updateTestInformationInReport(extentReports);
    }

}
