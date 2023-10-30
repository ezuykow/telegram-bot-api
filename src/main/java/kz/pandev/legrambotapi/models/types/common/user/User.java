package kz.pandev.legrambotapi.models.types.common.user;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents a Telegram user or bot
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Unique identifier for this user or bot
     */
    @SerializedName("id")
    @EqualsAndHashCode.Include
    private Long id;

    /**
     * True, if this user is a bot
     */
    @SerializedName("is_bot")
    private Boolean isBot;

    /**
     * User's or bot's first name
     */
    @SerializedName("first_name")
    private String firstName;

    /**
     * Optional. User's or bot's last name
     */
    @SerializedName("last_name")
    @Nullable
    private String lastName;

    /**
     * Optional. User's or bot's username
     */
    @SerializedName("username")
    @Nullable
    private String username;

    /**
     * Optional. IETF language tag of the user's language
     */
    @SerializedName("language_code")
    @Nullable
    private String languageCode;

    /**
     * Optional. True, if this user is a Telegram Premium user
     */
    @SerializedName("is_premium")
    @Nullable
    private Boolean isPremium;

    /**
     * Optional. True, if this user added the bot to the attachment menu
     */
    @SerializedName("added_to_attachment_menu")
    @Nullable
    private Boolean addedToAttachmentMenu;

    /**
     * Optional. True, if the bot can be invited to groups. Returned only in getMe.
     */
    @SerializedName("can_join_groups")
    @Nullable
    private Boolean canJoinGroups;

    /**
     * Optional. True, if privacy mode is disabled for the bot. Returned only in getMe.
     */
    @SerializedName("can_read_all_group_messages")
    @Nullable
    private Boolean canReadAllGroupMessages;

    /**
     * Optional. True, if the bot supports inline queries. Returned only in getMe.
     */
    @SerializedName("supports_inline_queries")
    @Nullable
    private Boolean supportsInlineQueries;
}