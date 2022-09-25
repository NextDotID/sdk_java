package proofservice.response;

import common.BaseResponse;
import common.constract.Action;
import common.constract.Platform;
import lombok.Data;

import java.util.List;

@Data
public class GetProofChainChangeResponse extends BaseResponse {
    private List<Link> links;

    @Data
    static class Link {
        /**
         * link id in proof service db
         */
        private Long id;

        /**
         * avatar link this id
         */
        private String avatar;

        private Action action;

        private Platform platform;

        private String identity;

        private String proofLocation;

        private String createdAt;

        /**
         *  generate signature_payload and avatar_private_key
         */
        private String signature;

        private String signaturePayload;

        private String extra;

        private String uuid;

        private String arweaveId;
    }

}
