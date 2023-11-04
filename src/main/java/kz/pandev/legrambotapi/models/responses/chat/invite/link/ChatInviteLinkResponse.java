package kz.pandev.legrambotapi.models.responses.chat.invite.link;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.chat.ChatInviteLink;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * General Telegram bot API server response to methods, which result is ChatInviteLink object
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class ChatInviteLinkResponse extends Response implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * If request successful, the result {@link ChatInviteLink}
     */
    @SerializedName("result")
    private ChatInviteLink chatInviteLink;
}