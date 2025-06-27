package com.sunny.deeplink;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.verify.domain.DomainVerificationManager;
import android.content.pm.verify.domain.DomainVerificationUserState;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.OnNewIntentListener;

import java.util.Map;
public final class DeepLink extends AndroidNonvisibleComponent implements OnNewIntentListener {
  public Activity activity;
  public DeepLink(ComponentContainer container){
    super(container.$form());
    activity = container.$context();
    form.registerForOnNewIntent(this);
  }
  private String getUrl(Intent intent){
    Uri uri = intent.getData();
    if (uri != null) {
      return uri.toString();
    }
    return "";
  }

  @SimpleFunction(description = "Registers a specific screen to handle deep link navigation with a start value")
  public void RegisterScreen(String screenName,String startValue){
    SharedPreferences.Editor edit = form.getSharedPreferences("asdfghjk", 0).edit();
    String replaceAll = this.form.getClass().getName().replaceAll(this.form.getClass().getSimpleName(), screenName);
    edit.putString("scrName", replaceAll).apply();
    edit.putString("strtvlu", startValue).apply();
  }
  @SimpleFunction(description = "Returns the url which started the current activity")
  public String GetStartUrl(){
    return getUrl(activity.getIntent());
  }

  @SimpleEvent(description = "Event raised when app gets resumed and gives the url which started this activity/screen if there is any else empty string")
  public void OnResume(String url){
    EventDispatcher.dispatchEvent(this,"OnResume",url);

  }
  @SimpleFunction(description = "Opens the system settings page where users can configure which links your app should handle")
  public void VerifyDeepLink(){
    Intent intent = new Intent(Settings.ACTION_APP_OPEN_BY_DEFAULT_SETTINGS,
            Uri.parse("package:" + form.getPackageName()));
    form.startActivity(intent);
  }

  @SimpleFunction(description = "Checks if your app is currently allowed to handle domain links and returns true if enabled. Works only on Android 12 and above")
  public boolean IsLinkHandlingAllowed(){
    if(Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
      return false; 
    }
    DomainVerificationManager manager =
            form.getSystemService(DomainVerificationManager.class);
    DomainVerificationUserState userState =
            null;
    try {
      userState = manager.getDomainVerificationUserState(form.getPackageName());
      Map<String, Integer> hostToStateMap = userState.getHostToStateMap();
      for (String key : hostToStateMap.keySet()) {
        Integer stateValue = hostToStateMap.get(key);
        if (stateValue == DomainVerificationUserState.DOMAIN_STATE_VERIFIED || stateValue == DomainVerificationUserState.DOMAIN_STATE_SELECTED) {
          return true;
        }
      }
    } catch (PackageManager.NameNotFoundException e) {
      e.printStackTrace();
      return false;
    }
    return false;
  }
  @Override
  public void onNewIntent(Intent intent) {
    OnResume(getUrl(intent));
  }
}
