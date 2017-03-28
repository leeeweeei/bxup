package com.bxup.bxup.constroller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.bxup.bxup.common.constant.CommonConstant;
import com.bxup.bxup.model.WelcomeIMG;
import com.bxup.bxup.service.WelcomeImgService;

@Controller
@RequestMapping(value = "/welcomeimg")
public class WeclomeImgController {

	static Logger log = Logger.getLogger(WeclomeImgController.class.getName());

	@Autowired
	private WelcomeImgService welcomeImgService;

	@RequestMapping(method = RequestMethod.GET)
	public String showAllWelcomeImg(Map<String, Object> mode) throws Exception {
		log.info("showAllWelcomeImg called");
		List<WelcomeIMG> welcomeIMG = welcomeImgService.findAll();
		mode.put("welcomePhoto", welcomeIMG);
		return "welcomePhoto";
	}

}
