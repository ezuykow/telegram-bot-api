package kz.pandev.legrambotapi.additional.test.classes;

import kz.pandev.legrambotapi.models.types.games.Game;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ezuykow
 */
public class GameTest {

    public static void check(Game game) {
        assertNotNull(game.getTitle());
        assertNotNull(game.getDescription());
        assertNotNull(game.getText());
        assertNotNull(game.getTextEntities());
        PhotoSizeTest.checkPhotos(game.getPhoto());
        AnimationCheck.check(game.getAnimation());
    }
}