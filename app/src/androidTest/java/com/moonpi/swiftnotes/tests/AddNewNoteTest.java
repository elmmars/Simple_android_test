package com.moonpi.swiftnotes.tests;

import com.moonpi.swiftnotes.pages.AddNewNotePage;
import com.moonpi.swiftnotes.pages.MainPage;

import org.junit.Before;
import org.junit.Test;

public class AddNewNoteTest extends BaseTest {
    MainPage mainPage = new MainPage();
    AddNewNotePage addNewNotePage = new AddNewNotePage();

    @Before
    public void setUp() {
        mainPage.clickAddNewNote();
    }

    @Test
    public void checkSaveChangesNoteDialog() {
        addNewNotePage.clickOnBack();
        addNewNotePage.checkSaveChangesNoteDialog();
    }

    @Test
    public void clickAndCheckChangeColorButton() {
        addNewNotePage.clickChangeColorButton()
                .checkChangeColorMenu();
    }

    @Test
    public void clickAndCheckContextMenu() {
        addNewNotePage.clickMenuButton()
                .checkContextMenu();
    }

    @Test
    public void clickAndCheckNoteFontSize() {
        addNewNotePage.clickMenuButton()
                .clickNoteFontSizeButton()
                .checkNoteFontSizeMenu();
    }

    @Test
    public void typeAndCheckTitleAndTextOfNewNote() {
        addNewNotePage.typeAndCheckTitle("Some title")
                .clickOnNote()
                .typeAndCheckNote("Text");
    }

    @Test
    public void addNewNote() {
        addNewNotePage.typeAndCheckTitle("Some title")
                .clickOnNote()
                .typeAndCheckNote("Text")
                .clickOnBack()
                .clickNo();
    }

    @Test
    public void changeColorNote() {
        addNewNotePage.changeNoteColor();
    }
}
