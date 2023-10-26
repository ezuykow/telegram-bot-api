package kz.pandev.legrambotapi.models.temp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ChatPermissions implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}