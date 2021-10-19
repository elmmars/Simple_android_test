package com.moonpi.swiftnotes.tests;


import static androidx.test.espresso.Espresso.onView;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.moonpi.swiftnotes.MainActivity;

import org.junit.After;
import org.junit.Rule;
import org.junit.rules.RuleChain;

public class BaseTest {
    @Rule
    public ActivityScenarioRule mActivityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Rule
    public RuleChain chain = RuleChain
            .outerRule(mActivityRule);
         //  .around();
         //perform(ViewActions.closeSoftKeyboard());
    @After
   public void baseAfter(){
        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());
    }
}
