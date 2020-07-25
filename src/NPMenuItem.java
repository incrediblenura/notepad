import javax.swing.JMenuItem;
public class NPMenuItem extends JMenuItem
{
	public NPMenuItem(String menu_title)
	{
		super(menu_title);
	}
	public NPMenuItem(String menu_title, int mnemonic_key)
	{
		super(menu_title);
		setMnemonic(mnemonic_key);
	}
}
