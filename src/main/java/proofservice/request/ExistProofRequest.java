package proofservice.request;

import common.constract.Platform;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class ExistProofRequest {

    @NotNull
    private Platform platform;

    @NotNull
    private String identity;

    @NotNull
    private String publicKey;

}
