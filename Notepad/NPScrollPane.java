package Notepad;
import javax.swing.JScrollPane;
public class NPScrollPane extends JScrollPane{
    public static final long serialVersionUID = -8;
    public NPScrollPane()
    {
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }
}
