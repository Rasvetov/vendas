package project.rasvetov.validation;

import project.rasvetov.validation.constraintvalidation.NotEmptyListValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
// annotation personalizada que impede que as listas sejam vazias
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = NotEmptyListValidator.class)
public @interface NotEmptyList{
    String message() default "A lista não pode ser vazia.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
