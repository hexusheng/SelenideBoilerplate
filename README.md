
Java + Selenide + TestNG + Allure

параллельный запуск по классам и методам

mvn test -Dbrowser=chrome -Dheadless=1


Allure отчет - `allure serve target/allure-results`


-----
Selenide

Браузер (настройки selenide) инициируется в конструкторе класса App

Create properties file video.properties in classpath:

video.folder= ${user home}/video
video.enabled=false               // default true
video.mode=ALL                    // default ANNOTATED
recorder.type=FFMPEG              // default MONTE
video.save.mode=ALL               // default FAILED_ONLY
video.frame.rate=1                // default 24