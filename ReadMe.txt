Для запуска приложения в application.properties установить свою конфигурацию для Postgres
В src\main\resources\database находятся два файла init_tables.sql, populate_db.sql с помощью которых можно создать
таблицы и вставить данные используя СУБД.
Или в application.properties установить
 spring.jpa.generate-ddl=true
 spring.jpa.hibernate.ddl-auto=create
 тогда Hibernate автоматически создаст таблицы.
 (При этом скрипты упомянутые выше могут не сработать, так как при авто создании порядок полей может отличаться)
Для тестирования в Postman можно использовать коллекцию Product_collection.postman_collection.json
Логирование происходит в Console и  product_info.log