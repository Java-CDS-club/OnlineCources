package com.oc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocket {

	private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Online Cources", "OC Documentation", "1.0", "urn:tos",
			new Contact("Suhail Mansoori", "", "9666919222"), "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	
	private static final Set<String> PUBLISER_CONSUMER = new HashSet<String>(Arrays.asList("application/xml","application/json"));

	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.consumes(PUBLISER_CONSUMER)
				.produces(PUBLISER_CONSUMER);
	}
}
