package com.takehome.affirm.affirm_mobile_take_home;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nivesuresh on 6/23/19.
 */

public class PhotoModel {
    @SerializedName("farm")
    private int farm;

    @SerializedName("height_s")
    private String height_s;

    @SerializedName("id")
    private String id;

    @SerializedName("isfamily")
    private int isfamily;

    @SerializedName("isfriend")
    private int isfriend;

    @SerializedName("ispublic")
    private int ispublic;

    @SerializedName("owner")
    private String owner;

    @SerializedName("secret")
    private String secret;

    @SerializedName("server")
    private String server;

    @SerializedName("title")
    private String title;

    @SerializedName("url_s")
    private String url_s;

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public String getHeight_s() {
        return height_s;
    }

    public void setHeight_s(String height_s) {
        this.height_s = height_s;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(int isfamily) {
        this.isfamily = isfamily;
    }

    public int getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(int isfriend) {
        this.isfriend = isfriend;
    }

    public int getIspublic() {
        return ispublic;
    }

    public void setIspublic(int ispublic) {
        this.ispublic = ispublic;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl_s() {
        return url_s;
    }

    public void setUrl_s(String url_s) {
        this.url_s = url_s;
    }

    public String getWidth_s() {
        return width_s;
    }

    public void setWidth_s(String width_s) {
        this.width_s = width_s;
    }

    String width_s;
}
