package com.example.test.product_info.page;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class ProductPage {
    private int pageNumber = 0;
    private int pageSize = 10;
    private String sortDirection = "asc";
    private String sortBy = "id";

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
