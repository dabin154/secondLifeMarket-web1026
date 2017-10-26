package com.secondLifeMarket.general.admin.manage.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secondLifeMarket.general.admin.dao.ImageDao;
import com.secondLifeMarket.general.admin.manage.ImageManage;
import com.secondLifeMarket.general.admin.model.ImageInfo;
@Service("ImageManage")
public class ImageManageImpl implements ImageManage{
	
	@Autowired
	private ImageDao dao;
	
	@Override
	public void uploadImage(ImageInfo info) {
		dao.insertImages(info);
	}

	@Override
	public ImageInfo getByName(String name) {
		
		return dao.findImageByName(name);
	}

}
