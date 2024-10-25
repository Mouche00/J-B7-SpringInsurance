package com.insurance.utils.records;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public record EntityId(@GeneratedValue(strategy = GenerationType.AUTO) UUID id) implements Serializable {
}
