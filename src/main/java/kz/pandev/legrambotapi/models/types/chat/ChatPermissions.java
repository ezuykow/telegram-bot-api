package kz.pandev.legrambotapi.models.types.chat;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * Describes actions that a non-administrator user is allowed to take in a chat.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ChatPermissions implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Optional. True, if the user is allowed to send text messages, contacts, invoices, locations and venues
     */
    @SerializedName("can_send_messages")
    @Nullable
    private Boolean canSendMessage;

    /**
     * Optional. True, if the user is allowed to send audios
     */
    @SerializedName("can_send_audios")
    @Nullable
    private Boolean canSendAudios;

    /**
     * Optional. True, if the user is allowed to send documents
     */
    @SerializedName("can_send_documents")
    @Nullable
    private Boolean canSendDocuments;

    /**
     * Optional. True, if the user is allowed to send photos
     */
    @SerializedName("can_send_photos")
    @Nullable
    private Boolean canSendPhotos;

    /**
     * Optional. True, if the user is allowed to send videos
     */
    @SerializedName("can_send_videos")
    @Nullable
    private Boolean canSendVideos;

    /**
     * Optional. True, if the user is allowed to send video notes
     */
    @SerializedName("can_send_video_notes")
    @Nullable
    private Boolean canSendVideoNotes;

    /**
     * Optional. True, if the user is allowed to send voice notes
     */
    @SerializedName("can_send_voice_notes")
    @Nullable
    private Boolean canSendVoiceNotes;

    /**
     * Optional. True, if the user is allowed to send polls
     */
    @SerializedName("can_send_polls")
    @Nullable
    private Boolean canSendPolls;

    /**
     * Optional. True, if the user is allowed to send animations, games, stickers and use inline bots
     */
    @SerializedName("can_send_other_messages")
    @Nullable
    private Boolean canSendOtherMessages;

    /**
     * Optional. True, if the user is allowed to add web page previews to their messages
     */
    @SerializedName("can_add_web_page_previews")
    @Nullable
    private Boolean canAddWebPagePreviews;

    /**
     * Optional. True, if the user is allowed to change the chat title, photo and other settings.
     * Ignored in public supergroups
     */
    @SerializedName("can_change_info")
    @Nullable
    private Boolean canChangeInfo;

    /**
     * Optional. True, if the user is allowed to invite new users to the chat
     */
    @SerializedName("can_invite_users")
    @Nullable
    private Boolean canInviteUsers;

    /**
     * Optional. True, if the user is allowed to pin messages. Ignored in public supergroups
     */
    @SerializedName("can_pin_messages")
    @Nullable
    private Boolean canPinMessages;

    /**
     * Optional. True, if the user is allowed to create forum topics.
     * If omitted defaults to the value of can_pin_messages
     */
    @SerializedName("can_manage_topics")
    @Nullable
    private Boolean canManageTopics;
}