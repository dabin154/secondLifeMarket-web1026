package com.secondLifeMarket.general.admin.manage;

import com.secondLifeMarket.general.admin.model.ImageInfo;

public interface ImageManage {
	
	public void uploadImage(ImageInfo info);
	
	public ImageInfo getByName(String name);

}
