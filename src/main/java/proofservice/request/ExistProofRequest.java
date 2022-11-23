package proofservice.request;

import common.constract.Platform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExistProofRequest {

    @NotNull(message = "platform is required")
    private Platform platform;

    @NotNull(message = "identity is required")
    private String identity;

    @NotNull(message = "publicKey is required")
    private String publicKey;

}
