package com.testautomator;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.test.InstrumentationTestCase;


/**
 * Created by rnewton on 11/7/17.
 */
public class MainApplicationTest extends InstrumentationTestCase {

    private UiDevice device;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        // Open the simulator and head to the home screen
        device = UiDevice.getInstance(getInstrumentation());
        device.pressHome();
        device.wait(Until.hasObject(By.desc("Apps list")), 3000);

        // Open up the list of apps
        UiObject2 appsButton = device.findObject(By.desc("Apps list"));
        appsButton.click();
        device.wait(Until.hasObject(By.text("TestAutomator")), 3000);

        // Open our app
        UiObject2 testAutomatorApp = device.findObject(By.text("TestAutomator"));
        testAutomatorApp.click();
    }

    public void testToggleShowsGreenBox() throws Exception {
        BySelector greenBoxSelector = By.desc("greenBox");
        BySelector buttonSelector = By.desc("toggleButton");

        // Find the toggle button and click it
        device.wait(Until.hasObject(buttonSelector), 3000);
        UiObject2 button = device.findObject(buttonSelector);
        button.click();

        // Find the green box and assert it exists
        device.wait(Until.hasObject(greenBoxSelector), 3000);
        Boolean greenBoxExists = device.hasObject(greenBoxSelector);
        assertTrue("The green box exists", greenBoxExists);
    }

    public void testGreenBoxDoesNotExistToStart() throws Exception {
        BySelector greenBoxSelector = By.desc("greenBox");

        // Load the application and assert it doesn't exist to start
        device.waitForIdle();
        Boolean greenBoxExists = device.hasObject(greenBoxSelector);
        assertFalse("The green box does not exist to start", greenBoxExists);
    }

    public void tearDown() throws Exception {

    }
}