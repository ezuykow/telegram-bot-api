package kz.pandev.legrambotapi.models.responses.common.get;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.menu.MenuButton;
import lombok.Getter;
import lombok.ToString;

/**
 * Telegram bot API server response to GetChatMenuButton request
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class GetChatMenuButtonResponse extends Response {

    /**
     * Result as {@link MenuButton}
     */
    @SerializedName("result")
    private MenuButton menuButton;
}