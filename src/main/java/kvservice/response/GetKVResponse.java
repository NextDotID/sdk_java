package kvservice.response;

import common.constract.Platform;
import common.model.ProofInfo;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class GetKVResponse {
    private String avatar;
    private List<Proof> proofs;

    @Data
    static class Proof{

        private Platform platform;
        private String identity;
        private String content;

    }
}
