package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import models.Comparator;
import models.Node;
import models.Tree;
import views.MainWindow;

public class Controller implements ActionListener, KeyListener{

	private Tree tree;
	private MainWindow mainWindow;
	private Comparator comparator;
	
	public Controller() {
		tree = new Tree("AutoComplete Words");
		mainWindow = new MainWindow(this);
		comparator = new Comparator();
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
			for (int i = 0; i < nodes.size(); i++) {
				for (int j = i + 1; j < nodes.size(); j++) {
					if (comparator.compare(nodes.get(i).getValue(), nodes.get(j).getValue()) < 0) {
						Node aux = nodes.get(i);
						nodes.set(i, nodes.get(j));
						nodes.set(j, aux);
					}
				}
			}
			for (Node node : nodes) {
				texts.add(tree.getStringBefore(node));
			}
			mainWindow.setModel(texts);
			mainWindow.revalidate();
			mainWindow.repaint();
		}
	}
}