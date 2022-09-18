package proofservice.response;

import common.BaseRequest;
import common.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ExistProofResponse extends BaseResponse {
    private String createAt;
    private String lastCheckedAt;
    private Boolean isValid;
    private String isValidReason;
}
