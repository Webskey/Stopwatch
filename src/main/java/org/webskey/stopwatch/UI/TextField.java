package org.webskey.stopwatch.UI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class TextField extends JTextField implements ActionListener, DocumentListener {

	private static final long serialVersionUID = 1L;
	private JLabel label;

	public TextField(int columns,JLabel label) {
		super(columns);
		this.label=label;
		getDocument().addDocumentListener(this);			
		addActionListener(this);
		setFont(new Font("", Font.ITALIC, 20));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = getText();
		requestFocusInWindow();
		setText("");
		label.setText(name);
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {}

	@Override
	public void insertUpdate(DocumentEvent e) {
		update(e);
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		update(e);
	}

	private void update(DocumentEvent e) {
		Document doc = e.getDocument();
		int len = doc.getLength();
		String text="";
		try {
			text = doc.getText(0, len);

		} catch (BadLocationException ex) {
			System.err.println(ex);
		}
		label.setText(text);
	}
}