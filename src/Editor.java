import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
public class Editor extends JTextArea
{
	public Editor(int width,int height)
	{
		setTabSize(4);
		setBounds(0,0,width,height);
		setFont(new Font("Consolas",Font.PLAIN,18));
		//setColor(Color.WHITE);
		setBackground(Color.LIGHT_GRAY);
	}
}