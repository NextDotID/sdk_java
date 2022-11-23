package proofservice.response;

import com.google.gson.annotations.SerializedName;
import common.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class HealthResponse extends BaseResponse {

    private String hello;

    @SerializedName("built_at")
    private String builtAt;

    private String revision;

    private String environment;

    private List<String> platforms;
}
