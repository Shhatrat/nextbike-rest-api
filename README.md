# nextbike-rest-api

Extremally simple restful api of Nextbike services.

Version 0.2 is deployed here:

**http://uw382.mikr.us**

# Endpoints
All enpoints are HTTP GET methods.

## Info

- `/info`  getting simple info about API

request: http://uw382.mikr.us/info

response:
``` 
{"description": "Api created by Shhatrat. Source: https://github.com/Shhatrat/nextbike-rest-api",
 "version": "0.2"}
```

## All country
`country/all` getting all countries with cities. 

Optional params:

    `items` - how many items will be returned

    `skip` - how many items will be skiped
    
request: http://uw382.mikr.us/country/all?items=1    
response:

```[{"name":"nextbike Germany","mCities":[{"name":"Wiesbaden","uid":7},{"name":"Offenbach am Main","uid":32},{"name":"Hamburg","uid":43},{"name":"Düsseldorf","uid":50},{"name":"Tübingen","uid":101},{"name":"München","uid":139},{"name":"Flensburg","uid":147},{"name":"Offenburg","uid":155},{"name":"Potsdam","uid":158},{"name":"Gütersloh","uid":160},{"name":"Norderstedt","uid":177},{"name":"Quickborn","uid":256},{"name":"Würzburg","uid":281},{"name":"Marburg","uid":438},{"name":"Rüsselsheim am Main","uid":439},{"name":"Turin","uid":520},{"name":"Wittenberge","uid":591}]}]```


## Filtered country
`country/{country_name}` getting country by name. 

    `country_name`- name of searched country

Optional params:

    `items` - how many items will be returned

    `skip` - how many items will be skiped
    
request: http://uw382.mikr.us/country/nextbike%20germany    
response:

```[{"name":"nextbike Germany","mCities":[{"name":"Wiesbaden","uid":7},{"name":"Offenbach am Main","uid":32},{"name":"Hamburg","uid":43},{"name":"Düsseldorf","uid":50},{"name":"Tübingen","uid":101},{"name":"München","uid":139},{"name":"Flensburg","uid":147},{"name":"Offenburg","uid":155},{"name":"Potsdam","uid":158},{"name":"Gütersloh","uid":160},{"name":"Norderstedt","uid":177},{"name":"Quickborn","uid":256},{"name":"Würzburg","uid":281},{"name":"Marburg","uid":438},{"name":"Rüsselsheim am Main","uid":439},{"name":"Turin","uid":520},{"name":"Wittenberge","uid":591}]}]```


## Nearest country
`country/{country_name}` getting all countries with cities sorted by distance. 

    `lat` - latitude of user
    `lng` - longitude of user

Optional params:

    `items` - how many items will be returned

    `skip` - how many items will be skiped
    
request: http://uw382.mikr.us/country/nearest?lat=51.76&lng=19.44    
response:
```[{"name":"nextbike Germany","mCities":[{"name":"Wiesbaden","uid":7},{"name":"Offenbach am Main","uid":32},{"name":"Hamburg","uid":43},{"name":"Düsseldorf","uid":50},{"name":"Tübingen","uid":101},{"name":"München","uid":139},{"name":"Flensburg","uid":147},{"name":"Offenburg","uid":155},{"name":"Potsdam","uid":158},{"name":"Gütersloh","uid":160},{"name":"Norderstedt","uid":177},{"name":"Quickborn","uid":256},{"name":"Würzburg","uid":281},{"name":"Marburg","uid":438},{"name":"Rüsselsheim am Main","uid":439},{"name":"Turin","uid":520},{"name":"Wittenberge","uid":591}]}]```


## Minimal City
`city/{cityUid}/minimal` getting minimal info of city. 

    `cityUid` - uid of city

    
request: http://uw382.mikr.us/city/330/minimal   
response:

```{"name":"Lódź","uid":330}```


## Full City
`city/{cityUid}/minimal` getting full info of city. 

    `cityUid` - uid of city

    
request: http://uw382.mikr.us/city/330/full   
response:
```{"name":"Lódź","uid":330,"lat":51.7689,"lng":19.4554,"availableBikes":1270,"numPlaces":159}```


## Places
`city/{cityUid}/places` getting places of city. 

    `cityUid` - uid of city

Optional params:

    `items` - how many items will be returned

    `skip` - how many items will be skiped

request: http://uw382.mikr.us/city/330/places?items=1&skip=3  
response:
```[{"uid":"781799","lat":51.762010000258,"lng":19.447292089462,"name":"Żeromskiego / Kopernika","bikes":5,"bikeRacks":15}]```


## Nearest places
`city/{cityUid}/nearestPlaces` getting places of city.

    `cityUid` - uid of city

Optional params:

    `items` - how many items will be returned

    `skip` - how many items will be skiped

    `lat` - latitude of user (for sorting by distance)

    `lng` - longitude of user (for sorting by distance)

request: http://uw382.mikr.us/city/330/nearestPlaces?items=1&skip=3
response:
```[{"uid":"781799","lat":51.762010000258,"lng":19.447292089462,"name":"Żeromskiego / Kopernika","bikes":5,"bikeRacks":15}]```
