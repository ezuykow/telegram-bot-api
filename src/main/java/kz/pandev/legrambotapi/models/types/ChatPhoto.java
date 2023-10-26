package kz.pandev.legrambotapi.models.types;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents a chat photo
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ChatPhoto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Unique file identifier of small (160x160) chat photo, which is supposed to be the same over time and
     * for different bot's. Can't be used to download or reuse the file
     */
    @SerializedName("small_file_unique_id")
    @EqualsAndHashCode.Include
    private String smallFileUniqueId;

    /**
     * File identifier of small (160x160) chat photo. This file_id can be used only for photo download
     * and only for as long as the photo is not changed
     */
    @SerializedName("small_file_id")
    private String smallFileId;

    /**
     * Unique file identifier of big (640x640) chat photo, which is supposed to be the same over time and
     * for different bot's. Can't be used to download or reuse the file
     */
    @SerializedName("big_file_unique_id")
    private String bigFileUniqueId;

    /**
     * File identifier of big (640x640) chat photo. This file_id can be used only for photo download
     * and only for as long as the photo is not changed
     */
    @SerializedName("big_file_id")
    private String bigFileId;
}