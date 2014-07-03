package com.example.robolectric

import android.app.Activity
import android.os.Bundle
import com.example.R
import groovy.transform.CompileStatic;

@CompileStatic
public class DeckardActivity extends Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.deckard)
  }
}