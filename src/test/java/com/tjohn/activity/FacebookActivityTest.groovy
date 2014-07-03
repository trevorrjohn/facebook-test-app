package com.tjohn.activity

import android.widget.TextView
import com.tjohn.R
import groovy.transform.CompileStatic
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

import static org.fest.assertions.api.ANDROID.assertThat

@CompileStatic
@RunWith(RobolectricTestRunner.class)
class FacebookActivityTest {
  @Test
  public void someTest() {
    def activity = Robolectric.setupActivity(FacebookActivity.class)
    assertThat((TextView) activity.findViewById(R.id.text)).hasText("Hello Groovy!")
  }
}
