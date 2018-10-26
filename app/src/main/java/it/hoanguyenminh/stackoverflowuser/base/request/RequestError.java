package it.hoanguyenminh.stackoverflowuser.base.request;

public class RequestError {
    public static final int UNKNOWN = -999;
    private int mErrorCode;
    private String mErrorMess;

    public RequestError() {
        this.mErrorCode = UNKNOWN;
        this.mErrorMess = "";
    }

    public static RequestError create() {
        RequestError ins = new RequestError();
        return ins;
    }

    public RequestError errorCode(int errorCode) {
        this.mErrorCode = errorCode;
        return this;
    }

    public RequestError errorMessage(String errorMess) {
        this.mErrorMess = errorMess;
        return this;
    }

    public int getErrorCode() {
        return mErrorCode;
    }

    public String getErrorMess() {
        return mErrorMess;
    }
}
