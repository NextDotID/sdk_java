package proofservice;


import com.google.gson.Gson;
import common.BaseClient;
import common.BaseResponse;
import common.Env;
import common.ParamChecker;
import org.apache.http.client.utils.URIBuilder;
import proofservice.request.*;
import proofservice.response.*;

import java.net.URISyntaxException;

import static common.Service.PROOF_SERVICE;

public class ProofClient extends BaseClient {
    private static final Gson gson = new Gson();

    public ProofClient(Env env) {
        setEnv(env);
    }

    private static ProofClient productClient;
    private static ProofClient stagClient;

    public static ProofClient getProdClient() {
        if (productClient == null) {
            productClient = new ProofClient(Env.PF_PROD);
        }
        return productClient;
    }

    public static ProofClient getStagClient() {
        if (stagClient == null) {
            stagClient = new ProofClient(Env.PF_STAG);
        }
        return stagClient;
    }

    public HealthResponse getHealth() {
        URIBuilder uriBuilder;
        try {
            uriBuilder = new URIBuilder(getEnv().getUrlPrefix());
            uriBuilder.setPath("/healthz");
            return (HealthResponse) get(uriBuilder, PROOF_SERVICE, HealthResponse.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new HealthResponse();
    }

    /**
     * POST /v1/proof/payload
     * get payload for signature
     */
    public ProofPayloadResponse payLoadProofV1(PayLoadProofRequest request) {
        ParamChecker.checkParam(request);
        URIBuilder uriBuilder;
        try {
            uriBuilder = new URIBuilder(getEnv().getUrlPrefix());
            String body = gson.toJson(request);
            uriBuilder.setPath("/v1/proof/payload");
            return (ProofPayloadResponse) post(uriBuilder, PROOF_SERVICE, ProofPayloadResponse.class, body);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new ProofPayloadResponse();
    }

    /**
     * modified proof
     * 1.findPrevious proof
     * 2.validate proof (platform validate )
     * 3.create Proof from platform Validatetor
     * post v1/proof
     */
    public BaseResponse postProofV1(ProofUploadRequest request) {
        ParamChecker.checkParam(request);
        URIBuilder uriBuilder;
        try {
            uriBuilder = new URIBuilder(getEnv().getUrlPrefix());
            String body = gson.toJson(request);
            uriBuilder.setPath("v1/proof");
            return post(uriBuilder, PROOF_SERVICE, BaseResponse.class, body);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new BaseResponse();
    }

    /**
     * query existed binding
     * get v1/proof
     */
    public GetProofResponse getProofV1(GetProofRequest request) {
        ParamChecker.checkParam(request);
        ParamChecker.checkParam(request);
        URIBuilder uriBuilder;
        try {
            uriBuilder = new URIBuilder(getEnv().getUrlPrefix());
            uriBuilder.setParameter("platform", request.getPlatform().name());
            uriBuilder.setParameter("identity", request.getIdentity());
            uriBuilder.setParameter("page", String.valueOf(request.getPage()));
            uriBuilder.setPath("v1/proof");
            return (GetProofResponse) get(uriBuilder, PROOF_SERVICE, GetProofResponse.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new GetProofResponse();

    }

    /**
     * get /v1/proof/exist
     */
    public ExistProofResponse existProofV1(ExistProofRequest request) {
        ParamChecker.checkParam(request);
        URIBuilder uriBuilder;
        try {
            uriBuilder = new URIBuilder(getEnv().getUrlPrefix());
            uriBuilder.setParameter("platform", request.getPlatform().name());
            uriBuilder.setParameter("identity", request.getIdentity());
            uriBuilder.setParameter("public_key", request.getPublicKey());
            uriBuilder.setPath("/v1/proof/exists");
            return (ExistProofResponse) get(uriBuilder, PROOF_SERVICE, ExistProofResponse.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new ExistProofResponse();
    }

    /**
     * get /V1/proofchain
     */
    public GetProofChainResponse getProofChain(GetProofChainRequest request) {
        ParamChecker.checkParam(request);
        URIBuilder uriBuilder;
        try {
            uriBuilder = new URIBuilder(getEnv().getUrlPrefix());
            uriBuilder.setParameter("public_key", request.getPublicKey());
            uriBuilder.setParameter("page", String.valueOf(request.getPage()));
            uriBuilder.setPath("/v1/proofchain");
            return (GetProofChainResponse) get(uriBuilder, PROOF_SERVICE, GetProofChainResponse.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new GetProofChainResponse();
    }

    /**
     * get /v1/proofchain/changes
     */
    public GetProofChainChangeResponse getProofChainChange(GetProofChainChangeRequest request) {
        URIBuilder uriBuilder;
        try {
            uriBuilder = new URIBuilder(getEnv().getUrlPrefix());
            uriBuilder.setParameter("last_id", String.valueOf(request.getLastId()));
            uriBuilder.setParameter("count", String.valueOf(request.getCount()));
            uriBuilder.setPath("/v1/proofchain/changes");
            return (GetProofChainChangeResponse) get(uriBuilder, PROOF_SERVICE, GetProofChainChangeResponse.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return new GetProofChainChangeResponse();
    }
}
