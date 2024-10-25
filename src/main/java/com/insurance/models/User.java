package com.insurance.models;

import com.insurance.utils.records.EntityId;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @EmbeddedId
    private EntityId id;

    @NotBlank(message = "{name.required}")
    private String name;

    @Email(message = "{email.invalid}")
    @NotBlank(message = "{email.required}")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "{password.required}")
    private String password;

    @NotNull(message = "{age.required}")
    @Min(value = 18, message = "{age.min}")
    private Integer age;

    @Pattern(regexp = "^(07|06|05)\\d{8}$\n", message = "{phone.invalid}")
    private String phone;

    private String address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Insurance> insurances;

    public EntityId getId() {
        return id;
    }

    public void setId(EntityId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(Set<Insurance> insurances) {
        this.insurances = insurances;
    }

    public User(String address, String phone, int age, String password, String email, String name) {
        this.address = address;
        this.phone = phone;
        this.age = age;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public User() {
    }
}
