package com.secondLifeMarket.general.admin.webapp.controller.handle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HandleController {
	
//	private static final Logger logger = LoggerFactory.getLogger(HandleController.class); 
	
	@RequestMapping("/returnFirst")
	public Object returnFirst(){
		return "mainhandle";
	}
	
}
