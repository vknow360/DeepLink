# DeepLink
Add deep link support to apps (For MIT AI2 and its distros)

## Introduction
Deep Link feature is one of most requested feature on all app inventor distros.This extension enables you to add deep link support to your app without coding and modifying manifest file.The only thing you have to do is to add your own scheme and host.

## What is Deep Link?
Deeplinks are a concept that help users navigate between the web and applications. They are basically URLs which navigate users directly to the specific content in applications.                                      <br><a href="https://medium.com/@muratcanbur/intro-to-deep-linking-on-android-1b9fe9e38abd">Learn More on Medium</a>
## How to add Deep Link support?
This is the quite complicated part because you should be familiar with Java and XML to do this.You can find a lot of tutorials on Internet to add deep links support.Kindly note that it will be not easier for you if you are a AI2 user.<br>
But as you know my <a href="https://github.com/vknow360/CustomWebView/"> Custom WebView</a> extension is able to add your app in browser's list so I modified its source in such a way that your app will only appear in browser's list for specific links.<br>
So lets get started.<br>
1.Open <a href="https://github.com/vknow360/DeepLink/blob/master/DeepLink.java">DeepLink.java</a> file.<br>
2.Navigate to `UsesActivities` annotation.<br>
You will see something like this:<br>
![image](https://user-images.githubusercontent.com/41724811/88656866-980cf000-d0ee-11ea-9cc1-8df0b096043e.png)<br>
Lets breakdown each element.<br>
(i) `UsesActivities` defines which activities will be added in Manifest file by Compiler.<br>
(ii) `ActvityElement` adds activity element.<br>
(iii) `IntentFilterElement` adds intent filter to activity.<br>
(iv) `ActionElement` adds action element to intent filter.<br>
(v) `CategoryElement` specifies category in activity element.<br>
(vi) `DataElement` specifies data elements in activity.<br>
<br>
Now you have to add your desired `scheme` and `host` in `DataElement`.<br>
I have defined two of them:<br>
![image](https://user-images.githubusercontent.com/41724811/88658535-39954100-d0f1-11ea-8d2a-b25f9c0ae4c4.png)<br>
In above case, your app will be triggered if user clicks a link which starts with either `deepLink://Screen1` or `https://community.kodular.io`.<br>

