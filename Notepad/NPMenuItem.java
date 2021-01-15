package Notepad;

import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
public class NPMenuItem extends JMenuItem
{
    public static final long serialVersionUID = -14;
    /**
     * 
     * @param title
     * @return
     */
    public NPMenuItem(String title)
    {
        super(title);
    }
    public NPMenuItem(String title,String iconPath)
    {
        super(title);
        setIcon(new ImageIcon(this.getClass().getResource(iconPath)));
    }
}
