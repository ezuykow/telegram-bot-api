package kz.pandev.legrambotapi.models.responses.common.get;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import lombok.Getter;
import lombok.ToString;

/**
 * Telegram bot API server response to GetChatMemberCount request
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class GetChatMemberCountResponse extends Response {

    /**
     * Result as int
     */
    @SerializedName("result")
    private int count;
}