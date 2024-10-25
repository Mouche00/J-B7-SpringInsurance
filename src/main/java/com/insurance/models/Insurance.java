package com.insurance.models;

import com.insurance.utils.records.EntityId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "insurances")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")

public abstract class Insurance {

    @EmbeddedId
    private EntityId id;

    @NotBlank
    private String assetType;

    @NotNull
    private boolean riskFactor;

    @PastOrPresent
    private LocalDate validatedAt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "insurance", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Quote> quotes;

    public EntityId getId() {
        return id;
    }

    public void setId(EntityId id) {
        this.id = id;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public boolean isRiskFactor() {
        return riskFactor;
    }

    public void setRiskFactor(boolean riskFactor) {
        this.riskFactor = riskFactor;
    }

    public LocalDate getValidatedAt() {
        return validatedAt;
    }

    public void setValidatedAt(LocalDate validatedAt) {
        this.validatedAt = validatedAt;
    }

    public Set<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(Set<Quote> quotes) {
        this.quotes = quotes;
    }

    public Insurance(String assetType, boolean riskFactor, User user) {
        this.assetType = assetType;
        this.riskFactor = riskFactor;
        this.user = user;
    }

    public Insurance() {
    }
}
