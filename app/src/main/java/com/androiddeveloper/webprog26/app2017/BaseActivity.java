package com.androiddeveloper.webprog26.app2017;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.androiddeveloper.webprog26.app2017.constants.Constants;

/**
 * Created by webpr on 21.06.2017.
 */

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupActivityComponent();


    }

    @Override
    protected void onResume() {
        checkIsUserLoggedIn();
        super.onResume();
    }

    @Override
    protected void onRestart() {
        checkIsUserLoggedIn();
        super.onRestart();
    }

    protected abstract void setupActivityComponent();

    private void checkIsUserLoggedIn(){
        if(!(this instanceof MainActivity)){
            if(isUserLoggedIn()){
                Intent mainActivityIntent = new Intent(BaseActivity.this, MainActivity.class);
                mainActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainActivityIntent);
                finish();
            }
        }
    }

    private boolean isUserLoggedIn(){
        return PreferenceManager.getDefaultSharedPreferences(this).getBoolean(Constants.IS_LOGGED_IN, false);
    }
}
