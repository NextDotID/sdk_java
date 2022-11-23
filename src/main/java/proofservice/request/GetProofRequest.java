package proofservice.request;

import common.constract.Platform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProofRequest {
    /**
     * if null will search all platform
     */
    @NotNull(message = "platform is required")
    private Platform platform;
    /**
     * id on platform separateBy  ,
     */
    @NotNull(message = "identity is required")
    private String identity;
    private Integer page;

    private boolean extra;
}
