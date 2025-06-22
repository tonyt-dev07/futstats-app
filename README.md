# FutStats App ⚽

**FutStats App** е уеб приложение за управление и визуализация на футболна статистика – играчи, отбори, лиги, мачове и класиране. Разработено с **Spring Boot**, **Hibernate (JPA)** и **Thymeleaf**.

---

## 🔧 Технологии

- Java 21
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Thymeleaf
- Lombok
- Maven
- IntelliJ IDEA Ultimate

---

## 📁 Функционалности

- 📋 CRUD за играчи, отбори, лиги, мачове
- 📊 Генериране на класиране по лиги (league standings)
- 🔍 Търсене и филтриране на играчи по позиция, отбор или националност
- 🏟️ История на мачовете (домакнин/гост)
- 📈 Статистики на играчи (по сезони и мачове)
- REST API (в бъдещи версии)

---

## 🧱 Структура (Feature-based)

futstats-app/
├── league/
├── team/
├── player/
├── match/
├── leagueStanding/
├── common/
└── resources/

yaml
Копиране
Редактиране

---

## 🚀 Стартиране

1. Клонирай проекта:
   ```bash
   git clone https://github.com/твоят-профил/futstats-app.git
   cd futstats-app
Стартирай с:

./mvnw spring-boot:run или

Чрез IntelliJ: Run Application

Отвори в браузър:

arduino
Копиране
Редактиране
http://localhost:8080

## 🗄️ База данни

Проектът използва релационна база данни. По време на разработка препоръчително е да използваш:

- ✅ **PostgreSQL** или **MySQL**
- ✅ Инструмент за достъп: [JetBrains DataGrip](https://www.jetbrains.com/datagrip/)
- ✅ Възможност за H2 (in-memory) за тестване

Примерна конфигурация с PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/futstats_db
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

👤 Автор
Тони Тодоров

GitHub: @tonyt-dev07
