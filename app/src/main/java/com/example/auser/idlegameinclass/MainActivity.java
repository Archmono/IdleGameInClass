package com.example.auser.idlegameinclass;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;

import static com.example.auser.idlegameinclass.R.id.textView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    ImageView img1,img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView)findViewById(R.id.textView);
        img1 = (ImageView)findViewById(R.id.imageView01);

        json();
    }

    private void json() {

        try {
            InputStream is = this.getResources().openRawResource(R.raw.json);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            //讀取json到buffer中
            String json = new String(buffer, "UTF-8");
            //轉換編碼
            JSONObject jsonObject = new JSONObject(json);
            //把json丟到jsonObject中
            JSONArray array = jsonObject.getJSONArray("mobsdata");
            //取出"info"中的資料,放入JSONArray array
            StringBuffer strBuf = new StringBuffer();
            //建立保存用的StringBuffer,以儲存資料

            for (int i = 0; i < array.length(); i++) {

                JSONObject item = array.getJSONObject(i);

                String id = item.getString("id");
                String name = item.getString("name");
                int HP = item.getInt("HP");
                //大括號中內容為一個JSONObject,要額外創建
                JSONObject pics = item.getJSONObject("pics");
                String pic1 = pics.getString("pic1");
                JSONObject dropLoots = item.getJSONObject("dropLoots");
                String loot1 = dropLoots.getString("loot1");

                strBuf.append("id:" + id + "\n");
                strBuf.append("name:" + name + "\n");
                strBuf.append("HP:" + HP + "\n");
                strBuf.append("pics:" + "\n");
                strBuf.append("  pic1:" + pic1 + "\n");
                strBuf.append("掉落物:" + dropLoots + "\n");
                strBuf.append("掉落1:" + loot1 + "\n");
                //把資料放入strBuf中=
            }

            JSONObject resIDname = array.getJSONObject(0);
            JSONObject pics = resIDname.getJSONObject("pics");
            String pic1 = pics.getString("pic1");

            tv1.setText(strBuf);
            Log.d("array length", array.length() + "");

            int resID = getResources().getIdentifier(pic1,"drawable", getPackageName());
            img1.setImageResource(resID);
            Log.d("redID",resID + "");

        } catch (Exception e) {
            tv1.setText(e.getMessage());
        }
    }
}
