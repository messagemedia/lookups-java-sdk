/*
 * MessageMediaLookups
 */
package com.messagemedia.lookups.controllers;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.messagemedia.lookups.models.*;
import com.messagemedia.lookups.exceptions.*;
import com.messagemedia.lookups.APIHelper;
import com.messagemedia.lookups.Configuration;
import com.messagemedia.lookups.testing.TestHelper;
import com.messagemedia.lookups.controllers.LookupsController;

import com.fasterxml.jackson.core.type.TypeReference;

public class LookupsControllerTest extends ControllerTestBase {

    /**
     * Controller instance (for all tests)
     */
    private static LookupsController controller;

    /**
     * Setup test class
     */
    @BeforeClass
    public static void setUpClass() {
        controller = getClient().getLookups();
    }

    /**
     * Tear down test class
     * @throws IOException
     */
    @AfterClass
    public static void tearDownClass() throws IOException {
        controller = null;
    }

    /**
     * Use the Lookups API to find information about a phone number.
A request to the lookups API has the following format:
```/v1/lookups/phone/{phone_number}?options={carrier,type}```
The `{phone_number}` parameter is a required field and should be set to the phone number to be looked up.
The options query parameter can also be used to request additional information about the phone number.
By default, a request will only return the `country_code` and `phone_number` properties in the response.
To request details about the the carrier, include `carrier` as a value of the options parameter.
To request details about the type, include `type` as a value of the options parameter. To pass multiple values
to the options parameter, use a comma separated list, i.e. `carrier,type`.
A successful request to the lookups endpoint will return a response body as follows:
```json
{
  "country_code": "AU",
  "phone_number": "+61491570156",
  "type": "mobile",
  "carrier": {
    "name": "Telstra"
  }
}
```
Each property in the response body is defined as follows:
- ```country_code``` ISO ALPHA 2 country code of the phone number
- ```phone_number``` E.164 formatted phone number
- ```type``` The type of number. This can be ```"mobile"``` or ```"landline"```
- ```carrier``` Holds information about the specific carrier (if available)
  - ```name``` The carrier's name as reported by the network
     * @throws Throwable
     */
    @Test
    public void testLookupAPhoneNumber() throws Throwable {
        // Parameters for the API call
        String phoneNumber = "+61491570156";
        String options = "carrier,type";

        // Set callback and perform API call
        LookupAPhoneNumberResponse result = null;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.getLookupAPhoneNumber(phoneNumber, options);
        } catch(APIException e) {};

       // Test whether the response is null
        assertNotNull("Response is null",
                httpResponse.getResponse());
        // Test response code
        assertEquals("Status is not 200",
                200, httpResponse.getResponse().getStatusCode());

        // Test headers
        Map<String, String> headers = new LinkedHashMap<String, String>();
        headers.put("Content-Type", TestHelper.nullString);

        assertTrue("Headers do not match", TestHelper.areHeadersProperSubsetOf(
                headers, httpResponse.getResponse().getHeaders(), true));

        // Test whether the captured response is as we expected
        assertNotNull("Result does not exist",
                result);
        assertEquals("Response body does not match exactly",
                "{\"carrier\":{\"name\":\"AU Landline Carrier\"},\"country_code\":\"AU\",\"phone_number\":\"+61491570156\",\"type\":\"MOBILE\"}",
                TestHelper.convertStreamToString(httpResponse.getResponse().getRawBody()));
    }

}
