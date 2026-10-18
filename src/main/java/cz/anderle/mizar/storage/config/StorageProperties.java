package cz.anderle.mizar.storage.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@ConfigurationProperties(prefix = "storage")
public class StorageProperties {

    private String storagePath;
}
