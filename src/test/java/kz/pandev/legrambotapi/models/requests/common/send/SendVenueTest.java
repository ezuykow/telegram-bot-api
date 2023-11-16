package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.models.types.common.Venue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SendVenueTest {

    @Test
    void sendVenue() throws InterruptedException {
        float lat = 21.999998f, lng = 105.2f;
        String title = "title", address = "addr", frsqrId = "asdfasdf", frsqrType = "frType";
        Venue venue = Config.bot.execute(new SendVenue(Config.personalChatId, lat, lng, title, address)
                .foursquareId(frsqrId).foursquareType(frsqrType)
        ).getMessage().getVenue();
        assertEquals(lat, venue.getLocation().getLatitude(), 0.01f);
        assertEquals(lng, venue.getLocation().getLongitude(), 0.01f);
        assertEquals(address, venue.getAddress());
        assertEquals(title, venue.getTitle());
        assertEquals(frsqrId, venue.getFoursquareId());
        assertEquals(frsqrType, venue.getFoursquareType());

        String ggId = "ggId", ggType = "library";
        venue = Config.bot.execute(new SendVenue(Config.personalChatId, lat, lng, title, address)
                .googlePlaceId(ggId).googlePlaceType(ggType)
        ).getMessage().getVenue();
        assertEquals(ggId, venue.getGooglePlaceId());
        assertEquals(ggType, venue.getGooglePlaceType());
        Thread.sleep(1000);
    }

}