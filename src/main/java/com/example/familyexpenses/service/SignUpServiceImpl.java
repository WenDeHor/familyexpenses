package com.example.familyexpenses.service;


import com.example.familyexpenses.forms.UserForm;
import com.example.familyexpenses.model.Role;
import com.example.familyexpenses.model.State;
import com.example.familyexpenses.model.User;
import com.example.familyexpenses.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class SignUpServiceImpl implements SingUpService {

    private final UserRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    public SignUpServiceImpl(UserRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void singUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());

        User user = User.builder()
                .password(hashPassword)
//                .login(userForm.getLogin())
                .email(userForm.getEmail())
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();
        usersRepository.save(user);
    }
}
