package kz.pandev.legrambotapi.models.types.common;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents a service message about a user allowing a bot to write messages after adding it to the
 * attachment menu, launching a Web App from a link, or accepting an explicit request from a Web App sent by
 * the method requestWriteAccess.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class WriteAccessAllowed implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Optional. True, if the access was granted after the user accepted an explicit request from a Web App sent by
     * the method requestWriteAccess
     */
    @SerializedName("from_request")
    @Nullable
    private Boolean fromRequest;

    /**
     * Optional. Name of the Web App, if the access was granted when the Web App was launched from a link
     */
    @SerializedName("web_app_name")
    @Nullable
    private String webAppName;

    /**
     * Optional. True, if the access was granted when the bot was added to the attachment or side menu
     */
    @SerializedName("from_attachment_menu")
    @Nullable
    private Boolean fromAttachmentMenu;
}