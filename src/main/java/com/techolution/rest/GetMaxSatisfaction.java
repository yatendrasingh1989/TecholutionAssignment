package com.techolution.rest;

import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techolution.dto.RestaurantData;
import com.techolution.util.RestaurantFileUtil;
@RestController
@RequestMapping("/satisfaction")
public class GetMaxSatisfaction {
	
	@Autowired
	RestaurantFileUtil restaurantFileUtil;
	@Value("${file.location}")
	String location;
	
	private static Logger log= LoggerFactory.getLogger(GetMaxSatisfaction.class);
	
	@RequestMapping(method = RequestMethod.GET, value="/getMaxSatisfaction")
	public @ResponseBody String getMaxSatisfaction(){
		log.info("Reading file from location:"+location);
		List<RestaurantData> restaurantData= restaurantFileUtil.readFile(location);
		
		return "Maximum Satisfaction :"+ restaurantData.stream().max(new Comparator<RestaurantData>() {

			@Override
			public int compare(RestaurantData o1,RestaurantData o2) {
				return o1.getSatisfaction() .compareTo(o2.getSatisfaction());
			}
		}).get().getSatisfaction();
		
	}

	
}
