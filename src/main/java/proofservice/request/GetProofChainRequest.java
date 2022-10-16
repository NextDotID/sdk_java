package proofservice.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetProofChainRequest {
    @NotNull(message = "publicKey is required")
    String publicKey;
    Integer page;
}
