package kz.pandev.legrambotapi.models.types.menu;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a menu button, which opens the bot's list of commands.
 * @author ezuykow
 */
@EqualsAndHashCode(callSuper = true)
@ToString
public class MenuButtonCommands extends MenuButton implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Menu button type
     */
    private static final String MENU_BUTTON_TYPE = "commands";

    public MenuButtonCommands() {
        this.type = MENU_BUTTON_TYPE;
    }
}