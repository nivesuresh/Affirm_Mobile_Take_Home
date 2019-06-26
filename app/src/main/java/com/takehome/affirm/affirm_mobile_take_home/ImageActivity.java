package com.takehome.affirm.affirm_mobile_take_home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.widget.AbsListView;
import android.widget.GridView;

import java.util.List;

/**
 * Created by nivesuresh on 6/24/19.
 */

public class ImageActivity extends AppCompatActivity implements ImagePresenter.ImageView {

    private ImagePresenter imagePresenter;
    private GridView gridView;
    private ImageAdapter imageAdapter;
    private SearchView searchView;

    FlickrService flickrService;

    private String searchText;

    int page = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        searchView = findViewById(R.id.image_search_bar);
        flickrService = RetrofitClientInstance.getRetrofitInstance().create(FlickrService.class);
        gridView = findViewById(R.id.image_grid_layout);
        imagePresenter = new ImagePresenter(this, flickrService, searchView.getQuery().toString());

        gridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                if(!imagePresenter.isLastPage) {
                    if((visibleItemCount + firstVisibleItem) >= totalItemCount &&
                            firstVisibleItem >= 0) {
                        imagePresenter.getNextPage(searchText, page);
                    }
                }
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchText = query;
                imagePresenter.getFirstPagePhotos(query, page);
                page++;
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
    }

    private void generateDataList(List<PhotoModel> photoModelList) {
        imageAdapter = new ImageAdapter(this, photoModelList);
        gridView.setAdapter(imageAdapter);
        imageAdapter.notifyDataSetChanged();
    }

    @Override
    public void updatePhotoModels(List<PhotoModel> photoModelList) {
        generateDataList(photoModelList);
    }
}