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
In above case, your app will be triggered if user clicks a link which starts with one of the following:<br>
1.`appinventor://DeepLink`<br>
2.`https://community.kodular.io`.<br>
3.`https://DeepLink`<br>
4.`appinventor://community.appinventor.mit.edu`
First one is called uri link and latter is url link.If you want to remove support of anyone from your app then simply comment(add // before line) and that compiler will ignore that line.

## Compile Modified Version
1.Use <a href="https://github.com/mit-cml/extension-template">Extension Template</a> to compile Java files<br>
2.Use <a href="https://editor.appybuilder.com/">Appy Builder Code Editor</a> to compile files<br>
3.Use <a href="https://deep-link.000webhostapp.com/">this </a> website to get aix with desired deep link support<br>
4.Contact me with Java files in case you are unable to setup environment or compile files<br>

**Note**
If you want to use Code Editor then you will have to change few things.<br>
1.Remove package name<br>
2.<img src="https://kodular-community.s3.dualstack.eu-west-1.amazonaws.com/original/3X/2/2/22cb98cbb8bf3a6f3e3bb60a4caa807f725f1036.png"><br>
Replace above line with `com.appybuilder.`+ your email without @ part+ `DeepLink$DeepActivity`

### How it works?
To check how it works, I opened browser and tried to load Kodular Community.Here is what I got:<br>
<img src="https://kodular-community.s3.dualstack.eu-west-1.amazonaws.com/optimized/3X/2/f/2fa8ba8df1eeb0de02f0ac2f11d48ea7e7b7c661_2_281x500.png"><br>
<img src="https://kodular-community.s3.dualstack.eu-west-1.amazonaws.com/optimized/3X/8/1/815dbfcd8e0958dffb7526b82b51972f309056b5_2_281x500.png"><br>
<img src="https://kodular-community.s3.dualstack.eu-west-1.amazonaws.com/optimized/3X/6/3/63b498a4ff19a35dd66de0732fec2fb4741c0b4d_2_281x500.png"><br>


## References
1.<a href="https://code.tutsplus.com/tutorials/how-to-enable-deep-links-on-android--cms-26317#">TutsPlus Tutorial</a><br>
2.<a href="https://medium.com/@saitwalshreyash19/writing-extensions-for-app-inventor-2-and-kodular-7d20092bff16?sk=1e2ce3fa85dd781c002c78c75ce83ccd">Guide by Shreyash on how to setup environment</a>
