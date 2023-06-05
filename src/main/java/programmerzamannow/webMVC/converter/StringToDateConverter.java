package programmerzamannow.webMVC.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.pattern.Converter;
import lombok.extern.slf4j.Slf4j;
import java.util.Date;

@Component
@Slf4j
public class StringToDateConverter implements org.springframework.core.convert.converter.Converter<String,Date>{

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    @Nullable
    public Date convert(String source) {
        try {
          return dateFormat.parse(source);
        } catch (ParseException e) {
           log.warn("error convert date from string {}", source, e);
           return null;
        }
    }
    
    
}
