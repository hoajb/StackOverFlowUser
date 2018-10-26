package it.hoanguyenminh.stackoverflowuser.base.request;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import it.hoanguyenminh.stackoverflowuser.BuildConfig;
import it.hoanguyenminh.stackoverflowuser.config.AppConfig;
import it.hoanguyenminh.stackoverflowuser.model.Reputations;
import it.hoanguyenminh.stackoverflowuser.model.Users;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class NetworkRequest {

    private static NetworkRequest _instance;

    public synchronized static NetworkRequest newInstance() {
        if (_instance == null) {
            init();
        }
        return _instance;
    }

    private static void init() {
        _instance = new NetworkRequest(AppConfig.BASE_URL);
    }

    public NetworkRequest(String baseUrl) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        clientBuilder.connectTimeout(60, TimeUnit.SECONDS);
        clientBuilder.readTimeout(60, TimeUnit.SECONDS);
        clientBuilder.writeTimeout(60, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            clientBuilder.addInterceptor(interceptor);
        }

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        Gson gson = gsonBuilder.create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(clientBuilder.build())
                .build();

        networkAPI = retrofit.create(NetworkAPI.class);
    }

    private NetworkAPI networkAPI;

    public NetworkAPI getNetworkAPI() {
        return networkAPI;
    }

    public interface NetworkAPI {
        @GET("users")
        Call<Users> getUsers(
                @Query("site") String site,
                @Query("pagesize") int pagesize,
                @Query("page") int page
        );

        @GET("users/{id}/reputation-history")
        Call<Reputations> getReputations(
                @Path("id") long id,
                @Query("site") String site,
                @Query("pagesize") int pagesize,
                @Query("page") int page
        );
    }
}
