package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.models.requests.AbstractSendRequest;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to send an animated emoji that will display a random value. On success, the sent Message is returned.
 * @author ezuykow
 */
public class SendDice extends AbstractSendRequest<SendDice> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     */
    public SendDice(@NotNull Object chatId) {
        super(chatId);
    }

    //region API

    /**
     * Set parameter emoji
     * @param emoji Emoji on which the dice throw animation is based. Currently, must be one of
     *             “🎲”, “🎯”, “🏀”, “⚽”, “🎳”, or “🎰”. Dice can have values 1-6 for
     *             “🎲”, “🎯” and “🎳”, values 1-5 for “🏀” and “⚽”, and values 1-64
     *             for “🎰”. Defaults to “🎲”
     * @return this request
     */
    public SendDice emoji(@NotNull String emoji) {
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