package com.z100jamz.zb.partystory;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ScrollPaneConstants;

import javax.swing.JList;
import javax.swing.JEditorPane;
import javax.swing.JTable;

public class View extends JFrame{
	
	private Controller controller;
	private JPanel topContentPane, wsJPanel, adJPanel, avJPanel, cjJPanel;
	private JPanel nnJPanel, pnJPanel, ppJPanel, prJPanel, vbJPanel, ssJPanel, cfJPanel;
	private JTabbedPane tabbedPane, subTabbedPane;
	private JPanel panle1, panel2, panel3;
	private JButton wsButton, adButton, avButton, cjButton;
	private JButton nnButton, pnButton, ppButton, prButton;
	private JButton vbButton, ssButton, cfButton;
	private JTextArea wsTextArea, adTextArea, avTextArea, cjTextArea;
	private JTextArea nnTextArea, pnTextArea, ppTextArea, prTextArea, vbTextArea, ssTextArea, cfTextArea;
	private JScrollPane wsScrollPane, adScrollPane, avScrollPane, cjScrollPane;
	private JScrollPane nnScrollPane, pnScrollPane, ppScrollPane, prScrollPane, vbScrollPane, ssScrollPane, cfScrollPane;
	private JTextField minParagraphs, maxParagraphs, minSentences,maxSentences, configDir, dataDir;
	public String myMinParagraphs, myMaxParagraphs, myMinSentences, myMaxSentences, myConfigDir, myDataDir;

	
	public View(Controller controller) {
		// super("PartyStory");
		setTitle( "Party Story Application");
		this.controller = controller;
		JPanel topContentPane = new JPanel();
		// topContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		topContentPane.setLayout(new BorderLayout());
		getContentPane().add(topContentPane);
		//this.add(contentPane);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		topContentPane.add(tabbedPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		wsTextArea = new JTextArea(20,60);
		wsTextArea.setWrapStyleWord(true);
		wsScrollPane = new JScrollPane(wsTextArea);
		//wsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		wsTextArea.setEditable(true);
		//String areatext = controller.getModelStringWS("");
		// String allinit = controller.initModelWS();
		//wsTextArea.setText(areatext);
		wsTextArea.setLineWrap(true); 
		wsButton = new JButton("Write Story!");
		wsJPanel = new JPanel(new BorderLayout());
		wsJPanel.add(wsScrollPane, BorderLayout.PAGE_START);
		wsJPanel.add(wsButton, BorderLayout.PAGE_END);
		tabbedPane.addTab("Write Story", null, wsJPanel, null);
		
		wsButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				wsButtonAction(e);				
			}	
		});

		subTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Maintain", null, subTabbedPane, null);
		
		adTextArea = new JTextArea(20,60);
		adScrollPane = new JScrollPane(adTextArea);
		adTextArea.setEditable(true);
		String adareatext = controller.getModelStringAD("");
		adTextArea.setText(adareatext);
		adButton = new JButton("AD Button");
		adJPanel = new JPanel(new BorderLayout());
		adJPanel.add(adScrollPane, BorderLayout.PAGE_START);
		adJPanel.add(adButton, BorderLayout.PAGE_END);
		subTabbedPane.addTab("AD", null, adJPanel, null);
		
		adButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				adButtonAction(e);				
			}	
		});
		
		avTextArea = new JTextArea(20,60);
		avScrollPane = new JScrollPane(avTextArea);
		avTextArea.setEditable(true);
		String avareatext = controller.getModelStringAV("");
		avTextArea.setText(avareatext);
		avButton = new JButton("AV Button");
		avJPanel = new JPanel(new BorderLayout());
		avJPanel.add(avScrollPane, BorderLayout.PAGE_START);
		avJPanel.add(avButton, BorderLayout.PAGE_END);
		subTabbedPane.addTab("AV", null, avJPanel, null);
		
		avButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				avButtonAction(e);				
			}	
		});		

		cjTextArea = new JTextArea(20,60);
		cjScrollPane = new JScrollPane(cjTextArea);
		cjTextArea.setEditable(true);
		String cjareatext = controller.getModelStringCJ("");
		cjTextArea.setText(cjareatext);
		cjButton = new JButton("CJ Button");
		cjJPanel = new JPanel(new BorderLayout());
		cjJPanel.add(cjScrollPane, BorderLayout.PAGE_START);
		cjJPanel.add(cjButton, BorderLayout.PAGE_END);
		subTabbedPane.addTab("CJ", null, cjJPanel, null);
		
		cjButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cjButtonAction(e);				
			}	
		});		

		nnTextArea = new JTextArea(20,60);
		nnScrollPane = new JScrollPane(nnTextArea);
		nnTextArea.setEditable(true);
		String nnareatext = controller.getModelStringNN("");
		nnTextArea.setText(nnareatext);
		nnButton = new JButton("NN Button");
		nnJPanel = new JPanel(new BorderLayout());
		nnJPanel.add(nnScrollPane, BorderLayout.PAGE_START);
		nnJPanel.add(nnButton, BorderLayout.PAGE_END);
		subTabbedPane.addTab("NN", null, nnJPanel, null);
		
		nnButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				nnButtonAction(e);				
			}	
		});				
		
		pnTextArea = new JTextArea(20,60);
		pnScrollPane = new JScrollPane(pnTextArea);
		pnTextArea.setEditable(true);
		String pnareatext = controller.getModelStringPN("");
		pnTextArea.setText(pnareatext);
		pnButton = new JButton("PN Button");
		pnJPanel = new JPanel(new BorderLayout());
		pnJPanel.add(pnScrollPane, BorderLayout.PAGE_START);
		pnJPanel.add(pnButton, BorderLayout.PAGE_END);
		subTabbedPane.addTab("PN", null, pnJPanel, null);
		
		pnButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				pnButtonAction(e);				
			}	
		});	
		
		ppTextArea = new JTextArea(20,60);
		ppScrollPane = new JScrollPane(ppTextArea);
		ppTextArea.setEditable(true);
		String ppareatext = controller.getModelStringPP("");
		ppTextArea.setText(ppareatext);
		ppButton = new JButton("PP Button");
		ppJPanel = new JPanel(new BorderLayout());
		ppJPanel.add(ppScrollPane, BorderLayout.PAGE_START);
		ppJPanel.add(ppButton, BorderLayout.PAGE_END);
		subTabbedPane.addTab("PP", null, ppJPanel, null);
		
		ppButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ppButtonAction(e);				
			}	
		});	
		
		prTextArea = new JTextArea(20,60);
		prScrollPane = new JScrollPane(prTextArea);
		prTextArea.setEditable(true);
		String prareatext = controller.getModelStringPR("");
		prTextArea.setText(prareatext);
		prButton = new JButton("PR Button");
		prJPanel = new JPanel(new BorderLayout());
		prJPanel.add(prScrollPane, BorderLayout.PAGE_START);
		prJPanel.add(prButton, BorderLayout.PAGE_END);
		subTabbedPane.addTab("PR", null, prJPanel, null);
		
		prButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				prButtonAction(e);				
			}	
		});	
		
		vbTextArea = new JTextArea(20,60);
		vbScrollPane = new JScrollPane(vbTextArea);
		vbTextArea.setEditable(true);
		String vbareatext = controller.getModelStringVB("");
		vbTextArea.setText(vbareatext);
		vbButton = new JButton("VB Button");
		vbJPanel = new JPanel(new BorderLayout());
		vbJPanel.add(vbScrollPane, BorderLayout.PAGE_START);
		vbJPanel.add(vbButton, BorderLayout.PAGE_END);
		subTabbedPane.addTab("VB", null, vbJPanel, null);
		
		vbButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				vbButtonAction(e);				
			}	
		});		
		
		ssTextArea = new JTextArea(20,60);
		ssScrollPane = new JScrollPane(ssTextArea);
		ssTextArea.setEditable(true);
		String ssareatext = controller.getModelStringSS("");
		ssTextArea.setText(ssareatext);
		ssButton = new JButton("SS Button");
		ssJPanel = new JPanel(new BorderLayout());
		ssJPanel.add(ssScrollPane, BorderLayout.PAGE_START);
		ssJPanel.add(ssButton, BorderLayout.PAGE_END);
		subTabbedPane.addTab("SS", null, ssJPanel, null);
		
		ssButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ssButtonAction(e);				
			}	
		});	
		
		cfTextArea = new JTextArea(10,40);
		cfScrollPane = new JScrollPane(cfTextArea);
		cfTextArea.setEditable(false);
		cfButton = new JButton("Configure Button!");
		//cfJPanel = new JPanel(new BorderLayout());
		//cfJPanel.add(cfScrollPane, BorderLayout.PAGE_START);
		//cfJPanel.add(cfButton, BorderLayout.PAGE_END);
		minParagraphs = new JTextField(5);
		myMinParagraphs = controller.getModelMinParagraphs("");
		minParagraphs.setText(myMinParagraphs);
		maxParagraphs = new JTextField(5);
		myMaxParagraphs = controller.getModelMaxParagraphs("");
		maxParagraphs.setText(myMaxParagraphs);
		minSentences = new JTextField(5);
		myMinSentences = controller.getModelMinSentences("");
		minSentences.setText(myMinSentences);
		maxSentences = new JTextField(5);
		myMaxSentences = controller.getModelMaxSentences("");
		maxSentences.setText(myMaxSentences);
		configDir = new JTextField(50);
		myConfigDir = controller.getModelConfigDir("");
		configDir.setText(myConfigDir);
		dataDir = new JTextField(50);
		myDataDir = controller.getModelDatatDir("");
		dataDir.setText(myDataDir);
		cfJPanel = new JPanel(new GridLayout(7,2));
		cfJPanel.add(new JLabel("Min Paragraphs"));
		cfJPanel.add(minParagraphs);
		cfJPanel.add(new JLabel("Max Paragraphs"));
		cfJPanel.add(maxParagraphs);
		cfJPanel.add(new JLabel("Min Sentences"));
		cfJPanel.add(minSentences);
		cfJPanel.add(new JLabel("Max Sentences"));
		cfJPanel.add(maxSentences);
		cfJPanel.add(new JLabel("Config Dir"));
		cfJPanel.add(configDir);
		cfJPanel.add(new JLabel("Data Dir"));
		cfJPanel.add(dataDir);
		cfJPanel.add(new JLabel(""));
		cfJPanel.add(cfButton);
		tabbedPane.addTab("Configure", null, cfJPanel, null);
		
		cfButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cfButtonAction(e);				
			}	
		});
		
		pack();
		setVisible(true);
	}

	private void updateMinParagraphs() {
		// Do I need to do anything here?
		
	}

	protected void cfButtonAction(ActionEvent e) {
		controller.handleCfButtonAction();
	}

	protected void wsButtonAction(ActionEvent e) {
		controller.handleWsButtonAction();
	}

	protected void adButtonAction(ActionEvent e) {
		controller.handleAdButtonAction();
	}	

	protected void avButtonAction(ActionEvent e) {
		controller.handleAvButtonAction();
	}
	
	protected void cjButtonAction(ActionEvent e) {
		controller.handleCjButtonAction();
	}
	
	protected void nnButtonAction(ActionEvent e) {
		controller.handleNnButtonAction();
	}
	
	protected void pnButtonAction(ActionEvent e) {
		controller.handlePnButtonAction();
	}
	
	protected void ppButtonAction(ActionEvent e) {
		controller.handlePpButtonAction();
	}
	
	protected void prButtonAction(ActionEvent e) {
		controller.handlePrButtonAction();
	}
	
	protected void vbButtonAction(ActionEvent e) {
		controller.handleVbButtonAction();
	}
	
	protected void ssButtonAction(ActionEvent e) {
		controller.handleSsButtonAction();
	}
	
	//public String getStoryText() {
	//	String stret = wsTextArea.getText();
	//	return stret;
	//}

	public String getAdText() {
		String adret = adTextArea.getText();
		return adret;
	}

	
	public String getAvText() {
		String avret = avTextArea.getText();
		return avret;
	}
	
	public String getCjText() {
		String cjret = cjTextArea.getText();
		return cjret;
	}
	
	public String getNnText() {
		String nnret = nnTextArea.getText();
		return nnret;
	}
	
	public String getPnText() {
		String pnret = pnTextArea.getText();
		return pnret;
	}
	
	public String getPpText() {
		String ppret = ppTextArea.getText();
		return ppret;
	}
	
	public String getPrText() {
		String prret = prTextArea.getText();
		return prret;
	}
	
	public String getVbText() {
		String vbret = vbTextArea.getText();
		return vbret;
	}
	
	public String getSsText() {
		String ssret = ssTextArea.getText();
		return ssret;
	}
	
	public String getMinPText() {
		//String minpret = myMinParagraphs;
		String minpret = minParagraphs.getText();
		//System.out.println("Sending minParas from view: "+minpret);
		return minpret;
	}
	
	public String getMaxPText() {
		//String maxpret = myMaxParagraphs;
		String maxpret = maxParagraphs.getText();
		return maxpret;
	}
	
	public String getMinSText() {
		//String minsret = myMinSentences;
		String minsret = minSentences.getText();
		return minsret;
	}
	
	public String getMaxSText() {
		//String maxsret = myMaxSentences;
		String maxsret = maxSentences.getText();
		return maxsret;
	}
	
	public String getConfigDirText() {
		String confdret = configDir.getText();
		return confdret;
	}
	
	public String getDataDirText() {
		String datadret = dataDir.getText();
		return datadret;
	}

	public void updateStoryText(Model model) {
		// OK, what happens here.
		wsTextArea.setText("");
		// why is this not getting the existing currentStory?
		// and why is it not replacing the previous one in the widget?
		wsTextArea.setText(model.getCurrentStory());
		//wsButton.setText("Story Written.");
		
	}
	
}
