package com.secondLifeMarket.general.admin.webapp.controller.goods;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.secondLifeMarket.general.admin.contents.UserAuthoritySubject;
import com.secondLifeMarket.general.admin.manage.DicManager;
import com.secondLifeMarket.general.admin.manage.GoodsManager;
import com.secondLifeMarket.general.admin.manage.UersBrowseRecordManager;
import com.secondLifeMarket.general.admin.model.DicInfo;
import com.secondLifeMarket.general.admin.model.GoodsInfo;
import com.secondLifeMarket.general.admin.model.User;
import com.secondLifeMarket.general.admin.model.UserBrowseRecordModel;
import com.secondLifeMarket.general.admin.util.framework.Page;
import com.secondLifeMarket.general.admin.webapp.controller.goods.searcher.GoodsSearcher;

@Controller
public class GoodsController {
	@Autowired
	private GoodsManager goodsManager;
	@Autowired
	private DicManager dicManager;
	@Autowired
	private UersBrowseRecordManager uersBrowseRecordManager;
	
	@RequestMapping(value="/goodsList",method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView goodsList(@ModelAttribute("goodsSearcher")GoodsSearcher goodsSearcher){
		ModelAndView modelAndView = new ModelAndView();
		Page<GoodsInfo> pageObj = goodsManager.seacherGoodsList(goodsSearcher);
		//加载数据字典
		List<DicInfo> areaList = new ArrayList<DicInfo>();
		List<DicInfo> goodsAttrList = new ArrayList<DicInfo>();
		areaList = dicManager.findDicValueByName("area");
		goodsAttrList = dicManager.findDicValueByName("goods_attr");
		
		modelAndView.setViewName("goodsPage");
		return modelAndView.addObject("pageObj",pageObj)
				           .addObject("areaList",areaList)
				           .addObject("goodsAttrList",goodsAttrList);
	}
	
	@RequestMapping(value="/manage",method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView goodsAdd(){
		ModelAndView modelAndView = new ModelAndView();
		GoodsInfo goodsInfo = new GoodsInfo();
		List<DicInfo> areaList = new ArrayList<DicInfo>();
		List<DicInfo> goodsAttrList = new ArrayList<DicInfo>();
		areaList = dicManager.findDicValueByName("area");
		goodsAttrList = dicManager.findDicValueByName("goods_attr");
		
		modelAndView.addObject("goodsInfo",goodsInfo);
		modelAndView.setViewName("goodsManagePage");
		return modelAndView
				.addObject("areaList",areaList)
		        .addObject("goodsAttrList",goodsAttrList);
	}
	
	@RequestMapping(value="/goodsAdd",method = {RequestMethod.GET,RequestMethod.POST})
	public Object goodsSave(@ModelAttribute("goodsInfo")GoodsInfo goodsInfo){
		goodsManager.goodsAdd(goodsInfo);
		return "redirect:/goodsList";
	}
	
	@RequestMapping("/goodsDetail")
	public Object goodsDetail(String id){
		ModelAndView model = new ModelAndView();
		GoodsInfo info =goodsManager.getGoodsDetailById(id);
		if(info!=null){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			UserBrowseRecordModel userBrowseRecord = new UserBrowseRecordModel();
			User user=UserAuthoritySubject.getAccountSubject();//取Session中的User
			userBrowseRecord.setUserName(user.getUserName());
			userBrowseRecord.setPassWd(user.getPassWd());
			userBrowseRecord.setGoodsId(id);
			userBrowseRecord.setGoodsName(info.getGoodsName());
			userBrowseRecord.setGoodsAttribute(info.getGoodsAttribute());
			userBrowseRecord.setGoodsOwner(info.getGoodsOwner());
			userBrowseRecord.setConnectWay(info.getGoodsOwnerConnectWay());
			userBrowseRecord.setGoodsPrice(info.getGoodsPrice());
			userBrowseRecord.setBrowerDate(df.format(new Date()));
			uersBrowseRecordManager.addUserBrowseRecod(userBrowseRecord);
		}
		model.setViewName("goodsDetailPage");
		model.addObject("info",info);
		return model;
		
	}
	
}
