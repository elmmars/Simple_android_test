package com.moonpi.swiftnotes.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.adevinta.android.barista.interaction.BaristaClickInteractions.clickOn;
import static com.moonpi.swiftnotes.DeviceUtil.checkKeyboard;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static java.util.Arrays.asList;

import android.support.v7.widget.AppCompatImageButton;
import android.view.View;

import com.moonpi.swiftnotes.R;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.ArrayList;

import io.qameta.allure.kotlin.Step;

public class AddNewNotePage {

    private Matcher<View> titleField = withId(R.id.titleEdit);
    private Matcher<View> noteField = withId(R.id.bodyEdit);
    private Matcher<View> changeColorButton = withId(R.id.action_note_colour);
    private Matcher<View> changeNoteColor = withText("Change note color");

    private Matcher<View> blueColorButton = withContentDescription("#44A1EB");
    private Matcher<View> mintColorButton = withContentDescription("#77DDBB");
    private Matcher<View> lightGreenColorButton = withContentDescription("#BBE535");
    private Matcher<View> yellowColorButton = withContentDescription("#EEEE22");
    private Matcher<View> orangeColorButton = withContentDescription("#FFBB22");
    private Matcher<View> lightRedColorButton = withContentDescription("#F56545");
    private Matcher<View> pinkColorButton = withContentDescription("#FF5997");
    private Matcher<View> purpleColorButton = withContentDescription("#A767FF");
    private Matcher<View> whiteColorButton = withContentDescription("#FFFFFF");
    private Matcher<View> menuButton = withContentDescription("More options");
    private Matcher<View> noteFontSize = withText("Note font size");
    private Matcher<View> noteFontSizeTitle = withText("Change note font size");
    private Matcher<View> smallButton = withText("Small");
    private Matcher<View> mediumButton = withText("Medium");
    private Matcher<View> largeButton = withText("Large");
    private Matcher<View> cancelButton = withText("Cancel");
    private Matcher<View> hideOrShowNoteBody = withText("Hide note body in list");
    private Matcher<View> backButton = allOf(Matchers.<View>instanceOf(AppCompatImageButton.class), withParent(withId(R.id.toolbarEdit)));
    private Matcher<View> saveChanges = withText("Save changes?");
    private Matcher<View> yesButton = withText("Yes");
    private Matcher<View> noButton = withText("No");
    private ArrayList<Matcher<View>> list = new ArrayList<>(asList(blueColorButton, mintColorButton, lightGreenColorButton, yellowColorButton, orangeColorButton, lightRedColorButton, pinkColorButton, purpleColorButton, whiteColorButton));

    @Step("Проверка отображения экрана создания новой заметки")
    public AddNewNotePage checkAddNewNote() {
        onView(titleField).check(matches(isDisplayed()));
        onView(noteField).check(matches(isDisplayed()));
        onView(changeColorButton).check(matches(isDisplayed()));
        onView(menuButton).check(matches(isDisplayed()));
        onView(backButton).check(matches(isDisplayed()));
        checkKeyboard();
        return this;
    }

    @Step("Клик назад")
    public AddNewNotePage clickOnBack() {
        onView(backButton).perform(click());
        return this;
    }

    @Step("Проверка экрана сохранения изменений")
    public AddNewNotePage checkSaveChangesNoteDialog() {
        onView(saveChanges).check(matches(isDisplayed()));
        onView(yesButton).check(matches(isDisplayed()));
        onView(noButton).check(matches(isDisplayed()));
        return this;
    }

    @Step("Клик по кнопке изменения цвета в окне сохранения пустой заметки")
    public AddNewNotePage clickChangeColorButton() {
        onView(changeColorButton).perform(click());
        return this;
    }

    @Step("Проверка экрана изменения цвета")
    public AddNewNotePage checkChangeColorMenu() {
        onView(changeNoteColor).check(matches(isDisplayed()));
        for (int i = 0; i < list.size(); i++) {
            onView(list.get(i)).check(matches(isDisplayed()));
        }
        return this;
    }

    @Step("Клик по кнопке контекстного меню при создании пустой заметки")
    public AddNewNotePage clickMenuButton() {
        onView(menuButton).perform(click());
        return this;
    }

    @Step("Проверка экрана контекстного меню")
    public AddNewNotePage checkContextMenu() {
        onView(noteFontSize).check(matches(isDisplayed()));
        onView(hideOrShowNoteBody).check(matches(isDisplayed()));
        return this;
    }

    @Step("Клик по кнопке изменения шрифта")
    public AddNewNotePage clickNoteFontSizeButton() {
        onView(noteFontSize).perform(click());
        return this;
    }

    @Step("Проверка экрана изменения размера шрифта")
    public AddNewNotePage checkNoteFontSizeMenu() {
        onView(noteFontSizeTitle).check(matches(isDisplayed()));
        onView(smallButton).check(matches(isDisplayed()));
        onView(mediumButton).check(matches(isDisplayed()));
        onView(largeButton).check(matches(isDisplayed()));
        onView(cancelButton).check(matches(isDisplayed()));
        return this;
    }

    @Step("Клик по Yes в окне сохранения пустой заметки")
    public AddNewNotePage clickYes() {
        onView(yesButton).perform(click());
        return this;
    }

    @Step("Клик по No в окне сохранения пустой заметки")
    public AddNewNotePage clickNo() {
        onView(noButton).perform(click());
        return this;
    }

    @Step("Ввод в поле Title")
    public AddNewNotePage typeAndCheckTitle(String text) {
        onView(titleField).perform(typeText(text));
        onView(titleField).check(matches(withText(containsString(text))));
        return this;
    }

    @Step("Переход к полю Note")
    public AddNewNotePage clickOnNote() {
        onView(noteField).perform(click());
        return this;
    }

    @Step("Ввод в поле Note")
    public AddNewNotePage typeAndCheckNote(String text) {
        onView(noteField).perform(typeText(text));
        onView(noteField).check(matches(withText(containsString(text))));
        return this;
    }

    @Step("Изменить цвет")
    public AddNewNotePage changeNoteColor() {
        for (int i = 0; i < list.size(); i++) {
            onView(changeColorButton).perform(click());
            onView(list.get(i)).perform(click());
        }
        return this;
    }
}
