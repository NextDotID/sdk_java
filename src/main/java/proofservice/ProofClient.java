package proofservice;

import common.BaseResponse;
import common.Env;
import proofservice.request.*;
import proofservice.response.ExistProofResponse;
import proofservice.response.GetProofChainResponse;
import proofservice.response.GetProofResponse;
import proofservice.response.ProofPayloadResponse;

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
     * get payload for signature
     *
     */
    public ProofPayloadResponse payLoadProofV1(PayLoadProofRequest request){
        return new ProofPayloadResponse();
    }

    /**
     * modified proof
     * 1.findPrevious proof
     *
     * 2.validate proof (platform validate )
     *
     * 3.create Proof from platform Validatetor
     * post v1/proof/post
     */
    public BaseResponse postProofV1(ProofUploadRequest request){
        return new BaseResponse();
    }

    /**
     * query existed binding
     *  get v1/proof
     */
    public GetProofResponse getProofV1(GetProofRequest request){
        return new GetProofResponse();
    }

    /**
     * get /v1/proof/exist
     */
    public ExistProofResponse existProofV1(ExistProofRequest request){
        return new ExistProofResponse();
    }

    /**
     * get /V1/proofchain
     */
    public GetProofChainResponse getProofChain(GetProofRequest request){
        return new GetProofChainResponse();
    }

    /**
     * get /v1/proofchain/changes
     * @return
     */
    public GetProofChainResponse getProofChainChange(GetProofChainChangeRequest request){
        return new GetProofChainResponse();
    }
}
