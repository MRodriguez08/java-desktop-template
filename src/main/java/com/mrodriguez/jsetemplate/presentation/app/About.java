package com.mrodriguez.jsetemplate.presentation.app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class About extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public About() {
		setBounds(100, 100, 600, 300);
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.desktop);
		contentPanel.setForeground(SystemColor.desktop);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblSimpleJseDesktop = new JLabel("Simple JSE Desktop Application Template");
			lblSimpleJseDesktop.setFont(new Font("Dialog", Font.BOLD, 20));
			lblSimpleJseDesktop.setForeground(SystemColor.text);
			contentPanel.add(lblSimpleJseDesktop);
		}
		
		this.addWindowFocusListener(new WindowFocusListener() {

            public void windowGainedFocus(WindowEvent e) {
                //do nothing
            }

            public void windowLostFocus(WindowEvent e) {
                if (SwingUtilities.isDescendingFrom(e.getOppositeWindow(), About.this)) {
                    return;
                }
                About.this.setVisible(false);
            }

        });
		
	}

}
