import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * Created by Pegah on 12/6/2016.
 */
public class Server extends JFrame {


    private JTextField[] testField;
    private JPanel[] panels = new JPanel[10];
    private JPanel topPanel = new JPanel();
    private     JSplitPane  splitPaneV;
    private     JSplitPane  splitPaneHMainUp;
    private     JSplitPane  splitPaneHMainDown;
    private     JSplitPane  splitPaneUR;
    private     JSplitPane  splitPaneUL;
    private     JSplitPane  splitPaneDR;
    private     JSplitPane  splitPaneDL;



    public Server() throws HeadlessException {
        super("server");
        setBackground( Color.gray );

        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );

        splitPaneHMainUp = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
        splitPaneUR = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
        splitPaneUL = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
        splitPaneDR = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
        splitPaneDL = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
        splitPaneHMainDown = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );

        //create pannels
        for(int i=0 ; i<8 ; i++)
        {
            panels[i] = new JPanel();
            panels[i].setLayout( new BorderLayout() );
            panels[i].setPreferredSize( new Dimension( 230, 300 ) );
            panels[i].setMaximumSize(new Dimension(230,300));
            panels[i].add( new JLabel( "Client:" +(i+1) ), BorderLayout.NORTH );
            JTextArea temp = new JTextArea();
            temp.setEditable(false);
            temp.setBackground(Color.gray);
            panels[i].add( new JScrollPane(),BorderLayout.CENTER);
            panels[i].setVisible(false);
        }

        splitPaneV = new JSplitPane( JSplitPane.VERTICAL_SPLIT );
        splitPaneUL.setLeftComponent(panels[0]);
        splitPaneUL.setRightComponent(panels[1]);
        splitPaneUR.setLeftComponent(panels[2]);
        splitPaneUR.setRightComponent(panels[3]);
        splitPaneDL.setLeftComponent(panels[4]);
        splitPaneDL.setRightComponent(panels[5]);
        splitPaneDR.setLeftComponent(panels[6]);
        splitPaneDR.setRightComponent(panels[7]);
        splitPaneHMainUp.setLeftComponent(splitPaneUL);
        splitPaneHMainUp.setRightComponent(splitPaneUR);
        splitPaneHMainDown.setLeftComponent(splitPaneDL);
        splitPaneHMainDown.setRightComponent(splitPaneDR);
        splitPaneV.setLeftComponent(splitPaneHMainUp);
        splitPaneV.setRightComponent(splitPaneHMainDown);

        topPanel.add( splitPaneV, BorderLayout.CENTER );

        this.setSize(1000,670);
        this.setVisible(true);
    }
}
