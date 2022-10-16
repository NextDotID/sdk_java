package common;

public enum  Env {
    production("https://proof-service.next.id"),
    development("https://proof-service.nextnext.id");
    private final String urlPrefix;
     Env(String urlPrefix){
        this.urlPrefix = urlPrefix;
    }

    public String getUrlPrefix() {
        return urlPrefix;
    }
}
