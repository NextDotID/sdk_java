package kvservice.response;

import lombok.Data;

@Data
public class PostKVPayloadResponse {
    private String uuid;
    private String createdAt;
    private String signPayload;
}
