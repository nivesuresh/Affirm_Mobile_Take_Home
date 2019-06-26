package com.takehome.affirm.affirm_mobile_take_home;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by nivesuresh on 6/23/19.
 */

public class ImagePresenter {

    private ImageView imageView;
    private FlickrService flickrService;
    private String searchText;
    boolean isLastPage = false;
    private List<PhotoModel> photoModelList = new ArrayList<>();

    public ImagePresenter(ImageView imageView, FlickrService flickrService, String searchText) {
        this.imageView = imageView;
        this.flickrService = flickrService;
        this.searchText = searchText;
    }

    public void getFirstPagePhotos(String searchText, int page) {
        this.searchText = searchText;
        getObservable(page).subscribeWith(getObserver());
    }

    //getPhotoItemList
    public void getNextPage(String searchText, int page) {
        this.searchText = searchText;
        if(page >= 3000) { //TODO: write code for getting the actual total pages
            isLastPage = true;
            return;
        }

        page++;

        if(searchText != null) {
            getNextObservable(page).subscribeWith(getNextObserver());
        }
    }

    public Observable<Photos> getObservable(int page){
        return flickrService
                .getPhotosFromFlickr("flickr.photos.search",
                        "675894853ae8ec6c242fa4c077bcf4a0",
                        searchText,
                        "url_s",
                        "json",
                        1,
                        page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<Photos> getObserver(){
        return new DisposableObserver<Photos>() {

            @Override
            public void onNext(@NonNull Photos photosResponse) {
                Log.d("Affirm Take Home","OnNext"+photosResponse.getPhotosModel());
                    photoModelList.clear();
                    photoModelList.addAll(photosResponse.getPhotosModel().getPhotoList());
                    imageView.updatePhotoModels(photoModelList);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("Affirm Take Home","Error"+e);
                e.printStackTrace();
                //mvi.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d("Affirm Take Home","Completed");
            }
        };
    }

    public Observable<Photos> getNextObservable(int page){
        return flickrService
                .getPhotosFromFlickr("flickr.photos.search",
                        "675894853ae8ec6c242fa4c077bcf4a0",
                        searchText,
                        "url_s",
                        "json",
                        1,
                        page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<Photos> getNextObserver(){
        return new DisposableObserver<Photos>() {

            @Override
            public void onNext(@NonNull Photos photosResponse) {
                Log.d("Affirm Take Home","OnNext"+photosResponse.getPhotosModel());
                photoModelList.addAll(photosResponse.getPhotosModel().getPhotoList());
                imageView.updatePhotoModels(photoModelList);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("Affirm Take Home","Error"+e);
                e.printStackTrace();
                //mvi.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d("Affirm Take Home","Completed");
            }
        };
    }

    public interface ImageView {
        void updatePhotoModels(List<PhotoModel> photoModelList);

    }
}