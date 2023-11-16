package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.addons.SimpleMessageSender;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.common.Dice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SendDiceTest {

    @Test
    void sendDice() throws InterruptedException {
        SendResponse response = SimpleMessageSender.sendDice(Config.bot, Config.personalChatId);
        Dice dice = response.getMessage().getDice();
        assertNotNull(dice);
        assertTrue(dice.getValue() >= 1 && dice.getValue() <= 6);
        assertEquals("🎲", dice.getEmoji());

        response = Config.bot.execute(new SendDice(Config.personalChatId).darts());
        dice = response.getMessage().getDice();
        assertNotNull(dice);
        assertTrue(dice.getValue() >= 1 && dice.getValue() <= 6);
        assertEquals("🎯", dice.getEmoji());

        response = Config.bot.execute(new SendDice(Config.personalChatId).basketball());
        dice = response.getMessage().getDice();
        assertNotNull(dice);
        assertTrue(dice.getValue() >= 1 && dice.getValue() <= 5);
        assertEquals("🏀", dice.getEmoji());

        response = Config.bot.execute(new SendDice(Config.personalChatId).football());
        dice = response.getMessage().getDice();
        assertNotNull(dice);
        assertTrue(dice.getValue() >= 1 && dice.getValue() <= 5);
        assertEquals("⚽", dice.getEmoji());

        response = Config.bot.execute(new SendDice(Config.personalChatId).slotMachine());
        dice = response.getMessage().getDice();
        assertNotNull(dice);
        assertTrue(dice.getValue() >= 1 && dice.getValue() <= 64);
        assertEquals("🎰", dice.getEmoji());

        response = Config.bot.execute(new SendDice(Config.personalChatId).bowling());
        dice = response.getMessage().getDice();
        assertNotNull(dice);
        assertTrue(dice.getValue() >= 1 && dice.getValue() <= 6);
        assertEquals("🎳", dice.getEmoji());
        Thread.sleep(1000);
    }

}