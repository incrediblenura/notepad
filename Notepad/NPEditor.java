package Notepad;
import javax.swing.JTextArea;
import java.awt.Font;
public class NPEditor extends JTextArea
{
    public static final long serialVersionUID = -11;
    public NPEditor()
    {
        setBackground(java.awt.Color.GRAY);
        setFont(new Font("Calibri",Font.PLAIN,18));
    }    
}
