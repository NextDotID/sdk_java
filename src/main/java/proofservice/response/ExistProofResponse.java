package proofservice.response;

import com.google.gson.annotations.SerializedName;
import common.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ExistProofResponse extends BaseResponse {
    @SerializedName("created_at")
    private String createAt;
    @SerializedName("last_checked_at")
    private String lastCheckedAt;
    @SerializedName("is_valid")
    private Boolean isValid;
    @SerializedName("invalid_reason")
    private String isValidReason;
}
