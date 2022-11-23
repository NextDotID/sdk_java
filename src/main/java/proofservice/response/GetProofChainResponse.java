package proofservice.response;

import com.google.gson.annotations.SerializedName;
import common.BaseResponse;
import common.constract.Action;
import common.model.Pagination;
import common.constract.Platform;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class GetProofChainResponse extends BaseResponse {
    private Pagination pagination;

    @SerializedName("proof_chain")
    private List<ProofChain> proofChain;

    @Data
    static class ProofChain {
        private Action action;
        private Platform platform;
        private String identity;
        @SerializedName("proof_location ")
        private String proofChain;
        @SerializedName("created_at ")
        private String createdAt;
        private String signature;
        @SerializedName("signature_payload ")
        private String signaturePayload;
        private String extra;
        private String uuid;
        /**
         * Arweave transaction ID of this proof
         */
        @SerializedName("arweave_id ")
        private String arweaveId;

        public String getPlatform() {
            return this.platform.name();
        }
    }
}
