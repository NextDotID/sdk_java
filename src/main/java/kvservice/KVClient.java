package kvservice;

import com.google.gson.Gson;
import common.*;

import kvservice.request.KVPostRequest;

import kvservice.request.PayLoadKVRequest;
import kvservice.response.GetKVResponse;
import kvservice.response.PostKVPayloadResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URIBuilder;

import java.net.URISyntaxException;

import static common.Service.KV_SERVICE;

public class KVClient extends BaseClient {
    private static final Gson gson = new Gson();

    public KVClient(Env env) {
        setEnv(env);
    }

    private static KVClient productClient;
    private static KVClient stagClient;

    public static KVClient getProdClient() {
        if (productClient == null) {
            productClient = new KVClient(Env.KV_PROD);
        }
        return productClient;
    }

    public static KVClient getStagClient() {
        if (stagClient == null) {
            stagClient = new KVClient(Env.KV_STAG);
        }
        return stagClient;
    }


    /**
     * Get /v1/kv
     */
    public GetKVResponse getKVV1(String avatar) {
        if (StringUtils.isEmpty(avatar)) {
            throw new NextIdException("avatar is require");
        }
        URIBuilder uriBuilder;
        try {
            uriBuilder = new URIBuilder(getEnv().getUrlPrefix());
            uriBuilder.setPath("/v1/kv");
            uriBuilder.setParameter("avatar", avatar);
            return (GetKVResponse) get(uriBuilder, KV_SERVICE, GetKVResponse.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new GetKVResponse();
    }

    /**
     * POST /v1/kv
     */
    public BaseResponse postKVV1(KVPostRequest request) {
        ParamChecker.checkParam(request);
        URIBuilder uriBuilder;
        try {
            uriBuilder = new URIBuilder(getEnv().getUrlPrefix());
            String body = gson.toJson(request);
            uriBuilder.setPath("/v1/kv");
            return post(uriBuilder, KV_SERVICE, BaseResponse.class, body);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new BaseResponse();
    }

    /**
     * /v1/kv/payload
     */
    public PostKVPayloadResponse postKVPayloadV1(PayLoadKVRequest request) {
        ParamChecker.checkParam(request);
        URIBuilder uriBuilder;
        try {
            uriBuilder = new URIBuilder(getEnv().getUrlPrefix());
            String body = gson.toJson(request);
            uriBuilder.setPath("/v1/kv/payload");
            return (PostKVPayloadResponse) post(uriBuilder, KV_SERVICE, PostKVPayloadResponse.class, body);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new PostKVPayloadResponse();
    }
}
