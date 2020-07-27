import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
public class NPLineNumber extends JTextArea
{
	public NPLineNumber()
	{
		super("1");
		setFont(new Font("Consolas",Font.PLAIN,18));
		setBackground(Color.WHITE);
		setEditable(false);
	}
}