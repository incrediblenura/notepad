import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.text.Element;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
public class ToolBox extends JTabbedPane
{
	private final Editor editor;
	private JPanel panel;
	private final NPLineNumber lines;
	private final JScrollPane scroll_panel;
	public ToolBox(int width,int height)
	{
		setLayout(new BorderLayout());
		editor = new Editor(width,height);
		editor.getDocument().addDocumentListener(new DocumentListener(){
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
	}});
	lines = new NPLineNumber();
	scroll_panel = new JScrollPane();
	scroll_panel.getViewport().add(editor);
	scroll_panel.setRowHeaderView(lines);
	setBounds(0,0,width,height);
	add("untitled",scroll_panel);
	}
	public void setText(String text)
	{
		editor.setText(text);
	}
}