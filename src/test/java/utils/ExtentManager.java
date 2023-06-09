package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();
    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setReportName("DS Algo");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Team Name", "Ninja Leaners");
        extentReports.setSystemInfo("Author", "Group4");
        return extentReports;
    }
}
