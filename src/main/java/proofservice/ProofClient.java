package proofservice;

import common.BaseRequest;
import common.BaseResponse;
import common.Env;
import kvservice.KVClient;

public class ProofClient {
    private Env env;
    private static ProofClient client;
    private ProofClient (Env env){
        this.env = env;
    }
    public static ProofClient getProClient(){
        if (client ==null){
            client = new ProofClient(Env.production);
        }
        return client;
    }
    public static ProofClient getDevClient(){
        if (client == null){
            client = new ProofClient(Env.development);
        }
        return client;
    }

    public BaseResponse getProofV1(BaseRequest request){
        return new BaseResponse();
    }

    public BaseResponse postProofV1(BaseRequest request){
        return new BaseResponse();
    }

    public BaseResponse existProofV1(BaseRequest request){
        return new BaseResponse();
    }

    public BaseResponse getProofChain(BaseRequest request){
        return new BaseResponse();
    }
}
