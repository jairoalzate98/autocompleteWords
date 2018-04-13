package views;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import controllers.Controller;
import controllers.Event;
import models.Node;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField jtfWord;
	private JTree jTree;
	private DefaultTreeModel modelRoot;
	private DefaultMutableTreeNode model;
	private JScrollPane jsTree;

	public MainWindow(Controller controller) {
		setTitle("AutoCompleteWords");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		jtfWord = new JTextField(30);
		jtfWord.setBorder(BorderFactory.createTitledBorder("Ingrese la palabra"));
		add(jtfWord, BorderLayout.NORTH);
		JButton jbtnAddWord = new JButton("Aceptar");
		jbtnAddWord.setActionCommand(Event.ADD_WORD.toString());
		jbtnAddWord.addActionListener(controller);
		add(jbtnAddWord, BorderLayout.SOUTH);
		model = new DefaultMutableTreeNode();
		modelRoot = new DefaultTreeModel(model);
		jTree = new JTree(modelRoot);
		jsTree = new JScrollPane(jTree);
		add(jsTree, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void paintTree(Node root) {
		DefaultMutableTreeNode uiRoot = new DefaultMutableTreeNode(root);
		modelRoot.setRoot(uiRoot);
		model.add(uiRoot);
		for (int i = 0; i < root.getNodeList().size(); i++) {
			createNode(uiRoot, root.getNodeList().get(i));
		}
		
		revalidate();
		repaint();
	}
	
	private void createNode(DefaultMutableTreeNode actual, Node node) {
		if (node != null) {
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(node);
			actual.add(newNode);
			for (int i = 0; i < node.getNodeList().size(); i++) {
				createNode(newNode, node.getNodeList().get(i));
			}
		}
	}
	
	public String getTextToEnter(){
		return jtfWord.getText();
	}
}