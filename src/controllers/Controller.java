package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Tree;
import views.MainWindow;

public class Controller implements ActionListener{

	private Tree tree;
	private MainWindow mainWindow;
	
	public Controller() {
		tree = new Tree("AutoComplete Words");
		mainWindow = new MainWindow(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Event.valueOf(e.getActionCommand())) {
		
		}
	}
}