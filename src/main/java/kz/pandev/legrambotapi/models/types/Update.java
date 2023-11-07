package kz.pandev.legrambotapi.models.types;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.CallbackQuery;
import kz.pandev.legrambotapi.models.types.common.chat.ChatJoinRequest;
import kz.pandev.legrambotapi.models.types.common.chat.member.ChatMemberUpdated;
import kz.pandev.legrambotapi.models.types.common.message.Message;
import kz.pandev.legrambotapi.models.types.common.poll.Poll;
import kz.pandev.legrambotapi.models.types.common.poll.PollAnswer;
import kz.pandev.legrambotapi.models.types.inline.mode.ChosenInlineResult;
import kz.pandev.legrambotapi.models.types.inline.mode.InlineQuery;
import kz.pandev.legrambotapi.models.types.payments.PreCheckoutQuery;
import kz.pandev.legrambotapi.models.types.payments.shipping.ShippingQuery;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents an incoming update.
 * At most one of the optional parameters can be present in any given update.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Update implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * The update's unique identifier. Update identifiers start from a certain positive number
     * and increase sequentially. This ID becomes especially handy if you're using webhooks,
     * since it allows you to ignore repeated updates or to restore the correct update sequence,
     * should they get out of order. If there are no new updates for at least a week, then
     * identifier of the next update will be chosen randomly instead of sequentially.
     */
    @SerializedName("update_id")
    @EqualsAndHashCode.Include
    private Integer updateId;

    /**
     * Optional. New incoming message of any kind - text, photo, sticker, etc.
     */
    @SerializedName("message")
    @Nullable
    private Message message;

    /**
     * Optional. New version of a message that is known to the bot and was edited
     */
    @SerializedName("edited_message")
    @Nullable
    private Message editedMessage;

    /**
     * Optional. New incoming channel post of any kind - text, photo, sticker, etc.
     */
    @SerializedName("channel_post")
    @Nullable
    private Message channelPost;

    /**
     * Optional. New version of a channel post that is known to the bot and was edited
     */
    @SerializedName("edited_channel_post")
    @Nullable
    private Message editedChannelPost;

    /**
     * Optional. New incoming inline query
     */
    @SerializedName("inline_query")
    @Nullable
    private InlineQuery inlineQuery;

    /**
     * Optional. The result of an inline query that was chosen by a user and sent to their
     * chat partner. Please see our documentation on the feedback collecting for details on
     * how to enable these updates for your bot.
     */
    @SerializedName("chosen_inline_result")
    @Nullable
    private ChosenInlineResult chosenInlineResult;

    /**
     * Optional. New incoming callback query
     */
    @SerializedName("callback_query")
    @Nullable
    private CallbackQuery callbackQuery;

    /**
     * Optional. New incoming shipping query. Only for invoices with flexible price
     */
    @SerializedName("shipping_query")
    @Nullable
    private ShippingQuery shippingQuery;

    /**
     * Optional. New incoming pre-checkout query. Contains full information about checkout
     */
    @SerializedName("pre_checkout_query")
    @Nullable
    private PreCheckoutQuery preCheckoutQuery;

    /**
     * Optional. New poll state. Bots receive only updates about stopped polls and polls, which are sent by the bot
     */
    @SerializedName("poll")
    @Nullable
    private Poll poll;

    /**
     * Optional. A user changed their answer in a non-anonymous poll.
     * Bots receive new votes only in polls that were sent by the bot itself.
     */
    @SerializedName("poll_answer")
    @Nullable
    private PollAnswer pollAnswer;

    /**
     * Optional. The bot's chat member status was updated in a chat. For private chats,
     * this update is received only when the bot is blocked or unblocked by the user.
     */
    @SerializedName("my_chat_member")
    @Nullable
    private ChatMemberUpdated myChatMember;

    /**
     * Optional. A chat member's status was updated in a chat. The bot must be an administrator
     * in the chat and must explicitly specify "chat_member" in the list of allowed_updates to receive these updates.
     */
    @SerializedName("chat_member")
    @Nullable
    private ChatMemberUpdated chatMember;

    /**
     * Optional. A request to join the chat has been sent. The bot must have the can_invite_users
     * administrator right in the chat to receive these updates.
     */
    @SerializedName("chat_join_request")
    @Nullable
    private ChatJoinRequest chatJoinRequest;
}