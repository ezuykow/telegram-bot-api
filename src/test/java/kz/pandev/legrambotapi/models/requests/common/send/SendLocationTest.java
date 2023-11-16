package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.models.types.common.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SendLocationTest {

    @Test
    void sendLocation() throws InterruptedException {
        float lat = 21.999998f, lng = 105.2f, horizontalAccuracy = 1.9f;
        int livePeriod = 60, heading = 120, proximityAlertRadius = 50000;
        Location location = Config.bot.execute(new SendLocation(Config.personalChatId, lat, lng)
                .horizontalAccuracy(horizontalAccuracy)
                .livePeriod(livePeriod)
                .heading(heading)
                .proximityAlertRadius(proximityAlertRadius)
        ).getMessage().getLocation();
        assertEquals(lat, location.getLatitude(), 0.00001f);
        assertEquals(lng, location.getLongitude(), 0.00001f);
        assertEquals(horizontalAccuracy, location.getHorizontalAccuracy(), 0.11f);
        assertEquals(livePeriod, location.getLivePeriod().intValue());
        assertEquals(heading, location.getHeading().intValue());
        assertEquals(proximityAlertRadius, location.getProximityAlertRadius().intValue());
        Thread.sleep(1000);
    }

}