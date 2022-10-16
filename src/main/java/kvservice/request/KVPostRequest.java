package kvservice.request;


import common.constract.Platform;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class KVPostRequest {

    @NotNull(message = "persona is require")
    private String persona;

    @NotNull(message = "avatar is require")
    private String  avatar;

    /**
     * next.id it self
     */
    @NotNull(message = "platform is require")
    private Platform platform;

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
    private String createAt;

    /**
     * signature of this request
     */
    @NotNull(message = "signature is require")
    private String signature;

    @NotNull(message = "patch is require")
    private String patch;

}
