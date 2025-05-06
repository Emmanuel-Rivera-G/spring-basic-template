package edu.emmanuel.spring_boot_template.user.application.command.deleteUserById;

import edu.emmanuel.spring_boot_template.common.mediator.RequestHandler;
import edu.emmanuel.spring_boot_template.user.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteUserByIdHandler implements RequestHandler<DeleteUserByIdRequest, Void> {

    private final UserRepository userRepository;

    @Override
    public Void handle(DeleteUserByIdRequest request) {
        userRepository.deleteUserById(request.userId());

        return null;
    }

    @Override
    public Class<DeleteUserByIdRequest> getRequestType() {
        return DeleteUserByIdRequest.class;
    }
}
