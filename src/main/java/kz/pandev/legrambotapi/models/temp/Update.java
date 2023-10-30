package kz.pandev.legrambotapi.models.temp;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.message.Message;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author ezuykow
 */
@Getter
public class Update implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("update_id")
    private Integer updateId;

    @SerializedName("message")
    private Message message;
}