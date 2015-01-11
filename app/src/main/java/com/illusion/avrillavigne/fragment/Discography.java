package com.illusion.avrillavigne.fragment;

import android.os.Bundle;
import com.illusion.avrillavigne.adapter.AlbumExpandableListItemAdapter;
import com.nhaarman.listviewanimations.appearance.simple.SwingLeftInAnimationAdapter;

public class Discography extends Discography_list {

    private AlbumExpandableListItemAdapter mExpandableListItemAdapter;

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mExpandableListItemAdapter = new AlbumExpandableListItemAdapter(getActivity());
        SwingLeftInAnimationAdapter AnimationAdapter = new SwingLeftInAnimationAdapter(mExpandableListItemAdapter);
        AnimationAdapter.setAbsListView(getListView());

        assert AnimationAdapter.getViewAnimator() != null;
        getListView().setAdapter(AnimationAdapter);
    }
}