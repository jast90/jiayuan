package io.github.jast90.web.common.result;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Locale;

public class CommonResult<T> {

    @JsonIgnore
    private Locale locale;
    private int code;
    private String msg;
    private T data;
    /**
     * JSON 忽略
     */
    @JsonIgnore
    private IResult result;

    public CommonResult() {
    }

    public CommonResult(IResult result) {
        this.result = result;
        this.code = result.getCode();
        this.locale = Locale.getDefault();
        this.msg = SpringMessageLocator.getMessage(result.getName(),this.locale);
    }

    public CommonResult(IResult result, T data) {
        this(result);
        this.data = data;
    }

    public CommonResult(IResult result, Object[] param,T data) {
        this.result = result;
        this.code = result.getCode();
        this.locale = Locale.getDefault();
        this.msg = SpringMessageLocator.getMessage(result.getName(),param,this.locale);
        this.data = data;
    }



    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
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

    public IResult getResult() {
        return result;
    }

    public void setResult(IResult result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
