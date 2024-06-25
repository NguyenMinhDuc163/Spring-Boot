package com.javweb.spring_boot_non_jwt.models;

import java.util.ArrayList;
import java.util.List;

public class ErroResponseDTO {
    private String error;
    private List<String> detail = new ArrayList<>();

    public String getError() {
        return error;
    }

    public List<String> getDetail() {
        return detail;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setDetail(List<String> detail) {
        this.detail = detail;
    }
}
