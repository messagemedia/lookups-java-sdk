# Getting started

The MessageMedia Lookups API provides a number of endpoints for validating the phone numbers you’re sending to by checking their validity, type and carrier records.

## How to Build

The generated code uses a few Maven dependencies e.g., Jackson, UniRest,
and Apache HttpClient. The reference to these dependencies is already
added in the pom.xml file will be installed automatically. Therefore,
you will need internet access for a successful build.

* In order to open the client library in Eclipse click on ``` File -> Import ```.

![Importing SDK into Eclipse - Step 1](https://apidocs.io/illustration/java?step=import0&workspaceFolder=MessageMediaLookups-Java&workspaceName=MessageMediaLookups&projectName=MessageMediaLookups&rootNamespace=com.messagemedia.lookups)

* In the import dialog, select ``` Existing Java Project ``` and click ``` Next ```.

![Importing SDK into Eclipse - Step 2](https://apidocs.io/illustration/java?step=import1&workspaceFolder=MessageMediaLookups-Java&workspaceName=MessageMediaLookups&projectName=MessageMediaLookups&rootNamespace=com.messagemedia.lookups)

* Browse to locate the folder containing the source code. Select the detected location of the project and click ``` Finish ```.

![Importing SDK into Eclipse - Step 3](https://apidocs.io/illustration/java?step=import2&workspaceFolder=MessageMediaLookups-Java&workspaceName=MessageMediaLookups&projectName=MessageMediaLookups&rootNamespace=com.messagemedia.lookups)

* Upon successful import, the project will be automatically built by Eclipse after automatically resolving the dependencies.

![Importing SDK into Eclipse - Step 4](https://apidocs.io/illustration/java?step=import3&workspaceFolder=MessageMediaLookups-Java&workspaceName=MessageMediaLookups&projectName=MessageMediaLookups&rootNamespace=com.messagemedia.lookups)

## How to Use

The following section explains how to use the MessageMediaLookups library in a new console project.

### 1. Starting a new project

For starting a new project, click the menu command ``` File > New > Project ```.

![Add a new project in Eclipse](https://apidocs.io/illustration/java?step=createNewProject0&workspaceFolder=MessageMediaLookups-Java&workspaceName=MessageMediaLookups&projectName=MessageMediaLookups&rootNamespace=com.messagemedia.lookups)

Next, choose ``` Maven > Maven Project ```and click ``` Next ```.

![Create a new Maven Project - Step 1](https://apidocs.io/illustration/java?step=createNewProject1&workspaceFolder=MessageMediaLookups-Java&workspaceName=MessageMediaLookups&projectName=MessageMediaLookups&rootNamespace=com.messagemedia.lookups)

Here, make sure to use the current workspace by choosing ``` Use default Workspace location ```, as shown in the picture below and click ``` Next ```.

![Create a new Maven Project - Step 2](https://apidocs.io/illustration/java?step=createNewProject2&workspaceFolder=MessageMediaLookups-Java&workspaceName=MessageMediaLookups&projectName=MessageMediaLookups&rootNamespace=com.messagemedia.lookups)

Following this, select the *quick start* project type to create a simple project with an existing class and a ``` main ``` method. To do this, choose ``` maven-archetype-quickstart ``` item from the list and click ``` Next ```.

![Create a new Maven Project - Step 3](https://apidocs.io/illustration/java?step=createNewProject3&workspaceFolder=MessageMediaLookups-Java&workspaceName=MessageMediaLookups&projectName=MessageMediaLookups&rootNamespace=com.messagemedia.lookups)

In the last step, provide a ``` Group Id ``` and ``` Artifact Id ``` as shown in the picture below and click ``` Finish ```.

![Create a new Maven Project - Step 4](https://apidocs.io/illustration/java?step=createNewProject4&workspaceFolder=MessageMediaLookups-Java&workspaceName=MessageMediaLookups&projectName=MessageMediaLookups&rootNamespace=com.messagemedia.lookups)

### 2. Add reference of the library project

The created Maven project manages its dependencies using its ``` pom.xml ``` file. In order to add a dependency on the *MessageMediaLookups* client library, double click on the ``` pom.xml ``` file in the ``` Package Explorer ```. Opening the ``` pom.xml ``` file will render a graphical view on the cavas. Here, switch to the ``` Dependencies ``` tab and click the ``` Add ``` button as shown in the picture below.

![Adding dependency to the client library - Step 1](https://apidocs.io/illustration/java?step=testProject0&workspaceFolder=MessageMediaLookups-Java&workspaceName=MessageMediaLookups&projectName=MessageMediaLookups&rootNamespace=com.messagemedia.lookups)

Clicking the ``` Add ``` button will open a dialog where you need to specify MessageMediaLookups in ``` Group Id ``` and MessageMediaLookups in the ``` Artifact Id ``` fields. Once added click ``` OK ```. Save the ``` pom.xml ``` file.

![Adding dependency to the client library - Step 2](https://apidocs.io/illustration/java?step=testProject1&workspaceFolder=MessageMediaLookups-Java&workspaceName=MessageMediaLookups&projectName=MessageMediaLookups&rootNamespace=com.messagemedia.lookups)

### 3. Write sample code

Once the ``` SimpleConsoleApp ``` is created, a file named ``` App.java ``` will be visible in the *Package Explorer* with a ``` main ``` method. This is the entry point for the execution of the created project.
Here, you can add code to initialize the client library and instantiate a *Controller* class. Sample code to initialize the client library and using controller methods is given in the subsequent sections.

![Adding dependency to the client library - Step 2](https://apidocs.io/illustration/java?step=testProject2&workspaceFolder=MessageMediaLookups-Java&workspaceName=MessageMediaLookups&projectName=MessageMediaLookups&rootNamespace=com.messagemedia.lookups)

## How to Test

The generated code and the server can be tested using automatically generated test cases. 
JUnit is used as the testing framework and test runner.

In Eclipse, for running the tests do the following:

1. Select the project *MessageMediaLookups* from the package explorer.
2. Select "Run -> Run as -> JUnit Test" or use "Alt + Shift + X" followed by "T" to run the Tests.

## Initialization

### Authentication
In order to setup authentication and initialization of the API client, you need the following information.

| Parameter | Description |
|-----------|-------------|
| basicAuthUserName | The username to use with basic authentication |
| basicAuthPassword | The password to use with basic authentication |



API client can be initialized as following.

```java
// Configuration parameters and credentials
String basicAuthUserName = "basicAuthUserName"; // The username to use with basic authentication
String basicAuthPassword = "basicAuthPassword"; // The password to use with basic authentication

MessageMediaLookupsClient client = new MessageMediaLookupsClient(basicAuthUserName, basicAuthPassword);
```


# Class Reference

## <a name="list_of_controllers"></a>List of Controllers

* [LookupsController](#lookups_controller)

## <a name="lookups_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.messagemedia.lookups.controllers.LookupsController") LookupsController

### Get singleton instance

The singleton instance of the ``` LookupsController ``` class can be accessed from the API Client.

```java
LookupsController lookups = client.getLookups();
```

### <a name="get_lookup_a_phone_number_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.lookups.controllers.LookupsController.getLookupAPhoneNumberAsync") getLookupAPhoneNumberAsync

> Use the Lookups API to find information about a phone number.
> A request to the lookups API has the following format:
> ```/v1/lookups/phone/{phone_number}?options={carrier,type}```
> The `{phone_number}` parameter is a required field and should be set to the phone number to be looked up.
> The options query parameter can also be used to request additional information about the phone number.
> By default, a request will only return the `country_code` and `phone_number` properties in the response.
> To request details about the the carrier, include `carrier` as a value of the options parameter.
> To request details about the type, include `type` as a value of the options parameter. To pass multiple values
> to the options parameter, use a comma separated list, i.e. `carrier,type`.
> A successful request to the lookups endpoint will return a response body as follows:
> ```json
> {
>   "country_code": "AU",
>   "phone_number": "+61491570156",
>   "type": "mobile",
>   "carrier": {
>     "name": "Telstra"
>   }
> }
> ```
> Each property in the response body is defined as follows:
> - ```country_code``` ISO ALPHA 2 country code of the phone number
> - ```phone_number``` E.164 formatted phone number
> - ```type``` The type of number. This can be ```"mobile"``` or ```"landline"```
> - ```carrier``` Holds information about the specific carrier (if available)
>   - ```name``` The carrier's name as reported by the network


```java
void getLookupAPhoneNumberAsync(
        final String phoneNumber,
        final String options,
        final APICallBack<LookupAPhoneNumberResponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| phoneNumber |  ``` Required ```  | The phone number to be looked up |
| options |  ``` Optional ```  | TODO: Add a parameter description |


#### Example Usage

```java
String phoneNumber = "+61491570156";
String options = "carrier,type";
// Invoking the API call with sample inputs
lookups.getLookupAPhoneNumberAsync(phoneNumber, options, new APICallBack<LookupAPhoneNumberResponse>() {
    public void onSuccess(HttpContext context, LookupAPhoneNumberResponse response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 404 | Number was invalid |



[Back to List of Controllers](#list_of_controllers)



