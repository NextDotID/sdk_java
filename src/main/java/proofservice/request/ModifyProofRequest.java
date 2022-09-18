package proofservice.request;

import common.constract.Action;
import common.constract.Platform;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ModifyProofRequest {
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

    /**
     * Extra info for specific platform needed
     */
    private Extra extra;

    @NotNull
    private String uuid;

    @NotNull
    private String createAt;

    @Data
    static class Extra{
        private String walletSignature;
        private String signature;
    }

}
