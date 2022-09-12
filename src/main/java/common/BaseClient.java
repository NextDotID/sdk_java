package common;

import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URISyntaxException;

public class BaseClient {

    public BaseResponse get(URIBuilder uriBuilder, Service service) throws URISyntaxException, IOException {
        HttpClient client = ClientPool.getClient();
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setConfig(getRequestConfig(service));
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        return convertEntityToResponse(entity);
    }

    public BaseRequest post(){
        return null;
    }

    public RequestConfig getRequestConfig (Service service){
        return RequestConfig.custom().setConnectTimeout(service.getConnectTimeOut())
                .setConnectionRequestTimeout(service.getRequestTimeOut()).build();
    }

    public BaseResponse convertEntityToResponse(HttpEntity entity){
        return new BaseResponse();
    }
}
