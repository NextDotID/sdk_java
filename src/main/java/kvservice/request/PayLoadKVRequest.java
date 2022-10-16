package kvservice.request;


import common.BaseRequest;
import common.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class PayLoadKVRequest extends BaseRequest {
    @NotNull(message = "persona is required")
    private String persona;

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
    private String patch;

}
