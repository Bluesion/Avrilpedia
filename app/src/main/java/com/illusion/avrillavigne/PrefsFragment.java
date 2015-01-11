package com.illusion.avrillavigne;

import com.illusion.avrillavigne.util.SettingUtil;
import com.illusion.avrillavigne.R;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import com.illusion.avrillavigne.customlibrary.MaterialPreference.ListPreference;
import com.illusion.avrillavigne.IconListPreference;
import android.preference.Preference;
 
public class PrefsFragment extends SettingUtil implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_settings);
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
	
	    Preference avril = (Preference) findPreference("support");
	    avril.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
		    @Override
	        public boolean onPreferenceClick(Preference arg0) {
	            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","dnjscjf098@gmail.com", null));
	            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
	            startActivity(Intent.createChooser(emailIntent, "Send a mail"));
	            return true;
	        }
	    });
	
	    Preference iloveyou = (Preference) findPreference("license");
	    iloveyou.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
		    @Override
	        public boolean onPreferenceClick(Preference preference) {
		        Intent intent = new Intent(getActivity(), License.class);
		        startActivity(intent);
	        	return true;
	        }
	    });

        Preference somuch = (Preference) findPreference("changelog");
        somuch.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(getActivity(), Changelog.class);
                startActivity(intent);
                return true;
            }
        });

        Preference.OnPreferenceChangeListener onPreferenceChangeListener = new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                Intent i = new Intent(getActivity().getBaseContext(), MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                return true;
            }
        };

        com.illusion.avrillavigne.customlibrary.MaterialPreference.ListPreference from = (com.illusion.avrillavigne.customlibrary.MaterialPreference.ListPreference) getPreferenceManager().findPreference("theme");
        from.setOnPreferenceChangeListener(onPreferenceChangeListener);
        com.illusion.avrillavigne.IconListPreference lbs = (com.illusion.avrillavigne.IconListPreference) getPreferenceManager().findPreference("actionbar");
        lbs.setOnPreferenceChangeListener(onPreferenceChangeListener);
	}

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
    }

    public void onDestroy() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
    }
}