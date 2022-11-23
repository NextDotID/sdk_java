package proofservice.response;

import com.google.gson.annotations.SerializedName;
import common.BaseResponse;
import common.constract.Action;
import common.constract.Platform;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
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

        @SerializedName("proof_location")
        private String proofLocation;

        @SerializedName("alt_id")
        private String altId;

        @SerializedName("created_at")
        private String createdAt;

        /**
         * generate signature_payload and avatar_private_key
         */
        private String signature;

        @SerializedName("signature_payload")
        private String signaturePayload;

        private Object extra;

        private String uuid;

        @SerializedName("arweave_id")
        private String arweaveId;

        public String getPlatform() {
            return this.platform.name();
        }

        public String getAction() {
            return this.action.name();
        }
    }

}
