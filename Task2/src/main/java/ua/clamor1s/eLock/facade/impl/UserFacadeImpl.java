package ua.clamor1s.eLock.facade.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.clamor1s.eLock.dto.request.UserRequest;
import ua.clamor1s.eLock.dto.response.UserResponse;
import ua.clamor1s.eLock.entity.User;
import ua.clamor1s.eLock.facade.UserFacade;
import ua.clamor1s.eLock.service.UserService;

@Component
@RequiredArgsConstructor
public class UserFacadeImpl implements UserFacade {
    private final UserService userService;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = userService.createUser(userRequest);
        return userService.convertUserToUserResponse(user);
    }
}
