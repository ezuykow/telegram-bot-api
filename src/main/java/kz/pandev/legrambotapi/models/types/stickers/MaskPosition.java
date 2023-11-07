package kz.pandev.legrambotapi.models.types.stickers;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object describes the position on faces where a mask should be placed by default.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode
@ToString
public class MaskPosition implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * The part of the face relative to which the mask should be placed
     */
    public enum Point {
        FOREHEAD, EYES, MOUTH, CHIN
    }

    /**
     * The part of the face relative to which the mask should be placed.
     * One of “forehead”, “eyes”, “mouth”, or “chin”.
     */
    @SerializedName("point")
    private final String point;

    /**
     * Shift by X-axis measured in widths of the mask scaled to the face size, from left to right.
     * For example, choosing -1.0 will place mask just to the left of the default mask position.
     */
    @SerializedName("x_shift")
    private final Float xShift;

    /**
     * Shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom.
     * For example, 1.0 will place the mask just below the default mask position.
     */
    @SerializedName("y_shift")
    private final Float yShift;

    /**
     * Mask scaling coefficient. For example, 2.0 means double size.
     */
    @SerializedName("scale")
    private final Float scale;

    public MaskPosition(Point point, float xShift, float yShift, float scale) {
        this(point.name().toLowerCase(), xShift, yShift, scale);
    }

    public MaskPosition(String point, float xShift, float yShift, float scale) {
        this.point = point;
        this.xShift = xShift;
        this.yShift = yShift;
        this.scale = scale;
    }
}