package com.sunny.DeepLink;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.google.appinventor.components.annotations.androidmanifest.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.util.JsonUtil;

/*
 * @author vknow360 aka Sunny Gupta
 */
@DesignerComponent(version = 2, description ="Adds deep link support (this is older version of extension)<br> Developed by Sunny Gupta", category = ComponentCategory.EXTENSION, nonVisible = true, iconName = "https://res.cloudinary.com/andromedaviewflyvipul/image/upload/c_scale,h_20,w_20/v1571472765/ktvu4bapylsvnykoyhdm.png")
@UsesActivities(activities = {
        @ActivityElement(intentFilters = {
                @IntentFilterElement(actionElements = {
                        @ActionElement(name = "android.intent.action.VIEW")},
                        categoryElements = {
                        @CategoryElement(name = "android.intent.category.DEFAULT"),
                                @CategoryElement(name = "android.intent.category.BROWSABLE")},
                        dataElements = {@DataElement(scheme = "https",host="www.example.com"),
                                @DataElement(scheme = "https",host="example.com")})},name="com.sunny.DeepLink.DeepLink$DeepLinkActivity")})
@SimpleObject(external=true)
public final class DeepLink extends AndroidNonvisibleComponent{
    public DeepLink(ComponentContainer container){
        super(container.$form());
    }
    public static class DeepLinkActivity extends Activity{
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Uri uri = getIntent().getData();
            if (uri != null && uri.toString() != null){
                PackageManager packageManager = getPackageManager();
                Intent intent = packageManager.getLaunchIntentForPackage(getPackageName());
                intent.putExtra("APP_INVENTOR_START", JsonUtil.encodeJsonObject(uri.toString()));
                startActivity(intent);
                finish();
            }
        }
    }
}
