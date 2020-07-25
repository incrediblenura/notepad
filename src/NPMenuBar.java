import javax.swing.JMenuBar;
public class NPMenuBar extends JMenuBar
{
	private final NPMenu file_section;
	public NPMenuBar()
	{
		file_section = new NPMenu("File");
		setBounds(0,0,700,30);
		add("File",file_section);
	}
}
