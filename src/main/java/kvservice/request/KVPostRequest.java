package kvservice.request;


import kvservice.Patch;

import javax.validation.constraints.NotNull;

public class KVPostRequest {

    @NotNull
    private String persona;

    @NotNull
    private String  avatar;

    /**
     * next.id it self
     */
    @NotNull
    private String platform;

    @NotNull
    private String identity;

    /**
     * generate by server post POST /v1/kv/payload
     */
    @NotNull
    private String uuid;

    @NotNull
    private String createAt;

    /**
     * signature of this request
     */
    @NotNull
    private String signature;

    @NotNull
    private Patch patch;

}
