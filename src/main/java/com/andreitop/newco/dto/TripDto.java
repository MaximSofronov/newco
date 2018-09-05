package com.andreitop.newco.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.io.Serializable;

public class TripDto implements Serializable {

    private static final long serialVersionUID = 5914366185889783660L;

    private Long id;

    @NotNull
    @Pattern(regexp = "^[A-Z]{3}$", message = "Wrong origin")
    private String origin;

    @NotNull
    @Pattern(regexp = "^[A-Z]{3}$", message = "Wrong destination")
    private String destination;

    @Positive
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
