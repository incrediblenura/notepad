import javax.swing.JTextArea;
import java.awt.Font;
public class Editor extends JTextArea
{
	public Editor(int width,int height)
	{
		setBounds(0,0,width,height);
		setFont(new Font("Consolas",Font.PLAIN,18));
	}
}
