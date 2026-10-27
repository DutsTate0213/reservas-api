package com.labtech.reservas.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.domain.Page;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(T data, PageMetadata page) {

    public record PageMetadata(int number, int size, long totalElements, int totalPages) {}

    public static <T> ApiResponse<T> of(T data) {
        return new ApiResponse<>(data, null);
    }

    public static <T> ApiResponse<List<T>> of(Page<T> page) {
        return new ApiResponse<>(page.getContent(), new PageMetadata(
                page.getNumber(), page.getSize(),
                page.getTotalElements(), page.getTotalPages()));
    }
}