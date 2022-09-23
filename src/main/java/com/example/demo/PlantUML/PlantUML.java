package com.example.demo.PlantUML;
//
//@startuml
//actor Actor as actor
//
//participant SoapWSConfig as soapWSconfig
//participant WeatherEndPoint as soapWSendpoint
//participant WeatherServiceSoap as soapWS
//participant WeatherService as service
//participant restTemplate as rest
//
//actor -> soapWSconfig : SoapRequest
//activate soapWSconfig
//
//soapWSconfig -> soapWSendpoint : WeatherOperation(request) : SoapRequest
//activate soapWSendpoint
//
//soapWSendpoint -> soapWS : checkWeatherOperation(request)
//activate soapWS
//
//soapWS -> service : service.findall() : List<City>
//activate service
//
//service -> CityRepository : findall() : List<City>
//activate CityRepository
//
//CityRepository --> service : ok : List<City>
//deactivate CityRepository
//
//service --> soapWS : ok : List<City>
//
//loop for service.findall()
//
//soapWS -> service : service.findall()
//service --> soapWS : List<City>
//
//alt  if city and request same id and name - sucess
//
//soapWS -> service : getWeatherObjectOfCertainCity(request.getMiasto()).getMain().getTemp() : String
//service -> rest : getJSONofCity : String
//activate rest
//rest --> service : ok
//deactivate rest
//service -> service : getWeatherObjectOfCertainCity : WeatherMainClass
//
//service --> soapWS : SoapResponse.temp = getWeatherObjectOfCertainCity(request.getMiasto()).getMain().getTemp() : String
//deactivate service
//
//soapWS --> soapWSendpoint : SoapResponse : SOAP
//
//else false
//
//soapWS --> soapWSendpoint :  null
//deactivate soapWS
//
//end
//
//
//
//end
//
//
//soapWSendpoint --> soapWSconfig : WeatherOperationResponse  : SoapResponse
//deactivate soapWSendpoint
//
//soapWSconfig --> actor : WeatherOperationResponse  : SoapResponse
//deactivate soapWSconfig
//@enduml
