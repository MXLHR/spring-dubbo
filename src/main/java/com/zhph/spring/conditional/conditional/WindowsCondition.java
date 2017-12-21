package com.zhph.spring.conditional.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		
		
		boolean isWindows = context.getEnvironment().getProperty("os.name").contains("Windows");
		return isWindows;
	}

}
