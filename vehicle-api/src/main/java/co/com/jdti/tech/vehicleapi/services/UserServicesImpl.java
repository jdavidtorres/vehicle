package co.com.jdti.tech.vehicleapi.services;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.jdti.tech.vehicleapi.model.entities.Role;
import co.com.jdti.tech.vehicleapi.model.entities.UserEntity;
import co.com.jdti.tech.vehicleapi.repositories.IRoleRepository;
import co.com.jdti.tech.vehicleapi.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements IUserServices, UserDetailsService {

    private final IUserRepository iUserRepository;
    private final IRoleRepository iRoleRepository;
    private final BCryptPasswordEncoder encoder;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userLoaded = iUserRepository.findByEmail(username);
        return new User(userLoaded.getEmail(), userLoaded.getPassword(), true, true, true, true, new ArrayList<>());
    }

    @Transactional(readOnly = true)
    @Override
    public UserEntity getUser(String email) {
        return iUserRepository.findByEmail(email);
    }

    @Transactional
    @Override
    public UserEntity addUser(UserEntity user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return iUserRepository.save(user);
    }

    @Transactional
    @Override
    public void checkRoleUser(String roleName) {
        Role role = iRoleRepository.findByRoleName(roleName);
        if (role == null) {
            iRoleRepository.save(Role.builder().roleName(roleName).build());
        }
    }

    @Transactional
    @Override
    public void addUserToRole(UserEntity user, String roleName) {
        Role role = iRoleRepository.findByRoleName(roleName);
        user.setRole(role);
        iUserRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Boolean isUserInRole(UserEntity user, String roleName) {
        return iRoleRepository.findByRoleName(roleName).getUsers().contains(user);
    }
}
