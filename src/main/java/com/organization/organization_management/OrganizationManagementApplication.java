package com.organization.organization_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = ContextStackAutoConfiguration.class)
@EnableSwagger2
public class OrganizationManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationManagementApplication.class, args);
	}

}
