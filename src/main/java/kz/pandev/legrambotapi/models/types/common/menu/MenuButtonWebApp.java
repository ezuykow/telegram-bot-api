package kz.pandev.legrambotapi.models.types.common.menu;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.web.app.WebAppInfo;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a menu button, which launches a Web App.
 * @author ezuykow
 */
@EqualsAndHashCode(callSuper = true)
@ToString
public class MenuButtonWebApp extends MenuButton implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Menu button type
     */
    private static final String MENU_BUTTON_TYPE = "web_app";

    /**
     * Text on the button
     */
    @SerializedName("text")
    private String text;

    /**
     * Description of the Web App that will be launched when the user presses the button.
     * The Web App will be able to send an arbitrary message on behalf of the user using the method answerWebAppQuery.
     */
    @SerializedName("web_app")
    private WebAppInfo webApp;

    public MenuButtonWebApp(String text, WebAppInfo webAppInfo) {
        this.type = MENU_BUTTON_TYPE;
        this.text = text;
        this.webApp = webAppInfo;
    }
}