package Notepad;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class NPFileMenuAction implements ActionListener
{
    public static final long serialVersionUID = -13;
    /**
     * @Override
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object eventObject = e.getSource();
        if(eventObject instanceof JMenuItem)
        {
            String commandType = e.getActionCommand().trim();
            switch(commandType)
            {
                case "Exit":
                            systemExit();
                            break;
            }
        }
    }
    /**
     * @return void
     */
    private void systemExit()
    {
        System.exit(0);
    }
}
