package kvservice;

import com.alibaba.fastjson2.JSONObject;
import common.*;

import kvservice.request.KVPostRequest;

import kvservice.request.PayLoadKVRequest;
import kvservice.response.GetKVResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URIBuilder;

import static common.Service.KV_SERVICE;

public class KVClient extends BaseClient {


    /**
     * Get /v1/kv
     */
    public GetKVResponse getKVV1(String avatar) {
        if (StringUtils.isEmpty(avatar)) {
            throw new NextIdException("avatar is require");
        }
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setParameter("avatar", avatar);
        return (GetKVResponse) get(uriBuilder, KV_SERVICE, GetKVResponse.class);
    }

    /**
     * POST /v1/kv
     */
    public BaseResponse postKVV1(KVPostRequest request) {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setParameter("avatar", request.getAvatar());
        uriBuilder.setParameter("platform", request.getPlatform().name());
        uriBuilder.setParameter("identity", request.getIdentity());
        uriBuilder.setParameter("uuid", request.getUuid());
        uriBuilder.setParameter("created_at", request.getCreateAt());
        uriBuilder.setParameter("signature", request.getSignature());
        uriBuilder.setParameter("patch", request.getPatch());
        return post(uriBuilder, KV_SERVICE, BaseResponse.class);
    }

    /**
     * /v1/kv/payload
     */
    public BaseResponse postKVPayloadV1(PayLoadKVRequest request) {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setParameter("avatar", request.getAvatar());
        uriBuilder.setParameter("platform", request.getPlatform());
        uriBuilder.setParameter("identity", request.getIdentity());
        uriBuilder.setParameter("patch", JSONObject.toJSONString(request.getPatch()));
        return post(uriBuilder, KV_SERVICE, BaseResponse.class);
    }
}
