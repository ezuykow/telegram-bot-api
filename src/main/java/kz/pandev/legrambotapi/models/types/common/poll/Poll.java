package kz.pandev.legrambotapi.models.types.common.poll;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * This object contains information about a poll
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Poll implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Type of poll
     */
    @Getter
    @RequiredArgsConstructor
    public enum Type {
        @SerializedName("quiz")
        QUIZ("quiz"),
        @SerializedName("regular")
        REGULAR("regular");

        /**
         * Text value for sending to Telegram server
         */
        private final String textVal;
    }

    @SerializedName("id")
    @EqualsAndHashCode.Include
    private String id;

    /**
     * Poll question, 1-300 characters
     */
    @SerializedName("question")
    private String question;

    /**
     * List of poll options
     */
    @SerializedName("options")
    private List<PollOption> options;

    /**
     * Total number of users that voted in the poll
     */
    @SerializedName("total_voter_count")
    private Integer totalVoterCount;

    /**
     * True, if the poll is closed
     */
    @SerializedName("is_closed")
    private Boolean isClosed;

    /**
     * True, if the poll is anonymous
     */
    @SerializedName("is_anonymous")
    private Boolean isAnonymous;

    /**
     * Poll type, currently can be “regular” or “quiz”
     */
    @SerializedName("type")
    private Type type;

    /**
     * True, if the poll allows multiple answers
     */
    @SerializedName("allows_multiple_answers")
    private Boolean allowsMultipleAnswers;

    /**
     * Optional. 0-based identifier of the correct answer option. Available only for polls in the quiz mode, which
     * are closed, or was sent (not forwarded) by the bot or to the private chat with the bot.
     */
    @SerializedName("correct_option_id")
    @Nullable
    private Integer correctOptionId;

    /**
     * Optional. Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style
     * poll, 0-200 characters
     */
    @SerializedName("explanation")
    @Nullable
    private String explanation;

    /**
     * Optional. Special entities like usernames, URLs, bot commands, etc. that appear in the explanation
     */
    @SerializedName("explanation_entities")
    @Nullable
    private List<MessageEntity> explanationEntities;

    /**
     * Optional. Amount of time in seconds the poll will be active after creation
     */
    @SerializedName("open_period")
    @Nullable
    private Integer openPeriod;

    /**
     * Optional. Point in time (Unix timestamp) when the poll will be automatically closed
     */
    @SerializedName("close_date")
    @Nullable
    private Integer closeDate;
}