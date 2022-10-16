package common;

import com.alibaba.fastjson2.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class BaseClient {
    public BaseClient() {
    }

    private Env env;
    private static BaseClient productClient;
    private static BaseClient devClient;

    private BaseClient(Env env) {
        this.env = env;
    }

    public static BaseClient getProClient() {
        if (productClient == null) {
            productClient = new BaseClient(Env.production);
        }
        return productClient;
    }

    public static BaseClient getDevClient() {
        if (devClient == null) {
            devClient = new BaseClient(Env.development);
        }
        return devClient;
    }

    public BaseResponse get(URIBuilder uriBuilder, Service service, Class responseType) {
        uriBuilder.setPath(env.getUrlPrefix());
        try {
            HttpGet request = new HttpGet(uriBuilder.build());
            request.setConfig(getRequestConfig(service));
            return doHttp(request, responseType);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return BaseResponse.empty;
    }

    public BaseResponse post(URIBuilder uriBuilder, Service service, Class responseType) {
        uriBuilder.setPath(env.getUrlPrefix());
        try {
            HttpPost request = new HttpPost(uriBuilder.build());
            request.setConfig(getRequestConfig(service));
            return doHttp(request, responseType);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new BaseResponse();
    }

    public BaseResponse doHttp(HttpRequestBase request, Class responseType) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(request);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            return convertEntityToResponse(EntityUtils.toString(entity), responseType);
        }
        return null;
    }


    public RequestConfig getRequestConfig(Service service) {
        return RequestConfig.custom().setConnectTimeout(service.getConnectTimeOut())
                .setConnectionRequestTimeout(service.getRequestTimeOut()).build();
    }

    public BaseResponse convertEntityToResponse(String result, Class responseType) {
        BaseResponse response = (BaseResponse) JSONObject.parseObject(result, responseType);
        return response;
    }
}
