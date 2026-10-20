package cz.anderle.fabric.storage.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "cz.anderle.fabric.storage")
public class StorageProperties {

    private String discPath;
}
