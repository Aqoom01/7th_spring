package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.CategoriesExistValidator;
import umc.study.validation.validator.CheckPageValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckPageValidator.class)
@Target( {ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER } )
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "해당하는 페이지 넘버는 올바르지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
