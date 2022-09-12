package common;

public enum Service {
    KV_SERVICE(300,300),
    PROOF_SERVICE(300,300);

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
