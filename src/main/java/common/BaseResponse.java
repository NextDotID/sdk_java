package common;

import lombok.Data;

@Data
public class BaseResponse {
    Error error;
    public static final BaseResponse empty = new BaseResponse();
    @Data
    static class Error {
        private String errorCode;
        private String errorMsg;
    }

    public BaseResponse error(String errorCode, String errorMsg){
        return this;
    }
    public boolean isError(){
        return error!= null;
    }


}
