package br.com.Mod18.Annotations;

import java.lang.annotation.*;
import java.util.Collection;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.CONSTRUCTOR,ElementType.TYPE, ElementType.METHOD})
@Inherited
public @interface AnnotationsExample {
    long value();
    String[] nomes();

}
