package com.sunny.deeplink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.appinventor.components.runtime.util.JsonUtil;

public class DeepLinkActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(getLaunchIntent());
        finish();
    }

    private Intent getLaunchIntent(){
            try {
                String mScreen = getSharedPreferences("asdfghjk", 0).getString("scrName", "");
                Log.d("DeepLink",mScreen);
                Intent intent = mScreen.isEmpty() ? getPackageManager().getLaunchIntentForPackage(getPackageName()) : new Intent();
                if (!mScreen.isEmpty()){
                intent.setClassName(this,mScreen);
                }
                intent.putExtra("APP_INVENTOR_START", JsonUtil.getJsonRepresentation(getSharedPreferences("asdfghjk", 0).getString("strtvlu", "")));
                intent.setPackage(null);
                intent.setData(getIntent().getData());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                        Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                return intent;
            } catch (Exception e) {
                e.printStackTrace();
            }
        return null;
    }
}
