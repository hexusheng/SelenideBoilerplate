
Java + Selenide + TestNG + Allure

параллельный запуск по классам и методам

mvn test -Dbrowser=chrome -Dheadless=1

browser - chrome, firefox, remote

Allure отчет - `allure serve target/allure-results`


-----
Selenide

Браузер (настройки selenide) инициируется в конструкторе класса App

Если используется свой драйвер - WebDriverRunner.setWebDriver(driver), Selenide.close() работать не будет.
Нужно закрывать через свой драйвер.

....

-----
Запись видео.
Работает только только локально, в headless  режиме не работает. Просто снимет весь экран. 
 

Create properties file video.properties in classpath:

video.folder= ${user home}/video
video.enabled=false               // default true
video.mode=ALL                    // default ANNOTATED
recorder.type=FFMPEG              // default MONTE
video.save.mode=ALL               // default FAILED_ONLY
video.frame.rate=1                // default 24