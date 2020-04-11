package se.dsve;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("JUnit Platform Suite Demo")
@SelectClasses( { UsersTest.class, AdminsTest.class, StandardUserTest.class, ControllerTest.class,
        SmokeTest.class,
        UserInputTest.class, UserManagementTest.class} )
public class JUnit5TestSuite {
}


