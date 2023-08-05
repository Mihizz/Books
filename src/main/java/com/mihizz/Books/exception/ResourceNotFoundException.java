package com.mihizz.Books.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String resourcesName;
    private String fieldName;
    private Long fieldValue;


    public ResourceNotFoundException(String resourcesName, String fieldName, Long fieldValue) {
        super(String.format("%s not found with %s: '%s'",resourcesName,fieldName,fieldValue)); // BOOK NOT FOUND WITH ID : 1
        this.resourcesName = resourcesName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourcesName() {
        return resourcesName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Long getFieldValue() {
        return fieldValue;
    }
}
