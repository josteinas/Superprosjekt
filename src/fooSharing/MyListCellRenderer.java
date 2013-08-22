package fooSharing;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


public class MyListCellRenderer extends JLabel implements ListCellRenderer {
	     final static ImageIcon myIcon = new ImageIcon("monitor.png");
	     

	     // This is the only method defined by ListCellRenderer.
	     // We just reconfigure the JLabel each time we're called.

	     public Component getListCellRendererComponent(
	       JList list,
	       Object value,            // value to display
	       int index,               // cell index
	       boolean isSelected,      // is the cell selected
	       boolean cellHasFocus)    // the list and the cell have the focus
	     {
	         String s = value.toString();
	         setText(s);
	         System.out.println(myIcon);
	         setIcon(myIcon);
	         
	         if (isSelected) {
	             setBackground(list.getSelectionBackground());
	               setForeground(list.getSelectionForeground());
	           }
	         else {
	               setBackground(list.getBackground());
	               setForeground(list.getForeground());
	           }
	         setEnabled(list.isEnabled());
	         setFont(list.getFont());
	         setOpaque(true);
	         return this;
	     }
	 }

