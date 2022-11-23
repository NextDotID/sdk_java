package proofservice.request;

import com.google.gson.annotations.SerializedName;
import common.constract.Action;
import common.constract.Platform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProofUploadRequest {
    @NotNull(message = "action is required")
    private Action action;
    @NotNull(message = "platform is required")
    private Platform platform;
    @NotNull(message = "Identity is required")
    private String Identity;

    /**
     * location where accessible
     */
    @NotNull(message = "proofLocation is required")
    @SerializedName("proof_location")
    private String proofLocation;

    @NotNull(message = "publicKey is required")
    @SerializedName("public_key")
    private String publicKey;

    /**
     * Extra info for specific platform needed
     */
    private ProofUploadRequestExtra extra;

    /**
     * generate from post /v1/proof/payload
     */
    @NotNull(message = "uuid is required")
    private String uuid;

    @NotNull(message = "createAt is required")
    @SerializedName("created_at")
    private String createAt;

    @Data
    public static class ProofUploadRequestExtra {
        @SerializedName("wallet_signature")
        private String walletSignature;
        private String signature;
    }

    public String getAction() {
        return action.name();
    }

    public String getPlatform() {
        return platform.name();
    }
}
