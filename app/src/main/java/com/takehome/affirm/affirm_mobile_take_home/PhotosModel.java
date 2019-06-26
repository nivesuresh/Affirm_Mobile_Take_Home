package com.takehome.affirm.affirm_mobile_take_home;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nivesuresh on 6/24/19.
 */

public class PhotosModel {
    @SerializedName("page")
    private Integer page;

    @SerializedName("pages")
    private Integer pages;

    @SerializedName("perpage")
    private Integer perpage;

    @SerializedName("total")
    private String total;

    @SerializedName("photo")
    private List<PhotoModel> photoList = null;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPerpage() {
        return perpage;
    }

    public void setPerpage(Integer perpage) {
        this.perpage = perpage;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<PhotoModel> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<PhotoModel> photoList) {
        this.photoList = photoList;
    }
}
