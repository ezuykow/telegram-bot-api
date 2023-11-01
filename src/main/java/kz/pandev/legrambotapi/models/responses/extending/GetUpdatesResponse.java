package kz.pandev.legrambotapi.models.responses.extending;

import com.google.gson.annotations.SerializedName;
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
@ToString
public class GetUpdatesResponse extends Response {

    /**
     * Result as {@link List} of {@link Update}'s
     */
    @SerializedName("result")
    private List<Update> updates;
}