package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.common.StopPoll;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.responses.common.PollResponse;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardMarkup;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons.CallbackDataButton;
import kz.pandev.legrambotapi.models.types.common.keyboard.button.KeyboardButton;
import kz.pandev.legrambotapi.models.types.common.keyboard.button.KeyboardButtonPollType;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.models.types.common.poll.Poll;
import kz.pandev.legrambotapi.models.types.common.poll.PollOption;
import kz.pandev.legrambotapi.models.types.common.reply.keyboard.ReplyKeyboardMarkup;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SendPollTest {

    @Test
    void sendPoll() throws InterruptedException {
        String question = "Question ?";
        String[] answers = {"Answer 1", "Answer 2"};
        SendResponse sendResponse = Config.bot.execute(
                new SendPoll(Config.testGroupId, question, answers)
                        .isAnonymous(false)
                        .type(Poll.Type.QUIZ)
                        .allowsMultipleAnswers(false)
                        .correctOptionId(1)
                        .isClosed(false)
                        .explanation("Some __explanation__ of poll")
                        .explanationParseMode(ParseMode.MARKDOWN_V2)
                        .openPeriod(500)
        );
        Poll poll = sendResponse.getMessage().getPoll();
        assertFalse(poll.getId().isEmpty());
        assertEquals(question, poll.getQuestion());
        assertEquals(answers.length, poll.getOptions().size());
        for (int i = 0; i < answers.length; i++) {
            PollOption option = poll.getOptions().get(i);
            assertEquals(answers[i], option.getText());
            assertEquals(0, option.getVoterCount());
        }
        assertFalse(poll.getIsAnonymous());
        assertEquals(Poll.Type.QUIZ, poll.getType());
        assertFalse(poll.getAllowsMultipleAnswers());
        assertEquals(0, poll.getTotalVoterCount());
        assertEquals(1, poll.getCorrectOptionId());
        assertFalse(poll.getIsClosed());
        assertEquals("Some explanation of poll", poll.getExplanation());
        assertEquals(1, poll.getExplanationEntities().size());
        assertEquals(MessageEntity.Type.UNDERLINE, poll.getExplanationEntities().get(0).getType());
        assertTrue(poll.getOpenPeriod() >= 495 && poll.getOpenPeriod() <= 500);

        sendResponse = Config.bot.execute(
                new SendPoll(Config.testGroupId, question, answers)
                        .isAnonymous(false)
                        .type(Poll.Type.QUIZ)
                        .allowsMultipleAnswers(false)
                        .correctOptionId(1)
                        .isClosed(false)
                        .explanation("Some explanation of poll")
                        .explanationEntities(List.of(new MessageEntity(MessageEntity.Type.UNDERLINE, 5, 11)))
                        .closeDate(ZonedDateTime.of(LocalDateTime.now().plusSeconds(10), ZoneId.systemDefault()).toEpochSecond() * 1000)
        );
        assertTrue(sendResponse.isOk());

        Thread.sleep(1000);
    }

    @Test
    void sendPollWithKeyboard() throws InterruptedException {
        String question = "Question ?";
        String[] answers = {"Answer 1", "Answer 2"};
        long closeDate = System.currentTimeMillis() / 1000 + 500;
        SendResponse sendResponse = Config.bot.execute(
                new SendPoll(Config.personalChatId, question, answers)
                        .type(Poll.Type.REGULAR)
                        .allowsMultipleAnswers(true)
                        .replyMarkup(new ReplyKeyboardMarkup(
                                new KeyboardButton("all polls").requestPoll(new KeyboardButtonPollType()),
                                new KeyboardButton("quiz").requestPoll(new KeyboardButtonPollType(Poll.Type.QUIZ)),
                                new KeyboardButton("regular").requestPoll(new KeyboardButtonPollType(Poll.Type.REGULAR))))
                        .closeDate(closeDate)
        );
        Poll poll = sendResponse.getMessage().getPoll();
        assertEquals(question, poll.getQuestion());
        assertEquals(answers.length, poll.getOptions().size());
        assertTrue(poll.getIsAnonymous());
        assertEquals(poll.getTotalVoterCount(), 0);
        assertEquals(poll.getType(), Poll.Type.REGULAR);
        assertTrue(poll.getAllowsMultipleAnswers());
        assertEquals(closeDate, poll.getCloseDate().longValue());
        Thread.sleep(1000);
    }

    @Test
    void stopPoll() throws InterruptedException {
        String question = "Question ?";
        String[] answers = {"Answer 1", "Answer 2"};
        SendResponse sendResponse = Config.bot.execute(new SendPoll(Config.testGroupId, question, answers)
                .messageThreadId(0));
        Integer messageId = sendResponse.getMessage().getMessageId();

        PollResponse response = Config.bot.execute(new StopPoll(Config.testGroupId, messageId)
                .replyMarkup(new InlineKeyboardMarkup(new CallbackDataButton("text", "data"))));
        Poll poll = response.getPoll();
        assertTrue(poll.getIsClosed());
        assertEquals(question, poll.getQuestion());
        assertEquals(answers.length, poll.getOptions().size());
        for (int i = 0; i < answers.length; i++) {
            PollOption option = poll.getOptions().get(i);
            assertEquals(answers[i], option.getText());
            assertEquals(0, option.getVoterCount());
        }

        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new StopPoll(Config.testImage, messageId)));

        Thread.sleep(1000);
    }

}