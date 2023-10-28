package kz.pandev.legrambotapi.models.types.chat.member;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object contains information about one member of a chat. <br>
 * Currently, the following 6 types of chat members are supported, distinguished by the
 * {@link ChatMember#status} field:
 * <li> {@link MemberStatus#creator}
 * <li> {@link MemberStatus#administrator}
 * <li> {@link MemberStatus#member}
 * <li> {@link MemberStatus#restricted}
 * <li> {@link MemberStatus#left}
 * <li> {@link MemberStatus#kicked}
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ChatMember implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Possible statuses of member's in chat
     */
    @SuppressWarnings("java:S115") /*Enum objects in lower case*/
    public enum MemberStatus{
        /**
         * Chat member that owns the chat and has all administrator privileges
         */
        creator,
        /**
         * Chat member that has some additional privileges
         */
        administrator,
        /**
         * Chat member that has no additional privileges or restrictions
         */
        member,
        /**
         * Chat member that is under certain restrictions in the chat. Supergroups only
         */
        restricted,
        /**
         * Chat member that isn't currently a member of the chat, but may join it themselves
         */
        left,
        /**
         * Chat member that was banned in the chat and can't return to the chat or view chat messages
         */
        kicked
    }

    /**
     * Information about the user
     */
    @SerializedName("user")
    @EqualsAndHashCode.Include
    private User user;

    /**
     * The member's status in the chat
     */
    @SerializedName("status")
    @EqualsAndHashCode.Include
    private MemberStatus status;

    /**
     * Optional. True, if the user's presence in the chat is hidden
     * @apiNote Not null, when status is: creator, administrator
     */
    @SerializedName("is_anonymous")
    @Nullable
    private Boolean isAnonymous;

    /**
     * Optional. True, if the user is a member of the chat at the moment of the request
     * @apiNote Not null, when status is: restricted
     */
    @SerializedName("is_member")
    @Nullable
    private Boolean isMember;

    /**
     * Date when restrictions will be lifted for this user; Unix time.
     * If 0, then the user is restricted forever
     * @apiNote Not null, when status is: restricted, kicked
     */
    @SerializedName("until_date")
    @Nullable
    private Boolean untilDate;

    /**
     * Optional. True, if the bot is allowed to edit administrator privileges of that user
     * @apiNote Not null, when status is: administrator
     */
    @SerializedName("can_be_edited")
    @Nullable
    private Boolean canBeEdited;

    /**
     * Optional. True, if the user is allowed to send text messages, contacts, invoices, locations and venues
     * @apiNote Not null, when status is: restricted
     */
    @SerializedName("can_send_messages")
    @Nullable
    private Boolean canSendMessages;

    /**
     * Optional. True, if the user is allowed to send audios
     * @apiNote Not null, when status is: restricted
     */
    @SerializedName("can_send_audios")
    @Nullable
    private Boolean canSendAudios;

    /**
     * Optional. True, if the user is allowed to send documents
     * @apiNote Not null, when status is: restricted
     */
    @SerializedName("can_send_documents")
    @Nullable
    private Boolean canSendDocuments;

    /**
     * Optional. True, if the user is allowed to send photos
     * @apiNote Not null, when status is: restricted
     */
    @SerializedName("can_send_photos")
    @Nullable
    private Boolean canSendPhotos;

    /**
     * Optional. True, if the user is allowed to send videos
     * @apiNote Not null, when status is: restricted
     */
    @SerializedName("can_send_videos")
    @Nullable
    private Boolean canSendVideos;

    /**
     * Optional. True, if the user is allowed to send video notes
     * @apiNote Not null, when status is: restricted
     */
    @SerializedName("can_send_video_notes")
    @Nullable
    private Boolean canSendVideoNotes;

    /**
     * Optional. True, if the user is allowed to send voice notes
     * @apiNote Not null, when status is: restricted
     */
    @SerializedName("can_send_voice_notes")
    @Nullable
    private Boolean canSendVoiceNotes;

    /**
     * Optional. True, if the user is allowed to send polls
     * @apiNote Not null, when status is: restricted
     */
    @SerializedName("can_send_polls")
    @Nullable
    private Boolean canSendPolls;

    /**
     * Optional. True, if the user is allowed to send animations, games, stickers and use inline bots
     * @apiNote Not null, when status is: restricted
     */
    @SerializedName("can_send_other_messages")
    @Nullable
    private Boolean canSendOtherMessages;

    /**
     * Optional. True, if the user is allowed to add web page previews to their messages
     * @apiNote Not null, when status is: restricted
     */
    @SerializedName("can_add_web_page_previews")
    @Nullable
    private Boolean canAddWebPagePreviews;

    /**
     * Optional. True, if the administrator can access the chat event log, boost list in channels,
     * see channel members, report spam messages, see anonymous administrators in supergroups
     * and ignore slow mode. Implied by any other administrator privilege
     * @apiNote Not null, when status is: administrator
     */
    @SerializedName("can_manage_chat")
    @Nullable
    private Boolean canManageChat;

    /**
     * Optional. True, if the administrator can delete messages of other users
     * @apiNote Not null, when status is: administrator
     */
    @SerializedName("can_delete_messages")
    @Nullable
    private Boolean canDeleteMessages;

    /**
     * Optional. True, if the administrator can manage video chats
     * @apiNote Not null, when status is: administrator
     */
    @SerializedName("can_manage_video_chats")
    @Nullable
    private Boolean canManageVideoChats;

    /**
     * Optional. True, if the administrator can restrict, ban or unban chat members, or access supergroup statistics
     * @apiNote Not null, when status is: administrator
     */
    @SerializedName("can_restrict_members")
    @Nullable
    private Boolean canRestrictMembers;

    /**
     * Optional. True, if the administrator can add new administrators with a subset of their own privileges or
     * demote administrators that they have promoted, directly or indirectly (promoted by administrators
     * that were appointed by the user)
     * @apiNote Not null, when status is: administrator
     */
    @SerializedName("can_promote_members")
    @Nullable
    private Boolean canPromoteMembers;

    /**
     * Optional. True, if the user is allowed to change the chat title, photo and other settings
     * @apiNote Not null, when status is: administrator, restricted
     */
    @SerializedName("can_change_info")
    @Nullable
    private Boolean canChangeInfo;

    /**
     * Optional. True, if the user is allowed to invite new users to the chat
     * @apiNote Not null, when status is: administrator, restricted
     */
    @SerializedName("can_invite_users")
    @Nullable
    private Boolean canInviteUsers;

    /**
     * Optional. True, if the administrator can post messages in the channel, or access channel
     * statistics; channels only
     */
    @SerializedName("can_post_messages")
    @Nullable
    private Boolean canPostMessages;

    /**
     * Optional. True, if the administrator can edit messages of other users and can pin messages;
     * channels only
     */
    @SerializedName("can_edit_messages")
    @Nullable
    private Boolean canEditMessages;

    /**
     * Optional. True, if the user is allowed to pin messages; groups and supergroups only
     * @apiNote Not null, when status is: restricted
     */
    @SerializedName("can_pin_messages")
    @Nullable
    private Boolean canPinMessages;

    /**
     * Optional. True, if the administrator can post stories in the channel; channels only
     */
    @SerializedName("can_post_stories")
    @Nullable
    private Boolean canPostStories;

    /**
     * Optional. True, if the administrator can edit stories posted by other users; channels only
     */
    @SerializedName("can_edit_stories")
    @Nullable
    private Boolean canEditStories;

    /**
     * Optional. True, if the administrator can delete stories posted by other users; channels only
     */
    @SerializedName("can_delete_stories")
    @Nullable
    private Boolean canDeleteStories;

    /**
     * Optional. True, if the user is allowed to create, rename, close, and reopen forum topics; supergroups only
     * @apiNote Not null, when status is: restricted
     */
    @SerializedName("can_manage_topics")
    @Nullable
    private Boolean canManageTopics;

    /**
     * Optional. Custom title for this user
     */
    @SerializedName("custom_title")
    @Nullable
    private String customTitle;
}