import javax.swing.SwingUtilities;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import javax.swing.JFrame;
import java.io.FileWriter;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
public class Notepad extends JFrame
{
	private static ToolBox toolbox;
	private final NPMenuBar menu;
//	private final static String WARNING_MSG = "1B[31m";
	private static final int height = 500;
	private static final int width = 700;
	public Notepad()
	{
		super("Notepad");
		toolbox = new ToolBox(width,height);
		menu = new NPMenuBar();
		setLayout(new BorderLayout());
		setJMenuBar(menu);
		add(toolbox,BorderLayout.CENTER);
		setSize(700,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(300,100);
		setVisible(true);
	}

	public static void openFile(String pathToFile,String fileName)
	{
		BufferedReader buffer = null;
		try
		{
			buffer = new BufferedReader(new java.io.FileReader(pathToFile));
			String str1 = "", str2 = "";
			while((str1 = buffer.readLine())!=null)
			{
				str2 += str1+"\n";
				toolbox.setText(str2);
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
	
	public static void saveFile(File file)
	{
		try
		{
			FileWriter fileWriter = new FileWriter(file);
			String txt = toolbox.getText();
			fileWriter.write(txt);
			fileWriter.close();
		}
		catch(Exception exec)
		{
			JOptionPane.showMessageDialog(null, exec,"Exception",JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public static void main(String args[])
	{
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run()
			{
				new Notepad();				
			}	
		});
	}
}
