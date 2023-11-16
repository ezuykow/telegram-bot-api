package kz.pandev.legrambotapi.additional.test.classes;

import kz.pandev.legrambotapi.models.types.games.GameHighScore;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ezuykow
 */
public class GameHighScoreTest {

    public static void check(List<GameHighScore> scores) {
        for (int i = 0; i < scores.size(); i++) {
            GameHighScore score = scores.get(i);
            Integer expectedPos = i + 1;
            assertEquals(expectedPos, score.getPosition());
            assertNotNull(score.getScore());
            UserTest.checkUser(score.getUser());
        }
    }
}