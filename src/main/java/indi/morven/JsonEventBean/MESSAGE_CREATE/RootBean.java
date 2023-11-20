package indi.morven.JsonEventBean.MESSAGE_CREATE;

import com.google.gson.annotations.SerializedName;

public class RootBean {
    @SerializedName("op")
    private int op;
    @SerializedName("s")
    private int s;
    @SerializedName("t")
    private String t;
    @SerializedName("id")
    private String id;


    public RootBean() {
    }

    public RootBean(int op, int s, String t, String id) {
        this.op = op;
        this.s = s;
        this.t = t;
        this.id = id;
    }

    /**
     * 获取
     * @return op
     */
    public int getOp() {
        return op;
    }

    /**
     * 设置
     * @param op
     */
    public void setOp(int op) {
        this.op = op;
    }

    /**
     * 获取
     * @return s
     */
    public int getS() {
        return s;
    }

    /**
     * 设置
     * @param s
     */
    public void setS(int s) {
        this.s = s;
    }

    /**
     * 获取
     * @return t
     */
    public String getT() {
        return t;
    }

    /**
     * 设置
     * @param t
     */
    public void setT(String t) {
        this.t = t;
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    public String toString() {
        return "RootBean{op = " + op + ", s = " + s + ", t = " + t + ", id = " + id + "}";
    }
}
