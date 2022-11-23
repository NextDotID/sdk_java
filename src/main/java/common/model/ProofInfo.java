package common.model;


import com.google.gson.annotations.SerializedName;
import common.constract.Platform;
import lombok.Data;

@Data
public class ProofInfo {
    private Platform platform;
    private String identity;
    @SerializedName("created_at")
    private String createAt;
    @SerializedName("last_checked_at")
    private String lastCheckedAt;
    @SerializedName("is_valid")
    private Boolean isValid;
    @SerializedName("invalid_reason")
    private String invalidReason;
}
