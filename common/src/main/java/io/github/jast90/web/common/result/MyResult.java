package io.github.jast90.web.common.result;

public enum MyResult implements IResult {
    SUCCESS(0),FAIL(-1),NO_RECODE(1);
    private int code;

    MyResult(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getName() {
        return this.name();
    }

    public void setCode(int code) {
        this.code = code;
    }


}
