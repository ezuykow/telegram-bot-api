package kz.pandev.legrambotapi.addons.update;

/**
 * Possible types of Update content
 * @author ezuykow
 */
public enum UpdateContentType {

    /**
     * {@code Update} contains {@code Message}
     * (New incoming message of any kind - text, photo, sticker, etc.)
     */
    MESSAGE,
    /**
     * {@code Update} contains {@code CallbackQuery} (New incoming callback query)
     */
    CALLBACK_QUERY,
    /**
     * {@code Update} contains edited {@code Message} (New version of a message that is known to the bot and was edited)
     */
    EDITED_MESSAGE,
    /**
     * {@code Update} contains {@code Message} - channel post (New incoming channel post of any kind - text,
     * photo, sticker, etc.)
     */
    CHANNEL_POST,
    /**
     * {@code Update} contains {@code Message} - edited channel post (New version of a channel post that
     * is known to the bot and was edited)
     */
    EDITED_CHANNEL_POST,
    /**
     * {@code Update} contains {@code InlineQuery} (New incoming inline query)
     */
    INLINE_QUERY,
    /**
     * {@code Update} contains {@code ChosenInlineResult} (The result of an inline query that was chosen by
     * a user and sent to their chat partner. Please see our documentation on the feedback collecting for
     * details on how to enable these updates for your bot.)
     */
    CHOSEN_INLINE_RESULT,
    /**
     * {@code Update} contains {@code ShippingQuery} (New incoming shipping query. Only for invoices
     * with flexible price)
     */
    SHIPPING_QUERY,
    /**
     * {@code Update} contains {@code PreCheckoutQuery} (New incoming pre-checkout query. Contains full information
     * about checkout)
     */
    PRE_CHECKOUT_QUERY,
    /**
     * {@code Update} contains {@code Poll} (New poll state. Bots receive only updates about stopped
     * polls and polls, which are sent by the bot)
     */
    POLL,
    /**
     * {@code Update} contains {@code PollAnswer} (A user changed their answer in a non-anonymous poll.
     * Bots receive new votes only in polls that were sent by the bot itself.)
     */
    POLL_ANSWER,
    /**
     * {@code Update} contains {@code ChatMemberUpdated} (The bot's chat member status was updated in a chat.
     * For private chats, this update is received only when the bot is blocked or unblocked by the user.)
     */
    MY_CHAT_MEMBER,
    /**
     * {@code Update} contains {@code ChatMemberUpdated} (A chat member's status was updated in a chat. The bot
     * must be an administrator in the chat and must explicitly specify "chat_member" in the list
     * of allowed_updates to receive these updates.)
     */
    CHAT_MEMBER,
    /**
     * {@code Update} contains {@code ChatMemberUpdated} (A request to join the chat has been sent. The bot must
     * have the can_invite_users administrator right in the chat to receive these updates.)
     */
    CHAT_JOIN_REQUEST

}