package Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.cucumberex.MainActivity;
import com.example.cucumberex.R;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.runner.RunWith;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {

    private View decorView ;
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);
    @Before
    public void setUp()  {
        activityRule.getScenario().onActivity(new ActivityScenario.ActivityAction<MainActivity>() {
           @Override
            public void perform(MainActivity activity) {
                decorView = activity.getWindow().getDecorView();
            }
        });
    }
    @Given("CaseOne")
    public void case_one() {
        // Write code here that turns the phrase above into concrete actions
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.loginexample", appContext.getPackageName());
    }
    @When("CaseTwo")
    public void case_two() {
        // Write code here that turns the phrase above into concrete actions
        onView(ViewMatchers.withId(R.id.giris)).check(matches(withText("Giriş Yap")));
    }
    @When("CaseThree")
    public void case_three() {
        // Write code here that turns the phrase above into concrete actions
        onView(withText("LOGIN")).check(matches(isDisplayed()));
    }
    @When("CaseFour")
    public void case_four() {
        // Write code here that turns the phrase above into concrete actions
        onView(withId(R.id.mail)).check(matches(withHint("Mail")));
    }
    @When("CaseFive")
    public void case_five() {
        // Write code here that turns the phrase above into concrete actions
        onView(withText("LOGIN")).perform(click());
    }
    @Then("CaseSix")
    public void case_six() {
        // Write code here that turns the phrase above into concrete actions
        onView(withId(R.id.mail))
                .perform(typeText("root"));
        onView(withId(R.id.password)).perform(typeText("12345"));
        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.signinbtn)).perform(click());
        //Thread.sleep(2000);
        onView(withText("Giriş Yapıldı"))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }


}
