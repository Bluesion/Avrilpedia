package com.illusion.avrillavigne.fragment;

import com.illusion.avrillavigne.R;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.illusion.avrillavigne.customlibrary.MaterialDesign.ProgressBarCircularIndeterminate;

public class SNS extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

	private static final String ARG_POSITION = "position";
	private int position;
	private WebView webView;
	ArrayAdapter<JsonObject> tweetAdapter;
    private FrameLayout normal;
    private LinearLayout error;
    private SwipeRefreshLayout mSwipeLayout;
    private ProgressBarCircularIndeterminate progress;

	public static SNS newInstance(int position) {
		SNS f = new SNS();
		Bundle b = new Bundle();
		b.putInt(ARG_POSITION, position);
		f.setArguments(b);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		position = getArguments().getInt(ARG_POSITION);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.webview, container, false);
        progress = (ProgressBarCircularIndeterminate) rootView.findViewById(R.id.progressBarCircularIndetermininate);
		View v;
        if (isNetwork()) {
            normal = (FrameLayout) rootView.findViewById(R.id.channel);
            normal.setVisibility(View.VISIBLE);
            error = (LinearLayout) rootView.findViewById(R.id.no_internet_connection);
            error.setVisibility(View.GONE);

            if (position == 0) {
                tweetAdapter = new ArrayAdapter<JsonObject>(getActivity(), 0) {
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        if (convertView == null)
                            convertView = getActivity().getLayoutInflater().inflate(R.layout.tweet, null);

                        if (position >= getCount() - 3)
                            load();

                        JsonObject tweet = getItem(position);
                        JsonObject retweet = tweet.getAsJsonObject("retweeted_status");
                        if (retweet != null)
                            tweet = retweet;

                        JsonObject user = tweet.getAsJsonObject("user");
                        String twitterId = user.get("screen_name").getAsString();

                        String imageUrl = user.get("profile_image_url").getAsString();

                        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);

                        Ion.with(imageView)
                                .placeholder(R.drawable.twitter)
                                .load(imageUrl);

                        TextView handle = (TextView) convertView.findViewById(R.id.handle);
                        handle.setText(twitterId);

                        TextView text = (TextView) convertView.findViewById(R.id.tweet);
                        text.setText(tweet.get("text").getAsString());

                        return convertView;
                    }
                };

                v = inflater.inflate(R.layout.twitter, container, false);
                ListView listView = (ListView) v.findViewById(R.id.list);
                listView.setAdapter(tweetAdapter);

                mSwipeLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_container);
                mSwipeLayout.setOnRefreshListener(this);
                mSwipeLayout.setColorSchemeResources(R.color.card_color,
                        R.color.swipe_refresh_green, R.color.swipe_refresh_orange,
                        R.color.swipe_refresh_red);

                getCredentials();
                return v;

            } else if (position == 1) {
                if (isNetwork()) {
                    v = inflater.inflate(R.layout.webview, container, false);
                    normal = (FrameLayout) v.findViewById(R.id.channel);
                    normal.setVisibility(View.VISIBLE);
                    error = (LinearLayout) v.findViewById(R.id.no_internet_connection);
                    error.setVisibility(View.GONE);
                    webView = (WebView) v.findViewById(R.id.webview);
                    webView.loadUrl("https://www.facebook.com/avrillavigne");
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.setWebViewClient(new WebViewClient() {
                        public void onPageFinished() {
                            if (progress.isActivated()) {
                                progress.setVisibility(View.GONE);
                            }
                        }
                    });

                    setHasOptionsMenu(true);
                    return v;
                }

            } else if (position == 2) {
                if (isNetwork()) {
                    v = inflater.inflate(R.layout.webview, container, false);
                    normal = (FrameLayout) v.findViewById(R.id.channel);
                    normal.setVisibility(View.VISIBLE);
                    error = (LinearLayout) v.findViewById(R.id.no_internet_connection);
                    error.setVisibility(View.GONE);
                    webView = (WebView) v.findViewById(R.id.webview);
                    webView.loadUrl("http://instagram.com/avrillavigne");
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.setWebViewClient(new WebViewClient());

                    setHasOptionsMenu(true);
                    return v;
                }

            } else if (position == 3) {
                if (isNetwork()) {
                    v = inflater.inflate(R.layout.webview, container, false);
                    normal = (FrameLayout) v.findViewById(R.id.channel);
                    normal.setVisibility(View.VISIBLE);
                    error = (LinearLayout) v.findViewById(R.id.no_internet_connection);
                    error.setVisibility(View.GONE);
                    webView = (WebView) v.findViewById(R.id.webview);
                    webView.loadUrl("http://www.youtube.com/user/AvrilLavigne");
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.setWebViewClient(new WebViewClient());

                    setHasOptionsMenu(true);
                    return v;
                }

            } else {
                if (isNetwork()) {
                    v = inflater.inflate(R.layout.webview, container, false);
                    normal = (FrameLayout) v.findViewById(R.id.channel);
                    normal.setVisibility(View.VISIBLE);
                    error = (LinearLayout) v.findViewById(R.id.no_internet_connection);
                    error.setVisibility(View.GONE);
                    webView = (WebView) v.findViewById(R.id.webview);
                    webView.loadUrl("http://www.avrillavigne.com/us/home");
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.getSettings().setBuiltInZoomControls(true);
                    webView.getSettings().setSupportZoom(true);
                    webView.setWebChromeClient(new WebChromeClient() {
                        @Override
                        public void onProgressChanged(WebView view, int newProgress) {
                            super.onProgressChanged(view, newProgress);
                            if (newProgress > 0) {
                                progress.setVisibility(View.VISIBLE);
                            }
                            if (newProgress >= 100) {
                                progress.setVisibility(View.GONE);
                            }
                        }
                    });
                    setHasOptionsMenu(true);
                    return v;
                }
            }
        }
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.back) {
			if (SNS.this.webView.canGoBack())
            	SNS.this.webView.goBack();
			return true;
		}
		if (id == R.id.forward) {
			if (SNS.this.webView.canGoForward())
            	SNS.this.webView.goForward();
			return true;
		}
		if (id == R.id.refresh) {
			SNS.this.webView.reload();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	Future<JsonArray> loading;

    String accessToken;
    private void getCredentials() {
        Ion.with(this)
        .load("https://api.twitter.com/oauth2/token")
        .basicAuthentication("e4LrcHB55R3WamRYHpNfA", "MIABn1DU5db3Aj0xXzhthsf4aUKMAdoWJTMxJJcY")
        .setBodyParameter("grant_type", "client_credentials")
        .asJsonObject()
        .setCallback(new FutureCallback<JsonObject>() {
            @Override
            public void onCompleted(Exception e, JsonObject result) {
                if (e != null) {
                    Toast toast = Toast.makeText(getActivity(), R.string.sns_error, Toast.LENGTH_LONG);
                    View view = toast.getView();
                    view.setBackgroundResource(R.drawable.toast_frame);
                    toast.show();
                    return;
                }
                accessToken = result.get("access_token").getAsString();
                load();
            }
        });
    }

    @SuppressWarnings("deprecation")
	private void load() {
        if (loading != null && !loading.isDone() && !loading.isCancelled())
            return;

        String url = "https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=AvrilLavigne&count=20";
        if (tweetAdapter.getCount() > 0) {
            JsonObject last = tweetAdapter.getItem(tweetAdapter.getCount() - 1);
            url += "&max_id=" + last.get("id_str").getAsString();
        }

        loading = Ion.with(this)
        .load(url)
        .setHeader("Authorization", "Bearer " + accessToken)
        .asJsonArray()
        .setCallback(new FutureCallback<JsonArray>() {
            @Override
            public void onCompleted(Exception e, JsonArray result) {
                if (e != null) {
                    Toast toast = Toast.makeText(getActivity(), R.string.sns_error, Toast.LENGTH_LONG);
                    View view = toast.getView();
                    view.setBackgroundResource(R.drawable.toast_frame);
                    toast.show();
                    return;
                }
                for (int i = 0; i < result.size(); i++) {
                    tweetAdapter.add(result.get(i).getAsJsonObject());
                }
            }
        });
    }

    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeLayout.setRefreshing(false);
            }
        }, 5000);
    }
}