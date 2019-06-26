package com.takehome.affirm.affirm_mobile_take_home;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nivesuresh on 6/25/19.
 */

public class Photos {
    @SerializedName("photos")
    PhotosModel photosModel;

    @SerializedName("stat")
    String stat;

    public PhotosModel getPhotosModel() {
        return photosModel;
    }

    public void setPhotosModel(PhotosModel photosModel) {
        this.photosModel = photosModel;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
