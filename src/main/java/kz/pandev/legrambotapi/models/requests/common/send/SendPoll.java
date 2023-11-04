package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.models.requests.AbstractSendRequest;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.models.types.common.poll.Poll;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

/**
 * Use this method to send a native poll. On success, the sent Message is returned.
 * @author ezuykow
 */
@Getter
public class SendPoll extends AbstractSendRequest<SendPoll> {

    /**
     * Optional. True, if the poll needs to be anonymous, defaults to True
     */
    @Nullable
    private Boolean isAnonymous;
    /**
     * Optional. Poll type, “quiz” or “regular”, defaults to “regular”
     * @see Poll.Type
     */
    @Nullable
    private Poll.Type type;
    /**
     * Optional. True, if the poll allows multiple answers, ignored for polls in quiz mode, defaults to False
     */
    @Nullable
    private Boolean allowsMultipleAnswers;
    /**
     * Optional. 0-based identifier of the correct answer option, required for polls in quiz mode
     */
    @Nullable
    private Integer correctOptionId;
    /**
     * Optional. Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style
     * poll, 0-200 characters with at most 2 line feeds after entities parsing
     */
    @Nullable
    private String explanation;
    /**
     * Optional. Mode for parsing entities in the explanation.
     */
    @Nullable
    private ParseMode explanationParseMode;
    /**
     * Optional. List of special entities that appear in the poll explanation, which can be specified instead of parse_mode
     */
    @Nullable
    private List<MessageEntity> explanationEntities;
    /**
     * Optional. Amount of time in seconds the poll will be active after creation, 5-600. Can't be used
     * together with close_date.
     */
    @Nullable
    private Integer openPeriod;
    /**
     * Optional. Point in time (Unix timestamp) when the poll will be automatically closed. Must be at least 5 and
     * no more than 600 seconds in the future. Can't be used together with open_period.
     */
    @Nullable
    private Long closeDate;
    /**
     * Optional. Pass True if the poll needs to be immediately closed. This can be useful for poll preview.
     */
    @Nullable
    private Boolean isClosed;

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param question Poll question, 1-300 characters
     * @param options List of answer options, 2-10 strings 1-100 characters each
     */
    public SendPoll(Object chatId, String question, String... options) {
        super(chatId);
        addParameter("question", question);
        addParameter("options", options);
    }

    //region API

    /**
     * Set parameter {@link SendPoll#isAnonymous}
     * @param isAnonymous new parameter value
     * @return this request
     */
    public SendPoll isAnonymous(boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
        return addParameter("is_anonymous", isAnonymous);
    }

    /**
     * Set parameter {@link SendPoll#type}
     * @param type new parameter value
     * @return this request
     */
    public SendPoll type(Poll.Type type) {
        this.type = type;
        return addParameter("type", type.getTextVal());
    }

    /**
     * Set parameter {@link SendPoll#allowsMultipleAnswers}
     * @param allowsMultipleAnswers new parameter value
     * @return this request
     */
    public SendPoll allowsMultipleAnswers(boolean allowsMultipleAnswers) {
        this.allowsMultipleAnswers = allowsMultipleAnswers;
        return addParameter("allows_multiple_answers", allowsMultipleAnswers);
    }

    /**
     * Set parameter {@link SendPoll#correctOptionId}
     * @param correctOptionId new parameter value
     * @return this request
     */
    public SendPoll correctOptionId(int correctOptionId) {
        this.correctOptionId = correctOptionId;
        return addParameter("correct_option_id", correctOptionId);
    }

    /**
     * Set parameter {@link SendPoll#explanation}
     * @param explanation new parameter value
     * @return this request
     */
    public SendPoll explanation(String explanation) {
        this.explanation = explanation;
        return addParameter("explanation", explanation);
    }

    /**
     * Set parameter {@link SendPoll#explanationParseMode}
     * @param parseMode new parameter value
     * @return this request
     */
    public SendPoll explanationParseMode(ParseMode parseMode) {
        this.explanationParseMode = parseMode;
        return addParameter("explanation_parse_mode", parseMode.getTextVal());
    }

    /**
     * Set parameter {@link SendPoll#explanationEntities}
     * @param entities new parameter value
     * @return this request
     */
    public SendPoll explanationEntities(List<MessageEntity> entities) {
        this.explanationEntities = entities;
        return addParameter("explanation_entities", entities);
    }

    /**
     * Set parameter {@link SendPoll#openPeriod}
     * @param openPeriod new parameter value
     * @return this request
     */
    public SendPoll openPeriod(int openPeriod) {
        this.openPeriod = openPeriod;
        return addParameter("open_period", openPeriod);
    }

    /**
     * Set parameter {@link SendPoll#closeDate}
     * @param closeDate new parameter value
     * @return this request
     */
    public SendPoll closeDate(long closeDate) {
        this.closeDate = closeDate;
        return addParameter("close_date", closeDate);
    }

    /**
     * Set parameter {@link SendPoll#isClosed}
     * @param isClosed new parameter value
     * @return this request
     */
    public SendPoll isClosed(boolean isClosed) {
        this.isClosed = isClosed;
        return addParameter("is_closed", isClosed);
    }

    //endregion
}