package kz.pandev.legrambotapi.models.types.inline.mode.input.message.content;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.payments.LabeledPrice;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Represents the content of an invoice message to be sent as the result of an inline query.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode
@ToString
public class InputInvoiceMessageContent implements InputMessageContent, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Product name, 1-32 characters
     */
    @SerializedName("title")
    private String title;

    /**
     * Product description, 1-255 characters
     */
    @SerializedName("description")
    private String description;

    /**
     * Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user,
     * use for your internal processes.
     */
    @SerializedName("payload")
    private String payload;

    /**
     * Payment provider token, obtained via @BotFather
     */
    @SerializedName("provider_token")
    private String providerToken;

    /**
     * Three-letter ISO 4217 currency code, see more on
     * <a href="https://core.telegram.org/bots/payments#supported-currencies">currencies</a>
     */
    @SerializedName("currency")
    private String currency;

    /**
     * Price breakdown, a list of components
     * (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.)
     */
    @SerializedName("prices")
    private List<LabeledPrice> prices;

    /**
     * Optional. The maximum accepted amount for tips in the smallest units of the currency (integer, not float/double).
     * For example, for a maximum tip of US$ 1.45 pass max_tip_amount = 145. See the exp parameter in
     * <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number
     * of digits past the decimal point for each currency (2 for the majority of currencies). Defaults to 0
     */
    @SerializedName("max_tip_amount")
    @Nullable
    private Integer maxTipAmount;

    /**
     * Optional. A list of suggested amounts of tip in the smallest units of the currency (integer, not float/double).
     * At most 4 suggested tip amounts can be specified. The suggested tip amounts must be positive,
     * passed in a strictly increased order and must not exceed max_tip_amount.
     */
    @SerializedName("suggested_tip_amounts")
    @Nullable
    private List<Integer> suggestedTipAmounts;

    /**
     * Optional. Data about the invoice, which will be shared with the payment provider.
     * A detailed description of the required fields should be provided by the payment provider.
     */
    @SerializedName("provider_data")
    @Nullable
    private String providerData;

    /**
     * Optional. URL of the product photo for the invoice. Can be a photo of the goods or a
     * marketing image for a service.
     */
    @SerializedName("photo_url")
    @Nullable
    private String photoUrl;

    /**
     * Optional. Photo size in bytes
     */
    @SerializedName("photo_size")
    @Nullable
    private Integer photoSize;

    /**
     * Optional. Photo width
     */
    @SerializedName("photo_width")
    @Nullable
    private Integer photoWidth;

    /**
     * Optional. Photo height
     */
    @SerializedName("photo_height")
    @Nullable
    private Integer photoHeight;

    /**
     * Optional. Pass True if you require the user's full name to complete the order
     */
    @SerializedName("need_name")
    @Nullable
    private Boolean needName;

    /**
     * Optional. Pass True if you require the user's phone number to complete the order
     */
    @SerializedName("need_phone_number")
    @Nullable
    private Boolean needPhoneNumber;

    /**
     * Optional. Pass True if you require the user's email address to complete the order
     */
    @SerializedName("need_email")
    @Nullable
    private Boolean needEmail;

    /**
     * Optional. Pass True if you require the user's shipping address to complete the order
     */
    @SerializedName("need_shipping_address")
    @Nullable
    private Boolean needShippingAddress;

    /**
     * Optional. Pass True if the user's phone number should be sent to provider
     */
    @SerializedName("send_phone_number_to_provider")
    @Nullable
    private Boolean sendPhoneNumberToProvider;

    /**
     * Optional. Pass True if the user's email address should be sent to provider
     */
    @SerializedName("send_email_to_provider")
    @Nullable
    private Boolean sendEmailToProvider;

    /**
     * Optional. Pass True if the final price depends on the shipping method
     */
    @SerializedName("is_flexible")
    @Nullable
    private Boolean isFlexible;

    public InputInvoiceMessageContent(@NotNull String title, @NotNull String description, @NotNull String payload,
                                      @NotNull String providerToken, @NotNull String currency,
                                      @NotNull List<LabeledPrice> prices) {
        this.title = title;
        this.description = description;
        this.payload = payload;
        this.providerToken = providerToken;
        this.currency = currency;
        this.prices = prices;
    }

    //region API

    /**
     * Set parameter {@link InputInvoiceMessageContent#title}
     * @param title new parameter value
     * @return this {@link InputInvoiceMessageContent}
     */
    public InputInvoiceMessageContent title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Set parameter {@link InputInvoiceMessageContent#description}
     * @param description new parameter value
     * @return this {@link InputInvoiceMessageContent}
     */
    public InputInvoiceMessageContent description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Set parameter {@link InputInvoiceMessageContent#payload}
     * @param payload new parameter value
     * @return this {@link InputInvoiceMessageContent}
     */
    public InputInvoiceMessageContent payload(String payload) {
        this.payload = payload;
        return this;
    }

    /**
     * Set parameter {@link InputInvoiceMessageContent#providerToken}
     * @param providerToken new parameter value
     * @return this {@link InputInvoiceMessageContent}
     */
    public InputInvoiceMessageContent providerToken(String providerToken) {
        this.providerToken = providerToken;
        return this;
    }

    /**
     * Set parameter {@link InputInvoiceMessageContent#currency}
     * @param currency new parameter value
     * @return this {@link InputInvoiceMessageContent}
     */
    public InputInvoiceMessageContent currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Set parameter {@link InputInvoiceMessageContent#prices}
     * @param prices new parameter value
     * @return this {@link InputInvoiceMessageContent}
     */
    public InputInvoiceMessageContent prices(List<LabeledPrice> prices) {
        this.prices = prices;
        return this;
    }

    /**
     * Set parameter {@link InputInvoiceMessageContent#maxTipAmount}
     * @param maxTipAmount new parameter value
     * @return this {@link InputInvoiceMessageContent}
     */
    public InputInvoiceMessageContent maxTipAmount(Integer maxTipAmount) {
        this.maxTipAmount = maxTipAmount;
        return this;
    }

    /**
     * Set parameter {@link InputInvoiceMessageContent#suggestedTipAmounts}
     * @param suggestedTipAmounts new parameter value
     * @return this {@link InputInvoiceMessageContent}
     */
    public InputInvoiceMessageContent suggestedTipAmounts(List<Integer> suggestedTipAmounts) {
        this.suggestedTipAmounts = suggestedTipAmounts;
        return this;
    }

    /**
     * Set parameter {@link InputInvoiceMessageContent#providerData}
     * @param providerData new parameter value
     * @return this {@link InputInvoiceMessageContent}
     */
    public InputInvoiceMessageContent providerData(String providerData) {
        this.providerData = providerData;
        return this;
    }

    /**
     * Set parameter {@link InputInvoiceMessageContent#photoUrl}
     * @param photoUrl new parameter value
     * @return this {@link InputInvoiceMessageContent}
     */
    public InputInvoiceMessageContent photoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    /**
     * Set parameter {@link InputInvoiceMessageContent#photoSize}
     * @param photoSize new parameter value
     * @return this {@link InputInvoiceMessageContent}
     */
    public InputInvoiceMessageContent photoSize(Integer photoSize) {
        this.photoSize = photoSize;
        return this;
    }

    /**
     * Set parameter {@link InputInvoiceMessageContent#photoWidth}
     * @param photoWidth new parameter value
     * @return this {@link InputInvoiceMessageContent}
     */
    public InputInvoiceMessageContent photoWidth(Integer photoWidth) {
        this.photoWidth = photoWidth;
        return this;
    }

    /**
     * Set parameter {@link InputInvoiceMessageContent#photoHeight}
     * @param photoHeight new parameter value
     * @return this {@link InputInvoiceMessageContent}
     */
    public InputInvoiceMessageContent photoHeight(Integer photoHeight) {
        this.photoHeight = photoHeight;
        return this;
    }

    /**
     * Set parameter {@link InputInvoiceMessageContent#needName}
     * @param needName new parameter value
     * @return this {@link InputInvoiceMessageContent}
     */
    public InputInvoiceMessageContent needName(Boolean needName) {
        this.needName = needName;
        return this;
    }

    /**
     * Set parameter {@link InputInvoiceMessageContent#needPhoneNumber}
     * @param needPhoneNumber new parameter value
     * @return this {@link InputInvoiceMessageContent}
     */
    public InputInvoiceMessageContent needPhoneNumber(Boolean needPhoneNumber) {
        this.needPhoneNumber = needPhoneNumber;
        return this;
    }

    /**
     * Set parameter {@link InputInvoiceMessageContent#needEmail}
     * @param needEmail new parameter value
     * @return this {@link InputInvoiceMessageContent}
     */
    public InputInvoiceMessageContent needEmail(Boolean needEmail) {
        this.needEmail = needEmail;
        return this;
    }

    /**
     * Set parameter {@link InputInvoiceMessageContent#needShippingAddress}
     * @param needShippingAddress new parameter value
     * @return this {@link InputInvoiceMessageContent}
     */
    public InputInvoiceMessageContent needShippingAddress(Boolean needShippingAddress) {
        this.needShippingAddress = needShippingAddress;
        return this;
    }

    /**
     * Set parameter {@link InputInvoiceMessageContent#sendPhoneNumberToProvider}
     * @param sendPhoneNumberToProvider new parameter value
     * @return this {@link InputInvoiceMessageContent}
     */
    public InputInvoiceMessageContent sendPhoneNumberToProvider(Boolean sendPhoneNumberToProvider) {
        this.sendPhoneNumberToProvider = sendPhoneNumberToProvider;
        return this;
    }

    /**
     * Set parameter {@link InputInvoiceMessageContent#sendEmailToProvider}
     * @param sendEmailToProvider new parameter value
     * @return this {@link InputInvoiceMessageContent}
     */
    public InputInvoiceMessageContent sendEmailToProvider(Boolean sendEmailToProvider) {
        this.sendEmailToProvider = sendEmailToProvider;
        return this;
    }

    /**
     * Set parameter {@link InputInvoiceMessageContent#isFlexible}
     * @param isFlexible new parameter value
     * @return this {@link InputInvoiceMessageContent}
     */
    public InputInvoiceMessageContent isFlexible(Boolean isFlexible) {
        this.isFlexible = isFlexible;
        return this;
    }

    //endregion
}