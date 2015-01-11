package com.illusion.avrillavigne.adapter;

import android.content.Context;
import com.illusion.avrillavigne.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.nhaarman.listviewanimations.ArrayAdapter;

public class ExpandableListAdapter extends ArrayAdapter<String> {

    private final Context mContext;

    public ExpandableListAdapter(final Context context) {
        mContext = context;
        for (int i = 0; i < 1; i++) {
            add(mContext.getString(R.string.app_name, i));
        }
    }

    @Override
    public long getItemId(final int position) {
        return getItem(position).hashCode();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        TextView view = (TextView) convertView;
        if (view == null) {
            view = (TextView) LayoutInflater.from(mContext).inflate(R.layout.list_row, parent, false);
        }

        view.setText(getItem(position));

        return view;
    }
}