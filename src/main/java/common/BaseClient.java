package common;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class BaseClient {
    private static final Gson gson = new Gson();
    public BaseClient() {
    }

    private Env env;

    public Env getEnv() {
        return env;
    }

    public void setEnv(Env env) {
        this.env = env;
    }


    public BaseResponse get(URIBuilder uriBuilder, Service service, Class responseType) {
        try {
            HttpGet request = new HttpGet(uriBuilder.build());
            request.setConfig(getRequestConfig(service));
            return doHttp(request, responseType);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected BaseResponse post(URIBuilder uriBuilder, Service service, Class responseType, String body) {
        try {
            HttpPost request = new HttpPost(uriBuilder.build());
            request.setConfig(getRequestConfig(service));
            request.setEntity(new StringEntity(body));
            return doHttp(request, responseType);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public BaseResponse doHttp(HttpRequestBase request, Class responseType) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(request);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return convertEntityToResponse(EntityUtils.toString(entity), responseType);
            }
        } finally {
            response.close();
            client.close();
        }
        return null;
    }


    public RequestConfig getRequestConfig(Service service) {
        return RequestConfig.custom().setConnectTimeout(service.getConnectTimeOut())
                .setConnectionRequestTimeout(service.getRequestTimeOut()).build();
    }

    public BaseResponse convertEntityToResponse(String result, Class responseType){

        return (BaseResponse) gson.fromJson(result,responseType);
    }
}
