package kvservice;

import common.BaseResponse;
import common.Env;
import kvservice.request.KVGetPayloadRequest;
import kvservice.request.KVPostRequest;
import kvservice.request.KVgetRequest;
import kvservice.request.PayLoadKVRequest;

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

    public BaseResponse getV1(KVgetRequest request){
        return new BaseResponse();
    }

    public BaseResponse postKVV1(KVPostRequest request){
        return new BaseResponse();
    }

    public BaseResponse getPayload(KVGetPayloadRequest request){
        return new BaseResponse();
    }

    public BaseResponse postPayload(PayLoadKVRequest request){
        return new BaseResponse();
    }
}
