package kz.pandev.legrambotapi.models.types.common.message;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.temp.*;
import kz.pandev.legrambotapi.models.types.common.*;
import kz.pandev.legrambotapi.models.types.common.chat.Chat;
import kz.pandev.legrambotapi.models.types.common.chat.ChatShared;
import kz.pandev.legrambotapi.models.types.common.forum.*;
import kz.pandev.legrambotapi.models.types.forum.*;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardMarkup;
import kz.pandev.legrambotapi.models.types.common.poll.Poll;
import kz.pandev.legrambotapi.models.types.stickers.Sticker;
import kz.pandev.legrambotapi.models.types.common.user.User;
import kz.pandev.legrambotapi.models.types.common.user.UserShared;
import kz.pandev.legrambotapi.models.types.common.video.Video;
import kz.pandev.legrambotapi.models.types.common.video.VideoNote;
import kz.pandev.legrambotapi.models.types.common.video.chat.VideoChatEnded;
import kz.pandev.legrambotapi.models.types.common.video.chat.VideoChatParticipantsInvited;
import kz.pandev.legrambotapi.models.types.common.video.chat.VideoChatScheduled;
import kz.pandev.legrambotapi.models.types.common.video.chat.VideoChatStarted;
import kz.pandev.legrambotapi.models.types.common.web.app.WebAppData;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * This object represents a message
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Message implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Unique message identifier inside this chat
     */
    @SerializedName("message_id")
    @EqualsAndHashCode.Include
    private Integer messageId;

    /**
     * Conversation the message belongs to
     */
    @SerializedName("chat")
    @EqualsAndHashCode.Include
    private Chat chat;

    /**
     * Optional. Unique identifier of a message thread to which the message belongs; for supergroups only
     */
    @SerializedName("message_thread_id")
    @Nullable
    private Integer messageThreadId;

    /**
     * Optional. Sender of the message; empty for messages sent to channels. For backward compatibility, the field
     * contains a fake sender user in non-channel chats, if the message was sent on behalf of a chat.
     */
    @SerializedName("from")
    @Nullable
    private User from;

    /**
     *  Optional. Sender of the message, sent on behalf of a chat. For example, the channel itself for channel posts,
     *  the supergroup itself for messages from anonymous group administrators, the linked channel for messages
     *  automatically forwarded to the discussion group. For backward compatibility, the field from contains a fake
     *  sender user in non-channel chats, if the message was sent on behalf of a chat.
     */
    @SerializedName("sender_chat")
    @Nullable
    private Chat senderChat;

    /**
     * Date the message was sent in Unix time
     */
    @SerializedName("date")
    @Nullable
    private Integer date;

    /**
     * Optional. For forwarded messages, sender of the original message
     */
    @SerializedName("forward_from")
    @Nullable
    private User forwardFrom;

    /**
     * Optional. For messages forwarded from channels or from anonymous administrators, information about the original
     * sender chat
     */
    @SerializedName("forward_from_chat")
    @Nullable
    private Chat forwardFromChat;

    /**
     * Optional. For messages forwarded from channels, identifier of the original message in the channel
     */
    @SerializedName("forward_from_message_id")
    @Nullable
    private Integer forwardFromMessageId;

    /**
     * Optional. For forwarded messages that were originally sent in channels or by an anonymous chat administrator,
     * signature of the message sender if present
     */
    @SerializedName("forward_signature")
    @Nullable
    private String forwardSignature;

    /**
     * Optional. Sender's name for messages forwarded from users who disallow adding a link to their account in
     * forwarded messages
     */
    @SerializedName("forward_sender_name")
    @Nullable
    private String forwardSenderName;

    /**
     * Optional. For forwarded messages, date the original message was sent in Unix time
     */
    @SerializedName("forward_date")
    @Nullable
    private Integer forwardDate;

    /**
     * Optional. True, if the message is sent to a forum topic
     */
    @SerializedName("is_topic_message")
    @Nullable
    private Boolean isTopicMessage;

    /**
     * Optional. True, if the message is a channel post that was automatically forwarded to the connected discussion
     * group
     */
    @SerializedName("is_automatic_forward")
    @Nullable
    private Boolean isAutomaticForward;

    /**
     * Optional. For replies, the original message. Note that the Message object in this field will not contain further
     * reply_to_message fields even if it itself is a reply.
     */
    @SerializedName("reply_to_message")
    @Nullable
    private Message replyToMessage;

    /**
     * Optional. Bot through which the message was sent
     */
    @SerializedName("via_bot")
    @Nullable
    private User viaBot;

    /**
     * Optional. Date the message was last edited in Unix time
     */
    @SerializedName("edit_date")
    @Nullable
    private Integer editDate;

    /**
     * Optional. True, if the message can't be forwarded
     */
    @SerializedName("has_protected_content")
    @Nullable
    private Boolean hasProtectedContent;

    /**
     * Optional. The unique identifier of a media message group this message belongs to
     */
    @SerializedName("media_group_id")
    @Nullable
    private String mediaGroupId;

    /**
     * Optional. Signature of the post author for messages in channels, or the custom title of an anonymous group
     * administrator
     */
    @SerializedName("author_signature")
    @Nullable
    private String authorSignature;

    /**
     * Optional. For text messages, the actual UTF-8 text of the message
     */
    @SerializedName("text")
    @Nullable
    private String text;

    /**
     * Optional. For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text
     */
    @SerializedName("entities")
    @Nullable
    private List<MessageEntity> entities;

    /**
     * Optional. Message is an animation, information about the animation. For backward compatibility, when this
     * field is set, the document field will also be set
     */
    @SerializedName("animation")
    @Nullable
    private Animation animation;

    /**
     * Optional. Message is an audio file, information about the file
     */
    @SerializedName("audio")
    @Nullable
    private Audio audio;

    /**
     * Optional. Message is a general file, information about the file
     */
    @SerializedName("document")
    @Nullable
    private Document document;

    /**
     * Optional. Message is a photo, available sizes of the photo
     */
    @SerializedName("photo")
    @Nullable
    private List<PhotoSize> photo;

    /**
     * Optional. Message is a sticker, information about the sticker
     */
    @SerializedName("sticker")
    @Nullable
    private Sticker sticker;

    /**
     * Optional. Message is a forwarded story
     */
    @SerializedName("story")
    @Nullable
    private Story story;

    /**
     * Optional. Message is a video, information about the video
     */
    @SerializedName("video")
    @Nullable
    private Video video;

    /**
     * Optional. Message is a video note, information about the video message
     */
    @SerializedName("video_note")
    @Nullable
    private VideoNote videoNote;

    /**
     * Optional. Message is a voice message, information about the file
     */
    @SerializedName("voice")
    @Nullable
    private Voice voice;

    /**
     * Optional. Caption for the animation, audio, document, photo, video or voice
     */
    @SerializedName("caption")
    @Nullable
    private String caption;

    /**
     * Optional. For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear
     * in the caption
     */
    @SerializedName("caption_entities")
    @Nullable
    private List<MessageEntity> captionEntities;

    /**
     * Optional. True, if the message media is covered by a spoiler animation
     */
    @SerializedName("has_media_spoiler")
    @Nullable
    private Boolean hasMediaSpoiler;

    /**
     * Optional. Message is a shared contact, information about the contact
     */
    @SerializedName("contact")
    @Nullable
    private Contact contact;

    /**
     * Optional. Message is a dice with random value
     */
    @SerializedName("dice")
    @Nullable
    private Dice dice;

    /**
     * Optional. Message is a game, information about the game
     */
    @SerializedName("game")
    @Nullable
    private Game game;

    /**
     * Optional. Message is a native poll, information about the poll
     */
    @SerializedName("poll")
    @Nullable
    private Poll poll;

    /**
     * Optional. Message is a venue, information about the venue. For backward compatibility, when this field is set,
     * the location field will also be set
     */
    @SerializedName("venue")
    @Nullable
    private Venue venue;

    /**
     * Optional. Message is a shared location, information about the location
     */
    @SerializedName("location")
    @Nullable
    private Location location;

    /**
     * Optional. New members that were added to the group or supergroup and information about them
     * (the bot itself may be one of these members)
     */
    @SerializedName("new_chat_members")
    @Nullable
    private List<User> newChatMembers;

    /**
     * Optional. A member was removed from the group, information about them (this member may be the bot itself)
     */
    @SerializedName("left_chat_member")
    @Nullable
    private User leftChatMember;

    /**
     * Optional. A chat title was changed to this value
     */
    @SerializedName("new_chat_title")
    @Nullable
    private String newChatTitle;

    /**
     * Optional. A chat photo was change to this value
     */
    @SerializedName("new_chat_photo")
    @Nullable
    private List<PhotoSize> newChatPhoto;

    /**
     * Optional. Service message: the chat photo was deleted
     */
    @SerializedName("delete_chat_photo")
    @Nullable
    private Boolean deleteChatPhoto;

    /**
     * Optional. Service message: the group has been created
     */
    @SerializedName("group_chat_created")
    @Nullable
    private Boolean groupChatCreated;

    /**
     * Optional. Service message: the supergroup has been created. This field can't be received in a message coming
     * through updates, because bot can't be a member of a supergroup when it is created. It can only be found in
     * reply_to_message if someone replies to a very first message in a directly created supergroup
     */
    @SerializedName("supergroup_chat_created")
    @Nullable
    private Boolean supergroupChatCreated;

    /**
     * Optional. Service message: the channel has been created. This field can't be received in a message coming
     * through updates, because bot can't be a member of a channel when it is created. It can only be found in
     * reply_to_message if someone replies to a very first message in a channel.
     */
    @SerializedName("channel_chat_created")
    @Nullable
    private Boolean channelChatCreated;

    /**
     * Optional. Service message: auto-delete timer settings changed in the chat
     */
    @SerializedName("message_auto_delete_timer_changed")
    @Nullable
    private MessageAutoDeleteTimerChanged messageAutoDeleteTimerChanged;

    /**
     * Optional. The group has been migrated to a supergroup with the specified identifier
     */
    @SerializedName("migrate_to_chat_id")
    @Nullable
    private Long migrateToChatId;

    /**
     * Optional. The supergroup has been migrated from a group with the specified identifier
     */
    @SerializedName("migrate_from_chat_id")
    @Nullable
    private Long migrateFromChatId;

    /**
     * Optional. Specified message was pinned. Note that the Message object in this field will not contain further
     * reply_to_message fields even if it is itself a reply.
     */
    @SerializedName("pinned_message")
    @Nullable
    private Message pinnedMessage;

    /**
     * Optional. Message is an invoice for a payment, information about the invoice
     */
    @SerializedName("invoice")
    @Nullable
    private Invoice invoice;

    /**
     * Optional. Message is a service message about a successful payment, information about the payment
     */
    @SerializedName("successful_payment")
    @Nullable
    private SuccessfulPayment successfulPayment;

    /**
     * Optional. Service message: a user was shared with the bot
     */
    @SerializedName("user_shared")
    @Nullable
    private UserShared userShared;

    /**
     * Optional. Service message: a chat was shared with the bot
     */
    @SerializedName("chat_shared")
    @Nullable
    private ChatShared chatShared;

    /**
     * Optional. The domain name of the website on which the user has logged in
     */
    @SerializedName("connected_website")
    @Nullable
    private String connectedWebsite;

    /**
     * Optional. Service message: the user allowed the bot to write messages after adding it to the attachment or side
     * menu, launching a Web App from a link, or accepting an explicit request from a Web App sent by the
     * method requestWriteAccess
     */
    @SerializedName("write_access_allowed")
    @Nullable
    private WriteAccessAllowed writeAccessAllowed;

    /**
     * Optional. Telegram Passport data
     */
    @SerializedName("passport_data")
    @Nullable
    private PassportData passportData;

    /**
     * Optional. Service message. A user in the chat triggered another user's proximity alert while
     * sharing Live Location.
     */
    @SerializedName("proximity_alert_triggered")
    @Nullable
    private ProximityAlertTriggered proximityAlertTriggered;

    /**
     * Optional. Service message: forum topic created
     */
    @SerializedName("forum_topic_created")
    @Nullable
    private ForumTopicCreated forumTopicCreated;

    /**
     * Optional. Service message: forum topic edited
     */
    @SerializedName("forum_topic_edited")
    @Nullable
    private ForumTopicEdited forumTopicEdited;

    /**
     * Optional. Service message: forum topic closed
     */
    @SerializedName("forum_topic_closed")
    @Nullable
    private ForumTopicClosed forumTopicClosed;

    /**
     * Optional. Service message: forum topic reopened
     */
    @SerializedName("forum_topic_reopened")
    @Nullable
    private ForumTopicReopened forumTopicReopened;

    /**
     * Optional. Service message: the 'General' forum topic hidden
     */
    @SerializedName("general_forum_topic_hidden")
    @Nullable
    private GeneralForumTopicHidden generalForumTopicHidden;

    /**
     * Optional. Service message: the 'General' forum topic unhidden
     */
    @SerializedName("general_forum_topic_unhidden")
    @Nullable
    private GeneralForumTopicUnhidden generalForumTopicUnhidden;

    /**
     * Optional. Service message: video chat scheduled
     */
    @SerializedName("video_chat_scheduled")
    @Nullable
    private VideoChatScheduled videoChatScheduled;

    /**
     * Optional. Service message: video chat started
     */
    @SerializedName("video_chat_started")
    @Nullable
    private VideoChatStarted videoChatStarted;

    /**
     * Optional. Service message: video chat ended
     */
    @SerializedName("video_chat_ended")
    @Nullable
    private VideoChatEnded videoChatEnded;

    /**
     * Optional. Service message: new participants invited to a video chat
     */
    @SerializedName("video_chat_participants_invited")
    @Nullable
    private VideoChatParticipantsInvited videoChatParticipantsInvited;

    /**
     * Optional. Service message: data sent by a Web App
     */
    @SerializedName("web_app_data")
    @Nullable
    private WebAppData webAppData;

    /**
     * Optional. Inline keyboard attached to the message. login_url buttons are represented as ordinary url buttons
     */
    @SerializedName("reply_markup")
    @Nullable
    private InlineKeyboardMarkup replyMarkup;
}