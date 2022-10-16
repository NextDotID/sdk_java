package proofservice.request;

import common.BaseRequest;
import common.constract.Platform;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class GetProofRequest extends BaseRequest {
    /**
     * if null will search all platform
     */
    @NotNull(message = "platform is required")
    private Platform platform;
    /**
     * id on platform separateBy  ,
     */
    @NotNull(message = "identity is required")
    private String identity;
    private Integer page;
}
