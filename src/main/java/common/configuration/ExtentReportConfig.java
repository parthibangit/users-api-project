package common.configuration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.lang.reflect.Method;

public class ExtentReportConfig {

      private static final Logger logger = LoggerFactory.getLogger(ExtentReportConfig.class);

      public ExtentReports setUpReport() {
          String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"report.html";
          ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
          sparkReporter.config().setReportName("Prototype api automation");
          sparkReporter.config().setTheme(Theme.DARK);
          sparkReporter.config().setDocumentTitle("Api Automation Report");
          ExtentReports extentReports = new ExtentReports();
          extentReports.attachReporter(sparkReporter);
          logger.info("Report set up has done... ");
          return extentReports;

      }

      public ExtentTest newTest(ExtentReports extentReports) {
          ExtentTest extentTest = extentReports.createTest(this.getClass().getSimpleName());
          logger.info("Test creation has done... ");
          return extentTest;
      }

      public ExtentTest getTestMethodsName(ExtentTest extentTest, Method method) {
          ExtentTest node = extentTest.createNode(method.getName());
          logger.info("Test method creation has done for: {}", method.getName());
          return node;
      }

      public void fetchTestInformation(ExtentTest node, ITestResult result) {
          if(result.getStatus() == ITestResult.SUCCESS) {
             node.log(Status.PASS, result.getName() + " test case passed");
             logger.info("Test Passed... ");

          } else if (result.getStatus() == ITestResult.FAILURE) {
              node.log(Status.FAIL, result.getName() + " test case failed");
              node.log(Status.FAIL, result.getThrowable());
              logger.info("Test Failed... ");

          } else {
              node.log(Status.SKIP, result.getName() + " test case skipped");
              logger.info("Test Skipped... ");
          }
      }

      public void updateTestInformationInReport(ExtentReports extentReports) {
          extentReports.flush();
          logger.info("Test information updated in the report... ");
      }

}
