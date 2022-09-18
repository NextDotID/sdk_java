package kvservice.request;


import common.BaseRequest;
import common.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class PayLoadKVRequest extends BaseRequest {
    @NotNull
    private String persona;

    @NotNull
    private String  avatar;

    /**
     * next.id it self
     */
    @NotNull
    private String platform;

    @NotNull
    private String identity;


    static class patch {

    }
}
