$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/CHERRY/workspace/CucumberWithJava/src/test/java/Feature/demoSite.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 20,
  "name": "Automation Demo Site Registration page.",
  "description": "",
  "id": "automation-demo-site-registration-page.",
  "keyword": "Feature",
  "tags": [
    {
      "line": 19,
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "line": 23,
  "name": "Demo Site User registration",
  "description": "",
  "id": "automation-demo-site-registration-page.;demo-site-user-registration",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 22,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "User wants to configure the browser",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "User provide the specified URL",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "Verify User on Registration Page",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "User Enter all the required inforation",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "User clicking the Submitt button",
  "keyword": "Then "
});
formatter.match({
  "location": "DemoReg.user_wants_to_configure_the_browser()"
});
formatter.result({
  "duration": 1025008407,
  "error_message": "java.lang.IllegalStateException: The path to the driver executable must be set by the webdriver.gecko.driver system property; for more information, see https://github.com/mozilla/geckodriver. The latest version can be downloaded from https://github.com/mozilla/geckodriver/releases\r\n\tat com.google.common.base.Preconditions.checkState(Preconditions.java:754)\r\n\tat org.openqa.selenium.remote.service.DriverService.findExecutable(DriverService.java:124)\r\n\tat org.openqa.selenium.firefox.GeckoDriverService.access$100(GeckoDriverService.java:41)\r\n\tat org.openqa.selenium.firefox.GeckoDriverService$Builder.findDefaultExecutable(GeckoDriverService.java:141)\r\n\tat org.openqa.selenium.remote.service.DriverService$Builder.build(DriverService.java:339)\r\n\tat org.openqa.selenium.firefox.FirefoxDriver.toExecutor(FirefoxDriver.java:158)\r\n\tat org.openqa.selenium.firefox.FirefoxDriver.\u003cinit\u003e(FirefoxDriver.java:120)\r\n\tat org.openqa.selenium.firefox.FirefoxDriver.\u003cinit\u003e(FirefoxDriver.java:98)\r\n\tat stepDefFile.DemoReg.user_wants_to_configure_the_browser(DemoReg.java:32)\r\n\tat ✽.Given User wants to configure the browser(C:/Users/CHERRY/workspace/CucumberWithJava/src/test/java/Feature/demoSite.feature:24)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "DemoReg.user_provide_the_specified_URL()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DemoReg.verify_User_on_Registration_Page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DemoReg.user_Enter_all_the_required_inforation()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DemoReg.user_clicking_the_Submitt_button()"
});
formatter.result({
  "status": "skipped"
});
});