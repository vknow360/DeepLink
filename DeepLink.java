package com.sunny.DeepLink;
import android.app.Activity;
import android.net.Uri;
import com.google.appinventor.components.annotations.androidmanifest.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
/*
* @author vknow360 aka Sunny Gupta
* Contributed by meatomdeveloper
*/
@DesignerComponent(version = 3, description ="Adds deep link support<br> Developed by Sunny Gupta", category = ComponentCategory.EXTENSION, nonVisible = true, iconName = "https://res.cloudinary.com/andromedaviewflyvipul/image/upload/c_scale,h_20,w_20/v1571472765/ktvu4bapylsvnykoyhdm.png")
@UsesActivities(activities = {@ActivityElement(intentFilters = {@IntentFilterElement(actionElements = {@ActionElement(name = "android.intent.action.VIEW")}, categoryElements = {@CategoryElement(name = "android.intent.category.DEFAULT"), @CategoryElement(name = "android.intent.category.BROWSABLE")}, dataElements = {@DataElement(scheme = "appinventor",host="DeepLink"), @DataElement(scheme = "https",host="community.appinventor.mit.edu")})},name="appinventor.ai_vknow360.DeepLink.Screen1",launchMode = "singleTask")})
@SimpleObject(external=true)
public final class DeepLink extends AndroidNonvisibleComponent implements OnResumeListener{
    public Activity activity;
    public DeepLink(ComponentContainer container){
        super(container.$form());
        activity = container.$context();
    }
    public String getUrl(){
        Uri uri = activity.getIntent().getData();
        if (uri != null && uri.toString() != null){
            return uri.toString();
        }
        return "";
    }
    @SimpleFunction(description = "Returns the url which started the current activity/screen")
    public String GetStartUrl(){
        return getUrl();
    }

    @Override
    public void onResume() {
        OnResume(getUrl());
    }
    @SimpleEvent(description = "Event raised when app gets resumed and gives the url which started this activity/screen if there is any else empty string")
    public void OnResume(String url){
        EventDispatcher.dispatchEvent(this,"OnResume",url);
    }
}
