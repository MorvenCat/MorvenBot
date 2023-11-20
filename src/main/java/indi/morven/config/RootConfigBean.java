package indi.morven.config;

public class RootConfigBean {
    private BaseConfigBean baseConfigBean;
    private AuthConfigBean authConfig;


    public RootConfigBean() {
        this.baseConfigBean = new BaseConfigBean();
        this.authConfig = new AuthConfigBean();
    }

    public RootConfigBean(BaseConfigBean baseConfigBean, AuthConfigBean authConfig) {
        this.baseConfigBean = baseConfigBean;
        this.authConfig = authConfig;
    }

    /**
     * 获取
     *
     * @return baseConfigBean
     */
    public BaseConfigBean getBaseConfigBean() {
        return baseConfigBean;
    }

    /**
     * 设置
     *
     * @param baseConfigBean
     */
    public void setBaseConfigBean(BaseConfigBean baseConfigBean) {
        this.baseConfigBean = baseConfigBean;
    }

    /**
     * 获取
     *
     * @return authConfig
     */
    public AuthConfigBean getAuthConfig() {
        return authConfig;
    }

    /**
     * 设置
     *
     * @param authConfig
     */
    public void setAuthConfig(AuthConfigBean authConfig) {
        this.authConfig = authConfig;
    }
}

