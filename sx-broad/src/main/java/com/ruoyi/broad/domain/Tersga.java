package com.ruoyi.broad.domain;

/**
 * @author 张超 teavamc
 * @Description:按照终端地址进行运行状态的分组统计
 * @ClassName Tersga
 * @date 2019/1/25 19:57
 **/
public class Tersga {
    private static final long serialVersionUID = 1L;

    /** 分组名称 */
    private String aname;
    /** 总数 */
    private int sum;
    /** 运行数量 */
    private int run;
    /** 停止数量 */
    private int down;

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    @Override
    public String toString() {
        return "Tersga{" +
                "aname='" + aname + '\'' +
                ", sum=" + sum +
                ", run=" + run +
                ", down=" + down +
                '}';
    }
}
