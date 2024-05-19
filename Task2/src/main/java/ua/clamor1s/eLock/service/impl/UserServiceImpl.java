package ua.clamor1s.eLock.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.eLock.dto.request.UserRequest;
import ua.clamor1s.eLock.dto.response.UserResponse;
import ua.clamor1s.eLock.entity.User;
import ua.clamor1s.eLock.mapper.UserMapper;
import ua.clamor1s.eLock.repository.UserRepository;
import ua.clamor1s.eLock.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    @Override
    public User createUser(UserRequest userRequest) {
        User user = userMapper.userRequestToUserEntity(userRequest);
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User createUserIfNotExist(UserRequest userRequest) {
        boolean exist = userExistByEmail(userRequest.getEmail());
        if (exist) {
            return userRepository.findByEmail(userRequest.getEmail());
        }
        return createUser(userRequest);
    }

    @Transactional
    @Override
    public boolean userExistByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public UserResponse convertUserToUserResponse(User user) {
        return userMapper.userEntityToUserResponse(user);
    }
}
