/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.jsonpath;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jayway.jsonpath.Option;
import org.apache.camel.support.language.LanguageAnnotation;

/**
 * An annotation used to inject a <a href="http://commons.apache.org/jsonpath/">JsonPath</a> expression into a method
 * parameter when using <a href="http://camel.apache.org/bean-integration.html">Bean Integration</a>
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@LanguageAnnotation(language = "jsonpath", factory = JsonPathAnnotationExpressionFactory.class)
public @interface JsonPath {

    String value();

    /**
     * Whether to suppress exceptions such as PathNotFoundException
     */
    boolean suppressExceptions() default false;

    /**
     * Whether to allow in inlined simple exceptions in the JsonPath expression
     */
    boolean allowSimple() default true;

    /**
     * To configure the JsonPath options to use
     */
    Option[] options() default {};

    /**
     * The desired return type.
     */
    Class<?> resultType() default Object.class;

    /**
     * The name of the variable we want to apply the expression to.
     */
    String variableName() default "";

    /**
     * The name of the header we want to apply the expression to.
     */
    String headerName() default "";

    /**
     * The name of the exchange property we want to apply the expression to.
     */
    String propertyName() default "";
}
