package kz.pandev.legrambotapi.models.types.common.chat;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a join request sent to a chat.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ChatJoinRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Chat to which the request was sent
     */
    @SerializedName("chat")
    private Chat chat;

    /**
     * User that sent the join request
     */
    @SerializedName("from")
    private User from;

    /**
     * Identifier of a private chat with the user who sent the join request.
     * The bot can use this identifier for 5 minutes to send messages until the join request is processed,
     * assuming no other administrator contacted the user.
     */
    @SerializedName("user_chat_id")
    private Long userChatId;

    /**
     * Date the request was sent in Unix time
     */
    @SerializedName("date")
    private Integer date;

    /**
     * Optional. Bio of the user.
     */
    @SerializedName("bio")
    @Nullable
    private String bio;

    /**
     * Optional. Chat invite link that was used by the user to send the join request
     */
    @SerializedName("invite_link")
    @Nullable
    private ChatInviteLink inviteLink;
}