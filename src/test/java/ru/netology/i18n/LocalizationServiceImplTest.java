package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {
    LocalizationService localizationService = new LocalizationServiceImpl();

    @Test
    void localeRu() {
        String excepted = "Добро пожаловать";

        Assertions.assertEquals(excepted, localizationService.locale(Country.RUSSIA));
    }

    @Test
    public void localeUsa() {
        String excepted = "Welcome";

        Assertions.assertEquals(excepted, localizationService.locale(Country.USA));
    }
}
