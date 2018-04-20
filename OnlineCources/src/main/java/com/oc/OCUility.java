package com.oc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class OCUility {

	@Autowired
	public MessageSource ms;
	
	public String getMessage(String key, Object[] args) {
		return ms.getMessage(key, args, LocaleContextHolder.getLocale()); 
	}
}
