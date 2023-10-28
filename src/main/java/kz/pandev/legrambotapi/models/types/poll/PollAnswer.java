package kz.pandev.legrambotapi.models.types.poll;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.user.User;
import kz.pandev.legrambotapi.models.types.chat.Chat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * This object represents an answer of a user in a non-anonymous poll
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PollAnswer implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Unique poll identifier
     */
    @SerializedName("poll_id")
    private String pollId;

    /**
     * Optional. The chat that changed the answer to the poll, if the voter is anonymous
     */
    @SerializedName("voter_chat")
    @Nullable
    private Chat voterChat;

    /**
     * Optional. The user that changed the answer to the poll, if the voter isn't anonymous
     */
    @SerializedName("user")
    @Nullable
    private User user;

    /**
     * 0-based identifiers of chosen answer options. May be empty if the vote was retracted
     */
    @SerializedName("option_ids")
    private List<Integer> optionIds;
}