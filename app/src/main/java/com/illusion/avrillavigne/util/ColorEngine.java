package com.illusion.avrillavigne.util;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import com.illusion.avrillavigne.R;

public class ColorEngine extends ActionBarActivity {
	
	public static void setAppTheme(ActionBarActivity a) {

	    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(a);
	    int mTheme = Integer.parseInt(sp.getString("actionbar", "0"));
	    if (mTheme == 0) {
	    	a.setTheme(R.style.Tomato);
	    }
	    if (mTheme == 1) {
	        a.setTheme(R.style.Tangerine);
	    }
        if (mTheme == 2) {
            a.setTheme(R.style.Pumpkin);
        }
        if (mTheme == 3) {
            a.setTheme(R.style.Mango);
        }
        if (mTheme == 4) {
            a.setTheme(R.style.Banana);
        }
        if (mTheme == 5) {
            a.setTheme(R.style.Citron);
        }
        if (mTheme == 6) {
            a.setTheme(R.style.Avocado);
        }
        if (mTheme == 7) {
            a.setTheme(R.style.Pistachio);
        }
        if (mTheme == 8) {
            a.setTheme(R.style.Basil);
        }
        if (mTheme == 9) {
            a.setTheme(R.style.Eucalyptus);
        }
        if (mTheme == 10) {
            a.setTheme(R.style.Sage);
        }
        if (mTheme == 11) {
            a.setTheme(R.style.Peacock);
        }
        if (mTheme == 12) {
            a.setTheme(R.style.Cobalt);
        }
        if (mTheme == 13) {
            a.setTheme(R.style.Blueberry);
        }
        if (mTheme == 14) {
            a.setTheme(R.style.Lavender);
        }
        if (mTheme == 15) {
            a.setTheme(R.style.Wisteria);
        }
        if (mTheme == 16) {
            a.setTheme(R.style.Amethyst);
        }
        if (mTheme == 17) {
            a.setTheme(R.style.Grape);
        }
        if (mTheme == 18) {
            a.setTheme(R.style.Radicchio);
        }
        if (mTheme == 19) {
            a.setTheme(R.style.Cherry_Blossom);
        }
        if (mTheme == 20) {
            a.setTheme(R.style.Flamingo);
        }
        if (mTheme == 21) {
            a.setTheme(R.style.Cocoa);
        }
        if (mTheme == 22) {
            a.setTheme(R.style.Graphite);
        }
        if (mTheme == 23) {
            a.setTheme(R.style.Birch);
        }
	}
}