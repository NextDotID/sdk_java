package proofservice.response;

import common.BaseResponse;
import common.constract.Pagination;
import common.constract.Platform;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class GetProofResponse extends BaseResponse {
    private Pagination pagination;



    @Data
    static class IdInfo{
        /**
         * avatar pk
         */
        private String avatar;

        private String LastArweaveId;

        private List<ProofInfo> proofs;

    }


    @Data
    static class ProofInfo{
        private Platform platform;
        private String identity;
        private String createAt;
        private String lastCheckedAt;
        private Boolean isValid;
        private String isValidReason;

    }

}
