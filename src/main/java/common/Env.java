package common;

public enum Env {
    KV_PROD("https://kv-service.next.id"),
    KV_STAG("https://kv-service.nextnext.id"),
    PF_PROD("https://proof-service.next.id"),
    PF_STAG("https://proof-service.nextnext.id");
    private final String urlPrefix;
    Env(String urlPrefix){
        this.urlPrefix = urlPrefix;
    }

    public String getUrlPrefix() {
        return urlPrefix;
    }
}
