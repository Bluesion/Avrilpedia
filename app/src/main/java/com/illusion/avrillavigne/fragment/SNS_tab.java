package com.illusion.avrillavigne.fragment;

import com.illusion.avrillavigne.customlibrary.MaterialDialog.MaterialDialogBuilder;
import com.illusion.avrillavigne.customlibrary.PagerSlidingTabStrip;
import com.illusion.avrillavigne.R;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SNS_tab extends Fragment {

    private int White = Color.parseColor("#ffffff");

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_channel, container, false);
        setHasOptionsMenu(true);

        if (isNetwork()) {
            MaterialDialogBuilder dialogBuilder = new MaterialDialogBuilder(getActivity());
            dialogBuilder.setTitle(R.string.channel_title);
            dialogBuilder.setMessage(R.string.channel_text);
            dialogBuilder.setPositiveButton(R.string.close, null);
            dialogBuilder.show();
        }

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) rootView.findViewById(R.id.tabs);
        tabs.setTextColor(White);
        tabs.setDividerColor(Color.parseColor("#00ffffff"));
        tabs.setIndicatorColor(White);
        tabs.setIndicatorHeight(1);
        ViewPager pager = (ViewPager) rootView.findViewById(R.id.pager);
        MyPagerAdapter adapter = new MyPagerAdapter(getFragmentManager());
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(5);
        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
        pager.setPageMargin(pageMargin);
        tabs.setViewPager(pager);

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

	public class MyPagerAdapter extends FragmentPagerAdapter {

		private final String[] TITLES = { "Twitter", "Facebook", "Instagram", "Youtube", "Homepage" };

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLES[position];
		}

		@Override
		public int getCount() {
			return TITLES.length;
		}

		@Override
		public Fragment getItem(int position) {
			return SNS.newInstance(position);
		}
	}
}