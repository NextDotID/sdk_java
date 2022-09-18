package proofservice.response;

import common.BaseResponse;
import common.constract.Action;
import common.constract.Pagination;
import common.constract.Platform;
import lombok.Data;

import java.util.List;

public class getProofChainResponse extends BaseResponse {
    private Pagination pagination;

    private List<ProofChain> proofChain;


    @Data
    static class ProofChain{
        private Action action;
        private Platform platform;
        private String identity;
        private String proofChain;
        private String CreatedAt;
        private String signature;
        private String signaturePayload;
        private String extra;
        private String uuid;
        /**
         * Arweave transaction ID of this proof
         */
        private String arweave_id;
    }
}
