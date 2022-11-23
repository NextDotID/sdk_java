package proofservice.response;

import com.google.gson.annotations.SerializedName;
import common.BaseResponse;
import common.model.Pagination;
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
    static class IdInfo {
        /**
         * avatar pk
         */
        private String avatar;

        @SerializedName("last_arweave_id")
        private String LastArweaveId;

        private List<ProofInfo> proofs;

    }


}
