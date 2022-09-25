package kvservice;

import common.BaseResponse;
import common.Env;
import common.NextIdException;
import kvservice.request.KVGetPayloadRequest;
import kvservice.request.KVPostRequest;
import kvservice.request.KVgetRequest;
import kvservice.request.PayLoadKVRequest;
import kvservice.response.GetKVResponse;
import org.apache.commons.lang3.StringUtils;

public class KVClient {
    private Env env;
    private static KVClient client;
    private KVClient (Env env){
        this.env = env;
    }
    public static KVClient getProClient(){
        if(client == null){
            client = new KVClient(Env.production);
        }
        return client;
    }
    public static KVClient getDevClient(){
        if(client == null){
            client = new KVClient(Env.development);
        }
        return client;
    }

    /**
     * Get /v1/kv
     */
    public GetKVResponse getKVV1(String avatar){
        if(StringUtils.isEmpty(avatar)){
            throw new NextIdException("avatar is require");
        }
        return new GetKVResponse();
    }

    /**
     * POST /v1/kv
     */
    public BaseResponse postKVV1(KVPostRequest request){
        return new BaseResponse();
    }

    /**
     * /v1/kv/payload
     * @param request
     * @return
     */
    public BaseResponse postKVPayloadV1(PayLoadKVRequest request){
        return new BaseResponse();
    }
}
