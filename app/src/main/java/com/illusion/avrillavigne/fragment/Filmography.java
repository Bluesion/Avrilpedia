package com.illusion.avrillavigne.fragment;

import com.illusion.avrillavigne.adapter.FilmoExpandableListItemAdapter;
import com.nhaarman.listviewanimations.appearance.simple.SwingLeftInAnimationAdapter;
import android.graphics.BitmapFactory;
import android.os.Bundle;
 
public class Filmography extends Discography_list {
     
	private FilmoExpandableListItemAdapter mExpandableListItemAdapter;

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mExpandableListItemAdapter = new FilmoExpandableListItemAdapter(getActivity());
        SwingLeftInAnimationAdapter AnimationAdapter = new SwingLeftInAnimationAdapter(mExpandableListItemAdapter);
        AnimationAdapter.setAbsListView(getListView());

        assert AnimationAdapter.getViewAnimator() != null;
        getListView().setAdapter(AnimationAdapter);
    }
    
    public static int getBitmapOfWidth(String fileName){
		try {
			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inJustDecodeBounds = true;
			BitmapFactory.decodeFile(fileName, options);
			return options.outWidth;
		} catch(Exception e) {
			return 0;
		}
	}

	public static int getBitmapOfHeight(String fileName){
		try {
			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inJustDecodeBounds = true;
			BitmapFactory.decodeFile(fileName, options); 
			return options.outHeight;
		} catch(Exception e) {
			return 0;
		}
	}
}