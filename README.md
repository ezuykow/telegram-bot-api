# Legram Bot API

Library for working with Telegram Bot API

Full support of all Bot API 6.9 methods

---
- [Connecting to the project](#connecting-to-the-project)
- [Usage](#usage)
    - [Creating TelegramBot instance](#creating-telegrambot-instance)
      - [Simple TelegramBot](#simple-telegrambot)
      - [Custom TelegramBot](#custom-telegrambot)
    - [Making requests](#making-requests)
      - [Request with response](#request-with-response)
      - [Request with nested processing](#request-with-nested-processing)
  - [Useful TelegramBot methods](#useful-telegrambot-methods)
  - [Getting Update's](#getting-updates)
    - [GetUpdates request](#getupdates-request)
    - [Executing GetUpdates request](#executing-getupdates-request)
      - [UpdatesListener](#updateslistener)
      - [Webhook](#webhook)
        - [Building request](#building-request)
        - [Executing request](#executing-request)
  - [Available types and methods](#available-types-and-methods)
- [Request](#request)
- [Response](#response)
- [Callback](#callback)

# Connecting to the project

...

# Usage

## Creating TelegramBot instance

### Simple TelegramBot

1. TelegramBot with default Bot API server (https://api.telegram.org)
```java
TelegramBot bot = new TelegramBot("BOT_TOKEN");
```

2. TelegramBot with local Bot API server
```java
TelegramBot bot = new TelegramBot("BOT_TOKEN", "BOT_API_SERVER_URL");
```

### Custom TelegramBot

To create a TelegramBot with custom parameters, use TelegramBot.Builder
```java
TelegramBot bot = new TelegramBot.Builder("BOT_TOKEN")
        .apiServerUrl("BOT_API_SERVER_URL")
        .okHttpClient(client)
        .build();
```

Parameters `.apiServerUrl` and `.okHttpClient` are unnecessary. If they are missing, the default values will be substituted.
The `.okHttpClient` parameter accepts an object of the OkHttpClient class from library [OkHttp](https://github.com/square/okhttp)

Additional parameters for TelegramBot.Builder:
```java
.updatesHandlerSleepTime(millis) //Sleep time of UpdatesHandler for long polling bot in millis
.httpClientBasicDebugMode() //Enable debug mode for default OkHttpClient with level "basic" (headers and body)
.httpClientHeadersDebugMode() //Enable debug mode for default OkHttpClient with level "headers" (headers only)
.httpClientBodyDebugMode() //Enable debug mode for default OkHttpClient with level "body" (body only)
.httpClientDisableDebugMode() //Disable debug mode for default OkHttpClient
```

## Making requests

### Request with response

> [Response](#response) response = bot.execute([request](#request));

### Request with nested processing

> bot.execute(request, [callback](#callback));

## Useful TelegramBot methods

> `String getFullFilePath(File file)` - return full path to target file on Telegram bot API server\
> `byte[] getFileContent(File file)` - return file content as byte array

## Getting Update's

### GetUpdates request

```java
GetUpdates getUpdates = new GetUpdates()
        .offset(0)
        .limit(100)
        .timeout(0)
        .allowedUpdates(Collections.emptyList());
```

About parameters:
> `.offset(value)` - Optional. Receive identifier of the first update to be returned. Must be greater by one than the
> highest among the identifiers of previously received updates. By default, updates starting with the earliest 
> unconfirmed update are returned. An update is considered confirmed as soon as getUpdates is called with 
> an offset higher than its update_id. The negative offset can be specified to retrieve updates starting from 
> -offset update from the end of the updates queue. All previous updates will be forgotten.
> 
> `.limit(value)` - Optional. Receive int value, what limits the number of updates to be retrieved. Values between 
> 1-100 are accepted. Defaults to 100.
> 
> `.timeout(value)` - Optional. Receive timeout in seconds for long polling. Defaults to 0, i.e. usual short polling. 
> Should be positive, short polling should be used for testing purposes only.
> 
> `.allowedUpdates(value)` - Optional. Receive array of Strings of the update type names you want your bot to receive.
> Specify an empty list to receive all update types except chat_member (default). If not specified, 
> the previous setting will be used.

### Executing GetUpdates request

```java
GetUpdatesResponse response = bot.execute(getUpdates);
List<Update> updates = response.getUpdates();
```

###  UpdatesListener

UpdatesListener - interface, which must be implemented by the incoming Update's handler.

You can set a listener to receive incoming updates as if using Webhook.\
This will trigger executing getUpdates requests in a loop.
There are few ways to set a listener:
1. `bot.setUpdatesListener(listener, exceptionHandler, getUpdates);`
2. `bot.setUpdatesListener(listener, exceptionHandler);` - using GetUpdates request with default parameters
3. `bot.setUpdatesListener(listener, getUpdates);` - without ExceptionHandler
4. `bot.setUpdatesListener(listener);` - without ExceptionHandler and using GetUpdates request with default parameters

> `listener` - instance of class, which implementing UpdatesListener interface \
> `exceptionHandler` - instance of class, which implementing ExceptionHandler interface (interface, which must be 
> implemented by handler of exceptions that occurs in UpdatesListener) \
> `getUpdates` - instance of GetUpdates class (GetUpdates request)

Listener should return id of the last processed (confirmed) update.
To confirm all updates return UpdatesListener.CONFIRMED_UPDATES_ALL, this should be enough in most cases.
To not confirm any updates return UpdatesListener.CONFIRMED_UPDATES_NONE, these updates will be redelivered.
To set a specific update as last confirmed, just return the required updateId.

To stop receiving updates use:
```java
bot.removeUpdatesListener();
```

### Webhook

Official [Guide to All Things Webhook](https://core.telegram.org/bots/webhooks)

#### Building request
If your application run on server that is able to handle TLS1.2(+) HTTPS-traffic:
```java
SetWebhook setWebhook = new SetWebhook().url("https://your_app_url");
```
If you use self-signed certificate:
```java
SetWebhook setWebhook = new SetWebhook().url("https://your_app_url")
        .certificate(cert);
//where `cert` - certificate as java.io.File or byte[]
```
#### Executing request

To execute SetWebhook request use:
```java
bot.execute(setWebhook);
```

## Available types and methods
All types and methods have the same name as [original ones](https://core.telegram.org/bots/api).

# Request

Request - abstract class, that is general request to Telegram bot API server.\
All available methods extends it class.

# Response

Response - class, that is general Telegram bot API server response.\
All available methods return a response extending this class when executed.\
There are few general fields for all responses:
1. `boolean ok` - True, if request was successful. In case of an unsuccessful request, 'ok' equals false and the error is explained in the 'description'
2. `String description` - Optional. A human-readable description of the result
3. `Integer errorCode` - Optional. Code of error if request is unsuccessful
4. `ResponseParameters parameters` - Optional. Describes why a request was unsuccessful

# Callback

Callback - interface for executing request's with custom processing. It's handler of request result with methods 
onResponse (when request executed successfully) and onFailure (when request executed unsuccessfully).\
Example:
```java
bot.execute(new GetUpdates(), new Callback<GetUpdates, GetUpdatesResponse>{
        @Override
        public void onResponse(GetUpdates request, GetUpdatesResponse response) {
            List<Update> updates = response.getUpdates();
            //processing...
        }

        @Override
        public void onFailure(GetUpdates request, Exception e) {
            //When request executing is unseccessful...
        }
});
```