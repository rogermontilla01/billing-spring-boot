package com.billing.billing_system.service.DateService;

import java.text.ParseException;
import java.util.Date;

public interface DateService {
    Date getDate() throws ParseException;

    RemoteDate fallBack();
}
