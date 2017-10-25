package party.shaytang.search.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@EnableElasticsearchRepositories(basePackages = "party.shaytang.search.repositories")
public class ESConfig {
    private static String HOST = "localhost";
    private static int PORT = 9300;

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(getClient());
    }

    private Client getClient() {
        TransportClient client = null;
        try {
            InetSocketTransportAddress address = new InetSocketTransportAddress(
                    InetAddress.getByName(ESConfig.HOST), ESConfig.PORT);
            client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }
}
