package proofservice.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetProofChainChangeRequest {
    @NotNull(message = "platform is required")
    private Long lastId;
    private Integer count;
}
