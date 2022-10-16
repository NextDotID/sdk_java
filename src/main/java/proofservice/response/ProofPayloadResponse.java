package proofservice.response;

import common.BaseResponse;
import lombok.Data;

@Data
public class ProofPayloadResponse extends BaseResponse {

    PostContent postContent;

    /**
     * Raw String be sent to persional_sign
     */
    String signPayload;
    /**
     * uuid of chains link use to send to postProof
     */
    String uuid;

    /**
     * create of this chain link
     */
    String crateAt;

    static class PostContent{
        String defaultMessage;
        String zhCN;
    }
}
