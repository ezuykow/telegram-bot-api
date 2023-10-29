package kz.pandev.legrambotapi.models.types.menu;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * Describes that no specific value for the menu button was set.
 * @author ezuykow
 */
@EqualsAndHashCode(callSuper = true)
@ToString
public class MenuButtonDefault extends MenuButton implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Menu button type
     */
    private static final String MENU_BUTTON_TYPE = "default";

    public MenuButtonDefault() {
        this.type = MENU_BUTTON_TYPE;
    }
}