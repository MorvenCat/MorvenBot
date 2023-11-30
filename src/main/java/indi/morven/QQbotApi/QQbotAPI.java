package indi.morven.QQbotApi;

import indi.morven.QQbotApi.SendMsg.channelsMsg;
import indi.morven.QQbotApi.SendMsg.dmsMsg;
import indi.morven.QQbotApi.SendMsg.groupsMsg;
import indi.morven.QQbotApi.SendMsg.userMsg;
import indi.morven.QQbotApi.Token.TokenRequest;
import indi.morven.QQbotApi.Token.TokenResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;

public interface QQbotAPI {
    /**
     *
     */
    //获取token
    @POST("/app/getAppAccessToken")
    Call<TokenResponse> getToken(@Body TokenRequest request);

    //文字子频道
    @POST("/channels/{channel_id}/messages")
    Call<channelsMsg> channelsMsg(@Body channelsMsg request, @Path("channel_id") String id);

    //单聊
    @POST("/v2/users/{openid}/messages")
    Call<Response> userMsg(@Body userMsg request, @Path("openid") String id);

    //群聊
    @POST("/v2/groups/{group_openid}/messages")
    Call<Response> groupsMsg(@Body groupsMsg request, @Path("group_openid") String id);

    //频道私信
    @POST("/dms/{guild_id}/messages")
    Call<Response> dmsMsg(@Body dmsMsg request, @Path("guild_id") String id);

}
