package com.secondLifeMarket.general.admin.dao;

import com.secondLifeMarket.general.admin.model.ImageInfo;

public interface ImageDao {
	
  public int insertImages(ImageInfo info);
  
  public ImageInfo findImageByName(String name);
  
}
