package com.moonpi.swiftnotes;

import static org.junit.Assert.assertTrue;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;

import java.io.IOException;

import io.qameta.allure.kotlin.Step;

public class DeviceUtil {
    @Step("Проверка отображения клавиатуры")
    public static void checkKeyboard() {
        try {
            assertTrue(isKeyboardOpenedShellCheck());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isKeyboardOpenedShellCheck() throws IOException {
        return UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
                .executeShellCommand("dumpsys input_method | grep mInputShown").contains("mInputShown=true");
    }
}
