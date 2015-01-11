package com.illusion.avrillavigne.fragment;

import com.illusion.avrillavigne.R;
import com.illusion.avrillavigne.adapter.ExpandableListAdapter;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class Discography_list extends Fragment {

    private ListView mListView;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         RelativeLayout wrapper = new RelativeLayout(getActivity());
         inflater.inflate(R.layout.album_list, wrapper, true);
         mListView = (ListView) wrapper.findViewById(R.id.activity_mylist_listview);
         return wrapper;
    }

    public ListView getListView() {
        return mListView;
    }

}
