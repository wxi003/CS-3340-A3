// The main class for printing the output
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class mainPrim {
	public static void main (String[] args)
	{

		try {
			File file = new File(args[0]);
			Scanner myReader = new Scanner (file);

			String vString = myReader.nextLine();
			System.out.println(vString);

			int vertices = Integer.parseInt(vString);
			MSTPrim graph = new MSTPrim(vertices);
			String line;
			int v1, v2, weight;
			System.out.println("Input graph:");
			while(myReader.hasNext())
			{
				line = myReader.nextLine();
				StringTokenizer tok = new StringTokenizer (line);
				v1=Integer.parseInt(tok.nextToken());
				v2=Integer.parseInt(tok.nextToken());
				weight=Integer.parseInt(tok.nextToken());
				System.out.println(v1+" - "+v2+" weight: "+weight);
				graph.addEdge(v1, v2, weight);
			}
			
			System.out.println(" ");

			graph.MST();


		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		
	}



}
