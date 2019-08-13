import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class criaHtml {

	public static void main(String[] args) throws IOException {
		 Scanner entrada = new Scanner(System.in);
		 
		    FileWriter arq = new FileWriter("Teste.html");
		    PrintWriter gravarArq = new PrintWriter(arq);
		    
		    System.out.print("Quantos Itens para o Gráfico? ");
		    int item = entrada.nextInt();
		    
		    entrada.nextLine();
		    System.out.print("Nome para o Gráfico? ");
		    String name = entrada.nextLine();
		    
		    String[] itens = new String[item];
		    float[] valores = new float[item];
		    
		    gravarArq.printf("<html><head><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script><script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart']});google.charts.setOnLoadCallback(drawChart);function drawChart() {var data = google.visualization.arrayToDataTable([['Tarefa', 'valor'],");
		    
		    
		    for(int f = 0; f < itens.length; f++) {
		    	System.out.print("Item "+f+" do gráfico : ");
		    	itens[f] = entrada.next();
		    	
		    	System.out.print("Valor "+f+" do gráfico : ");
		    	valores[f] = entrada.nextFloat();
		    	
		    }
		    
		    for (int x = 0; x < itens.length; x++) {
		    	if (x == (itens.length - 1)) {
		    		gravarArq.printf("['"+itens[x]+"',"+valores[x]+"]");
		    	} else {
		    		gravarArq.printf("['"+itens[x]+"',"+valores[x]+"],");
		    	}
		    }
		    
		    gravarArq.printf("]);var options = {title: '"+name+"'};var chart = new google.visualization.PieChart(document.getElementById('piechart'));chart.draw(data, options);}</script></head><body><div id=\"piechart\" style=\"width: 900px; height: 500px;\"></div></body></html>");
		 
		    arq.close();
		 
		    System.out.printf("Arquivo Criado com sucesso");
		    
		    entrada.close();
		  }
	}
