import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
public class NPMenu extends JMenu implements ActionListener
{
	private final NPMenuItem open;
	private final NPMenuItem save;
	private final NPMenuItem exit;
	public NPMenu(String menu_title)
	{
		super(menu_title);
		open = new NPMenuItem("Open File...", KeyEvent.VK_O);
		open.addActionListener(this);
		save = new NPMenuItem("Save File...", KeyEvent.VK_S);
		save.addActionListener(this);
		exit = new NPMenuItem("Exit");
		exit.addActionListener(this);
		add(open);
		add(save);
		add(exit);
	}
	public void actionPerformed(java.awt.event.ActionEvent ae)
	{
		if(ae.getSource() == open)
		{
			//System.out.println("Hello World!");
			JFileChooser file_chooser = new JFileChooser();
			int outcome = file_chooser.showOpenDialog(this);
			if(outcome == JFileChooser.APPROVE_OPTION)
			{
				Notepad.openFile(file_chooser.getSelectedFile().getPath(),file_chooser.getSelectedFile().getName());
			}
		}
		else if(ae.getSource() == save)
		{
			JFileChooser fc = new JFileChooser();
			int outcome  = fc.showSaveDialog(this);
			Notepad.saveFile(fc.getSelectedFile());
		}
		else if(ae.getSource() == exit)
		{
			System.exit(0);
		}
	}		
}
