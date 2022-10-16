package proofservice.request;

import common.constract.Action;
import common.constract.Platform;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProofUploadRequest {
    @NotNull
    private Action action;
    @NotNull
    private Platform platform;
    @NotNull
    private String Identity;

    /**
     * location where accessible
     */
    @NotNull
    private String proofLocation;

    @NotNull
    private String publicKey;

    /**
     * Extra info for specific platform needed
     */
    private ProofUploadRequestExtra extra;

    /**
     * generate from post /v1/proof/payload
     */
    @NotNull

    private String uuid;

    @NotNull
    private String createAt;

    @Data
    public static class ProofUploadRequestExtra{
        private String walletSignature;
        private String signature;
    }

}
