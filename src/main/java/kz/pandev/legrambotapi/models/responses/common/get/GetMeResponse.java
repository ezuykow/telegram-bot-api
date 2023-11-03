package kz.pandev.legrambotapi.models.responses.common.get;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.user.User;
import lombok.Getter;
import lombok.ToString;

/**
 * Telegram bot API server response to GetMe request
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class GetMeResponse extends Response {

    /**
     * Result as {@link User}
     */
    @SerializedName("result")
    private User user;
}