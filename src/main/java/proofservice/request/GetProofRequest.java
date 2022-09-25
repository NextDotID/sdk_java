package proofservice.request;

import common.BaseRequest;
import common.BaseResponse;
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
    @NotNull
    private Platform platform;
    /**
     * id on platform separateBy  ,
     */
    @NotNull
    private String identity;
    private Integer page;
}
