package kz.pandev.legrambotapi.models.responses.common.get;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.chat.member.ChatMember;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * Telegram bot API server response to GetChatAdministrators request
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class GetChatAdministratorsResponse extends Response {

    /**
     * Result as {@link List} of {@link ChatMember}
     */
    @SerializedName("result")
    private List<ChatMember> administrators;
}