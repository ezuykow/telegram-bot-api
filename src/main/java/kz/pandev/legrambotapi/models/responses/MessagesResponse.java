package kz.pandev.legrambotapi.models.responses;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.message.Message;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Telegram bot API server response with result as List of Message
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class MessagesResponse extends Response implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * If request successful, a List of Messages that were sent is returned.
     */
    @SerializedName("result")
    private List<Message> messages;
}