package Collinson.VendingMachineProgram;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
 
public class ListnerTest extends TestListenerAdapter {
	public ExtentSparkReporter reporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testContext) {
		String path = System.getProperty("user.dir") + "/reports/ExtentTestReport.html";
		reporter = new ExtentSparkReporter(path);
		try {
			reporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		reporter.config().setReportName("Vending Machine Test Report");
		reporter.config().setDocumentTitle("Extent Test Report");
		reporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "Suchita Thorat");
	}

	public void onTestSuccess(ITestResult tr) {
		// create new entry in the report 
		logger = extent.createTest(tr.getName());
		// send the passed information to the report with GREEN color highlighted
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult tr) {
		// create new entry in the report
		logger = extent.createTest(tr.getName());
		// send the failed information to the report with RED color highlighted
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	}

	public void onTestSkipped(ITestResult tr) {
		// create new entry in the report
		logger = extent.createTest(tr.getName()); 
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

}