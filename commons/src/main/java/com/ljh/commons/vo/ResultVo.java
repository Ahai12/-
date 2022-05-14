package com.ljh.commons.vo;

public class ResultVo {
    private int code;
    private String msg;
    private Object data;

    private ResultVo(){

    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 成功
     */
    public static ResultVo ok(String msg,Object data){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(200);
        resultVo.setMsg(msg);
        resultVo.setData(data);
        return resultVo;
    }

    public static ResultVo ok(String msg){

        return ResultVo.ok(msg,null);
    }


    public static ResultVo error(String msg){

        ResultVo resultVo = new ResultVo();
        resultVo.setCode(500);
        resultVo.setMsg(msg);

        return resultVo;
    }
}
