package io.github.jast90.web.common.result;

public interface IResult {


    default  int getCode(){
        return 0;
    }

    default String getName(){
        return "";
    }
}
