package com.moonpi.swiftnotes.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.moonpi.swiftnotes.DeviceUtil.checkKeyboard;

import android.view.View;

import com.moonpi.swiftnotes.R;

import org.hamcrest.Matcher;

import io.qameta.allure.kotlin.Step;

public class MainPage {

    private Matcher<View> newNote = withId(R.id.newNote);
    private Matcher<View> searchButton = withId(R.id.action_search);
    private Matcher<View> menuButton = withContentDescription("More options");
    private Matcher<View> swiftNotes = withText("Swiftnotes");
    private Matcher<View> pressPlus = withText("Press '+' to add new note");
    private Matcher<View> searchField = withId(R.id.search_src_text);
    private Matcher<View> escapeAfterSearchButton = withContentDescription("Collapse");
    private Matcher<View> backupNotes = withText("Backup notes");
    private Matcher<View> restoreNotes = withText("Restore notes");
    private Matcher<View> rateApp = withText("Rate app");

    @Step("Проверка UI")
    public MainPage checkPage() {
        onView(newNote).check(matches(isDisplayed()));
        onView(searchButton).check(matches(isDisplayed()));
        onView(menuButton).check(matches(isDisplayed()));
        onView(swiftNotes).check(matches(isDisplayed()));
        onView(pressPlus).check(matches(isDisplayed()));
        return this;
    }

    @Step("Клик Search")
    public MainPage clickSearch() {
        onView(searchButton).perform(click());
        return this;
    }

    @Step("Проверка отображения поля поиска")
    public MainPage checkElementsAfterClickSearch() {
        onView(searchField).check(matches(isDisplayed()));
        onView(menuButton).check(matches(isDisplayed()));
        onView(escapeAfterSearchButton).check(matches(isDisplayed()));
        checkKeyboard();
        return this;
    }

    @Step("Клик назад при поиске")
    public MainPage clickEscapeAfterSearch() {
        onView(escapeAfterSearchButton).perform(click());
        return this;
    }

    @Step("Клик Menu")
    public MainPage clickMenu() {
        onView(menuButton).perform(click());
        return this;
    }

    @Step("Проверка отображения контекстного меню")
    public MainPage checkContextMenu() {
        onView(backupNotes).check(matches(isDisplayed()));
        onView(restoreNotes).check(matches(isDisplayed()));
        onView(rateApp).check(matches(isDisplayed()));
        return this;
    }

    @Step("Клик по newNote")
    public MainPage clickAddNewNote() {
        onView(newNote).perform(click());
        return this;
    }

    @Step("Проверка отображения страницы создания новой заметки")
    public MainPage checkNewNote() {
        onView(backupNotes).check(matches(isDisplayed()));
        onView(restoreNotes).check(matches(isDisplayed()));
        onView(rateApp).check(matches(isDisplayed()));
        return this;
    }
}
