package com.illusion.avrillavigne.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import com.illusion.avrillavigne.R;
import com.illusion.avrillavigne.WallpaperSetting;
import com.illusion.avrillavigne.adapter.ImageAdapter;
import com.illusion.avrillavigne.customlibrary.MaterialDialog.MaterialDialogBuilder;

public class Wallpaper extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_wallpaper, container, false);

        if (isNetwork()) {
            LinearLayout nomal = (LinearLayout) rootView.findViewById(R.id.wallpaper);
            nomal.setVisibility(View.VISIBLE);
            LinearLayout error = (LinearLayout) rootView.findViewById(R.id.no_internet_connection);
            error.setVisibility(View.GONE);

            GridView gridview = (GridView) rootView.findViewById(R.id.gridview);
            final ImageAdapter adapter = new ImageAdapter(getActivity());
            gridview.setAdapter(adapter);
            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getActivity().getApplicationContext(), WallpaperSetting.class);
                    intent.putExtra("url", adapter.getItem(position));
                    startActivity(intent);
                }
            });

            MaterialDialogBuilder dialogBuilder = new MaterialDialogBuilder(getActivity());
            dialogBuilder.setTitle(R.string.wall_title);
            dialogBuilder.setMessage(R.string.wall_text);
            dialogBuilder.setPositiveButton(R.string.close, null);
            dialogBuilder.show();
        }

        return rootView;
    }

    private boolean isNetwork() {
        ConnectivityManager manager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobile = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if (wifi.isConnected() || mobile.isConnected())
            return true;
        else
            return false;
    }

}