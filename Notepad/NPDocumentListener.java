package Notepad;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;

public class NPDocumentListener implements DocumentListener {
    public static final long serialVersionUID = -7;
    private NPLineNumber lines;
    public NPDocumentListener(NPLineNumber ln)
    {
        lines = ln;
    }
    public String getText(DocumentEvent e)
    {
        int caretPosition = e.getDocument().getLength();
		Element root = e.getDocument().getDefaultRootElement();
		String text = "1" + System.getProperty("line.separator");
		for(int i = 2; i < root.getElementIndex(caretPosition) + 2; i++)
		{
			text += i + System.getProperty("line.separator");
		}
		return text;
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        lines.setText(getText(e));
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        lines.setText(getText(e));

    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        lines.setText(getText(e));

    }
    
}