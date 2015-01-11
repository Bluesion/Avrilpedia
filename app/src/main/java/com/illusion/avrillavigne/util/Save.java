package com.illusion.avrillavigne.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

public class Save {
    private Context mContext;
    private String NameOfFolder = "/Avrilpedia";
    private String NameOfFile   = "";

    public void SaveImage(Context context, Bitmap ImageToSave){
        mContext = context;
        String file_path = Environment.getExternalStorageDirectory().getAbsolutePath()+ NameOfFolder;
        File dir = new File(file_path);

        if(!dir.exists()){
            dir.mkdirs();
        }

        File file = new File(dir, NameOfFile + ".jpg");

        try {
            FileOutputStream fOut = new FileOutputStream(file);
            ImageToSave.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
            fOut.flush();
            fOut.close();
            MakeSureFileWasCreatedThenMakeAvabile(file);
            AbleToSave();
        }

        catch (FileNotFoundException e) {UnableToSave();}
        catch (IOException e){UnableToSave();}

    }

    private void MakeSureFileWasCreatedThenMakeAvabile(File file) {
        MediaScannerConnection.scanFile(mContext,
                new String[] { file.toString() }, null,
                new MediaScannerConnection.OnScanCompletedListener() {
                    public void onScanCompleted(String path, Uri uri) {
                        Log.e("ExternalStorage", "Scanned " + path + ":");
                        Log.e("ExternalStorage", "-> uri=" + uri);

                    }
                });
    }

    private void UnableToSave() {
        Toast.makeText(mContext, "Picture cannot to gallery", Toast.LENGTH_SHORT).show();
    }

    private void AbleToSave() {
        Toast.makeText(mContext, "Picture saved be saved", Toast.LENGTH_SHORT).show();
    }
}