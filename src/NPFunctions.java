import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
public class NPFunctions
{
	public void openFile(String pathToFile,String fileName,Editor editor)
	{
		BufferedReader buffer = null;
		try
		{
			buffer = new BufferedReader(new java.io.FileReader(pathToFile));
			String str1 = "", str2 = "";
			while((str1 = buffer.readLine())!=null)
			{
				str2 += str1+"\n";
				editor.setText(str2);
			}
			buffer.close();
		}
		catch(FileNotFoundException no_file_exc)
		{
			JOptionPane.showMessageDialog(null, no_file_exc,"FileNotFoundException",JOptionPane.WARNING_MESSAGE);
		}
		catch(IOException io_exc)
		{
			JOptionPane.showMessageDialog(null, io_exc,"IOException",JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void saveFile(File file,Editor editor)
	{
		try
		{
			FileWriter fileWriter = new FileWriter(file);
			String txt = editor.getText();
			fileWriter.write(txt);
			fileWriter.close();
		}
		catch(Exception exec)
		{
			JOptionPane.showMessageDialog(null, exec,"Exception",JOptionPane.WARNING_MESSAGE);
		}
	}

}