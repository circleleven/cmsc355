package sean.itr1;


import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.espresso.intent.Intents;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.Matchers.anything;
import static android.support.test.espresso.intent.Intents.intended;

@RunWith(AndroidJUnit4.class)
public class Iteration3EditLinksPageTest {
    @Rule
    public ActivityTestRule<SearchPage> AddSeriesActvityTestRule = new ActivityTestRule<>(SearchPage.class);

    // Issue: Edit Links Option: Scenario 7
    @Test
    public void editLinksPageTest() {
        onView(withId(R.id.search_show_title)).perform(typeText("Stranger Things"));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.search_confirm_basic)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.show_list)).atPosition(0).perform(click());

        onView(withId(R.id.edit_urls)).perform(click());
        onView(withId(R.id.confirm_imdb_url)).check(matches(isDisplayed()));
    }

}
