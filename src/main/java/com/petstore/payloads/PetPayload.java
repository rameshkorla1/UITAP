package com.petstore.payloads;

public class PetPayload {
	
	public static String pets(String id, String categoryid,String name,String categoryname, String tagsId, String tagName, String status)
	{
		String pets = "{\r\n" + 
				"  \"id\": "+id+",\r\n" + 
				"  \"category\": {\r\n" + 
				"    \"id\": "+categoryid+",\r\n" + 
				"    \"name\": \""+name+"\"\r\n" + 
				"  },\r\n" + 
				"  \"name\": \""+categoryname+"\",\r\n" + 
				"  \"photoUrls\": [\r\n" + 
				"    \" \"\r\n" + 
				"  ],\r\n" + 
				"  \"tags\": [\r\n" + 
				"    {\r\n" + 
				"      \"id\": "+tagsId+",\r\n" + 
				"      \"name\": \""+tagName+"\"\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"status\": \""+status+"\"\r\n" + 
				"}";
		return pets;
	}
	
	public static String pets()
	{
		String pets = "{\r\n" + 
				"  \"id\": 0,\r\n" + 
				"  \"category\": {\r\n" + 
				"    \"id\": 3,\r\n" + 
				"    \"name\": \"golden-retriever\"\r\n" + 
				"  },\r\n" + 
				"  \"name\": \"doggie\",\r\n" + 
				"  \"photoUrls\": [\r\n" + 
				"    \"string\"\r\n" + 
				"  ],\r\n" + 
				"  \"tags\": [\r\n" + 
				"    {\r\n" + 
				"      \"id\": 3,\r\n" + 
				"      \"name\": \"golden-retriever\"\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"status\": \"available\"\r\n" + 
				"}";
		return pets;
	}
	
	public static String deletePet(String id)
	{
		String pet ="";
		
		return pet;
	}

}
