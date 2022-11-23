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
public class PayLoadProofRequest {
    @NotNull(message = "action is required")
    private Action action;

    /**
     * target platform
     * all available platform
     * Keybase Twitter Ethereum Github Discord DotBit Solana
     * detail: https://github.com/nextdotid/proof_server/tree/32bb5b770f8612ea792a08b80d18ab14016e16ba/docs
     */
    @NotNull(message = "platform is required")
    private Platform platform;

    /**
     * target proof platform id
     */
    @NotNull(message = "Identity is required")
    private String Identity;

    /**
     * public key of next.id to connect
     */
    @NotNull(message = "publicKey is required")
    @SerializedName("public_key")
    private String publicKey;

    public String getAction() {
        return action.name();
    }

    public String getPlatform() {
        return platform.name();
    }

}
