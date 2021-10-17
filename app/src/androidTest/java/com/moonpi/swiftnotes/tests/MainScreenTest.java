package com.moonpi.swiftnotes.tests;

import com.moonpi.swiftnotes.pages.AddNewNotePage;
import com.moonpi.swiftnotes.pages.MainPage;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;

@RunWith(AllureAndroidJUnit4.class)
public class MainScreenTest extends BaseTest {

    MainPage mainPage = new MainPage();
    AddNewNotePage addNewNotePage = new AddNewNotePage();

    @Test
    public void checkUI() {
        mainPage.checkPage();
    }

    @Test
    public void clickAndCheckSearch() {
        mainPage.clickSearch()
                .checkElementsAfterClickSearch()
                .clickEscapeAfterSearch();
    }

    @Test
    public void checkAndCheckContextMenu() {
        mainPage.clickMenu()
                .checkContextMenu();
    }

    @Test
    public void clickPlus() {
        mainPage.clickAddNewNote();
        addNewNotePage.checkAddNewNote();
    }
}