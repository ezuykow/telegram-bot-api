package kz.pandev.legrambotapi.models.types.games;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.Animation;
import kz.pandev.legrambotapi.models.types.common.PhotoSize;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * This object represents a game.
 * Use BotFather to create and edit games, their short names will act as unique identifiers.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Game implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Title of the game
     */
    @SerializedName("title")
    private String title;

    /**
     * Description of the game
     */
    @SerializedName("description")
    private String description;

    /**
     * Photo that will be displayed in the game message in chats.
     */
    @SerializedName("photo")
    private List<PhotoSize> photo;

    /**
     * Optional. Brief description of the game or high scores included in the game message.
     * Can be automatically edited to include current high scores for the game when the bot
     * calls setGameScore, or manually edited using editMessageText. 0-4096 characters.
     */
    @SerializedName("text")
    @Nullable
    private String text;

    /**
     * Optional. Special entities that appear in text, such as usernames, URLs, bot commands, etc.
     */
    @SerializedName("text_entities")
    @Nullable
    private List<MessageEntity> textEntities;

    /**
     * Optional. Animation that will be displayed in the game message in chats. Upload via @BotFather
     */
    @SerializedName("animation")
    @Nullable
    private Animation animation;
}