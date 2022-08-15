package com.billing.billing_system.service.DateService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class DateServiceImp implements DateService {

    private final WebClient webClient;

    public Date getDate() throws ParseException {
        RemoteDate remoteDate = webClient.get()
                .uri("http://worldclockapi.com/api/json/utc/now")
                .retrieve()
                .bodyToMono(RemoteDate.class)
                .timeout(Duration.ofSeconds(15))
                .onErrorReturn(fallBack())
                .block();

        assert remoteDate != null;
        String remoteDateResult = remoteDate.getCurrentDateTime();
        return new SimpleDateFormat("yyyy-MM-dd'T'mm:ss'Z'").parse(remoteDateResult);

    }

    public RemoteDate fallBack() {
        String dateFormated = new SimpleDateFormat("yyyy-MM-dd'T'mm:ss'Z'").format(new Date());
        RemoteDate remoteDate = new RemoteDate();
        remoteDate.setCurrentDateTime(dateFormated);

        return remoteDate;
    }

}
