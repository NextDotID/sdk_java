package kvservice.response;

import common.BaseResponse;
import common.constract.Platform;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class GetKVResponse extends BaseResponse {
    private String persona;
    private String avatar;
    private List<Proof> proofs;

    @Data
    static class Proof {
        private Platform platform;
        private String identity;
        private String content;

        public String getPlatform() {
            return this.platform.name();
        }
    }

}
