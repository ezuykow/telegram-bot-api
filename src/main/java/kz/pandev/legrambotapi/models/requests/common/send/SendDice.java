package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.models.requests.AbstractSendRequest;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to send an animated emoji that will display a random value. On success, the sent Message is returned.
 * @author ezuykow
 */
@Getter
public class SendDice extends AbstractSendRequest<SendDice> {

    /**
     * Optional. Emoji on which the dice throw animation is based.
     * Currently, must be one of “🎲”, “🎯”, “🏀”, “⚽”, “🎳”, or “🎰”.
     * Dice can have values 1-6 for “🎲”, “🎯” and “🎳”, values 1-5 for “🏀” and “⚽”,
     * and values 1-64 for “🎰”. Defaults to “🎲”
     */
    @Nullable
    private String emoji;

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     */
    public SendDice(Object chatId) {
        super(chatId);
    }

    //region API

    /**
     * Set parameter {@link SendDice#emoji}
     * @param emoji new parameter value
     * @return this request
     */
    public SendDice emoji(String emoji) {
        return addParameter("emoji", emoji);
    }

    /**
     * Set parameter {@link SendDice#emoji} to darts
     * @return this request
     */
    public SendDice darts() {
        return emoji("🎯");
    }

    /**
     * Set parameter {@link SendDice#emoji} to basketball
     * @return this request
     */
    public SendDice basketball() {
        return emoji("🏀");
    }

    /**
     * Set parameter {@link SendDice#emoji} to football
     * @return this request
     */
    public SendDice football() {
        return emoji("⚽");
    }

    /**
     * Set parameter {@link SendDice#emoji} to slotMachine
     * @return this request
     */
    public SendDice slotMachine() {
        return emoji("🎰");
    }

    /**
     * Set parameter {@link SendDice#emoji} to bowling
     * @return this request
     */
    public SendDice bowling() {
        return emoji("🎳");
    }

    //endregion
}