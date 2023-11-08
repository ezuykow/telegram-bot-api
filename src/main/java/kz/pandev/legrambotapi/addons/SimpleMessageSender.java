package kz.pandev.legrambotapi.addons;

import kz.pandev.legrambotapi.configure.TelegramBot;
import kz.pandev.legrambotapi.models.requests.common.send.*;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.Keyboard;
import kz.pandev.legrambotapi.utils.enums.ChatAction;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * Useful methods for sending simple messages
 * @author ezuykow
 */
public class SimpleMessageSender {

    protected SimpleMessageSender() {}

    //region API

    /**
     * Send message text
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @param text text to send
     * @return server response as {@link SendResponse}
     */
    public static SendResponse sendText(@NotNull TelegramBot bot, long chatId, @NotNull String text) {
        return bot.execute(
                new SendMessage(chatId, text)
        );
    }

    /**
     * Send message text with {@link Keyboard}
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @param text text to send
     * @param keyboard {@link Keyboard} to send
     * @return server response as {@link SendResponse}
     */
    public static SendResponse sendTextWithKeyboard(@NotNull TelegramBot bot, long chatId, @NotNull String text,
                                                    @NotNull Keyboard keyboard) {
        return bot.execute(
                new SendMessage(chatId, text).replyMarkup(keyboard)
        );
    }

    /**
     * Send message text, which is reply to message with {@code messageId}
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @param text text to send
     * @param messageId target message ID
     * @return server response as {@link SendResponse}
     */
    public static SendResponse sendTextReplyToMessage(@NotNull TelegramBot bot, long chatId, @NotNull String text,
                                                      int messageId) {
        return bot.execute(
                new SendMessage(chatId, text).replyToMessageId(messageId)
        );
    }

    /**
     * Send photo
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @param photo photo as byte[]
     * @return server response as {@link SendResponse}
     */
    public static SendResponse sendPhoto(@NotNull TelegramBot bot, long chatId, @NotNull byte[] photo) {
        return bot.execute(
                new SendPhoto(chatId, photo)
        );
    }

    /**
     * Send photo
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @param photo photo as {@link File}
     * @return server response as {@link SendResponse}
     */
    public static SendResponse sendPhoto(@NotNull TelegramBot bot, long chatId, @NotNull File photo) {
        return bot.execute(
                new SendPhoto(chatId, photo)
        );
    }

    /**
     * Send document
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @param doc document as {@link File}
     * @return server response as {@link SendResponse}
     */
    public static SendResponse sendDocument(@NotNull TelegramBot bot, long chatId, @NotNull File doc) {
        return bot.execute(
                new SendDocument(chatId, doc)
        );
    }

    /**
     * Send document
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @param doc document as byte[]
     * @return server response as {@link SendResponse}
     */
    public static SendResponse sendDocument(@NotNull TelegramBot bot, long chatId, @NotNull byte[] doc) {
        return bot.execute(
                new SendDocument(chatId, doc)
        );
    }

    /**
     * Send animation
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @param animation animation as byte[]
     * @return server response as {@link SendResponse}
     */
    public static SendResponse sendAnimation(@NotNull TelegramBot bot, long chatId, @NotNull byte[] animation) {
        return bot.execute(
                new SendAnimation(chatId, animation)
        );
    }

    /**
     * Send animation
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @param animation animation as {@link File}
     * @return server response as {@link SendResponse}
     */
    public static SendResponse sendAnimation(@NotNull TelegramBot bot, long chatId, @NotNull File animation) {
        return bot.execute(
                new SendAnimation(chatId, animation)
        );
    }

    /**
     * Send audio
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @param audio audio as {@link File}
     * @return server response as {@link SendResponse}
     */
    public static SendResponse sendAudio(@NotNull TelegramBot bot, long chatId, @NotNull File audio) {
        return bot.execute(
                new SendAudio(chatId, audio)
        );
    }

