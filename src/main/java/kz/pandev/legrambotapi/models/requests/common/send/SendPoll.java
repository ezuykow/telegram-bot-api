package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.models.requests.AbstractSendRequest;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.models.types.common.poll.Poll;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * Use this method to send a native poll. On success, the sent Message is returned.
 * @author ezuykow
 */
public class SendPoll extends AbstractSendRequest<SendPoll> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param question Poll question, 1-300 characters
     * @param options Array of answer options, 2-10 strings 1-100 characters each
     */
    public SendPoll(@NotNull Object chatId, @NotNull String question, @NotNull String... options) {
        this(chatId, question, Arrays.asList(options));
    }

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param question Poll question, 1-300 characters
     * @param options List of answer options, 2-10 strings 1-100 characters each
     */
    public SendPoll(@NotNull Object chatId, @NotNull String question, @NotNull List<String> options) {
        super(chatId);
        addParameter("question", question);
        addParameter("options", options);
    }

    //region API

    /**
     * Set parameter is_anonymous
     * @param isAnonymous True, if the poll needs to be anonymous, defaults to True
     * @return this request
     */
    public SendPoll isAnonymous(boolean isAnonymous) {
        return addParameter("is_anonymous", isAnonymous);
    }

    /**
     * Set parameter type
     * @param type Poll type, “quiz” or “regular”, defaults to “regular”
     * @see Poll.Type
     * @return this request
     */
    public SendPoll type(@NotNull Poll.Type type) {
        return addParameter("type", type.getTextVal());
    }

    /**
     * Set parameter allows_multiple_answers
     * @param allowsMultipleAnswers True, if the poll allows multiple answers, ignored for polls in quiz mode,
     *                             defaults to False
     * @return this request
     */
    public SendPoll allowsMultipleAnswers(boolean allowsMultipleAnswers) {
        return addParameter("allows_multiple_answers", allowsMultipleAnswers);
    }

    /**
     * Set parameter correct_option_id
     * @param correctOptionId 0-based identifier of the correct answer option, required for polls in quiz mode
     * @return this request
     */
    public SendPoll correctOptionId(int correctOptionId) {
        return addParameter("correct_option_id", correctOptionId);
    }

    /**
     * Set parameter explanation
     * @param explanation Text that is shown when a user chooses an incorrect answer or taps on the lamp icon
     *                   in a quiz-style poll, 0-200 characters with at most 2 line feeds after entities parsing
     * @return this request
     */
    public SendPoll explanation(@NotNull String explanation) {
        return addParameter("explanation", explanation);
    }

    /**
     * Set parameter explanation_parse_mode
     * @param parseMode Mode for parsing entities in the explanation.
     * @see ParseMode
     * @return this request
     */
    public SendPoll explanationParseMode(@NotNull ParseMode parseMode) {
        return addParameter("explanation_parse_mode", parseMode.getTextVal());
    }

    /**
     * Set parameter explanation_entities
     * @param entities List of special entities that appear in the poll explanation, which can be
     *                specified instead of parse_mode
     * @return this request
     */
    public SendPoll explanationEntities(@NotNull List<MessageEntity> entities) {
        return addParameter("explanation_entities", entities);
    }

    /**
     * Set parameter open_period
     * @param openPeriod Amount of time in seconds the poll will be active after creation,
     *                  5-600. Can't be used together with close_date.
     * @return this request
     */
    public SendPoll openPeriod(int openPeriod) {
        return addParameter("open_period", openPeriod);
    }

    /**
     * Set parameter close_date
     * @param closeDate Point in time (Unix timestamp) when the poll will be automatically closed. Must be at
     *                 least 5 and no more than 600 seconds in the future. Can't be used together with open_period.
     * @return this request
     */
    public SendPoll closeDate(long closeDate) {
        return addParameter("close_date", closeDate);
    }

    /**
     * Set parameter is_closed
     * @param isClosed Pass True if the poll needs to be immediately closed. This can be useful for poll preview.
     * @return this request
     */
    public SendPoll isClosed(boolean isClosed) {
        return addParameter("is_closed", isClosed);
    }

    //endregion
}