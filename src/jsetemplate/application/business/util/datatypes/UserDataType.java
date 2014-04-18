package jsetemplate.application.business.util.datatypes;

import java.io.Serializable;

public class UserDataType implements Serializable {
    
    private String userId;
    
    private String email;
    
    private String password;
    
    private String name;
    
    private String surname;

    private UserRoleDataType role;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UserRoleDataType getRole() {
        return role;
    }

    public void setRole(UserRoleDataType role) {
        this.role = role;
    }
    
    @Override
    public String toString(){
        return this.userId;
    }
    
}
