package kvservice.request;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KVPostRequest {


    @NotNull(message = "avatar is require")
    private String  avatar;
    /**
     * next.id it self
     */
    @NotNull(message = "platform is require")
    private String platform;

    @NotNull(message = "identity is require")
    private String identity;

    /**
     * generate by server post POST /v1/kv/payload
     */
    @NotNull(message = "uuid is require")
    private String uuid;

    /**
     * generate by server post POST /v1/kv/payload
     */
    @NotNull(message = "createAt is require")
    @SerializedName("created_at")
    private Long createAt;

    /**
     * signature of this request
     */
    @NotNull(message = "signature is require")
    private String signature;

    @NotNull(message = "patch is require")
    private Object patch;

}
