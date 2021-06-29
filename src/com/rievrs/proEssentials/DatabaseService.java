package com.rievrs.proEssentials;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.rievrs.proEssentials.Users;

public class DatabaseService {
	
	
	public static void main(String args[]) throws IOException {
		
		File file = new File("../ProEssentials");
		Gson gson = new Gson();
		
		file.mkdir();
		
		JsonReader jsonReader = new JsonReader(new FileReader("../ProEssentials/user.json"));
		
		Map<String, Object> inFile = gson.fromJson(jsonReader, new TypeToken<HashMap<String, Object>>() {}.getType());

		if(inFile == null) {
			inFile = new HashMap<String, Object>();
		}
		
		Users user = new Users("John3 Deo", "john.doe@example.com", new String[]{"Member", "Admin"}, true);
		inFile.put("Teste", user);
		
		
		
		    // create a writer
		    Writer writer = new FileWriter("../ProEssentials/user.json");

		    // convert map to JSON File
		    gson.toJson(inFile, writer);

		    // close the writer
		    writer.close();
	}
	
}
