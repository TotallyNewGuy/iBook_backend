package com.project.iBook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private boolean success;

    private int code;

    private String msg;

    private Object data;

    // process success
    public static Result success(Object data) {
        return new Result(true, 200, "success", data);
    }

    // process fail
    public static Result fail(int code, String msg) {
        return new Result(false, code, msg, null);
    }

    public boolean isSuccess() {
        return success;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Result)) {
            return false;
        }
        Result compare = (Result) obj;
        return this.getData() == compare.getData() &&
                this.getCode() == compare.getCode() &&
                this.getMsg().equals(compare.getMsg()) &&
                this.isSuccess() == compare.isSuccess();
    }
}
