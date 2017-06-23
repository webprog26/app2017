package com.androiddeveloper.webprog26.app2017.engine.helpers;

import com.androiddeveloper.webprog26.app2017.constants.Constants;
import com.androiddeveloper.webprog26.app2017.engine.pojo_models.TwitterPost;
import com.androiddeveloper.webprog26.app2017.engine.pojo_models.TwitterUser;

import java.util.ArrayList;

import twitter4j.MediaEntity;
import twitter4j.Status;
import twitter4j.User;

/**
 * Created by webpr on 23.06.2017.
 */

public class StatusToTwitterPostConverter {

    public static TwitterPost convertStatusToTwitterPost(Status status){

        return new TwitterPost(status.getId(),
                               status.getCreatedAt(),
                               getTwitterUserFromStatus(status),
                               status.getText(),
                               getTwitterPostImagesUrls(status.getMediaEntities()));
    }

    private static TwitterUser getTwitterUserFromStatus(Status status){
        User user = status.getUser();

        TwitterUser.Builder builder = TwitterUser.newBuilder();
        builder.setUserId(user.getId())
                .setUserName(user.getName())
                .setUserMiniProfileImageUrl(user.getMiniProfileImageURL());

        return builder.build();
    }

    private static ArrayList<String> getTwitterPostImagesUrls(MediaEntity[] mediaEntities){

        ArrayList<String> twitterPostImagesUrls = new ArrayList<>();

        for(MediaEntity mediaEntity: mediaEntities){

            if(mediaEntity.getType().equals(Constants.MEDIA_ENTITY_TYPE_PHOTO)){
                twitterPostImagesUrls.add(mediaEntity.getMediaURL());
            }
        }

        return twitterPostImagesUrls;
    }
}
