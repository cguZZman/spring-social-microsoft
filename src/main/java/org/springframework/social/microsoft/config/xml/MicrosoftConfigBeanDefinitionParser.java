package org.springframework.social.microsoft.config.xml;

import org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser;
import org.springframework.social.microsoft.config.support.MicrosoftApiHelper;
import org.springframework.social.microsoft.connect.MicrosoftConnectionFactory;
import org.springframework.social.microsoft.security.MicrosoftAuthenticationService;
import org.springframework.social.security.provider.SocialAuthenticationService;

public class MicrosoftConfigBeanDefinitionParser extends AbstractProviderConfigBeanDefinitionParser {

	protected MicrosoftConfigBeanDefinitionParser() {
		super(MicrosoftConnectionFactory.class, MicrosoftApiHelper.class);
	}

	@Override
	protected Class<? extends SocialAuthenticationService<?>> getAuthenticationServiceClass() {
		return MicrosoftAuthenticationService.class;
	}
	
}
