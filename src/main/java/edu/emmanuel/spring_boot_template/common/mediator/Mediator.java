package edu.emmanuel.spring_boot_template.common.mediator;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class Mediator {

    private final Map<Class<?>, RequestHandler<?,?>> handlers;

    public Mediator(List<RequestHandler<?,?>> handlersList) {
        handlers = handlersList.stream().collect(Collectors.toMap(RequestHandler::getRequestType, Function.identity()));
    }

    @SuppressWarnings("unchecked")
    <R, T extends Request<R>> RequestHandler<T, R> getHandlerOfRequestClass(Class<T> clazz) {
        return Optional
                .ofNullable((RequestHandler<T, R>) handlers.get(clazz))
                .orElseThrow(() ->
                        new RuntimeException("No handler found for request type: " + clazz)
                );
    }

    @SuppressWarnings("unchecked")
    public <R, T extends Request<R>> R dispatch(T request) {
        RequestHandler<T, R> handler = getHandlerOfRequestClass(request.getClass());
        return handler.handle(request);
    }
}
