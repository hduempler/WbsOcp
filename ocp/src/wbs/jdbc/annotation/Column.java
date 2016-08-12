package wbs.jdbc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Die Annotation wird in den Bytecode übertragen und kann zur Laufzeit
// über das Reflection-API abgefragt werden
@Retention(RetentionPolicy.RUNTIME)

// Die Annotation muss vor einem Feld der Klasse positioniert werden
@Target(ElementType.FIELD)
public @interface Column {

}
