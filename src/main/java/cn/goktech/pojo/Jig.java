package cn.goktech.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Jig {
    private String id;

    private String jigmc;

    private String jiglx;

    private String jigdh;

    private String jigjb;

    private String lianxr;

    private String lianxdh;

    private String xiangxdz;

    private BigDecimal jingd;

    private BigDecimal weid;

    private Object youb;

    private Object qiy;

    private String jianyms;

    private Object userid;

    private Date updatetime;

    private String suozqy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getJigmc() {
        return jigmc;
    }

    public void setJigmc(String jigmc) {
        this.jigmc = jigmc == null ? null : jigmc.trim();
    }

    public String getJiglx() {
        return jiglx;
    }

    public void setJiglx(String jiglx) {
        this.jiglx = jiglx == null ? null : jiglx.trim();
    }

    public String getJigdh() {
        return jigdh;
    }

    public void setJigdh(String jigdh) {
        this.jigdh = jigdh == null ? null : jigdh.trim();
    }

    public String getJigjb() {
        return jigjb;
    }

    public void setJigjb(String jigjb) {
        this.jigjb = jigjb == null ? null : jigjb.trim();
    }

    public String getLianxr() {
        return lianxr;
    }

    public void setLianxr(String lianxr) {
        this.lianxr = lianxr == null ? null : lianxr.trim();
    }

    public String getLianxdh() {
        return lianxdh;
    }

    public void setLianxdh(String lianxdh) {
        this.lianxdh = lianxdh == null ? null : lianxdh.trim();
    }

    public String getXiangxdz() {
        return xiangxdz;
    }

    public void setXiangxdz(String xiangxdz) {
        this.xiangxdz = xiangxdz == null ? null : xiangxdz.trim();
    }

    public BigDecimal getJingd() {
        return jingd;
    }

    public void setJingd(BigDecimal jingd) {
        this.jingd = jingd;
    }

    public BigDecimal getWeid() {
        return weid;
    }

    public void setWeid(BigDecimal weid) {
        this.weid = weid;
    }

    public Object getYoub() {
        return youb;
    }

    public void setYoub(Object youb) {
        this.youb = youb;
    }

    public Object getQiy() {
        return qiy;
    }

    public void setQiy(Object qiy) {
        this.qiy = qiy;
    }

    public String getJianyms() {
        return jianyms;
    }

    public void setJianyms(String jianyms) {
        this.jianyms = jianyms == null ? null : jianyms.trim();
    }

    public Object getUserid() {
        return userid;
    }

    public void setUserid(Object userid) {
        this.userid = userid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getSuozqy() {
        return suozqy;
    }

    public void setSuozqy(String suozqy) {
        this.suozqy = suozqy == null ? null : suozqy.trim();
    }
}