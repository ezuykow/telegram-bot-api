package kz.pandev.legrambotapi.models.responses.common.get;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.chat.ChatAdministratorRights;
import lombok.Getter;
import lombok.ToString;

/**
 * Telegram bot API server response to GetMyDefaultAdministratorRights request
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class GetMyDefaultAdministratorRightsResponse extends Response {

    /**
     * Result as {@link ChatAdministratorRights}
     */
    @SerializedName("result")
    private ChatAdministratorRights chatAdministratorRights;
}