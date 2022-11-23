package kvservice.response;

import com.google.gson.annotations.SerializedName;
import common.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PostKVPayloadResponse extends BaseResponse {
    private String uuid;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("sign_payload")
    private String signPayload;
}
