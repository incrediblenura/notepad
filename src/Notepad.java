import javax.swing.SwingUtilities;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.io.FileWriter;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.UnsupportedLookAndFeelException;
public class Notepad extends JFrame
{
	private static ToolBox toolbox;
	private static NPFunctions funcs;
	private static final int height = 500;
	private static final int width = 700;
	public Notepad()
	{
		super("Notepad");
		try
		{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(ClassNotFoundException cnfe)
		{
			JOptionPane.showMessageDialog(null,"ClassNotFoundException",cnfe.getMessage(),JOptionPane.ERROR_MESSAGE);
		}catch(InstantiationException inse)
		{
			JOptionPane.showMessageDialog(null,"InstantiationException",inse.getMessage(),JOptionPane.ERROR_MESSAGE);
		}catch(IllegalAccessException ille)
		{
			JOptionPane.showMessageDialog(null,"IllegalAccessException",ille.getMessage(),JOptionPane.ERROR_MESSAGE);
		}catch(UnsupportedLookAndFeelException ulafe)
		{
			JOptionPane.showMessageDialog(null,"UnsupportedLookAndFeelException",ulafe.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
		toolbox = new ToolBox(width,height,JTabbedPane.TOP);
		funcs = new NPFunctions();
		setJMenuBar(new NPMenuBar());
		setLayout(new BorderLayout());
		add(toolbox);
		setSize(700,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setVisible(true);
	}
	public static void openFile(String pathToFile,String fileName)
	{
		funcs.openFile(pathToFile,fileName,toolbox.getEditor());
	}
	public static void saveFile(File pathToFile)
	{
		funcs.saveFile(pathToFile,toolbox.getEditor());
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
