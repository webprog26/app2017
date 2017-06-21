package com.androiddeveloper.webprog26.app2017.engine;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/**
 * Created by webpr on 21.06.2017.
 */

public interface MainView {

    @NonNull
    SharedPreferences getSharedPreferences();

    void backToStartActivity();
}
