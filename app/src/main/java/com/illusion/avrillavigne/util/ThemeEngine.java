package com.illusion.avrillavigne.util;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import com.illusion.avrillavigne.R;
import java.lang.reflect.Field;

public class ThemeEngine extends ActionBarActivity {
	
	public static void setAppTheme(ActionBarActivity a) {
		
	    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(a);
	    int mTheme = Integer.parseInt(sp.getString("theme", "0"));
	    if (mTheme == 0) {
	    	a.setTheme(R.style.Illusion);
	    }
	    if (mTheme == 1) {
	        a.setTheme(R.style.White_dark);
	    }
	    if (mTheme == 2) { 
	        a.setTheme(R.style.Illusion_full);
	    }
        if (mTheme == 3) {
            a.setTheme(R.style.White_dark_full);
        }
	}
}