package com.takehome.affirm.affirm_mobile_take_home;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by nivesuresh on 6/23/19.
 */

public class ImageAdapter extends BaseAdapter {
    List<PhotoModel> photoList;
    Context context;

    public ImageAdapter(Context context,List<PhotoModel> dataList){
        this.context = context;
        this.photoList = dataList;
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        private ImageView image;

        ImageViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            image = mView.findViewById(R.id.single_image);
        }
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View myView = view;
        ImageViewHolder holder;

        if (myView == null) {
            LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
            myView = layoutInflater.inflate(R.layout.photo_view, parent, false);
            holder = new ImageViewHolder(myView);
            holder.image = myView.findViewById(R.id.single_image);

            myView.setTag(holder);
        } else {
            holder = (ImageViewHolder) myView.getTag();
        }

        //to make the photos square and the uniform width/ height apart
        float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                8, context.getResources().getDisplayMetrics());
        int columnWidth = (int) ((ImageUtils.getScreenWidth(context) - (3 * padding)) / 3);

        holder.image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.image.setLayoutParams(new ConstraintLayout.LayoutParams(columnWidth,
                columnWidth));

        Picasso.get()
                .load(photoList.get(i).getUrl_s())
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .placeholder(R.drawable.ic_launcher_background)
                .config(Bitmap.Config.RGB_565)
                .into(holder.image);

        return myView;
    }



    @Override
    public int getCount() {
        return photoList.size();
    }

    @Override
    public Object getItem(int i) {
        return photoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
}
