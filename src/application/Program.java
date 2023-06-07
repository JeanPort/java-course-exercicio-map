package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Program {

	public static void main(String[] args) {
		
		String path = "C:\\desenvoledor\\ws-eclipse\\course_exercicio_map\\teste.txt";
		Map<String, Integer> votes = new LinkedHashMap<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();

			while (line != null) {
				
				String[] vect = line.split(",");
				String name = vect[0];
				int numberVotes = Integer.parseInt(vect[1]);
				
				if (votes.containsKey(name)) {
					votes.put(name, votes.get(name) + numberVotes);
				} else {
					votes.put(name, numberVotes);
				}
				
			
				line = br.readLine();

			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		for (String key : votes.keySet()) {
			System.out.println(key + ": " + votes.get(key));
		}
	}

}
