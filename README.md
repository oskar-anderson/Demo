# libGDXTextPerformance


## Results
Platvorm; Kaadrite sagedus sekundites (FPS)  
Windows 10 Google Chrome; 120  
Windows 10 Mozilla Firefox; 40  
Windows 10 lauaarvuti; 762  
Linux Mint 20 lauaarvuti; 1032  


## Getting started
### HTML:
```
./gradlew html:clean html:dist
code ./html/build/dist
```
Use VSCode Live Server plugin to start a local server.
Browsers are normally capped at 60FPS add this to chrome shortcut target property: "C:\Program Files\Google\Chrome\Application\chrome.exe" --args --disable-frame-rate-limit


### Desktop:
Running
```
./gradlew desktop:run
```
Publishing
```
./gradlew desktop:dist
cd desktop/build/libs
java -jar ./desktop-1.0.jar
```
