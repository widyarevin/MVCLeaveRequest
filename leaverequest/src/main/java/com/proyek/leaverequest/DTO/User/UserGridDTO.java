package com.proyek.leaverequest.DTO.User;

public class UserGridDTO {
    private String username;

    private String roleName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public UserGridDTO(String username, String roleName) {
        this.username = username;
        this.roleName = roleName;
    }

}
