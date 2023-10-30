package kz.pandev.legrambotapi.models.types.common;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents an animated emoji that displays a random value.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Dice implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Emoji on which the dice throw animation is based
     */
    @SerializedName("emoji")
    private String emoji;

    /**
     * Value of the dice, 1-6 for “🎲”, “🎯” and “🎳” base emoji, 1-5 for “🏀” and “⚽” base emoji,
     * 1-64 for “🎰” base emoji
     */
    @SerializedName("value")
    private Integer value;
}