package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

class GeoServiceImplTest {
    GeoService geoService = new GeoServiceImpl();

    @Test
    public void byIpLocalhost() {
        Location location = new Location(null, null, null, 0);
        Country exceptedCountry = location.getCountry();

        Location actualLocation = geoService.byIp(GeoServiceImpl.LOCALHOST);

        Assertions.assertEquals(exceptedCountry, actualLocation.getCountry());
    }

    @Test
    public void byIpRu() {
        String ipRu = "172.100.210.94";
        Country exceptedCountry = Country.RUSSIA;

        Location actualLocation = geoService.byIp(ipRu);

        Assertions.assertEquals(exceptedCountry, actualLocation.getCountry());
    }
}
