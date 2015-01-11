package com.illusion.avrillavigne.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.illusion.avrillavigne.R;
import com.nhaarman.listviewanimations.itemmanipulation.expandablelistitem.ExpandableListItemAdapter;

public class FilmoExpandableListItemAdapter extends ExpandableListItemAdapter<Integer> {

    private final Context mContext;
    private LayoutInflater mInflater;
    String txtColor = "#ff000000";

    public FilmoExpandableListItemAdapter(final Context context) {
        super(context, R.layout.fragment_album, R.id.activity_expandablelistitem_card_title, R.id.activity_expandablelistitem_card_content);
        mContext = context;
        mInflater = LayoutInflater.from(context);

        for (int i = 0; i < 7; i++) {
            add(i);
        }
    }

    @Override
    public View getTitleView(final int position, final View convertView, final ViewGroup parent) {
        TextView tv = (TextView) convertView;
        if (tv == null) {
            tv = new TextView(mContext);
        }

        switch (getItem(position) % 7) {
            case 0:
            	tv.setText(mContext.getString(R.string.filmo_0, (int) getItem(position)));
                tv.setTextColor(Color.parseColor(txtColor));
                break;
            case 1:
            	tv.setText(mContext.getString(R.string.filmo_1, (int) getItem(position)));
                tv.setTextColor(Color.parseColor(txtColor));
                break;
            case 2:
            	tv.setText(mContext.getString(R.string.filmo_2, (int) getItem(position)));
                tv.setTextColor(Color.parseColor(txtColor));
                break;
            case 3:
            	tv.setText(mContext.getString(R.string.filmo_3, (int) getItem(position)));
                tv.setTextColor(Color.parseColor(txtColor));
                break;
            case 4:
            	tv.setText(mContext.getString(R.string.filmo_4, (int) getItem(position)));
                tv.setTextColor(Color.parseColor(txtColor));
                break;
            case 5:
            	tv.setText(mContext.getString(R.string.filmo_5, (int) getItem(position)));
                tv.setTextColor(Color.parseColor(txtColor));
                break;
            default:
            	tv.setText(mContext.getString(R.string.filmo_6, (int) getItem(position)));
                tv.setTextColor(Color.parseColor(txtColor));
        }
        return tv;
    }

    @Override
    public View getContentView(final int position, final View convertView, final ViewGroup parent) {
    	View v = null;

        if(position == 0){
            v = mInflater.inflate(R.layout.filmo_0, null);
        }
        else if(position == 1){
        	v = mInflater.inflate(R.layout.filmo_1, null);
        }
        else if(position == 2){
            v = mInflater.inflate(R.layout.filmo_2, null);
        }
        else if(position == 3){
            v = mInflater.inflate(R.layout.filmo_3, null);
        }
        else if(position == 4){
        	v = mInflater.inflate(R.layout.filmo_4, null);
        }
        else if(position == 5){
        	v = mInflater.inflate(R.layout.filmo_5, null);
        }
        else{
            v = mInflater.inflate(R.layout.filmo_6, null);
        }

        return v;
    }
}