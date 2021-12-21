package cn.zhiyucs.blog.exception;

import lombok.Data;

@Data
public class BlogException extends RuntimeException {
    private String msg;
    private int code = 500;

    public BlogException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BlogException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BlogException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BlogException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }
}