package proofservice.request;

import common.constract.Platform;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class ExistProofRequest {

    @NotNull(message = "platform is required")
    private Platform platform;

    @NotNull(message = "identity is required")
    private String identity;

    @NotNull(message = "publicKey is required")
    private String publicKey;

}
