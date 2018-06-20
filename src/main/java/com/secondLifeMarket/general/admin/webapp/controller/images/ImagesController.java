package com.secondLifeMarket.general.admin.webapp.controller.images;

import java.io.IOException;
import java.util.Random;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.secondLifeMarket.general.admin.manage.ImageManage;
import com.secondLifeMarket.general.admin.model.ImageInfo;

@Controller
public class ImagesController {
	
	@Autowired
	private ImageManage manage;



	@RequiresRoles("admin,superadmin,buyer")
	@RequestMapping("/uploadImage")
	@ResponseBody
	public Object upload(MultipartFile img) throws IOException{
		String imageName=String.format("%010d", new Random().nextInt(1000000));
		ImageInfo imageInfo = new ImageInfo();
		imageInfo.setImageName(imageName);
		imageInfo.setData(imageName);
		imageInfo.setImageByte(img.getBytes());
		manage.uploadImage(imageInfo);
		return imageInfo;
	}
	
	@RequestMapping("/downImages")
	@ResponseBody
	public Object sourceImg(String id){
		ImageInfo imageInfo = new ImageInfo();
		imageInfo = manage.getByName(id);
		return imageInfo.getImageByte();
	}
	

}
