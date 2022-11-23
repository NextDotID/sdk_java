package proofservice.response;
import com.google.gson.annotations.SerializedName;
import common.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProofPayloadResponse extends BaseResponse {
    @SerializedName("post_content")
    private PostContent postContent;

    /**
     * Raw String be sent to persional_sign
     */
    @SerializedName("sign_payload")
    private String signPayload;
    /**
     * uuid of chains link use to send to postProof
     */
    private String uuid;

    /**
     * create of this chain link
     */
    @SerializedName("created_at")
    private String crateAt;

    @Data
    static class PostContent {
        @SerializedName("default")
        String defaultMessage;
        @SerializedName("zh_CN")
        String zhCN;
    }
}
