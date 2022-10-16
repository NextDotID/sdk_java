package kvservice.response;

import common.BaseResponse;
import common.constract.Platform;
import common.model.ProofInfo;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class GetKVResponse extends BaseResponse {
    private String avatar;
    private List<Proof> proofs;

    @Data
    static class Proof{

        private Platform platform;
        private String identity;
        private String content;

    }
}
