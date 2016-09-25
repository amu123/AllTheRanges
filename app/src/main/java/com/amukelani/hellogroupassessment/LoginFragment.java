package com.raywenderlich.hellogroupassessment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.raywenderlich.hellogroupassessment.utils.LoginUtils;

/**
 * Created by Amukelani on 9/25/16.
 */
public class LoginFragment extends Fragment {
  private static final String ARGUMENT_RES_ID = "ResId";
  private static final String ARGUMENT_NAME = "name";
  private static final String ARGUMENT_DESCRIPTION = "description";
  private static final String ARGUMENT_URL = "url";

  private EditText mUsernameView;
  private EditText mPasswordView;
  private LoginUtils loginUtils;
  private Context context;

  private login mListener;

  public static LoginFragment newInstance() {
    final Bundle args = new Bundle();
    final LoginFragment fragment = new LoginFragment();
    fragment.setArguments(args);
    return fragment;
  }

  public LoginFragment() {
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    final View rootView = inflater.inflate(R.layout.fragment_login, container, false);

    context = getActivity().getApplicationContext();

    mUsernameView = (EditText) rootView.findViewById(R.id.user_name);

    mPasswordView = (EditText) rootView.findViewById(R.id.password);

    Button mLogInButton = (Button)rootView.findViewById(R.id.login_button);
    mLogInButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        attemptLogin(view);
      }
    });

    Button mSignUpButton = (Button)rootView.findViewById(R.id.register_button);
    mSignUpButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.android.com/ "));
        getActivity().startActivity(i);
      }
    });
    return rootView;
  }

  public void attemptLogin(View v){

    this.loginUtils = new LoginUtils();

    // Store values at the time of the login attempt.
    String userName = mUsernameView.getText().toString();
    String password = mPasswordView.getText().toString();
//
//        System.out.println(userName + " " + password);
    Log.d("Login ", mUsernameView.getText().toString() + " " + mPasswordView.getText().toString());

    boolean isValid = false;
    boolean isUserNameValid = loginUtils.isUserNameValid(userName);
    boolean isPasswordValid = loginUtils.isPasswordValid(password);

    if(isPasswordValid && isUserNameValid){

      isValid = true;
    }else {
      Toast.makeText(v.getContext(), "Something went wrong, Please check your username or password", Toast.LENGTH_SHORT).show();
    }

    if(isValid){

      mListener.login(1);
    }


  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);

    if (context instanceof login) {
      mListener = (login) context;
    } else {
      throw new ClassCastException(context.toString() + " must implement OnRageComicSelected.");
    }

    final int imageCount = 1;
  }

  public interface login {
    void login(int resId);
  }
}
