package proofservice.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetProofChainChangeRequest {
    @NotNull
    private Long parameters;
    private Long count;
}
