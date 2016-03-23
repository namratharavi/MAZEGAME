import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class client {

	public static void main(String[] args) 
	{
			String csvSplitBy = " ";
			int [][]digits = new int[150][5];
			int i = 0,k = 0,l = 0;
			BufferedReader fin = null;
				try
				{
					fin = new BufferedReader(new FileReader("C:\\Users\\dell\\college\\4th sem\\design patterns\\CreateMaze.txt"));
					String ch;
					while((ch = fin.readLine()) != null)
					{
						String []part = ch.split(csvSplitBy);
						for(int a = 0 ; a < part.length; a++)
						{
							digits[i][a]=Integer.parseInt(part[a]);
						}
						i++;
					}
				}

				catch(FileNotFoundException e)
				{
				System.out.println(e);
				}
				catch(IOException e)
				{
				System.out.println(e);
				}
				finally
				{
					if(fin != null)
					{
						try
						{
							fin.close();
						}
						catch(IOException e)
						{
							e.printStackTrace();
						}
					}
				}
				for(k=0; k<i;k++)
				{
					for(l=0;l<5;l++)
					{	
						System.out.print(digits[k][l]);
					}
					System.out.println();
				}
				System.out.println("Creating Maze");
				maze maze = new maze(digits,k);
				maze.createmaze();
				maze.traversemaze();
	}
}
