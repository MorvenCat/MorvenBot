package indi.morven.QQbotApi;

import indi.morven.QQbotApi.SendMsg.channelsMsg;
import indi.morven.QQbotApi.SendMsg.dmsMsg;
import indi.morven.QQbotApi.SendMsg.groupsMsg;
import indi.morven.QQbotApi.SendMsg.userMsg;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;

public interface QQbotAPI {
    /**
     *
     */
    @POST("/app/getAppAccessToken")
    //获取token
    Call<Response> getAccessToken(@Body channelsMsg request);


    @POST("/channels/{channel_id}/messages")
        //文字子频道
    Call<channelsMsg> channelsMsg(@Body channelsMsg request, @Path("channel_id") String id);

    @POST("/v2/users/{openid}/messages")
        //单聊
    Call<Response> userMsg(@Body userMsg request, @Path("openid") String id);

    @POST("/v2/groups/{group_openid}/messages")
        //群聊
    Call<Response> groupsMsg(@Body groupsMsg request, @Path("group_openid") String id);

    @POST("/dms/{guild_id}/messages")
        //频道私信
    Call<Response> dmsMsg(@Body dmsMsg request, @Path("guild_id") String id);

}
