# Домашнее задание к занятию «Система сборки Maven, управление зависимостями, автотесты на JUnit5»

## Решения
### Задание 1:
* <a href="https://github.com/Nephedov/5.1.Java/blob/main/pom.xml">pom.xml</a> с подключенными JUnit Jupiter и Maven Surefire Plugin.
* <a href="https://github.com/Nephedov/5.1.Java/blob/main/src/test/java/ru/netology/bonus/BonusServiceTest.java">BonusServiceTest</a> - параметризированный автотест тестом.
* <a href="https://github.com/Nephedov/5.1.Java/blob/main/src/test/resources/data.csv">data.csv</a> - тестовые данные.
### Задание 2:
* <a href="https://github.com/Nephedov/5.2.Java/issues/1">issue</a> - Скриншот лога с ошибкой.

## Что было сделано
### Задание 1
* Создан Maven проект и настроен <a href="https://github.com/Nephedov/5.1.Java/blob/main/pom.xml">pom.xml</a> c плагинами и зависимостями:
  * JunitJupiter.
  * Maven Surefire Plugin.
* Реализован параметризированный автотест в классе <a href="https://github.com/Nephedov/5.1.Java/blob/main/src/test/java/ru/netology/bonus/BonusServiceTest.java">BonusServiceTest</a>.
* Реализован <a href="https://github.com/Nephedov/5.1.Java/blob/main/src/test/resources/data.csv">data.csv</a> - с тестовыми данными.

### Задание 2
* Проведен анализ логов и устранение <a href="https://github.com/Nephedov/5.2.Java/issues/1">ошибки</a>.

# Задание 1. Дописываем тесты (обязательное к выполнению)
Нашей целью будет переделать проект с приложением про бонус с покупки на Мавен и хорошо его протестировать.

1. Создайте проект на базе Maven.

2. Добавьте в проект JUnit Jupiter & Surefire Plugin

3. Создайте сервисный класс со следующим исходным кодом:
```java
public class BonusService {
  public long calculate(long amount, boolean registered) {
    int percent = registered ? 3 : 1;
    long bonus = amount * percent / 100;
    long limit = 500;
    if (bonus > limit) {
      bonus = limit;
    }
    return bonus;
  }
}
```

4. Создайте тестовый класс со следующим исходным кодом:
```java
import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

  @org.junit.jupiter.api.Test
  void shouldCalculateForRegisteredAndUnderLimit() {
    BonusService service = new BonusService();

    // подготавливаем данные:
    long amount = 1000;
    boolean registered = true;
    long expected = 30;

    // вызываем целевой метод:
    long actual = service.calculate(amount, registered);

    // производим проверку (сравниваем ожидаемый и фактический):
    assertEquals(expected, actual);
  }

  @org.junit.jupiter.api.Test
  void shouldCalculateForRegisteredAndOverLimit() {
    BonusService service = new BonusService();

    // подготавливаем данные:
    long amount = 1_000_000;
    boolean registered = true;
    long expected = 500;

    // вызываем целевой метод:
    long actual = service.calculate(amount, registered);

    // производим проверку (сравниваем ожидаемый и фактический):
    assertEquals(expected, actual);
  }
}
```

5. Запустите тесты через `mvn clean test`, убедитесь, что они запускаются и проходят.

6. Проведите тест-дизайн сервисного класса, очень глубоко его можно не проводить, допишите недостающие тесты.

7. Убедитесь, что тесты запускаются и проходят.

# Задание 2. Читаем логи (необязательная задача повышенной сложности)

Ваша задача:
1. Взять проект, который прикреплён в архиве [`bonus-service.zip`](https://github.com/netology-code/javaqa2-homeworks/blob/main/files/bonus-service.zip?raw=true).
1. Открыть его как Maven проект в IDEA.
1. Запустить следующую команду Maven*: `mvn clean compile spotbugs:check`.
1. Проанализировать логи, выяснить в чём ошибка. Воспользуйтесь гуглом по типу ошибки и чтением документации.
1. Исправить ошибку так, чтобы повторный вызов `mvn clean compile spotbugs:check` завершался успешно, менять `pom.xml` нельзя.
