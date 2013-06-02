package com.z100jamz.zb.partystory;

public class Controller {
	private Model model;
	private View PartyStoryGUI;
	public String cdataDir;
	public Controller() {
		model = new Model(null);
		cdataDir = getModelDatatDir("");
		PartyStoryGUI = new View(this);
	}
	
	// action handlers go here
	

	public void handleWsButtonAction() {
		System.out.println("Write Story Button Clicked!");
		//model.writeFile("/home/teak/psws.txt", PartyStoryGUI.getStoryText());
		model.WriteStory();
		PartyStoryGUI.updateStoryText(model);
		//model.countUp();
		//view.update(model);
		
	}

	public void handleAdButtonAction() {
		System.out.println("Adjective Button Clicked!");
		//System.out.println("Trying to handle: "+cdataDir+"/psad.txt");
		model.writeFile(cdataDir+"/psad.txt", PartyStoryGUI.getAdText());
	}
	
	public void handleAvButtonAction() {
		System.out.println("Adverb Button Clicked!");
		model.writeFile(cdataDir+"/psav.txt", PartyStoryGUI.getAvText());
	}
	
	public void handleCjButtonAction() {
		System.out.println("Conjunction Button Clicked!");
		model.writeFile(cdataDir+"/pscj.txt", PartyStoryGUI.getCjText());
	}
	
	public void handleNnButtonAction() {
		System.out.println("Noun Button Clicked!");
		model.writeFile(cdataDir+"/psnn.txt", PartyStoryGUI.getNnText());
	}
	
	public void handlePnButtonAction() {
		System.out.println("Pronoun Button Clicked!");
		model.writeFile(cdataDir+"/pspn.txt", PartyStoryGUI.getPnText());
	}
	
	public void handlePpButtonAction() {
		System.out.println("Proper Pronoun Button Clicked!");
		model.writeFile(cdataDir+"/pspp.txt", PartyStoryGUI.getPpText());
	}
	
	public void handlePrButtonAction() {
		System.out.println("Preposition Button Clicked!");
		model.writeFile(cdataDir+"/pspr.txt", PartyStoryGUI.getPrText());
	}
	
	public void handleVbButtonAction() {
		System.out.println("Verb Button Clicked!");
		model.writeFile(cdataDir+"/psvb.txt", PartyStoryGUI.getVbText());
	}
	
	public void handleSsButtonAction() {
		System.out.println("Sentence Structure Button Clicked!");
		model.writeFile(cdataDir+"/psss.txt", PartyStoryGUI.getSsText());
	}
	
	public void handleCfButtonAction() {
		System.out.println("Configure Button Clicked!");
		model.writeConfig(PartyStoryGUI.getMinPText(), PartyStoryGUI.getMaxPText(), PartyStoryGUI.getMinSText(), PartyStoryGUI.getMaxSText(), PartyStoryGUI.getConfigDirText(), PartyStoryGUI.getDataDirText());
	}


	public String getModelStringWS(String toReturn) {
		// do I need anything at all here?
		// toReturn = model.readFile("/home/teak/psws.txt");
		toReturn = "";
		return toReturn;
	}

	public String getModelStringAD(String toReturn) {
		//System.out.println("Trying to read: "+cdataDir+"/psad.txt");
		toReturn = model.readFile(cdataDir+"/psad.txt");
		return toReturn;
	}
	
	public String getModelStringAV(String toReturn) {
		toReturn = model.readFile(cdataDir+"/psav.txt");
		return toReturn;
	}
	
	public String getModelStringCJ(String toReturn) {
		toReturn = model.readFile(cdataDir+"/pscj.txt");
		return toReturn;
	}
	
	public String getModelStringNN(String toReturn) {
		toReturn = model.readFile(cdataDir+"/psnn.txt");
		return toReturn;
	}
	
	public String getModelStringPN(String toReturn) {
		toReturn = model.readFile(cdataDir+"/pspn.txt");
		return toReturn;
	}
	
	public String getModelStringPP(String toReturn) {
		toReturn = model.readFile(cdataDir+"/pspp.txt");
		return toReturn;
	}
	
	public String getModelStringPR(String toReturn) {
		toReturn = model.readFile(cdataDir+"/pspr.txt");
		return toReturn;
	}
	
	public String getModelStringVB(String toReturn) {
		toReturn = model.readFile(cdataDir+"/psvb.txt");
		return toReturn;
	}
	
	public String getModelStringSS(String toReturn) {
		toReturn = model.readFile(cdataDir+"/psss.txt");
		return toReturn;
	}

	public String initModelWS() {
		String initReturn = model.initModel();
		return initReturn;
	}
	
	public String getModelMinParagraphs(String toReturn) {
		toReturn = model.getMinParagraphs();
		return toReturn;
	}

	public String getModelMaxParagraphs(String toReturn) {
		toReturn = model.getMaxParagraphs();
		return toReturn;
	}

	public String getModelMinSentences(String toReturn) {
		toReturn = model.getMinSentences();
		return toReturn;
	}

	public String getModelMaxSentences(String toReturn) {
		toReturn = model.getMaxSentences();
		return toReturn;
	}

	public String getModelConfigDir(String toReturn) {
		toReturn = model.getConfigDir();
		return toReturn;
	}

	public String getModelDatatDir(String toReturn) {
		toReturn = model.getDataDir();
		return toReturn;
	}

	
}
