/**
 * @author CJ Cucio
 * @date 28 November 2019
 */

package yib00005xs.std511.library.form;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class DropDownList extends JComboBox {
    
    private List<String> list;

    public DropDownList(List<String> list) {
        super(list.toArray());
        this.setEditable(true);
        this.list = list;
        final JTextField jTxtField = (JTextField) this.getEditor().getEditorComponent();

        jTxtField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent key) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        doFilter(jTxtField.getText());
                    }
                });
            }
        });
    }

    private void doFilter(String query) {
        if (!this.isPopupVisible()) {
            this.showPopup();
        }
        List<String> filterArray = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toLowerCase().contains(query.toLowerCase())) {
                filterArray.add(list.get(i));
            }
        }
        if (filterArray.size() > 0) {
            DefaultComboBoxModel model = (DefaultComboBoxModel) this.getModel();
            model.removeAllElements();
            for (String item : filterArray) {
                model.addElement(item);
            }
            JTextField jTextField = (JTextField) this.getEditor().getEditorComponent();
            jTextField.setText(query);
        } else {
            this.setPopupVisible(false);
        }
    }

}
