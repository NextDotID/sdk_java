package proofservice.request;

import common.BaseRequest;
import common.BaseResponse;
import common.constract.Platform;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GetProofRequest extends BaseRequest {
    /**
     * if null will search all platform
     */
    private Platform platform;
    /**
     * id on platform separateBy  ,
     */
    private String identity;
    private Integer page;
}
