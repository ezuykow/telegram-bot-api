package kz.pandev.legrambotapi.models.types;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents a message about a forwarded story in the chat. Currently, holds no information
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Story implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

}