# DeepLink Extension

An App Inventor 2 extension for handling deep links and URL schemes in your applications. This extension allows your App Inventor app to respond to custom URLs and web links, enabling seamless navigation from web browsers, other apps, or sharing links.

## Features

-   🔗 **Deep Link Handling**: Handle custom URL schemes and web links
-   📱 **Screen Registration**: Register specific screens to handle deep link navigation
-   🌐 **Domain Verification**: Check and manage domain verification status
-   📲 **Resume Events**: Get notified when your app is opened via a deep link
-   ⚙️ **Link Settings**: Direct users to system settings for link handling preferences

## Installation

### Option 1: Compile Source Using Rush

To build the extension from source code:

1. **Install Rush CLI**: Download and install Rush CLI from [rush-cli repository](https://github.com/ShreyashSaitwal/rush-cli)
2. **Clone/Download**: Get the source code of this DeepLink extension
3. **Customize**: Modify the `AndroidManifest.xml` to match your domain/URL scheme
4. **Build**: Run `rush build` in the project directory
5. **Import**: The generated `.aix` file will be in the `out/` directory - import it into App Inventor

### Option 2: Generate AIX File Online

Use the online tool to generate a customized extension:

**🔗 [Generate AIX File - https://sunnythedeveloper.in/tools/deeplink](https://sunnythedeveloper.in/tools/deeplink)**

This tool allows you to:

-   Customize the deep link URLs for your domain
-   Configure your own URL schemes
-   Generate a personalized `.aix` file with your specific settings
-   Modify the extension to work with your website or app ecosystem

Simply visit the link above, enter your domain details, and download your customized DeepLink extension.

## Usage

### Basic Setup

1. Add the DeepLink component to your screen (it's a non-visible component)
2. Configure your app's deep link settings using the provided functions

### Functions

#### `RegisterScreen(screenName, startValue)`

Registers a specific screen to handle deep link navigation.

**Parameters:**

-   `screenName` (String): The name of the screen that should handle the deep link
-   `startValue` (String): Initial value to pass to the screen when opened via deep link

**Example:**

```blocks
DeepLink.RegisterScreen("Screen2", "welcome_from_link")
```

#### `GetStartUrl()`

Returns the URL that started the current activity.

**Returns:** String - The deep link URL or empty string if none

**Example:**

```blocks
when Screen.Initialize do
  set label.Text to DeepLink.GetStartUrl
end
```

#### `VerifyDeepLink()`

Opens the system settings page where users can configure which links your app should handle.

**Example:**

```blocks
when Button.Click do
  DeepLink.VerifyDeepLink
end
```

#### `IsLinkHandlingAllowed()`

Checks if your app is currently allowed to handle domain links.

**Returns:** Boolean - True if link handling is enabled, false otherwise

**Example:**

```blocks
when Screen.Initialize do
  if DeepLink.IsLinkHandlingAllowed then
    set StatusLabel.Text to "Link handling is enabled"
  else
    set StatusLabel.Text to "Link handling is disabled"
  end if
end
```

### Events

#### `OnResume(url)`

Triggered when the app is resumed and provides the URL that started the activity.

**Parameters:**

-   `url` (String): The deep link URL or empty string if none

**Example:**

```blocks
when DeepLink.OnResume do
  if get url ≠ "" then
    set UrlLabel.Text to get url
    // Handle the deep link URL
  end if
end
```

## Configuration

### Android Manifest Setup

The extension automatically handles the Android Manifest configuration. By default, it's configured to handle:

-   **HTTP/HTTPS links**: `http://sunnythedeveloper.in` and `https://sunnythedeveloper.in`
-   **Custom schemes**: You can modify the manifest to add your own custom URL schemes

### Domain Verification

For HTTPS links to work properly, you need to:

1. Add a `assetlinks.json` file to your domain's `/.well-known/` directory
2. Configure the file to include your app's package name and signing certificate
3. Use the `VerifyDeepLink()` function to help users enable link handling

## Example Implementation

Here's a complete example of how to use the DeepLink extension:

### Screen1 (Main Screen)

```blocks
when Screen1.Initialize do
  DeepLink.RegisterScreen("Screen1", "main_screen")
  set StartUrlLabel.Text to DeepLink.GetStartUrl
end

when DeepLink.OnResume do
  if get url ≠ "" then
    set NotificationLabel.Text to "Opened from: " + get url
    // Parse the URL and navigate accordingly
  end if
end

when SettingsButton.Click do
  DeepLink.VerifyDeepLink
end
```

## Common Use Cases

1. **Social Media Sharing**: Allow users to share links that open specific content in your app
2. **Email Marketing**: Include links in emails that open directly to relevant app sections
3. **Cross-App Navigation**: Enable other apps to link to specific features in your app
4. **Web-to-App**: Redirect users from your website to the mobile app

## Troubleshooting

### Links not opening in app

1. Check if `IsLinkHandlingAllowed()` returns true
2. Use `VerifyDeepLink()` to open system settings
3. Verify domain verification is properly configured

### App not receiving URL data

1. Ensure `RegisterScreen()` is called with correct parameters
2. Check that `OnResume` event is properly handled
3. Verify the deep link URL format matches your configuration

## Technical Details

-   **Created with**: Rush CLI
-   **Version**: 3
-   **Author**: vknow360
-   **Minimum Android**: API level varies based on domain verification features
-   **Package**: com.sunny.deeplink

## License

This extension is created using Rush and has MIT License.

## Support

For issues, questions, or contributions, please refer to the App Inventor community forum.

---

_This extension enables powerful deep linking capabilities for your App Inventor applications, making them more integrated with the Android ecosystem and web._
