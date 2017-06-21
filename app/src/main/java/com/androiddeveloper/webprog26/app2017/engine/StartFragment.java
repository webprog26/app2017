package com.androiddeveloper.webprog26.app2017.engine;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.androiddeveloper.webprog26.app2017.R;
import com.androiddeveloper.webprog26.app2017.dagger.App;
import com.androiddeveloper.webprog26.app2017.dagger.StartFragmentPresenterModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by webpr on 21.06.2017.
 */

public class StartFragment extends BaseFragment implements StartFragmentView{

    private static final String TAG = "StartFragment";

    @BindView(R.id.btn_login)
    Button mBtnLogin;

    @Inject
    StartFragmentPresenter mStartFragmentPresenter;

    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);

        mStartFragmentPresenter.setView(this);

        registerEventsHandler();
        Log.i(TAG, "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.start_fragment_layout, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getBtnLogin().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStartFragmentPresenter.askOauth();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void onDestroy() {
        unregisterEventsHandler();
        super.onDestroy();
    }

    private Button getBtnLogin() {
        return mBtnLogin;
    }

    @Override
    protected void setupFragmentComponent() {
        App.getAppComponent().plus(new StartFragmentPresenterModule()).inject(this);
    }

    @Override
    public void registerEventsHandler() {
        mStartFragmentPresenter.getEventsHandler().register();
    }

    @Override
    public void unregisterEventsHandler() {
        mStartFragmentPresenter.getEventsHandler().unregister();
    }

    @Override
    public void startAuthBrowserActivity(String authUrl) {

        this.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(authUrl)));
        getActivity().finish();
    }
}
