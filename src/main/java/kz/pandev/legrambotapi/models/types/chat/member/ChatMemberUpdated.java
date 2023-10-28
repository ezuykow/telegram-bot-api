package kz.pandev.legrambotapi.models.types.chat.member;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.chat.Chat;
import kz.pandev.legrambotapi.models.types.chat.ChatInviteLink;
import kz.pandev.legrambotapi.models.types.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents changes in the status of a chat member.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ChatMemberUpdated implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Chat the user belongs to
     */
    @SerializedName("chat")
    private Chat chat;

    /**
     * Performer of the action, which resulted in the change
     */
    @SerializedName("from")
    private User from;

    /**
     * Date the change was done in Unix time
     */
    @SerializedName("date")
    private Integer date;

    /**
     * Previous information about the chat member
     */
    @SerializedName("old_chat_member")
    private ChatMember oldChatMember;

    /**
     * New information about the chat member
     */
    @SerializedName("new_chat_member")
    private ChatMember newChatMember;

    /**
     * Optional. Chat invite link, which was used by the user to join the chat;
     * for joining by invite link events only.
     */
    @SerializedName("invite_link")
    @Nullable
    private ChatInviteLink inviteLink;

    /**
     * Optional. True, if the user joined the chat via a chat folder invite link
     */
    @SerializedName("via_chat_folder_invite_link")
    @Nullable
    private Boolean viaChatFolderInviteLink;
}