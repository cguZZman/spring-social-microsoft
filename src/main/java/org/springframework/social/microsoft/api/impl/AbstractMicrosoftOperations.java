package org.springframework.social.microsoft.api.impl;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.onedrive.api.resource.Resource;

public class AbstractMicrosoftOperations {
	
	protected final RestTemplate restTemplate;
	protected final boolean isAuthorized;
	private final static Log logger = LogFactory.getLog(AbstractMicrosoftOperations.class);

	protected AbstractMicrosoftOperations(RestTemplate restTemplate, boolean isAuthorized) {
		this.restTemplate = restTemplate;
		this.isAuthorized = isAuthorized;

		restTemplate.setErrorHandler(new DefaultResponseErrorHandler(){
			@Override
			public void handleError(ClientHttpResponse response) throws IOException {
				if (logger.isWarnEnabled()) {
					String bodyText = StreamUtils.copyToString(response.getBody(), Charset.defaultCharset());
					logger.warn("Microsoft API REST response body:" + bodyText);
				}
			}
		});
	}

	protected void requireAuthorization() {
		if (!isAuthorized) {
			throw new MissingAuthorizationException("microsoft");
		}
	}

	protected <T> T getEntity(String url, Class<T> type) {
		return restTemplate.getForObject(url, type);
	}

	@SuppressWarnings("unchecked")
	protected <T> T saveEntity(String url, T entity) {
		return (T) restTemplate.postForObject(url, entity, entity.getClass());
	}

	protected <T extends Resource> T saveEntity(String baseUrl, T entity) {

		String url;
		HttpMethod method;

		if (StringUtils.hasText(entity.getId())) {
			url = baseUrl + '/' + entity.getId();
			method = HttpMethod.PUT;
		} else {
			url = baseUrl;
			method = HttpMethod.POST;
		}

		@SuppressWarnings("unchecked")
		ResponseEntity<T> response = restTemplate.exchange(url, method, new HttpEntity<T>(entity),
				(Class<T>) entity.getClass());

		return response.getBody();
	}

	protected void deleteEntity(String baseUrl, Resource entity) {
		deleteEntity(baseUrl, entity.getId());
	}

	protected void deleteEntity(String baseUrl, String id) {
		restTemplate.delete(baseUrl + '/' + id);
	}

	protected <T> T patch(String url, Object request, Class<T> responseType) {
		ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.PATCH, new HttpEntity<Object>(request), responseType);
		return response.getBody();
	}

}
