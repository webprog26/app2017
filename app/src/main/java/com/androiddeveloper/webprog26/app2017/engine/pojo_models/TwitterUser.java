package com.androiddeveloper.webprog26.app2017.engine.pojo_models;

/**
 * Created by webpr on 23.06.2017.
 */

public class TwitterUser {

    private long userId;
    private String userName;
    private String userMiniProfileImageUrl;

    public static TwitterUser.Builder newBuilder(){
        return new TwitterUser(). new Builder();
    }

    public class Builder {

        public Builder setUserId(long userId){
            TwitterUser.this.userId = userId;
            return this;
        }

        public Builder setUserName(String userName){
            TwitterUser.this.userName = userName;
            return this;
        }

        public Builder setUserMiniProfileImageUrl(String userMiniProfileImageUrl){
            TwitterUser.this.userMiniProfileImageUrl = userMiniProfileImageUrl;
            return this;
        }

        public TwitterUser build(){
            return TwitterUser.this;
        }
    }

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserMiniProfileImageUrl() {
        return userMiniProfileImageUrl;
    }
}
