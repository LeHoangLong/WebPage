package com.kiti.configuration;

import javax.servlet.jsp.jstl.core.Config;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class SessionInitializer extends AbstractHttpSessionApplicationInitializer{
	public SessionInitializer() {
		super(Config.class);
	}
}
