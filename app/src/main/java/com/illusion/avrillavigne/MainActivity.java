package com.illusion.avrillavigne;

import com.illusion.avrillavigne.adapter.NavDrawerItem;
import com.illusion.avrillavigne.adapter.NavDrawerListAdapter;
import com.illusion.avrillavigne.fragment.Discography;
import com.illusion.avrillavigne.fragment.Award;
import com.illusion.avrillavigne.fragment.Filmography;
import com.illusion.avrillavigne.fragment.Avrillavigne;
import com.illusion.avrillavigne.fragment.SNS_tab;
import com.illusion.avrillavigne.fragment.Wallpaper;
import com.illusion.avrillavigne.util.ColorEngine;
import com.illusion.avrillavigne.util.ThemeEngine;
import android.content.res.TypedArray;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
    private RelativeLayout mDrawerRelativeLayout;
	private CharSequence mTitle;
	private String[] mDrawerText;
    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;
    private TypedArray mDrawerIcon;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeEngine.setAppTheme(this);
        ColorEngine.setAppTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        initDrawer();
        if (savedInstanceState == null) {
            displayView(0);
        }
    }
    
    private void initDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navDrawerItems = new ArrayList<NavDrawerItem>();
    	mTitle = getTitle();
        mDrawerText = getResources().getStringArray(R.array.nav_drawer_items);
        mDrawerIcon = getResources().obtainTypedArray(R.array.nav_drawer_icons);
		mDrawerList = (ListView) findViewById(R.id.list_slidermenu);
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mDrawerRelativeLayout = (RelativeLayout) findViewById(R.id.left_drawer);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle(mTitle);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(R.string.app_name);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        navDrawerItems.add(new NavDrawerItem(mDrawerText[0], mDrawerIcon.getResourceId(0, -1)));
        navDrawerItems.add(new NavDrawerItem(mDrawerText[1], mDrawerIcon.getResourceId(1, -1)));
        navDrawerItems.add(new NavDrawerItem(mDrawerText[2], mDrawerIcon.getResourceId(2, -1)));
        navDrawerItems.add(new NavDrawerItem(mDrawerText[3], mDrawerIcon.getResourceId(3, -1)));
        navDrawerItems.add(new NavDrawerItem(mDrawerText[4], mDrawerIcon.getResourceId(4, -1)));
        navDrawerItems.add(new NavDrawerItem(mDrawerText[5], mDrawerIcon.getResourceId(5, -1)));
        navDrawerItems.add(new NavDrawerItem(mDrawerText[6], mDrawerIcon.getResourceId(6, -1)));

        mDrawerIcon.recycle();

        adapter = new NavDrawerListAdapter(getApplicationContext(), navDrawerItems);

        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(this);

        mTextView = (TextView) findViewById (R.id.drawer_text);
        String userName = PreferenceManager.getDefaultSharedPreferences(this).getString("userName", "Avril Lavigne");

        if (userName == null || "".equals(userName))
            mTextView.setText("Avril Lavigne");
        else
            mTextView.setText(userName);
    }
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
 
    private void displayView(int position) {
		Fragment fragment = null;
        switch (position) {
        case 0:
            fragment = new Avrillavigne();
            break;
        case 1:
        	fragment = new SNS_tab();
            break;
        case 2:
            fragment = new Discography();
            break;
        case 3:
            fragment = new Filmography();
            break;
        case 4:
            fragment = new Award();
            break;
        case 5:
            fragment = new Wallpaper();
            break;
        case 6:
            fragment = new PrefsFragment();
            break;
 
        default:
            break;
        }
        
        if (fragment != null) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            setTitle(mDrawerText[position]);
    		mDrawerLayout.closeDrawer(mDrawerRelativeLayout);
        }
    }
    	
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        displayView(position);
	}
 
    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }
 
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }
 
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if (isNavDrawerOpen()) {
            closeNavDrawer();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        invalidateOptionsMenu();
    }

    protected boolean isNavDrawerOpen() {
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(Gravity.START);
    }

    protected void closeNavDrawer() {
        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(Gravity.START);
        }
    }
    
    private void clearApplicationCache(java.io.File dir){
        if(dir==null)
            dir = getCacheDir();
        else;
        if(dir==null)
            return;
        else;
        java.io.File[] children = dir.listFiles();
        try{
            for(int i=0;i<children.length;i++)
                if(children[i].isDirectory())
                    clearApplicationCache(children[i]);
                else children[i].delete();
        }
        catch(Exception e){}
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        clearApplicationCache(null);
    }
}