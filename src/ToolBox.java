import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.Font;
public class ToolBox extends JTabbedPane
{
	private final Editor editor;
	private final JPanel editor_panel;
	private final JScrollPane scroll_panel;
	public ToolBox(int width,int height)
	{
		editor = new Editor(width,height);
		scroll_panel = new JScrollPane(editor);
		editor_panel = new JPanel();
		editor_panel.setLayout(null);
		editor_panel.add(scroll_panel);
		setBounds(0,30,700,400);
		add("untitled",scroll_panel);
	}
	public void setText(String text)
	{
		editor.setText(text);
	}
}

