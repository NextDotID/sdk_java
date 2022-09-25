package proofservice.response;

import common.BaseResponse;
import common.model.Pagination;
import common.constract.Platform;
import common.model.ProofInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class GetProofResponse extends BaseResponse {
    private Pagination pagination;

    private List<IdInfo> ids;

    @Data
    static class IdInfo{
        /**
         * avatar pk
         */
        private String avatar;

        private String LastArweaveId;

        private List<ProofInfo> proofs;

    }


}
