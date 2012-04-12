package com.brsanthu.dataexporter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.brsanthu.dataexporter.model.AlignType;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Column {
    String name() default Null;
    String title() default Null;
    Class type() default NullClass.class;
    int width() default -1;
    AlignType align() default AlignType.MIDDLE_LEFT;
    boolean skip() default false;
    
    public static final class NullClass{/*Empty class*/}
    public static final String Null = "null";
}
