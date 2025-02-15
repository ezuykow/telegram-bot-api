package kz.pandev.legrambotapi.utils.enums;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Modes for parsing entities in the message's texts.
 * For sending to Telegram server use {@link ParseMode#getTextVal()}
 * @see <a href="https://core.telegram.org/bots/api#formatting-options">Formatting options docs</a>
 * @author ezuykow
 */
@Getter
@RequiredArgsConstructor
public enum ParseMode {

    /**
     * Markdown parse mode <br>
     * This is a legacy mode, retained for backward compatibility.
     * @apiNote Use the following syntax in your message: <br>
     * *bold text* <br>
     * _italic text_ <br>
     * [inline URL](<a href="http://www.example.com/">http://www.example.com/</a>) <br>
     * [inline mention of a user](tg://user?id=123456789) <br>
     * `inline fixed-width code` <br>
     * ``` <br>
     * pre-formatted fixed-width code block <br>
     * ``` <br>
     * ```python <br>
     * pre-formatted fixed-width code block written in the Python programming language <br>
     * ``` <br>
     * <br> Please note: <br>
     * <li>Entities must not be nested, use parse mode MarkdownV2 instead. <br>
     * <li>There is no way to specify underline and strikethrough entities, use parse mode MarkdownV2 instead. <br>
     * <li>To escape characters '_', '*', '`', '[' outside of an entity, prepend the characters '\' before them. <br>
     * <li>Escaping inside entities is not allowed, so entity must be closed first and reopened again: use _snake_\__case_ for italic snake_case and *2*\**2=4* for bold 2*2=4. <br>
     */
    @SerializedName("Markdown")
    MARKDOWN("Markdown"),

    /**
     * Markdown v2 parse mode <br>
     * @apiNote Use the following syntax in your message: <br>
     * *bold \*text* <br>
     * _italic \*text_ <br>
     * __underline__ <br>
     * ~strikethrough~ <br>
     * ||spoiler|| <br>
     * *bold _italic bold ~italic bold strikethrough ||italic bold strikethrough spoiler||~ __underline italic bold___ bold*  <br>
     * [inline URL](<a href="http://www.example.com/">http://www.example.com</a>)  <br>
     * [inline mention of a user](tg://user?id=123456789) <br>
     * ![👍](tg://emoji?id=5368324170671202286) <br>
     * `inline fixed-width code` <br>
     * ``` <br>
     * pre-formatted fixed-width code block <br>
     * ``` <br>
     * ```python <br>
     * pre-formatted fixed-width code block written in the Python programming language <br>
     * ``` <br>
     * <br> Please note: <br>
     * <li>Any character with code between 1 and 126 inclusively can be escaped anywhere with a preceding '\' character, in which case it is treated as an ordinary character and not a part of the markup. This implies that '\' character usually must be escaped with a preceding '\' character. <br>
     * <li>Inside pre and code entities, all '`' and '\' characters must be escaped with a preceding '\' character. <br>
     * <li>Inside the (...) part of the inline link and custom emoji definition, all ')' and '\' must be escaped with a preceding '\' character. <br>
     * <li>In all other places characters '_', '*', '[', ']', '(', ')', '~', '`', '>', '#', '+', '-', '=', '|', '{', '}', '.', '!' must be escaped with the preceding character '\'. <br>
     * <li>In case of ambiguity between italic and underline entities __ is always greadily treated from left to right as beginning or end of underline entity, so instead of ___italic underline___ use ___italic underline_\r__, where \r is a character with code 13, which will be ignored. <br>
     * <li>A valid emoji must be provided as an alternative value for the custom emoji. The emoji will be shown instead of the custom emoji in places where a custom emoji cannot be displayed (e.g., system notifications) or if the message is forwarded by a non-premium user. It is recommended to use the emoji from the emoji field of the custom emoji sticker. <br>
     * <li>Custom emoji entities can only be used by bots that purchased additional usernames on Fragment. <br>
     */
    @SerializedName("MarkdownV2")
    MARKDOWN_V2("MarkdownV2"),

    /**
     * HTML parse mode <br>
     * @apiNote The following tags are currently supported: <br>
     * &lt;b&gt;bold&lt;/b>, &lt;strong>bold&lt;/strong> <br>
     * &lt;i>italic&lt;/i>, &lt;em>italic&lt;/em> <br>
     * &lt;u&lt;underline&lt;/u>, &lt;ins>underline&lt;/ins> <br>
     * &lt;s>strikethrough&lt;/s>, &lt;strike>strikethrough&lt;/strike>, &lt;del>strikethrough&lt;/del> <br>
     * &lt;span class="tg-spoiler">spoiler&lt;/span>, &lt;tg-spoiler>spoiler&lt;/tg-spoiler> <br>
     * &lt;b>bold &lt;i>italic bold &lt;s>italic bold strikethrough &lt;span class="tg-spoiler">italic bold strikethrough spoiler&lt;/span>&lt;/s> &lt;u>underline italic bold&lt;/u>&lt;/i> bold&lt;/b> <br>
     * &lt;a href="http://www.example.com/">inline URL&lt;/a> <br>
     * &lt;a href="tg://user?id=123456789">inline mention of a user&lt;/a> <br>
     * &lt;tg-emoji emoji-id="5368324170671202286">👍&lt;/tg-emoji> <br>
     * &lt;code>inline fixed-width code&lt;/code> <br>
     * &lt;pre>pre-formatted fixed-width code block&lt;/pre> <br>
     * &lt;pre>&lt;code class="language-python">pre-formatted fixed-width code block written in the Python programming language&lt;/code>&lt;/pre> <br>
     * <br> Please note: <br>
     * <li>Only the tags mentioned above are currently supported. <br>
     * <li>All <, > and & symbols that are not a part of a tag or an HTML entity must be replaced with the corresponding HTML entities (< with &lt;, > with &gt; and & with &amp;). <br>
     * <li>All numerical HTML entities are supported. <br>
     * <li>The API currently supports only the following named HTML entities: &lt;, &gt;, &amp; and &quot;. <br>
     * <li>Use nested pre and code tags, to define programming language for pre entity. <br>
     * <li>Programming language can't be specified for standalone code tags. <br>
     * <li>A valid emoji must be used as the content of the tg-emoji tag. The emoji will be shown instead of the custom emoji in places where a custom emoji cannot be displayed (e.g., system notifications) or if the message is forwarded by a non-premium user. It is recommended to use the emoji from the emoji field of the custom emoji sticker. <br>
     * <li>Custom emoji entities can only be used by bots that purchased additional usernames on Fragment. <br>
     */
    @SerializedName("HTML")
    HTML("HTML");

    /**
     * Text value of parse mode for sending to Telegram server
     */
    private final String textVal;
}