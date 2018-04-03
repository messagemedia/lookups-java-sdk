# MessageMedia Lookups Java SDK
[![Travis Build Status](https://travis-ci.org/messagemedia/lookups-java-sdk.svg?branch=master)](https://travis-ci.org/messagemedia/lookups-java-sdk)
[![maven](https://img.shields.io/badge/maven-v1.0.0-blue.svg)](https://mvnrepository.com/artifact/com.messagemedia.sdk/lookups)

The MessageMedia Lookups API provides a number of endpoints for validating the phone numbers you’re sending to by checking their validity, type and carrier records.

## ⭐️ Install via Maven
At present the jars are available from a public maven repository.

Use the following dependency in your project to grab via Maven:
```
<dependency>
    <groupId>com.messagemedia.sdk</groupId>
    <artifactId>lookups</artifactId>
    <version>1.0.0</version>
</dependency>

```

## 🎬 Get Started
It's easy to get started. Simply enter the API Key and secret you obtained from the [MessageMedia Developers Portal](https://developers.messagemedia.com) into the code snippet below and a mobile number you wish to send to.

### 👀 Lookup a number
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

## 📕 Documentation
The Java SDK Documentation can be viewed [here](DOCUMENTATION.md)

## 😕 Got Stuck?
Please contact developer support at developers@messagemedia.com or check out the developer portal at [developers.messagemedia.com](https://developers.messagemedia.com/)
