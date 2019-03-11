package com.xiedang.www.utils.date;


import org.springframework.data.convert.Jsr310Converters;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateTimeUtil {


    public Date localDateTimeToDate(LocalDateTime source) {
        Jsr310Converters.DateToLocalDateTimeConverter instance = Jsr310Converters.DateToLocalDateTimeConverter.INSTANCE;
        return source == null ? null : Date.from(source.atZone(ZoneId.systemDefault()).toInstant());
    }

    public LocalDateTime dateTolocalDateTime(Date source) {
        return source == null ? null : LocalDateTime.ofInstant(source.toInstant(), ZoneId.systemDefault());
    }

}
