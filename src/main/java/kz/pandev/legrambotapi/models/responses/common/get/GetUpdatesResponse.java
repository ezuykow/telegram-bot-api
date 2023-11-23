package kz.pandev.legrambotapi.models.responses.common.get;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.addons.update.ExtendedUpdate;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.Update;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * Telegram bot API server response to GetUpdates request
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class GetUpdatesResponse extends Response {

    /**
     * Result as {@link List} of {@link Update}'s
     */
    @SerializedName("result")
    private List<ExtendedUpdate> updates;
}