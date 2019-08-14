import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.Scanner;
	import com.google.gson.Gson;
	import com.google.gson.GsonBuilder;
	import com.google.gson.JsonArray;
	import com.google.gson.JsonElement;
	import com.google.gson.JsonParser;
	
	
	public class lerGson {
	
		public static void main(String[] args) throws IOException {
	
			Scanner entrada = new Scanner(System.in);
			JsonParser jp = new JsonParser();
	
			System.out.print("Informe a quantidade de valores: ");
			int t = entrada.nextInt();
	
			int[] vet = new int[t];
	
			for (int i = 0; i < t; i++) {
				System.out.print("->");
				vet[i] = entrada.nextInt();
			}
	
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			FileWriter writer = new FileWriter("arrayjson.json");
			writer.write(gson.toJson(vet));
			writer.close();
			entrada.close();
	
			System.out.println(gson.toJson(vet));
	
			FileReader reader = new FileReader("arrayjson.json");
			Object obj = jp.parse(reader);
	
			System.out.println(obj);
	
			JsonArray employeeList = (JsonArray) obj;
	
			for (int i = 0; i< t; i++) {
	
				JsonElement aux = employeeList.get(i);
	            System.out.println(aux);
	
			}
	
		}
}