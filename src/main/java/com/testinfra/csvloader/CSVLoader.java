package com.testinfra.csvloader;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class CSVLoader {
	public static <T> List<T> loadObjectList(Class<T> type, String fileName) {
	    try {
	        CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
	        CsvMapper mapper = new CsvMapper();
	        File file = new ClassPathResource(fileName).getFile();
	        MappingIterator<T> readValues = 
	          mapper.reader(type).with(bootstrapSchema).readValues(file);
	        return readValues.readAll();
	    } catch (Exception e) {
	        System.out.println("Error occurred while loading object list from file " + fileName + ": "+e.getMessage());
	        return Collections.emptyList();
	    }
	}

	public static void main(String []a){
		testData();
		testDataTest();
	}

	private static void testData(){
		List<Data> dataList = loadObjectList(Data.class, "data.csv");
		System.out.println("Loaded data set: "+dataList.toString());
	}

	private static void testDataTest(){
		List<DataTest> dataList = loadObjectList(DataTest.class, "data-test.csv");
		processTransactions(dataList);
	}

	private static void processTransactions(List<DataTest> dataList){
		Map<String, List<Data>> testCaseMap = new HashMap<String, List<Data>>();
		for(DataTest dt:dataList){
			String tcId = dt.getId();
			if(!testCaseMap.containsKey(tcId)){
				List<Data> data = new ArrayList<Data>();
				data.add(dt.getDataModel());
				testCaseMap.put(tcId, data);
			}else{
				testCaseMap.get(tcId).add(dt.getDataModel());
			}
		}
		System.out.println(testCaseMap.toString());
	}
}
