package com.techolution.util;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.techolution.dto.RestaurantData;
import com.techolution.rest.GetMaxSatisfaction;

@Component
public class RestaurantFileUtil {
	private static Logger log= LoggerFactory.getLogger(GetMaxSatisfaction.class);
	public List<RestaurantData> readFile(String location) {
		List<RestaurantData> restaturantData= new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(location))) {
			log.info("Finished file reading.");
			restaturantData=stream.map(line -> getRestaurantData(line)).collect(toList());
	} catch (IOException e) {
			log.error("Exception while reading file :"+e.getMessage());
		}
		return restaturantData;
	}
	private static RestaurantData getRestaurantData(String line){
		String [] linedata=line.split("\\s+");
		RestaurantData restaurantData = new RestaurantData();
		restaurantData.setSatisfaction(linedata[0]);
		restaurantData.setTimeTaken(linedata[1]);
		return restaurantData;	
	}
}
