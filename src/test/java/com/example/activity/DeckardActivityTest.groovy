package com.example.activity

import android.widget.TextView
import com.example.R
import com.example.robolectric.DeckardActivity
import groovy.transform.CompileStatic
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

import static org.fest.assertions.api.ANDROID.assertThat

@CompileStatic
@RunWith(RobolectricTestRunner.class)
class DeckardActivityTest {
  @Test
  public void someTest() {
    def activity = Robolectric.setupActivity(DeckardActivity.class)
    assertThat((TextView) activity.findViewById(R.id.text)).hasText("Hello Groovy!")
  }
}
