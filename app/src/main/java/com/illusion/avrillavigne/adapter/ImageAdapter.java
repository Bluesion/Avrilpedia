package com.illusion.avrillavigne.adapter;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.illusion.avrillavigne.R;
import com.illusion.avrillavigne.util.Data;
import com.illusion.avrillavigne.util.SquaredImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("deprecation")
public class ImageAdapter extends BaseAdapter {

    private final Context context;
    private final List<String> urls = new ArrayList<String>();

    public ImageAdapter(Context context) {
        this.context = context;
        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        final int width = display.getWidth();
        final int height = display.getHeight();
        if (width == 480 && height == 800) {
            Collections.addAll(urls, Data.URLS_hdpi);
        }
        if (width == 720 && height == 1280) {
            Collections.addAll(urls, Data.URLS_xhdpi);
        }
        if (width == 1080 && height == 1920) {
            Collections.addAll(urls, Data.URLS_xxhdpi);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SquaredImageView view = (SquaredImageView) convertView;
        if (view == null) {
            view = new SquaredImageView(context);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        String url = getItem(position);

        Picasso.with(context)
                .load(url)
                .placeholder(R.drawable.alert)
                .error(R.drawable.alert)
                .fit()
                .centerCrop()
                .into(view);

        return view;
    }

    @Override public int getCount() {
        return urls.size();
    }

    @Override public String getItem(int position) {
        return urls.get(position);
    }

    @Override public long getItemId(int position) {
        return position;
    }

}