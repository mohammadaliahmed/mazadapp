package com.appsinventiv.mazad.NetworkResponses;


import com.appsinventiv.mazad.Models.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("user")
    @Expose
    private User user = null;
//    @SerializedName("posts")
//    @Expose
//    private List<PostsModel> postsList = null;
//    @SerializedName("ads")
//    @Expose
//    private List<AdsModel> ads = null;
//    @SerializedName("messages")
//    @Expose
//    private List<MessageModel> messages = null;
//    @SerializedName("comments")
//    @Expose
//    private List<CommentsModel> comments = null;
//
//    @SerializedName("room")
//    @Expose
//    private Room room;
//
//    @SerializedName("adModel")
//    @Expose
//    private AdsModel adModel;
//    @SerializedName("comment")
//    @Expose
//    private CommentsModel comment = null;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
