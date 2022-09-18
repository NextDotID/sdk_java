package proofservice;

import common.BaseRequest;
import common.BaseResponse;
import common.Env;
import common.constract.Platform;
import proofservice.request.GetProofRequest;
import proofservice.request.ModifyProofRequest;
import proofservice.request.PayLoadProofRequest;
import proofservice.response.GetProofResponse;

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

    /**
     * get payload for signature and post
     */
    public BaseResponse payLoadProofV1(PayLoadProofRequest request){
        return new BaseResponse();
    }

    /**
     * modified proof
     */
    public BaseResponse postProofV1(ModifyProofRequest request){
        return new BaseResponse();
    }


    /**
     * query existed binding
     */
    public GetProofResponse getProofV1(GetProofRequest request){
        return new GetProofResponse();
    }


    public BaseResponse existProofV1(GetProofRequest request){
        return new BaseResponse();
    }

    public GetProofResponse getProofChain(String publicKey, Integer page){
        return new GetProofResponse();
    }

    public BaseResponse getProofChainChange(){
        return null;
    }
}
