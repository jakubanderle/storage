package cz.anderle.fabric.storage.client;

import cz.anderle.fabric.storage.client.invoker.ApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class StorageClientConfiguration {

    @Bean
    public ApiClient storageApiClient(@Value("${cz.anderle.fabric.storage.base-url}") String baseUrl) {
        ApiClient client = new ApiClient();
        client.setBasePath(baseUrl);
        return client;
    }
}
