package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.models.types.common.Contact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SendContactTest {

    @Test
    void sendContact() throws InterruptedException {
        String phone = "000111", name = "first", lastName = "last", vcard = "ok vcard";
        Contact contact = Config.bot.execute(new SendContact(Config.personalChatId, phone, name)
                .lastName(lastName).vCard(vcard)
        ).getMessage().getContact();
        assertEquals(phone, contact.getPhoneNumber());
        assertEquals(name, contact.getFirstName());
        assertEquals(lastName, contact.getLastName());
        assertEquals(vcard, contact.getVCard());
        assertNull(contact.getUserId());
        Thread.sleep(1000);
    }

}