package cn.com.showings.pojo;

import java.io.Serializable;

public class SysStatus implements Serializable {

    private static final long serialVersionUID = 4696421741153001072L;

    public static final int AUDITING = 1;//审核中

    public static final int SUCCESS = 2;//审核通过

    public static final int REFUSE = 3;//审核拒绝

    public static final int CANCEL = 4;//申请取消

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public static String idToName(int status) {
        switch (status) {
            case AUDITING:
                return "正在审核";
            case SUCCESS:
                return "审核成功";
            case REFUSE:
                return "审核失败";
            case CANCEL:
                return "申请取消";
            default:
                return "未定义状态";
        }
    }


    @Override
    public String toString() {
        return "SysStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}