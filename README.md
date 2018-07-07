# MessageMedia Lookups Java SDK
[![Travis Build Status](https://travis-ci.org/messagemedia/lookups-java-sdk.svg?branch=master)](https://travis-ci.org/messagemedia/lookups-java-sdk)
[![Pull Requests Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat)](http://makeapullrequest.com)
[![maven](https://img.shields.io/maven-metadata/v/http/central.maven.org/maven2/com/messagemedia/sdk/lookups/maven-metadata.xml.svg)](https://mvnrepository.com/artifact/com.messagemedia.sdk/lookups)

The MessageMedia Lookups API provides a number of endpoints for validating the phone numbers you’re sending to by checking their validity, type and carrier records.

![Isometric](https://developers.messagemedia.com/wp-content/uploads/2017/11/lookups-api.png)

## Table of Contents
* [Authentication](#closed_lock_with_key-authentication)
* [Errors](#interrobang-errors)
* [Information](#newspaper-information)
  * [Slack and Mailing List](#slack-and-mailing-list)
  * [Bug Reports](#bug-reports)
  * [Contributing](#contributing)
* [Installation](#star-installation)
* [Get Started](#clapper-get-started)
* [API Documentation](#closed_book-api-documentation)
* [Need help?](#confused-need-help)
* [License](#page_with_curl-license)

## :closed_lock_with_key: Authentication

Authentication is done via API keys. Sign up at https://developers.messagemedia.com/register/ to get your API keys.

Requests are authenticated using HTTP Basic Auth or HMAC. Provide your API key as the auth_user_name and API secret as the auth_password.

## :interrobang: Errors

Our API returns standard HTTP success or error status codes. For errors, we will also include extra information about what went wrong encoded in the response as JSON. The most common status codes are listed below.

#### HTTP Status Codes

| Code      | Title       | Description |
|-----------|-------------|-------------|
| 400 | Invalid Request | The request was invalid |
| 401 | Unauthorized | Your API credentials are invalid |
| 403 | Disabled feature | Feature not enabled |
| 404 | Not Found |	The resource does not exist |
| 50X | Internal Server Error | An error occurred with our API |

## :newspaper: Information

#### Slack and Mailing List

If you have any questions, comments, or concerns, please join our Slack channel:
https://developers.messagemedia.com/collaborate/slack/

Alternatively you can email us at:
developers@messagemedia.com

#### Bug reports

If you discover a problem with the SDK, we would like to know about it. You can raise an [issue](https://github.com/messagemedia/signingkeys-nodejs-sdk/issues) or send an email to: developers@messagemedia.com

#### Contributing

We welcome your thoughts on how we could best provide you with SDKs that would simplify how you consume our services in your application. You can fork and create pull requests for any features you would like to see or raise an [issue](https://github.com/messagemedia/signingkeys-nodejs-sdk/issues)


## :star: Installation
At present the jars are available from a public maven repository.

Use the following dependency in your project to grab via Maven:
```
<dependency>
    <groupId>com.messagemedia.sdk</groupId>
    <artifactId>lookups</artifactId>
    <version>1.0.0</version>
</dependency>

```

## :clapper: Get Started
It's easy to get started. Simply enter the API Key and secret you obtained from the [MessageMedia Developers Portal](https://developers.messagemedia.com) into the code snippet below and a mobile number you wish to send to.

### Lookup a number
```java
package com.company;
import com.messagemedia.lookups.*;
import com.messagemedia.lookups.controllers.LookupsController;
import com.messagemedia.lookups.http.client.APICallBack;
import com.messagemedia.lookups.http.client.HttpContext;
import com.messagemedia.lookups.models.LookupAPhoneNumberResponse;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String basicAuthUserName = "YOUR_API_KEY"; // The username to use with basic authentication
        String basicAuthPassword = "YOUR_API_SECRET"; // The password to use with basic authentication

        MessageMediaLookupsClient client = new MessageMediaLookupsClient(basicAuthUserName, basicAuthPassword);

        LookupsController lookups = client.getLookups();
        String phoneNumber = "YOUR_MOBILE_NUMBER";
        String options = "carrier,type";
        // Invoking the API call with sample inputs
        lookups.getLookupAPhoneNumberAsync(phoneNumber, options, new APICallBack<LookupAPhoneNumberResponse>() {
            public void onSuccess(HttpContext context, LookupAPhoneNumberResponse response) {
                // TODO success callback handler
                System.out.print(response.getCarrier());
            }
            public void onFailure(HttpContext context, Throwable error) {
                // TODO failure callback handler
                System.out.print(error);
            }
        });

    }
}
```

## :closed_book: API Reference Documentation
Check out the [full API documentation](https://developers.messagemedia.com/code/lookups-api-documentation/) for more detailed information.

## :confused: Need help?
Please contact developer support at developers@messagemedia.com or check out the developer portal at [developers.messagemedia.com](https://developers.messagemedia.com/)

## :page_with_curl: License
Apache License. See the [LICENSE](LICENSE) file.
