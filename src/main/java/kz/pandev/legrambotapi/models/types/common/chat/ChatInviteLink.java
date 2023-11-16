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
 * Represents an invite link for a chat
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ChatInviteLink implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * The invite link. If the link was created by another chat administrator, then the second part
     * of the link will be replaced with “…”.
     */
    @SerializedName("invite_link")
    private String inviteLink;

    /**
     * Creator of the link
     */
    @SerializedName("creator")
    private User creator;

    /**
     * True, if users joining the chat via the link need to be approved by chat administrators
     */
    @SerializedName("creates_join_request")
    private boolean createsJoinRequest;

    /**
     * True, if the link is primary
     */
    @SerializedName("is_primary")
    private Boolean isPrimary;

    /**
     * True, if the link is revoked
     */
    @SerializedName("is_revoked")
    private Boolean isRevoked;

    /**
     * Optional. Invite link name
     */
    @SerializedName("name")
    @Nullable
    private String name;

    /**
     * Optional. Point in time (Unix timestamp) when the link will expire or has been expired
     */
    @SerializedName("expire_date")
    @Nullable
    private Integer expireDate;

    /**
     * Optional. The maximum number of users that can be members of the chat simultaneously after joining
     * the chat via this invite link; 1-99999
     */
    @SerializedName("member_limit")
    @Nullable
    private Integer memberLimit;

    /**
     * Optional. Number of pending join requests created using this link
     */
    @SerializedName("pending_join_request_count")
    @Nullable
    private Integer pendingJoinRequestCount;
}