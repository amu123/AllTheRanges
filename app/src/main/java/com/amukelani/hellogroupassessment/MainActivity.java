package com.amukelani.hellogroupassessment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Amukelani on 9/25/16.
 */
public class MainActivity extends AppCompatActivity
    implements LoginFragment.login {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (savedInstanceState == null) {
      getSupportFragmentManager()
          .beginTransaction()
          .replace(R.id.root_layout, LoginFragment.newInstance(), "loginFragment")
          .commit();
    }
  }

  @Override
  public void login(int resId) {
    final ListItemsFragment detailsFragment =
        ListItemsFragment.newInstance(resId);
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.root_layout, detailsFragment, "listItemsFragment")
        .addToBackStack(null)
        .commit();
  }

}
