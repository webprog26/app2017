package com.androiddeveloper.webprog26.app2017.engine.pojo_models;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by webpr on 23.06.2017.
 */

public class TwitterPost {

    private final long postId;
    private final Date postCreatedAt;
    private final TwitterUser postAuthor;
    private final String postText;
    private final ArrayList<String> postImagesUrls;

    public TwitterPost(long postId,
                       Date postCreatedAt,
                       TwitterUser postAuthor,
                       String postText,
                       ArrayList<String> postImagesUrls
                       ) {
        this.postId = postId;
        this.postCreatedAt = postCreatedAt;
        this.postAuthor = postAuthor;
        this.postText = postText;
        this.postImagesUrls = postImagesUrls;
    }

    public long getPostId() {
        return postId;
    }

    public Date getPostCreatedAt() {
        return postCreatedAt;
    }

    public TwitterUser getPostAuthor() {
        return postAuthor;
    }

    public String getPostText() {
        return postText;
    }

    public ArrayList<String> getPostImagesUrls() {
        return postImagesUrls;
    }

    @Override
    public String toString() {
        return "Post: " + "with id " + getPostId() + "\n"
                + "posted at " + getPostCreatedAt().toString() + "\n"
                + "posted by " + getPostAuthor().getUserName() + "\n"
                + "contains text " + getPostText() + "\n"
                + "has " + getPostImagesUrls().size() + " photos";
    }
}
