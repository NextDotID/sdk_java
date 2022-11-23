package common;

public enum Service {
    KV_SERVICE(10000,10000),
    PROOF_SERVICE(10000,10000);

    private final int connectTimeOut;
    private final int requestTimeOut;
    Service(int connectTimeOut, int requestTimeOut){
        this.connectTimeOut = connectTimeOut;
        this.requestTimeOut = requestTimeOut;

    }

    public int getConnectTimeOut() {
        return connectTimeOut;
    }

    public int getRequestTimeOut() {
        return requestTimeOut;
    }
}
