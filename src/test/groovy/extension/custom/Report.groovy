package extension.custom

import java.lang.annotation.*

import org.spockframework.runtime.extension.ExtensionAnnotation

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ExtensionAnnotation(ReportExtension)
@interface Report {}
