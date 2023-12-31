package indi.morven.QQbotApi.Token;

public class TokenResponse {
    private String access_token;
    private int expires_in;

    public TokenResponse() {
    }

    public TokenResponse(String access_token, int expires_in) {
        this.access_token = access_token;
        this.expires_in = expires_in;
    }

    /**
     * 获取
     * @return access_token
     */
    public String getAccess_token() {
        return access_token;
    }

    /**
     * 设置
     * @param access_token
     */
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    /**
     * 获取
     * @return expires_in
     */
    public int getExpires_in() {
        return expires_in;
    }

    /**
     * 设置
     * @param expires_in
     */
    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
