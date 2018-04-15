package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import models.Node;
import models.Tree;
import views.MainWindow;

public class Controller implements ActionListener, KeyListener{

	private Tree tree;
	private MainWindow mainWindow;
	
	public Controller() {
		tree = new Tree("AutoComplete Words");
		mainWindow = new MainWindow(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Event.valueOf(e.getActionCommand())) {
		case ADD_WORD:
			addWord();
			break;
		}
		mainWindow.paintTree(tree.getRoot());
		mainWindow.revalidate();
		mainWindow.repaint();
	}

	private void addWord() {
		tree.addChildToRoot(mainWindow.getTextToEnter(), tree.getRoot());
		mainWindow.setJtfWord();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (!tree.getRoot().getNodeList().isEmpty()) {
			String text = mainWindow.getTextToEnter();
			ArrayList<Node> nodes = tree.getWords(text, tree.getRoot().getNodeList());
			ArrayList<String> texts = new ArrayList<>();
			for (Node node : nodes) {
				texts.add(tree.getStringBefore(node));
			}
			mainWindow.setModel(texts);
			mainWindow.revalidate();
			mainWindow.repaint();
		}
	}
}