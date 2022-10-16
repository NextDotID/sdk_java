package proofservice;

import com.alibaba.fastjson2.JSONObject;
import common.BaseClient;
import common.BaseResponse;
import common.Env;
import common.Service;
import org.apache.http.client.utils.URIBuilder;
import proofservice.request.*;
import proofservice.response.ExistProofResponse;
import proofservice.response.GetProofChainResponse;
import proofservice.response.GetProofResponse;
import proofservice.response.ProofPayloadResponse;

import static common.Service.PROOF_SERVICE;

public class ProofClient extends BaseClient {
    /**
     * POST /v1/proof/payload
     * get payload for signature
     */
    public ProofPayloadResponse payLoadProofV1(PayLoadProofRequest request){
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setParameter("action",request.getAction().name());
        uriBuilder.setParameter("platform",request.getPlatform().name());
        uriBuilder.setParameter("identity",request.getIdentity());
        uriBuilder.setParameter("public_key",request.getPublicKey());
        return (ProofPayloadResponse)post(uriBuilder, PROOF_SERVICE,ProofPayloadResponse.class);
    }

    /**
     * modified proof
     * 1.findPrevious proof
     * 2.validate proof (platform validate )
     * 3.create Proof from platform Validatetor
     * post v1/proof/post
     */
    public BaseResponse postProofV1(ProofUploadRequest request){
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setParameter("action",request.getAction().name());
        uriBuilder.setParameter("platform",request.getPlatform().name());
        uriBuilder.setParameter("identity",request.getIdentity());
        uriBuilder.setParameter("proof_location",request.getProofLocation());
        uriBuilder.setParameter("public_key",request.getPublicKey());
        uriBuilder.setParameter("extra", JSONObject.toJSONString(request.getExtra()));
        uriBuilder.setParameter("uuid",request.getUuid());
        uriBuilder.setParameter("created_at",request.getCreateAt());
        return post(uriBuilder, PROOF_SERVICE,BaseResponse.class);
    }

    /**
     * query existed binding
     *  get v1/proof
     */
    public GetProofResponse getProofV1(GetProofRequest request){
        URIBuilder uriBuilder = new URIBuilder();

        uriBuilder.setParameter("platform",request.getPlatform().name());
        uriBuilder.setParameter("identity",request.getIdentity());
        uriBuilder.setParameter("page",String.valueOf(request.getPage()));
        return (GetProofResponse)get(uriBuilder, PROOF_SERVICE,GetProofResponse.class);

    }

    /**
     * get /v1/proof/exist
     */
    public ExistProofResponse existProofV1(ExistProofRequest request){
        URIBuilder uriBuilder = new URIBuilder();

        uriBuilder.setParameter("platform",request.getPlatform().name());
        uriBuilder.setParameter("identity",request.getIdentity());
        uriBuilder.setParameter("public_key",request.getPublicKey());
        return (ExistProofResponse)get(uriBuilder, PROOF_SERVICE,ExistProofResponse.class);

    }

    /**
     * get /V1/proofchain
     */
    public GetProofChainResponse getProofChain(GetProofRequest request){
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setParameter("identity",request.getIdentity());
        uriBuilder.setParameter("page",String.valueOf(request.getPage()));
        return (GetProofChainResponse)get(uriBuilder, PROOF_SERVICE,GetProofChainResponse.class);
    }

    /**
     * get /v1/proofchain/changes
     * @return
     */
    public GetProofChainResponse getProofChainChange(GetProofChainChangeRequest request){
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setParameter("last_id",String.valueOf(request.getLastId()));
        uriBuilder.setParameter("count",String.valueOf(request.getCount()));
        return new GetProofChainResponse();
    }
}
