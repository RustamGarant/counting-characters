REST API для вычисления частоты встречи символов в строке
Это REST API позволяет вычислить частоту встречи символов в заданной строке и предоставляет результат в виде JSON, отсортированного по убыванию количества вхождений символов.

Запуск приложения
Для запуска приложения вам потребуется:

- Java 8+
- Spring Boot 2+
- Maven (для сборки проекта)
- 
Следующие шаги описывают процедуру запуска приложения:

1. Склонируйте репозиторий с кодом проекта с GitHub:
git clone git@github.com:RustamGarant/counting-characters.git

2. Перейдите в каталог проекта
cd counting-characters

3. Соберите проект с помощью Maven:
mvn clean package

4.Запустите приложение
java -jar target/counting-characters-api-1.0.jar

Приложение будет доступно по адресу http://localhost:8080

Формат запроса
Эндпоинт для вычисления частоты встречи символов:

POST /api/character-frequency
Тело запроса должно содержать JSON объект с полем inputString, которое представляет собой строку, для которой вы хотите вычислить частоту символов.

Пример запроса:
localhost:8080/api/v1/algo   
Body: sssttrrrrttt

Формат ответа
Ответ на запрос будет в формате JSON и будет содержать результат в виде объекта, где ключи - это символы, а значения - количество вхождений символов в строку, отсортированные по убыванию количества вхождений.

Пример ответа: {"t":5,"r":4,"s":3}

Вы можете использовать любой HTTP клиент (например, curl или Postman) для отправки POST запросов на эндпоинт api/v1/algo с заданной строкой и получения результата.

