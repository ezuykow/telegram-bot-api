package kz.pandev.legrambotapi.models.responses.common.get;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.File;
import lombok.Getter;
import lombok.ToString;

/**
 * Telegram bot API server response to GetFile request
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class GetFileResponse extends Response {

    /**
     * Result as {@link File}
     */
    @SerializedName("result")
    private File file;
}