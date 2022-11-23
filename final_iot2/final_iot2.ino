#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <WiFiClient.h>

#include <ESP8266WiFiMulti.h>
ESP8266WiFiMulti WiFiMulti;

const char* ssid = "Chirag Suthar";
const char* password = "AbraKaDabra_1";

const char* addVehicleName = "http://192.168.252.195/addCar/1";
const char* removeVehicleName = "http://192.168.252.195/removeCar/1";

const int irSensor1 = 13;
const int irSensor2 = 15;

bool addVehicle = false;
bool removeVehicle = false;

void setup() {
  // put your setup code here, to run once:
//  pinMode(irSensor1, INPUT_PULLUP);
//  pinMode(irSensor2, INPUT_PULLUP);
//
//  digitalWrite(LED_BUILTIN, LOW);

  Serial.begin(115200);
  Serial.println();
 
  Serial.print("Connecting to ");
  Serial.println(ssid);
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.println("Connected to WiFi");
  
}

void loop() {
  // put your main code here, to run repeatedly:

  
  if (WiFi.status() == WL_CONNECTED) {
    if(digitalRead(irSensor1)) {
      while(true) {
        if (digitalRead(irSensor2)) {
          addVehicle=true;
          digitalWrite(LED_BUILTIN, HIGH);
          delay(500);
          digitalWrite(LED_BUILTIN, LOW);
          delay(500);
          digitalWrite(LED_BUILTIN, HIGH);
          delay(500);
          digitalWrite(LED_BUILTIN, LOW);
          delay(500);
          break;
        }
      }
    }
    else if (digitalRead(irSensor2) > 0) {
      while(true) {
        if (digitalRead(irSensor1)) {
          removeVehicle = true;
          digitalWrite(LED_BUILTIN, HIGH);
          delay(500);
          digitalWrite(LED_BUILTIN, LOW);
          delay(500);
          break;
        }
      }
    }
    if (addVehicle) {
      httpGETRequest(addVehicleName);
      addVehicle = false;
    }
    if (removeVehicle) {
      httpGETRequest(removeVehicleName);
      removeVehicle = false;
    }
  }

}

void httpGETRequest(const char* serverName) {
  WiFiClient client;
  HTTPClient http;
    
  // Your IP address with path or Domain name with URL path 
  http.begin(client, serverName);
  
  // Send HTTP POST request
  int httpResponseCode = http.GET();
  
  String payload = "--"; 
  
  if (httpResponseCode>0) {
    Serial.print("HTTP Response code: ");
    Serial.println(httpResponseCode);
    payload = http.getString();
  }
  else {
    Serial.print("Error code: ");
    Serial.println(httpResponseCode);
  }
  // Free resources
  http.end();
}
