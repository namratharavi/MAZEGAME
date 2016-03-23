import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.*;
import java.lang.*;
import java.io.IOException;
import java.util.*;
public class maze 
{
	
	private int len = 0;
	private room []r;
	private int [][]rooms;
	public maze(int rooms[][],int len)
	{
		this.len = len;
		this.rooms=new int[len][5];
		for(int i = 0; i < len; i++) 
		{
            for(int j = 0; j < 5; j++) 
            {
                    this.rooms[i][j] = rooms[i][j];
            }
		}
		r = new room[len];
	}
	public void createmaze()
	{
		for(int i=0; i<len;i++)
        {
			this.makeroom(i);
        }
	}
	public void traversemaze()
	{
		String csvSplitBy = " ";
		int [][]travarr = new int[50][];
		int i = 0,k = 0,l = 0;
		BufferedReader fin = null;
			try
			{
				fin = new BufferedReader(new FileReader("C:\\Users\\kaushik srivatsav\\Downloads\\TraverseMaze.txt"));
				String ch;
				while((ch = fin.readLine()) != null)
				{
					String []part = ch.split(csvSplitBy);
					travarr[i] = new int[part.length]; 
					for(k = 0 ; k < part.length; k++)
					{
						travarr[i][k]=Integer.parseInt(part[k]);
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
			
      try
          {
          	PrintWriter ofile = new PrintWriter("destination.txt","UTF-8");
			int  x=0;
			int []destin = new int[i];
			for(int m=0; m<i;m++)
			{
				int strt = travarr[m][0];
				int temp, end = strt ,prsnt = strt;
				//System.out.print(prsnt);
				int []sides = gotoroom(strt-1);
				//System.out.print("ar "+travarr[m][0]+" rry");
				for(l=1;l<travarr[m].length;l++)
				{	
					//for(int j=1;j<5;j++)
					//{
					temp = prsnt;
					prsnt = sides[(travarr[m][l]+1)]; 
					//System.out.print(prsnt);
					//System.out.print("ar "+travarr[m][l]+" rry");
					//}
					if((prsnt-1)>=0)
					{
						end = prsnt;
						sides = gotoroom(prsnt-1);
					}
					else 
					{
						prsnt = temp; 
					}
				}
				//prsnt = sides[(travarr[k][l])+1];
				destin[x++] = end;
				System.out.println(end);
				ofile.println(end);
			}ofile.close();
			/*writetofile(destin,x);*/
		 }
		 catch(Exception e)
		 	{System.out.println(e);}
	}
	public int[] gotoroom(int roomno)
	{
		return r[roomno].getside();
	}
	public void makeroom(int x)
	{
		room rm = new room(rooms[x],x); 
		r[x] = rm;
	}
	/*public void writetofile(int[] dest, int len)
	{
		try
		{
			int i = 0;
			File file = new File("destination.txt");
			if(!file.exists())
				file.createNewFile();
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			while(i<len)
			{
				bw.write(dest[i]);
				i++;
			}
			bw.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}*/
}
