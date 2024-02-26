package com.customerintelligence.mcg.pruebatecnica.model;


/**
 * @author Manuel Cortés Granados (manuelcortesgranados@gmail.com)
 * @since 26 Febrero 2024 5:27 AM GMT -5:00 Bogotá D.C. Colombia
 */
public class CustomResponse<T> {
    private boolean success;
    private T data;
    private String errorMessage;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
