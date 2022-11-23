
import com.google.gson.Gson;
import common.BaseResponse;

import common.constract.Action;
import common.constract.Platform;
import kvservice.KVClient;
import kvservice.request.KVPostRequest;
import kvservice.request.PayLoadKVRequest;
import kvservice.response.GetKVResponse;
import kvservice.response.PostKVPayloadResponse;
import proofservice.ProofClient;
import proofservice.request.*;
import proofservice.response.*;

public class DemoTest {

    public static void main(String[] args) {
        Gson gson = new Gson();
        PostKVPayloadResponse response = postKVPayloadV1();
        System.out.println(gson.toJson(response));
    }

    public static GetProofChainChangeResponse getProofChainChange() {
        ProofClient client = ProofClient.getStagClient();
        GetProofChainChangeRequest request = new GetProofChainChangeRequest();
        request.setLastId(203L);
        request.setCount(1);
        return client.getProofChainChange(request);
    }

    public static GetProofChainResponse getProofChain() {
        ProofClient client = ProofClient.getStagClient();
        GetProofChainRequest request = new GetProofChainRequest();
        request.setPublicKey("0x028c3cda474361179d653c41a62f6bbb07265d535121e19aedf660da2924d0b1e3");
        request.setPage(1);
        return client.getProofChain(request);
    }

    public static ExistProofResponse existProofV1() {
        ProofClient client = ProofClient.getStagClient();
        ExistProofRequest request = new ExistProofRequest();
        request.setPlatform(Platform.twitter);
        request.setIdentity("some_twitter_screenname");
        request.setPublicKey("0x04c7cacde73af939c35d527b34e0556ea84bab27e6c0ed7c6c59be70f6d2db59c206b23529977117dc8a5d61fa848f94950422b79d1c142bcf623862e49f9e6575");
        return client.existProofV1(request);

    }

    public static GetProofResponse getProof() {
        ProofClient devClient = ProofClient.getProdClient();
        GetProofRequest request = new GetProofRequest();
        request.setPlatform(Platform.twitter);
        request.setIdentity("my_twitter_screen_name");
        request.setPage(0);
        return devClient.getProofV1(request);
    }

    public static HealthResponse getHealth() {
        ProofClient devClient = ProofClient.getStagClient();
        return devClient.getHealth();
    }

    public static ProofPayloadResponse payLoadProofV1() {
        ProofClient devClient = ProofClient.getProdClient();
        PayLoadProofRequest request = new PayLoadProofRequest();
        request.setAction(Action.create);
        request.setPlatform(Platform.twitter);
        request.setIdentity("my_twitter_screen_name");
        request.setPublicKey("0x04c7cacde73af939c35d527b34e0556ea84bab27e6c0ed7c6c59be70f6d2db59c206b23529977117dc8a5d61fa848f94950422b79d1c142bcf623862e49f9e6575");
        return devClient.payLoadProofV1(request);
    }

    public static BaseResponse postProofV1() {
        ProofClient devClient = ProofClient.getProdClient();
        ProofUploadRequest request = new ProofUploadRequest();
        request.setAction(Action.create);
        request.setPlatform(Platform.twitter);
        request.setIdentity("my_twitter_screen_name");
        request.setProofLocation("1415362679095635970");
        request.setPublicKey("0x04c7cacde73af939c35d527b34e0556ea84bab27e6c0ed7c6c59be70f6d2db59c206b23529977117dc8a5d61fa848f94950422b79d1c142bcf623862e49f9e6575");
        request.setUuid("ed9f421d-92e1-4c80-9bff-8516ef46ff43");
        request.setCreateAt("1647332405");
        return devClient.postProofV1(request);
    }


    public static GetKVResponse getKV() {
                KVClient devClient = KVClient.getStagClient();
        return devClient.getKVV1("0x04c7cacde73af939c35d527b34e0556ea84bab27e6c0ed7c6c59be70f6d2db59c206b23529977117dc8a5d61fa848f94950422b79d1c142bcf623862e49f9e6575");
    }

    public static BaseResponse postKV() {
        KVClient devClient = KVClient.getStagClient();
        KVPostRequest request = new KVPostRequest();
        request.setAvatar("0x04c7cacde73af939c35d527b34e0556ea84bab27e6c0ed7c6c59be70f6d2db59c206b23529977117dc8a5d61fa848f94950422b79d1c142bcf623862e49f9e6575");
        request.setPlatform("nextid");
        request.setIdentity("0x04c7cacde73af939c35d527b34e0556ea84bab27e6c0ed7c6c59be70f6d2db59c206b23529977117dc8a5d61fa848f94950422b79d1c142bcf623862e49f9e6575");
        request.setUuid("40c13c92-31e5-40d1-aebb-143d8e5b9c5e");
        request.setCreateAt(1646983606L);
        request.setSignature("ew0KICAiYXZhdGFyIjogIjB4MDRjN2NhY2RlNzNhZjkzOWMzNWQ1MjdiMzRlMDU1NmVhODRiYWIyN2U2YzBlZDdjNmM1OWJlNzBmNmQyZGI1OWMyMDZiMjM1Mjk5NzcxMTdkYzhhNWQ2MWZhODQ4Zjk0OTUwNDIyYjc5ZDFjMTQyYmNmNjIzODYyZTQ5ZjllNjU3NSIsDQogICJwbGF0Zm9ybSI6ICJuZXh0aWQiLA0KICAiaWRlbnRpdHkiOiAiMHgwNGM3Y2FjZGU3M2FmOTM5YzM1ZDUyN2IzNGUwNTU2ZWE4NGJhYjI3ZTZjMGVkN2M2YzU5YmU3MGY2ZDJkYjU5YzIwNmIyMzUyOTk3NzExN2RjOGE1ZDYxZmE4NDhmOTQ5NTA0MjJiNzlkMWMxNDJiY2Y2MjM4NjJlNDlmOWU2NTc1IiwNCiAgInV1aWQiOiAiNDBjMTNjOTItMzFlNS00MGQxLWFlYmItMTQzZDhlNWI5YzVlIiwNCiAgImNyZWF0ZWRfYXQiOiAxNjQ2OTgzNjA2LA0KICAic2lnbmF0dXJlIjogIiIsDQogICJwYXRjaCI6IHsNCiAgICAgICJ0aGlzIjogImlzIiwNCiAgICAgICJhIjogInNhbXBsZSIsDQogICAgICAic3RydWN0dXJlIjogWyJpdCIsICJjb3VsZCIsICJiZSIsICJhbnkiLCAiSlNPTiJdLA0KICAgICAgImtleSI6IHsNCiAgICAgICAgInRvIjogew0KICAgICAgICAgICJkZWxldGUiOiBudWxsDQogICAgICAgIH0NCiAgICAgIH0NCiAgICB9DQp9");
        request.setPatch("patch");

        return devClient.postKVV1(request);
    }

    public static PostKVPayloadResponse postKVPayloadV1() {
        KVClient devClient = KVClient.getStagClient();
        PayLoadKVRequest request = new PayLoadKVRequest();
        request.setAvatar("0x04c7cacde73af939c35d527b34e0556ea84bab27e6c0ed7c6c59be70f6d2db59c206b23529977117dc8a5d61fa848f94950422b79d1c142bcf623862e49f9e6575");
        request.setPlatform("nextid");
        request.setIdentity("0x04c7cacde73af939c35d527b34e0556ea84bab27e6c0ed7c6c59be70f6d2db59c206b23529977117dc8a5d61fa848f94950422b79d1c142bcf623862e49f9e6575");
        request.setPatch("patch");
        return devClient.postKVPayloadV1(request);
    }

}
