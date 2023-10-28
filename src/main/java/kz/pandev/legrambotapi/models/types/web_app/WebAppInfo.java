package kz.pandev.legrambotapi.models.types.web_app;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * Describes a Web App
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class WebAppInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * An HTTPS URL of a Web App to be opened with additional data as specified in Initializing Web Apps
     */
    @SerializedName("url")
    private String url;
}