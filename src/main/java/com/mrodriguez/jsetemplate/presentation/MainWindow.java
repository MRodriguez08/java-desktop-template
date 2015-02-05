package com.mrodriguez.jsetemplate.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;
import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;

import com.mrodriguez.jsetemplate.business.BusinessFactory;
import com.mrodriguez.jsetemplate.business.UserBusiness;
import com.mrodriguez.jsetemplate.persistence.entities.UserEntity;
import com.mrodriguez.jsetemplate.persistence.entities.UserRoleEntity;
import com.mrodriguez.jsetemplate.presentation.app.About;
import com.mrodriguez.jsetemplate.presentation.model.UserRoleTableModel;
import com.mrodriguez.jsetemplate.presentation.model.UserTableModel;

public class MainWindow {
	
	private static Logger logger = Logger.getLogger(MainWindow.class);

	private JFrame frame;
	private JLabel lblWindowTitle;
	private JPanel windowTitlePanel;
	private JPanel mainContentPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					logger.error(e.getMessage() , e);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setBounds(50, 50, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem exitMenuEntry = new JMenuItem("Exit");
		exitMenuEntry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				frame.setVisible(false);
				frame.dispose();
				System.exit(0);
			}
		});
		fileMenu.add(exitMenuEntry);
		
		
		//Administration dropdown menu
		
		JMenu administrationMenu = new JMenu("Administration");
		menuBar.add(administrationMenu);
		
		JMenuItem usersMenuEntry = new JMenuItem("Users");
		usersMenuEntry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				setUpUsersAdministration();
			}
		});
		administrationMenu.add(usersMenuEntry);
		
		JMenuItem rolesMenuEntry = new JMenuItem("Roles");
		rolesMenuEntry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				setUpRolesAdministration();
			}
		});
		administrationMenu.add(rolesMenuEntry);
		
		//Help dropdown menu
		
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		JMenuItem aboutMenuEntry = new JMenuItem("About");
		aboutMenuEntry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				About aboutDialog = new About();
				aboutDialog.setVisible(true);
			}
		});
		helpMenu.add(aboutMenuEntry);
		
		JPanel windowTitlePanel = new JPanel();
		frame.getContentPane().add(windowTitlePanel, BorderLayout.NORTH);
		
		lblWindowTitle = new JLabel("Window title");
		lblWindowTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		lblWindowTitle.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblWindowTitle.setHorizontalAlignment(SwingConstants.LEFT);
		windowTitlePanel.add(lblWindowTitle);
		
		mainContentPanel = new JPanel();
		frame.getContentPane().add(mainContentPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Users administration window setup
	 */
	private void setUpUsersAdministration(){		
		lblWindowTitle.setText("Users");
		
		//clear the content panel
		mainContentPanel.removeAll();
		
		UserBusiness userBusiness = BusinessFactory.getUserBusiness();
		List<UserEntity> users = userBusiness.findAll();	
		
		JTable table = new JTable(new UserTableModel(users));
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		
		mainContentPanel.add(scrollPane);
	}
	
	/**
	 * Users roles administration window setup
	 */
	private void setUpRolesAdministration(){		
		lblWindowTitle.setText("Roles");
		
		//clear the content panel
		mainContentPanel.removeAll();
		
		UserBusiness userBusiness = BusinessFactory.getUserBusiness();
		List<UserRoleEntity> roles = userBusiness.findAllRoles();	
		
		JTable table = new JTable(new UserRoleTableModel(roles));
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		
		mainContentPanel.add(scrollPane);
		
	}
	
}
