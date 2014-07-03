package com.tjohn.activity

import android.app.Activity
import android.os.Bundle
import com.tjohn.R
import groovy.transform.CompileStatic;

@CompileStatic
public class FacebookActivity extends Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.facebook)
  }
}