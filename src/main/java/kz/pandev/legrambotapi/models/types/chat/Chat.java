package kz.pandev.legrambotapi.models.types.chat;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.message.Message;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * This object represents a chat
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Chat implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Unique identifier for this chat
     */
    @SerializedName("id")
    @EqualsAndHashCode.Include
    private Long id;

    /**
     * Type of chat, can be either “private”, “group”, “supergroup” or “channel”
     */
    @SerializedName("type")
    private String type;

    /**
     * Optional. Title, for supergroups, channels and group chats
     */
    @SerializedName("title")
    @Nullable
    private String title;

    /**
     * Optional. Username, for private chats, supergroups and channels if available
     */
    @SerializedName("username")
    @Nullable
    private String username;

    /**
     * Optional. First name of the other party in a private chat
     */
    @SerializedName("first_name")
    @Nullable
    private String firstName;

    /**
     * Optional. Last name of the other party in a private chat
     */
    @SerializedName("last_name")
    @Nullable
    private String lastName;

    /**
     * Optional. True, if the supergroup chat is a forum (has topics enabled)
     */
    @SerializedName("is_forum")
    @Nullable
    private Boolean isForum;

    /**
     * Optional. Chat photo. Returned only in getChat.
     */
    @SerializedName("photo")
    @Nullable
    private ChatPhoto photo;

    /**
     * Optional. If non-empty, the list of all active chat usernames; for private chats, supergroups and channels.
     * Returned only in getChat.
     */
    @SerializedName("active_usernames")
    @Nullable
    private List<String> activeUsernames;

    /**
     * Optional. Custom emoji identifier of emoji status of the other party in a private chat. Returned only in getChat.
     */
    @SerializedName("emoji_status_custom_emoji_id")
    @Nullable
    private String emojiStatusCustomEmojiId;

    /**
     * Optional. Expiration date of the emoji status of the other party in a private chat in Unix time, if any.
     * Returned only in getChat.
     */
    @SerializedName("emoji_status_expiration_date")
    @Nullable
    private Integer emojiStatusExpirationDate;

    /**
     * Optional. Bio of the other party in a private chat. Returned only in getChat.
     */
    @SerializedName("bio")
    @Nullable
    private String bio;

    /**
     * Optional. True, if privacy settings of the other party in the private chat allows to use
     * tg://user?id=&lt;user_id&gt; links only in chats with the user. Returned only in getChat.
     */
    @SerializedName("has_private_forwards")
    @Nullable
    private Boolean hasPrivateForwards;

    /**
     * Optional. True, if the privacy settings of the other party restrict sending voice and video note messages
     * in the private chat. Returned only in getChat.
     */
    @SerializedName("has_restricted_voice_and_video_messages")
    @Nullable
    private Boolean hasRestrictedVoiceAndVideoMessages;

    /**
     * Optional. True, if users need to join the supergroup before they can send messages. Returned only in getChat.
     */
    @SerializedName("join_to_send_messages")
    @Nullable
    private Boolean joinToSendMessages;

    /**
     * Optional. True, if all users directly joining the supergroup need to be approved by supergroup administrators.
     * Returned only in getChat.
     */
    @SerializedName("join_by_request")
    @Nullable
    private Boolean joinByRequest;

    /**
     * Optional. Description, for groups, supergroups and channel chats. Returned only in getChat.
     */
    @SerializedName("description")
    @Nullable
    private String description;

    /**
     * Optional. Primary invite link, for groups, supergroups and channel chats. Returned only in getChat.
     */
    @SerializedName("invite_link")
    @Nullable
    private String inviteLink;

    /**
     * Optional. The most recent pinned message (by sending date). Returned only in getChat.
     */
    @SerializedName("pinned_message")
    @Nullable
    private Message pinnedMessage;

    /**
     * Optional. Default chat member permissions, for groups and supergroups. Returned only in getChat.
     */
    @SerializedName("permissions")
    @Nullable
    private ChatPermissions permissions;

    /**
     * Optional. For supergroups, the minimum allowed delay between consecutive messages sent by each unprivileged
     * user in seconds. Returned only in getChat.
     */
    @SerializedName("slow_mode_delay")
    @Nullable
    private Integer slowModeDelay;

    /**
     * Optional. The time after which all messages sent to the chat will be automatically deleted in seconds.
     * Returned only in getChat.
     */
    @SerializedName("message_auto_delete_time")
    @Nullable
    private Integer messageAutoDeleteTime;

    /**
     * Optional. True, if aggressive anti-spam checks are enabled in the supergroup. The field is only available
     * to chat administrators. Returned only in getChat.
     */
    @SerializedName("has_aggressive_anti_spam_enabled")
    @Nullable
    private Boolean hasAggressiveAntiSpamEnabled;

    /**
     * Optional. True, if non-administrators can only get the list of bots and administrators in the chat.
     * Returned only in getChat.
     */
    @SerializedName("has_hidden_members")
    @Nullable
    private Boolean hasHiddenMembers;

    /**
     * Optional. True, if messages from the chat can't be forwarded to other chats. Returned only in getChat.
     */
    @SerializedName("has_protected_content")
    @Nullable
    private Boolean hasProtectedContent;

    /**
     * Optional. For supergroups, name of group sticker set. Returned only in getChat.
     */
    @SerializedName("sticker_set_name")
    @Nullable
    private String stickerSetName;

    /**
     * Optional. True, if the bot can change the group sticker set. Returned only in getChat.
     */
    @SerializedName("can_set_sticker_set")
    @Nullable
    private Boolean canSetStickerSet;

    /**
     * Optional. Unique identifier for the linked chat, i.e. the discussion group identifier for a channel and vice
     * versa; for supergroups and channel chats. Returned only in getChat.
     */
    @SerializedName("linked_chat_id")
    @Nullable
    private Long linkedChatId;

    /**
     * Optional. For supergroups, the location to which the supergroup is connected. Returned only in getChat.
     */
    @SerializedName("location")
    @Nullable
    private ChatLocation location;
}