    /**
     * Send audio
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @param audio audio as byte[]
     * @return server response as {@link SendResponse}
     */
    public static SendResponse sendAudio(@NotNull TelegramBot bot, long chatId, @NotNull byte[] audio) {
        return bot.execute(
                new SendAudio(chatId, audio)
        );
    }

    /**
     * Send chat action
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @param chatAction chatAction as {@link ChatAction}
     * @return server response as {@link Response}
     */
    public static Response sendChatAction(@NotNull TelegramBot bot, long chatId, @NotNull ChatAction chatAction) {
        return bot.execute(
                new SendChatAction(chatId, chatAction)
        );
    }

    /**
     * Send contact
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @param phoneNumber contact's phone number
     * @param firstName contact's first name
     * @return server response as {@link SendResponse}
     */
    public static SendResponse sendContact(@NotNull TelegramBot bot, long chatId, @NotNull String phoneNumber,
                                           @NotNull String firstName) {
        return bot.execute(
                new SendContact(chatId, phoneNumber, firstName)
        );
    }

    /**
     * Send dice
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @return server response as {@link SendResponse}
     */
    public static SendResponse sendDice(@NotNull TelegramBot bot, long chatId) {
        return bot.execute(
                new SendDice(chatId)
        );
    }

    /**
     * Send location
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @param latitude location's latitude
     * @param longitude location's longitude
     * @return server response as {@link SendResponse}
     */
    public static SendResponse sendLocation(@NotNull TelegramBot bot, long chatId,
                                            float latitude, float longitude) {
        return bot.execute(
                new SendLocation(chatId, latitude, longitude)
        );
    }

    /**
     * Send poll
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @param question poll's question
     * @param options poll's options
     * @return server response as {@link SendResponse}
     */
    public static SendResponse sendPoll(@NotNull TelegramBot bot, long chatId,
                                            @NotNull String question, @NotNull String... options) {
        return bot.execute(
                new SendPoll(chatId, question, options)
        );
    }

    /**
     * Send video
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @param video video as {@link File}
     * @return server response as {@link SendResponse}
     */
    public static SendResponse sendVideo(@NotNull TelegramBot bot, long chatId, @NotNull File video) {
        return bot.execute(
                new SendVideo(chatId, video)
        );
    }

    /**
     * Send video
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @param video video as byte[]
     * @return server response as {@link SendResponse}
     */
    public static SendResponse sendVideo(@NotNull TelegramBot bot, long chatId, @NotNull byte[] video) {
        return bot.execute(
                new SendVideo(chatId, video)
        );
    }

    /**
     * Send videoNote
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @param videoNote videoNote as {@link File}
     * @return server response as {@link SendResponse}
     */
    public static SendResponse sendVideoNote(@NotNull TelegramBot bot, long chatId, @NotNull File videoNote) {
        return bot.execute(
                new SendVideoNote(chatId, videoNote)
        );
    }

    /**
     * Send videoNote
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @param videoNote videoNote as byte[]
     * @return server response as {@link SendResponse}
     */
    public static SendResponse sendVideoNote(@NotNull TelegramBot bot, long chatId, @NotNull byte[] videoNote) {
        return bot.execute(
                new SendVideoNote(chatId, videoNote)
        );
    }

    /**
     * Send voice
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @param voice voice as {@link File}
     * @return server response as {@link SendResponse}
     */
    public static SendResponse sendVoice(@NotNull TelegramBot bot, long chatId, @NotNull File voice) {
        return bot.execute(
                new SendVoice(chatId, voice)
        );
    }

    /**
     * Send voice
     * @param bot sender {@link TelegramBot}
     * @param chatId target chat ID
     * @param voice voice as byte[]
     * @return server response as {@link SendResponse}
     */
    public static SendResponse sendVoice(@NotNull TelegramBot bot, long chatId, @NotNull byte[] voice) {
        return bot.execute(
                new SendVoice(chatId, voice)
        );
    }

    //endregion
}