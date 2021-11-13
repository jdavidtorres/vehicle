package co.com.jdti.tech.vehicleapi.services;

import co.com.jdti.tech.vehicleapi.model.entities.UserEntity;

public interface IUserServices {

    public UserEntity getUser(String email);

    public UserEntity addUser(UserEntity user);

    public void checkRoleUser(String roleName);

    public void addUserToRole(UserEntity user, String role);

    public Boolean isUserInRole(UserEntity user, String role);
}
