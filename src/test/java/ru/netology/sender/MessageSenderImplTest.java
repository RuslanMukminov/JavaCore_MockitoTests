package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

class MessageSenderImplTest {
    GeoService geoService = Mockito.mock(GeoServiceImpl.class);
    LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
    MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
    Map<String, String> headers = new HashMap<String, String>();

    @Test
    public void testRuTextSend() {
        final String expectedText = "Добро пожаловать";

        Mockito.when(geoService.byIp(GeoServiceImpl.MOSCOW_IP))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, GeoServiceImpl.MOSCOW_IP);

        Assertions.assertEquals(expectedText, messageSender.send(headers));
    }

    @Test
    public void testUsaTextSend() {
        final String expectedText = "Welcome";

        Mockito.when(geoService.byIp(GeoServiceImpl.NEW_YORK_IP))
                .thenReturn(new Location("New York", Country.USA, null, 0));
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, GeoServiceImpl.NEW_YORK_IP);

        Assertions.assertEquals(expectedText, messageSender.send(headers));
    }
}
