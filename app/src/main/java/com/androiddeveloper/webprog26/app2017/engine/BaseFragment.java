package com.androiddeveloper.webprog26.app2017.engine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by webpr on 21.06.2017.
 */

public abstract class BaseFragment extends Fragment{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupFragmentComponent();
    }

    protected abstract void setupFragmentComponent();
}
