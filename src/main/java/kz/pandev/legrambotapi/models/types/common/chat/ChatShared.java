package kz.pandev.legrambotapi.models.types.common.chat;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object contains information about the chat whose identifier was shared
 * with the bot using a KeyboardButtonRequestChat button
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ChatShared implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Identifier of the request
     */
    @SerializedName("request_id")
    private Integer requestId;

    /**
     * Identifier of the shared chat
     */
    @SerializedName("chat_id")
    private Long chatId;
}