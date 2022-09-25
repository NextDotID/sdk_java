package proofservice.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetProofChainRequest {
    @NotNull
    String publicKey;
    Integer page;

}
