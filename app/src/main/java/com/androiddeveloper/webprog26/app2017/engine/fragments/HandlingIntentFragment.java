package com.androiddeveloper.webprog26.app2017.engine.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.androiddeveloper.webprog26.app2017.MainActivity;
import com.androiddeveloper.webprog26.app2017.constants.Constants;
import com.androiddeveloper.webprog26.app2017.dagger.App;
import com.androiddeveloper.webprog26.app2017.dagger.modules.HandlingIntentPresenterModule;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces.HandlingIntentFragmentPresenter;
import com.androiddeveloper.webprog26.app2017.engine.mvp.views.HandlingIntentFragmentView;

import javax.inject.Inject;

/**
 * Created by webpr on 21.06.2017.
 */

public class HandlingIntentFragment extends BaseFragment implements HandlingIntentFragmentView {

    private static final String TAG = "HIFragment";

    public static final String RECEIVED_URI_DATA = "received_uri_data";

    @Inject
    HandlingIntentFragmentPresenter mHandlingIntentFragmentPresenter;

    public static HandlingIntentFragment newInstance(Uri receivedUri){
        Bundle args = new Bundle();
        args.putParcelable(RECEIVED_URI_DATA, receivedUri);

        HandlingIntentFragment handlingIntentFragment = new HandlingIntentFragment();
        handlingIntentFragment.setArguments(args);

        return handlingIntentFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);

        mHandlingIntentFragmentPresenter.setView(this);

        registerEventsHandler();

        if(getArguments() != null){
            Uri receivedUri = getArguments().getParcelable(RECEIVED_URI_DATA);

            if(receivedUri != null){

                Log.i(TAG, receivedUri.toString());
                mHandlingIntentFragmentPresenter.askAccessToken(receivedUri.getQueryParameter(Constants.IEXTRA_OAUTH_VERIFIER));

            }

        }
    }

    @Override
    public void onDestroy() {
        unregisterEventsHandler();
        super.onDestroy();
    }

    @Override
    public void startMainActivity() {
        this.startActivity(new Intent(getActivity(), MainActivity.class));
        getActivity().finish();
    }

    @Override
    protected void setupFragmentComponent() {
        App.getAppComponent().plus(new HandlingIntentPresenterModule()).inject(this);
    }

    @Override
    public void registerEventsHandler() {
        mHandlingIntentFragmentPresenter.getEventsHandler().register();
    }

    @Override
    public void unregisterEventsHandler() {
        mHandlingIntentFragmentPresenter.getEventsHandler().unregister();
    }

    @NonNull
    @Override
    public SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(getActivity());
    }
}
