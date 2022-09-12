package common;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

public class ClientPool {
    public static HttpClient getClient(){
        return HttpClients.createDefault();
    }

}
