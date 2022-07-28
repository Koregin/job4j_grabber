# job4j_grabber

Система запускается по расписанию. Период запуска указывается в настройках - app.properties.

Программа должна считывать все вакансии относящиеся к Java и записывать их в базу.

Информация может парситься с различных сайтов.
Есть классы для парсинга вакансий с SQL.ru и HH.ru

Запуск граббера через класс Grabber(для sql.ru) или Grabber2(для hh.ru)  
Доступ к вакансиям через localhost:9000  

Параметры запуска прописываются в файле настроек app.properties:  
parseUrl - URL для парсинга  
port - HTTP порт для просмотра вакансий  
time - интервал парсинга