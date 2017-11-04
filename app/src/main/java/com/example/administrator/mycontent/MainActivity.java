package com.example.administrator.mycontent;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private Uri uri = Settings.System.CONTENT_URI;
    private ContentResolver cr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cr = getContentResolver();
        // Uri => content://Provider/table

//        Cursor cursor = cr.query(uri,null,null,null,null,null);
//        while (cursor.moveToNext()){
//            String name = cursor.getString(cursor.getColumnIndex("name"));
//            String value = cursor.getString(cursor.getColumnIndex("value"));
//            Log.i("brad", name + ":" + value);
//        }
        getSettingValue(Settings.System.FONT_SCALE);
    }

    private void getSettingValue(String name){
        Cursor cursor = cr.query(uri,new String[]{"name","value"},
                "name=?",new String[]{name},null,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            String value = cursor.getString(cursor.getColumnIndex("value"));
            Log.i("brad", name + ":" + value);
        }

    }

}
