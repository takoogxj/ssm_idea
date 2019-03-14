package pojo;

import java.util.ArrayList;
import java.util.List;

public class ResponseJsonResult {

    private int status= 200;
    private String msg;
    private Object object;
    private List list = new ArrayList<Object>();

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
