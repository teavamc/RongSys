package com.ruoyi.village.domain;

/**
 * 村民数据统计的实体
 *
 * @author 张超
 * @date 2019-01-25
 */
public class Mcount {
    private static final long serialVersionUID = 1L;

    /** 地区分组 */
    private String marea;

    /** 村民总数 */
    private int msum;

    /** 男 */
    private int man;

    /** 女 */
    private int woman;

    public String getMarea() {
        return marea;
    }

    public void setMarea(String marea) {
        this.marea = marea;
    }

    public int getMsum() {
        return msum;
    }

    public void setMsum(int msum) {
        this.msum = msum;
    }

    public int getMan() {
        return man;
    }

    public void setMan(int man) {
        this.man = man;
    }

    public int getWoman() {
        return woman;
    }

    public void setWoman(int woman) {
        this.woman = woman;
    }
}
