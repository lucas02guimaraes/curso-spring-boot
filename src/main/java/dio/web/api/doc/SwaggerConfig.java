package dio.web.api.doc;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
public class SwaggerConfig {

    private Contact contato() {
        Contact contato = new Contact();
        contato.setName("Seu nome");
        contato.setUrl("http://www.seusite.com.br");
        contato.setEmail("voce@seusite.com.br");
        return contato;
    }

    private Info informacoesApi() {
        Info apiInfo = new Info()
                .title("Title - Rest API")
                .description("API exemplo de uso de Springboot REST API")
                .version("1.0")
                .termsOfService("Termos de uso: Open Source")
                .license(new io.swagger.v3.oas.models.info.License()
                        .name("Licença - Open Source")
                        .url("http://www.seusite.com.br"))
                .contact(this.contato());
        return apiInfo;
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .packagesToScan("dio.web.api.controller") // Substitua pelo seu pacote
                .addOpenApiCustomizer(openApi -> openApi.info(informacoesApi()))
                .build();
    }
}
