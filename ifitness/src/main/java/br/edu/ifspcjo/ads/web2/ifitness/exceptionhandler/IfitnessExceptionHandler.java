
package br.edu.ifspcjo.ads.web2.ifitness.exceptionhandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class IfitnessExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    public IfitnessExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
        String userMessage = messageSource.getMessage(
            "invalid.message", null, LocaleContextHolder.getLocale());
        String developerMessage = ex.getCause() != null
            ? ex.getCause().toString()
            : ex.toString();

        return handleExceptionInternal(ex,
            new ErrorMessage(userMessage, developerMessage),
            headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
        List<ErrorMessage> errors = createErrorList(ex.getBindingResult());
        return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
    }

    private List<ErrorMessage> createErrorList(BindingResult bindingResult) {
        List<ErrorMessage> errors = new ArrayList<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String userMessage = getUserMessage(fieldError);
            String developerMessage = fieldError.getField() + ": "
                + fieldError.getDefaultMessage().replace("{0}",
                    messageSource.getMessage("user." + fieldError.getField(),
                        null, LocaleContextHolder.getLocale()));
            errors.add(new ErrorMessage(userMessage, developerMessage));
        }
        return errors;
    }

    private String getUserMessage(FieldError fieldError) {
        String fieldLabel = messageSource.getMessage(
            "user." + fieldError.getField(), null, LocaleContextHolder.getLocale());
        String code = fieldError.getCode();

        if ("NotNull".equals(code) || "NotBlank".equals(code)) {
            return fieldLabel + " é obrigatório(a)";
        }
        if ("Size".equals(code)) {
            Integer max = null;
            Integer min = null;
            for (Object argument : fieldError.getArguments()) {
                if (argument instanceof Integer value) {
                    if (max == null) {
                        max = value;
                    } else {
                        min = value;
                    }
                }
            }
            if (min != null && max != null) {
                return fieldLabel + " deve ter o tamanho entre " + min + " e " + max;
            }
        }
        if ("Email".equals(code)) {
            return fieldLabel + " deve ter um formato válido";
        }
        if ("Past".equals(code)) {
            return fieldLabel + " deve ser uma data no passado";
        }
        return messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
    }

    public static class ErrorMessage {

        private final String userMessage;
        private final String developerMessage;

        public ErrorMessage(String userMessage, String developerMessage) {
            this.userMessage = userMessage;
            this.developerMessage = developerMessage;
        }

        public String getUserMessage() {
            return userMessage;
        }

        public String getDeveloperMessage() {
            return developerMessage;
        }
    }
}
