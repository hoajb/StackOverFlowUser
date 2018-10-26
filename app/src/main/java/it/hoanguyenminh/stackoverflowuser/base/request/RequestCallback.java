package it.hoanguyenminh.stackoverflowuser.base.request;

import it.hoanguyenminh.stackoverflowuser.model.BaseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RequestCallback<T extends BaseModel> implements Callback<T> {

    public abstract void onSuccess(T data);

    public abstract void onFailure(RequestError error);

    public abstract void onFinish();

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onSuccess(response.body());
        } else {
            onFailure(RequestError.create()
                    .errorCode(response.code())
                    .errorMessage(response.message()));
        }

        onFinish();
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onFailure(RequestError.create()
                .errorCode(RequestError.UNKNOWN)
                .errorMessage(t.getMessage()));
        onFinish();

    }
}
