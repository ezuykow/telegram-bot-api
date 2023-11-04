package kz.pandev.legrambotapi.models.responses;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.message.Message;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * General Telegram bot API server response to Send*** methods
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class SendResponse extends Response implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * If request successful, the sent Message
     */
    @SerializedName("result")
    private Message message;
}