import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;


public class Sort_Input_Text_File {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList storewordlist=new ArrayList();
		
		ArrayList wrtlist=new ArrayList();
		
		try
		{
			FileInputStream fstream=new FileInputStream("file1.txt");
			DataInputStream in =new DataInputStream(fstream);
			BufferedReader br=new BufferedReader(new InputStreamReader(in));
			String strline;
			while((strline=br.readLine())!=null)
			{
				String[] s=strline.split("\\s");
				for (int i = 0; i < s.length; i++) {
					wrtlist.add(s[i]);
				}
				storewordlist.add(strline);
			}
			Collections.sort(wrtlist);
			PrintStream out=null;
			out=new PrintStream(new FileOutputStream("d:\\sortedfile.txt"));
			
			for (int i = 0; i < wrtlist.size(); i++) {
				out.println(wrtlist.get(i));
				out.print("");
				out.print("\n");
				
			}
		}catch(Exception e)
		{
			
		}

	}

}
