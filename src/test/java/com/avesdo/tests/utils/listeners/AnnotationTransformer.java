/**
 * 
 */
package com.avesdo.tests.utils.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/**
 * @author Anil
 *
 */
public class AnnotationTransformer implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		//annotation.setRetryAnalyzer(Retry.class);
	}

}
