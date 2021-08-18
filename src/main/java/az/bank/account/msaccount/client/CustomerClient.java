package az.bank.account.msaccount.client;

import az.bank.account.msaccount.model.client.CustomerApiDto;
import az.bank.account.msaccount.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomerClient {
    private final RestTemplate restTemplate;
    private final String apiUrl;
    private static final Logger logger = LoggerFactory.getLogger(CustomerClient.class);

    public CustomerClient(RestTemplate restTemplate,
                          @Value("${client.customer.int.url}") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }

    public CustomerApiDto getCustomer(Long id) {
        String url = String.format("%s/%d", apiUrl, id);

        return restTemplate.getForObject(url, CustomerApiDto.class);
    }

    public CustomerApiDto createCustomer(CustomerApiDto customerDto) {
        return restTemplate.postForObject(apiUrl, customerDto,
                CustomerApiDto.class);
    }

}
