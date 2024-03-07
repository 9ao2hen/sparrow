package com.mervyn.sparrow.config.expection;

/**
 * @author 2hen9ao
 * @date 2024/3/7 15:00
 */
public class SparrowException extends RuntimeException{

    private String code;
    private String message;
    private Object binding;

    public SparrowException() {
    }

    public SparrowException(String message) {
        super(message);
        this.message = message;
    }
    
    public SparrowException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }


    public SparrowException(Throwable cause) {
        super(cause);
    }

    public SparrowException(String message, Throwable cause) {
        super(message, cause);
        this.setMessage(message);
    }

    public SparrowException(String message, Throwable cause, Object binding) {
        this(message, cause);
        this.setBinding(binding);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetailMessage() {
        return super.getMessage();
    }

    public Object getBinding() {
        return this.binding;
    }

    public SparrowException setBinding(Object binding) {
        this.binding = binding;
        return this;
    }


}
