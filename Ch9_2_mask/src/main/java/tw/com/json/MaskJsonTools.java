package tw.com.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.com.beans.Mask;

public class MaskJsonTools {

	private static String getTestJson() {
		String json = "{\r\n"
				+ "    \"type\": \"FeatureCollection\",\r\n"
				+ "    \"features\": [\r\n"
				+ "        {\r\n"
				+ "            \"type\": \"Feature\",\r\n"
				+ "            \"properties\": {\r\n"
				+ "                \"id\": \"5901010076\",\r\n"
				+ "                \"name\": \"榮星藥局\",\r\n"
				+ "                \"phone\": \"(02)27124696\",\r\n"
				+ "                \"address\": \"臺北市松山區南京東路４段１３３巷５弄１號\",\r\n"
				+ "                \"mask_adult\": 0,\r\n"
				+ "                \"mask_child\": 2490,\r\n"
				+ "                \"updated\": \"2022\\/03\\/09 22:53:23\",\r\n"
				+ "                \"available\": \"星期一上午看診、星期二上午看診、星期三上午看診、星期四上午看診、星期五上午看診、星期六上午看診、星期日上午看診、星期一下午看診、星期二下午看診、星期三下午看診、星期四下午看診、星期五下午看診、星期六下午看診、星期日下午看診、星期一晚上看診、星期二晚上看診、星期三晚上看診、星期四晚上看診、星期五晚上看診、星期六晚上看診、星期日晚上休診\",\r\n"
				+ "                \"note\": \"-\",\r\n"
				+ "                \"custom_note\": \"\",\r\n"
				+ "                \"website\": \"\",\r\n"
				+ "                \"county\": \"臺北市\",\r\n"
				+ "                \"town\": \"松山區\",\r\n"
				+ "                \"cunli\": \"東勢里\",\r\n"
				+ "                \"service_periods\": \"NNNNNNNNNNNNNNNNNNNNY\"\r\n"
				+ "            },\r\n"
				+ "            \"geometry\": {\r\n"
				+ "                \"type\": \"Point\",\r\n"
				+ "                \"coordinates\": [\r\n"
				+ "                    121.555235,\r\n"
				+ "                    25.052137\r\n"
				+ "                ]\r\n"
				+ "            }\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"type\": \"Feature\",\r\n"
				+ "            \"properties\": {\r\n"
				+ "                \"id\": \"5901010085\",\r\n"
				+ "                \"name\": \"安世藥局\",\r\n"
				+ "                \"phone\": \"(02)27133405\",\r\n"
				+ "                \"address\": \"臺北市松山區南京東路４段１３３巷５弄９號\",\r\n"
				+ "                \"mask_adult\": 750,\r\n"
				+ "                \"mask_child\": 1650,\r\n"
				+ "                \"updated\": \"2022\\/03\\/09 22:53:23\",\r\n"
				+ "                \"available\": \"星期一上午看診、星期二上午看診、星期三上午看診、星期四上午看診、星期五上午看診、星期六上午看診、星期日上午看診、星期一下午看診、星期二下午看診、星期三下午看診、星期四下午看診、星期五下午看診、星期六下午看診、星期日下午看診、星期一晚上看診、星期二晚上看診、星期三晚上看診、星期四晚上看診、星期五晚上看診、星期六晚上看診、星期日晚上休診\",\r\n"
				+ "                \"note\": \"09:00~22:00\",\r\n"
				+ "                \"custom_note\": \"\",\r\n"
				+ "                \"website\": \"\",\r\n"
				+ "                \"county\": \"臺北市\",\r\n"
				+ "                \"town\": \"松山區\",\r\n"
				+ "                \"cunli\": \"東勢里\",\r\n"
				+ "                \"service_periods\": \"NNNNNNNNNNNNNNNNNNNNY\"\r\n"
				+ "            },\r\n"
				+ "            \"geometry\": {\r\n"
				+ "                \"type\": \"Point\",\r\n"
				+ "                \"coordinates\": [\r\n"
				+ "                    121.555562,\r\n"
				+ "                    25.05214\r\n"
				+ "                ]\r\n"
				+ "            }\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"type\": \"Feature\",\r\n"
				+ "            \"properties\": {\r\n"
				+ "                \"id\": \"5901010094\",\r\n"
				+ "                \"name\": \"明一藥局\",\r\n"
				+ "                \"phone\": \"(02)27691654\",\r\n"
				+ "                \"address\": \"臺北市松山區南京東路５段５９巷２８弄２５號１樓\",\r\n"
				+ "                \"mask_adult\": 940,\r\n"
				+ "                \"mask_child\": 150,\r\n"
				+ "                \"updated\": \"2022\\/03\\/09 22:53:23\",\r\n"
				+ "                \"available\": \"星期一上午看診、星期二上午看診、星期三上午看診、星期四上午看診、星期五上午看診、星期六上午看診、星期日上午休診、星期一下午看診、星期二下午看診、星期三下午看診、星期四下午看診、星期五下午看診、星期六下午看診、星期日下午休診、星期一晚上看診、星期二晚上看診、星期三晚上看診、星期四晚上看診、星期五晚上看診、星期六晚上休診、星期日晚上休診\",\r\n"
				+ "                \"note\": \"AM10: ~~PM9:00\",\r\n"
				+ "                \"custom_note\": \"\",\r\n"
				+ "                \"website\": \"\",\r\n"
				+ "                \"county\": \"臺北市\",\r\n"
				+ "                \"town\": \"松山區\",\r\n"
				+ "                \"cunli\": \"東光里\",\r\n"
				+ "                \"service_periods\": \"NNNNNNYNNNNNNYNNNNNYY\"\r\n"
				+ "            },\r\n"
				+ "            \"geometry\": {\r\n"
				+ "                \"type\": \"Point\",\r\n"
				+ "                \"coordinates\": [\r\n"
				+ "                    121.558168,\r\n"
				+ "                    25.052704\r\n"
				+ "                ]\r\n"
				+ "            }\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}";
		return json;
	}
	
	
	public static void maskJsonToObject(String maskJson,Consumer<List<Mask>> callBack) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objMapper = new ObjectMapper();
		Map<String,Object> maskJsonMap = objMapper.readValue(maskJson, Map.class);
		List<Map<String,Object>> features = (List)maskJsonMap.get("features");
		List<Mask> listMask = new ArrayList<>();
		for (Map<String,Object> dataMap : features) {
			Map<String,Object> pMap =  (Map)dataMap.get("properties");
			//System.out.println(pMap);
//			System.out.println(pMap.get("id"));
//			System.out.println(pMap.get("name"));
			Mask mask = new Mask(pMap.get("id").toString(),
					pMap.get("name").toString(),
					pMap.get("mask_adult").toString(),
					pMap.get("mask_child").toString());
			//System.out.println(mask);
			listMask.add(mask);
		}
		callBack.accept(listMask);
		
	}
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		//maskJsonToObject(getTestJson());
		
	}
	
}
