package co.com.jdti.tech.vehicleapi.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.com.jdti.tech.vehicleapi.model.entities.UserEntity;

@Service
public class UserServicesImpl implements IUserServices, UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public UserEntity getUser(String email) {
        return null;
    }

    @Override
    public UserEntity addUser(UserEntity user) {
        return null;
    }

    @Override
    public void checkRoleUser(String roleName) {

    }

    @Override
    public void addUserToRole(UserEntity user, String role) {

    }

    @Override
    public Boolean isUserInRole(UserEntity user, String role) {
        return null;
    }
}
