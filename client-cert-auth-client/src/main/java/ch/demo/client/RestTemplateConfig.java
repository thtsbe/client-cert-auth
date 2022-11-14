package ch.demo.client;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;

@Configuration
public class RestTemplateConfig {

    @Value("classpath:truststore.jks")
    Resource truststore;

    @Bean
    public RestTemplate restTemplate() throws Exception {
        char[] password = "changeit".toCharArray();

        SSLContext sslContext = SSLContextBuilder.create()
                //.loadKeyMaterial(keyStore("classpath:clientBobKeystore.jks", password), password)
                .loadTrustMaterial(truststore.getFile(), "changeit".toCharArray())
                // .loadTrustMaterial(null, new TrustSelfSignedStrategy()) // Alternative: simple without truststore
                .build();

        HttpClient client = HttpClients.custom().setSSLContext(sslContext).build();
        HttpComponentsClientHttpRequestFactory customRequestFactory = new HttpComponentsClientHttpRequestFactory();
        customRequestFactory.setHttpClient(client);
        return new RestTemplate(customRequestFactory);
    }

    private KeyStore keyStore(String file, char[] password) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        File key = ResourceUtils.getFile(file);
        try (InputStream in = new FileInputStream(key)) {
            keyStore.load(in, password);
        }
        return keyStore;
    }
}
