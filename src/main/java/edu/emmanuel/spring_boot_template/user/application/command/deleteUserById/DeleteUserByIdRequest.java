package edu.emmanuel.spring_boot_template.user.application.command.deleteUserById;

import edu.emmanuel.spring_boot_template.common.mediator.Request;

public record DeleteUserByIdRequest(Long userId) implements Request<Void> {
}
