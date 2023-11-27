package indi.morven.QQbotApi;

import indi.morven.QQbotApi.SendMsg.channelsMsg;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface QQbotAPI {
    String authorization = null;

    @POST("/send/message")
    Single<Response> sendMessage(@Body channelsMsg request);

}
