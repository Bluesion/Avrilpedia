package com.illusion.avrillavigne;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.illusion.avrillavigne.util.ColorEngine;
import com.illusion.avrillavigne.util.Save;
import com.illusion.avrillavigne.util.ThemeEngine;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class WallpaperSetting extends ActionBarActivity implements View.OnClickListener {

    int wallset;
    private Context context;
    private static Bitmap bmp;
    private static FileOutputStream fos;
    private String url = "", fname = "";
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        ThemeEngine.setAppTheme(this);
        ColorEngine.setAppTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper_setting);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Intent i = getIntent();
        String url = i.getExtras().getString("url");
        ImageView iv = (ImageView) findViewById(R.id.ImageView);
        Picasso.with(context)
                .load(url)
                .placeholder(R.drawable.alert)
                .error(R.drawable.alert)
                .into(iv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.setwallpaper:
                InputStream is = context.getResources().openRawResource(+R.id.ImageView);
                Bitmap bm = BitmapFactory.decodeStream(is);

                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                int heights = getBitmapOfHeight(getResources(), R.id.ImageView);
                int widths = getBitmapOfWidth(getResources(), R.id.ImageView);

                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

                try {
                    wallpaperManager.setBitmap(bm);
                    wallpaperManager.suggestDesiredDimensions(widths, heights);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Toast toast = Toast.makeText(getApplicationContext(), R.string.toastwallpaper, Toast.LENGTH_SHORT);
                View view = toast.getView();
                view.setBackgroundResource(R.drawable.toast_frame);
                toast.show();
                break;

            case R.id.download:
                Intent i = getIntent();
                String url = i.getExtras().getString("url");
                Picasso.with(this)
                        .load(url)
                        .into(target);
                break;
        }
    }

    public static void saveImage(Bitmap bmp, String name, Context c) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();

        bmp.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        File dir = new File(sdPath,  "testing");
        dir.mkdir();
        File file = new File(dir, ".jpg");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fos.write(bytes.toByteArray());
            fos.close();
            Toast.makeText(c, "Image saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Target target = new Target() {
        @Override
        public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    File file = new File(Environment.getExternalStorageDirectory().getPath() +".jpg");
                    try {
                        file.createNewFile();
                        FileOutputStream ostream = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
                        ostream.close();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
            if (placeHolderDrawable != null) {
            }
        }
    };

    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    };

    public static int getBitmapOfWidth(Resources res, int id){
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(res, id, options);
            return options.outWidth;
        } catch(Exception e) {
            return 0;
        }
    }

    public static int getBitmapOfHeight(Resources res, int id) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(res, id, options);
            return options.outHeight;
        } catch (Exception e) {
            return 0;
        }
    }
}