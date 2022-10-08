package ru.netology.bonus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/data.csv")
    public void shouldCalculateForRegisteredAndUnderLimit(long expected, long amount, boolean registered) {
        BonusService service = new BonusService();
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }


}