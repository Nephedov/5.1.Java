# Домашнее задание к занятию «Система сборки Maven, управление зависимостями, автотесты на JUnit5»

## Решения
### Задание 1:
  * <a href="https://github.com/Nephedov/5.1.Java/blob/9238dc324bb0a0708c1eb1d2d5ea1bf045b6f95d/pom.xml">pom.xml</a> с подключенными JUnit Jupiter и Surefire Plugin.
  * <a href="https://github.com/Nephedov/5.1.Java/blob/9238dc324bb0a0708c1eb1d2d5ea1bf045b6f95d/src/test/java/ru/netology/bonus/BonusServiceTest.java">BonusServiceTest</a> - тестовый класс с параметризированным тестом.
### Задание 2:
  * Обнаруженная и исправленная ошибка отраженная на скриншоте в <a href="https://github.com/Nephedov/5.2.Java/issues/1">issue</a>.

## Что было сделано
  * Создан и настроен Maven проект.
  * Подключены плагины JUnit Jupiter и Surefire Plugin в pom.xml.
  * Дописаны тестовые сценарии.
  * Проведен анализ логов и устранение ошибки.

# Задание 1. Дописываем тесты (обязательное к выполнению)
Нашей целью будет переделать проект с приложением про бонус с покупки на Мавен и хорошо его протестировать.

**Шаг 1.** Создайте проект на базе Maven.

**Шаг 2.** Добавьте в проект JUnit Jupiter & Surefire Plugin

**Шаг 3.** Создайте сервисный класс со следующим исходным кодом:
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

**Шаг 4.** Создайте тестовый класс со следующим исходным кодом:
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

**Шаг 5.** Запустите тесты через `mvn clean test`, убедитесь, что они запускаются и проходят.

**Шаг 6.** Проведите тест-дизайн сервисного класса, очень глубоко его можно не проводить, допишите недостающие тесты.

**Шаг 7.** Убедитесь, что тесты запускаются и проходят.

# Задание 2. Читаем логи (необязательная задача повышенной сложности)

Ваш коллега — очень любознательный товарищ. Узнав про то, что Maven может использовать плагины, он сразу начал искать, какие плагины есть.

И нашёл один, с его точки зрения, достаточно замечательный плагин, который ищет ошибки в коде.

Представляете? Сам ищет ошибки в коде!

Естественно, он не преминул этим воспользоваться, загуглил, как подключить этот плагин и даже смог его запустить на одном из наших проектов.

Но поскольку он не совсем разобрался, как работать с логами, он не совсем понимает, что и где не так и куда смотреть.

Поэтому он обратился к вам.

Ваша задача:
1. Взять проект, который прикреплён в архиве [`bonus-service.zip`](https://github.com/netology-code/javaqa2-homeworks/blob/main/files/bonus-service.zip?raw=true).
1. Открыть его как Maven проект в IDEA.
1. Запустить следующую команду Maven*: `mvn clean compile spotbugs:check`. Ваш коллега не может объяснить, что это значит, но говорит, что запускать нужно именно так.
1. Проанализировать логи, выяснить в чём ошибка. Воспользуйтесь гуглом по типу ошибки и чтением документации.
1. Исправить ошибку так, чтобы повторный вызов `mvn clean compile spotbugs:check` завершался успешно, менять `pom.xml` нельзя.
