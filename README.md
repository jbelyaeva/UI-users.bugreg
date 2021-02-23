**Запуск тестового набора:**

открываем терминал и в папке проекта и выполняем команду:

`mvn -Dbrowser=firefox test -Dsurefire.suiteXmlFiles=src/test/resources/testsets/testng-users.xml`

передаваемые параметры:

`-Dbrowser` – желаемый браузер: firefox, googlechrome (дефолтный googlechrome)

`-Dsurefire.suiteXmlFiles=src/test/resources/testsets/testng-users.xml` – запускаемый тестовый набор

чтобы запустить тестовый набор с дефолтными настройками команда выглядит так:
 
 `mvn test -Dsurefire.suiteXmlFiles=src/test/resources/testsets/testng-users.xml`

**Генерация отчета:**

после выполнения теста выполнить команду:

`allure generate ./target/allure-results --clean -o allure-report `

открыть отчет в браузере: 

`allure open`

очистить отчеты:

`rm -r ./target/allure-results/ allure-report || true`

