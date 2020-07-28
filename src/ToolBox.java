import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.text.Element;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
public class ToolBox extends JTabbedPane
{
	private Editor editor;
	private JPanel panel;
	private NPLineNumber lines;
	private JScrollPane scroll_panel;
	public ToolBox(int width,int height,int tabpos)
	{
		super(tabpos);
		setLayout(new BorderLayout());
		editor = new Editor(width,height);
		editor.getDocument().addDocumentListener(
			new DocumentListener()
			{
				public String getText()
				{
					int caretPosition = editor.getDocument().getLength();
					Element root = editor.getDocument().getDefaultRootElement();
					String text = "1" + System.getProperty("line.separator");
					for(int i = 2; i < root.getElementIndex(caretPosition) + 2; i++)
					{
						text += i + System.getProperty("line.separator");
					}
					return text;	
				}
				@Override
				public void changedUpdate(DocumentEvent de)
				{
					lines.setText(getText());
				}
				@Override
				public void insertUpdate(DocumentEvent de)
				{
					lines.setText(getText());
				}
				@Override
				public void removeUpdate(DocumentEvent de)
				{
					lines.setText(getText());
				}
			}
		);
		lines = new NPLineNumber();
		scroll_panel = new JScrollPane();
		scroll_panel.getViewport().add(editor);
		scroll_panel.setRowHeaderView(lines);
		add(scroll_panel,BorderLayout.EAST);
	}
	public void setText(String str)
	{
		editor.setText(str);
	}
	public Editor getEditor()
	{
		return editor;
	}
	public String getText()
	{
		return editor.getText();
	}	
}