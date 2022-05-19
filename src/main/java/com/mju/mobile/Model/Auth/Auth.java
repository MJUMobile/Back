package com.mju.mobile.Model.Auth;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Auth {
    @Id
    private String id;
    private String password;
}
