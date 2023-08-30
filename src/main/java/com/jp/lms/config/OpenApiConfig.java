package com.jp.lms.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 30 August 2023
 * @Project : lms
 */

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(name = "Joy Pedze",email = "joyp.pedze@gmail.com",url = "https://www.jp.com"),
                description = "Backend for Leave Management System",
                title = "Leave Management System",
                version = "1.0.0",
                termsOfService = "Terms of service",
                license = @License(name = "licence", url = "https://some-url.com")
        ),
        servers = {
                @Server(description = "LOCAL ENV", url = "http://localhost:8080"),
                @Server(description = "PROD ENV", url = "https://jp.com")
        }
)
public class OpenApiConfig {
}
