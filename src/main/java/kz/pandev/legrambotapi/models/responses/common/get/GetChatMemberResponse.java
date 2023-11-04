package kz.pandev.legrambotapi.models.responses.common.get;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.chat.member.ChatMember;
import lombok.Getter;
import lombok.ToString;

/**
 * Telegram bot API server response to GetChatMember request
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class GetChatMemberResponse extends Response {

    /**
     * Result as {@link ChatMember}
     */
    @SerializedName("result")
    private ChatMember chatMember;
}