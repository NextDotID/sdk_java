package kvservice.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayLoadKVRequest {
    @NotNull(message = "avatar is required")
    private String  avatar;
    /**
     * next.id it self
     */
    @NotNull(message = "platform is required")
    private String platform;

    @NotNull(message = "identity is required")
    private String identity;

    @NotNull(message = "patch is required")
    private Object patch;

}
