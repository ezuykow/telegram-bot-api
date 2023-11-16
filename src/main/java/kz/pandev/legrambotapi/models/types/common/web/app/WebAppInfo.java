package kz.pandev.legrambotapi.models.types.common.web.app;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * Describes a Web App
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode
@ToString
public class WebAppInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * An HTTPS URL of a Web App to be opened with additional data as specified in Initializing Web Apps
     */
    @SerializedName("url")
    private final String url;

    /**
     * @param url {@link WebAppInfo#url}
     */
    public WebAppInfo(@NotNull String url) {
        this.url = url;
    }
}