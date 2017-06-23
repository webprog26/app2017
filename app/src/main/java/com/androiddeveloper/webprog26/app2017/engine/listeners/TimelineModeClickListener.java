package com.androiddeveloper.webprog26.app2017.engine.listeners;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;

import com.androiddeveloper.webprog26.app2017.R;
import com.androiddeveloper.webprog26.app2017.constants.Constants;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces.MainPresenter;

/**
 * Created by webpr on 22.06.2017.
 */

public class TimelineModeClickListener implements View.OnClickListener{

    private final MainPresenter mainPresenter;
    private final Bitmap mDefaultBitmap;
    private final Bitmap mDetailedBitmap;

    public TimelineModeClickListener(final MainPresenter mainPresenter, final Resources resources) {
        this.mainPresenter = mainPresenter;

        this.mDefaultBitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_list_white_24dp);
        this.mDetailedBitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_description_white_24dp);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.ib_timeline_mode:

                switch (mainPresenter.getTimelineMode()){

                    case Constants.TIMELINE_MODE_DEFAULT:

                        ((ImageButton) v).setImageBitmap(mDetailedBitmap);
                        mainPresenter.changeTimelineModeToDetailed();

                        //Todo move next line of code to <? extends EventsHandler>
                        mainPresenter.saveTimeLineMode(Constants.TIMELINE_MODE_DETAILED);

                        break;

                    case Constants.TIMELINE_MODE_DETAILED:

                        ((ImageButton) v).setImageBitmap(mDefaultBitmap);
                        mainPresenter.changeTimelineModeToDefault();

                        //Todo move next line of code to <? extends EventsHandler>
                        mainPresenter.saveTimeLineMode(Constants.TIMELINE_MODE_DEFAULT);

                        break;

                }

                break;
        }

    }

    private MainPresenter getMainPresenter() {
        return mainPresenter;
    }


}
