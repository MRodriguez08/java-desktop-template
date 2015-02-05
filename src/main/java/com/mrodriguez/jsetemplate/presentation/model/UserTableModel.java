package com.mrodriguez.jsetemplate.presentation.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.mrodriguez.jsetemplate.persistence.entities.UserEntity;

public class UserTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[] columnNames = { "Nick", "Name" };

	private Object[][] data = null;
	
	public UserTableModel(){}
	
	public UserTableModel(List<UserEntity> users){
		data = new Object[users.size()][2];
		for (int i = 0; i < users.size(); i++){
			data[i] = new Object[] {users.get(i).getUserId() , users.get(i).getName() };
		}
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

	/*
	 * JTable uses this method to determine the default renderer/ editor for
	 * each cell. If we didn't implement this method, then the last column would
	 * contain text ("true"/"false"), rather than a check box.
	 */
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	/*
	 * Don't need to implement this method unless your table's editable.
	 */
	public boolean isCellEditable(int row, int col) {
		return false;
	}

	
}