package Notepad;
import java.awt.Font;
import javax.swing.JTextArea;
public class NPLineNumber extends JTextArea
{
    public static final long serialVersionUID = -10;
    public NPLineNumber()
    {
        super("1");
        setBackground(java.awt.Color.GRAY);
        setFont(new Font("Calibri",Font.PLAIN,18));
        setEditable(false);
    }
}
