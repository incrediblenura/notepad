package Notepad;
import javax.swing.*;
import java.awt.*;
public class Notepad
{
    public static final long serialVersionUID = -12;
    private JFrame           app = new       JFrame("Notepad"                 );
    private NPMenuBar      menus = new    NPMenuBar(                          );
    private NPEditor      editor = new     NPEditor(                          );
    private NPScrollPane  scroll = new NPScrollPane(                          );
    private NPMenu      fileMenu = new       NPMenu("File"                    );
    private NPMenuItem  openFile = new   NPMenuItem("Open", "res/img/open.png");
    private NPMenuItem  saveFile = new   NPMenuItem("Save", "res/img/save.png");
    private NPMenuItem      exit = new   NPMenuItem("Exit", "res/img/exit.png");
    private NPLineNumber   lines = new NPLineNumber(                          );
    private NPTabbedPane tabPane = new NPTabbedPane(                          );
    public Notepad()
    {
        createGUI();
    }
    private void createGUI()
    {
        NPFileMenuAction   fileActionListener = new   NPFileMenuAction();
        NPDocumentListener documentListener   = new NPDocumentListener(lines);
        exit.addActionListener(fileActionListener);
        editor.getDocument().addDocumentListener(documentListener);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.addSeparator();
        fileMenu.add(    exit);
        scroll.setRowHeaderView(lines);
        scroll.setViewportView(editor);
        menus.add(fileMenu);
        tabPane.addTab("untitled",scroll);
        app.setLayout(new BorderLayout());
        app.add(menus,BorderLayout.NORTH);
        app.add(tabPane,BorderLayout.CENTER);
        app.setSize(500,500);
        app.setLocation(300,200);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
             new Notepad();                
            }
        });
    }
}
