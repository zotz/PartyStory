package com.z100jamz.zb.partystory;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Random;

public class Model {
	
	String[] psADs;
	String[] psAVs;
	String[] psCJs;
	String[] psNNs;
	String[] psPNs;
	String[] psPPs;
	String[] psPRs;
	String[] psVBs;
	String[] psSSs;
	String[] linesFile;
	String line;
	String currentStory;
	String minParagraphs, maxParagraphs, minSentences, maxSentences, dataDir, configDir, homeDir;
	Random randomGenerator;
	int numPar, numSentPar;
	// minParagraphs = "0";
	


	public Model(Object object) {
		System.out.println("Initializing Model - Stage 1");
		// load in config file
		homeDir = System.getProperty("user.home");
		File configFile = new File(homeDir+"/psconfig.cfg");
		try {
		    FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
		    minParagraphs = props.getProperty("MIN_PARA");
		    maxParagraphs = props.getProperty("MAX_PARA");
		    minSentences = props.getProperty("MIN_SENT");
		    maxSentences = props.getProperty("MAX_SENT");	
		    dataDir = props.getProperty("DATA_DIR");
		    configDir = props.getProperty("CONFIG_DIR");
		    //System.out.print("Min Paragraphs: " + minParagraphs);
		    reader.close();
		} catch (FileNotFoundException ex) {
		    // file does not exist
		}catch (IOException ex) {
		    // I/O error
		}
		//set up a random number generator
		// giving no seed seeds with system time?
		randomGenerator = new Random();
		currentStory = "";
		System.out.println("Initializing Model Stage - 2");
		//System.out.println("dataDir is: "+dataDir);
		//System.out.println("Get adverbs AV from: : "+dataDir+"/psad.txt");
		psADs = readFileToArray(dataDir+"/psad.txt");
		psAVs = readFileToArray(dataDir+"/psav.txt");
		psCJs = readFileToArray(dataDir+"/pscj.txt");
		psNNs = readFileToArray(dataDir+"/psnn.txt");
		psPNs = readFileToArray(dataDir+"/pspn.txt");
		psPPs = readFileToArray(dataDir+"/pspp.txt");
		psPRs = readFileToArray(dataDir+"/pspr.txt");
		psVBs = readFileToArray(dataDir+"/psvb.txt");
		psSSs = readFileToArray(dataDir+"/psss.txt");
		System.out.println("Initializing Model - Stage 3 - data files read  in");
	}

	// read files for maintaining
	public String readFile(String fileName)
	{
	   String content = "";
	   File readfile = new File(fileName);
	   try {
	       FileReader reader = new FileReader(readfile);
	       char[] chars = new char[(int) readfile.length()];
	       reader.read(chars);
	       content = new String(chars);
	       reader.close();
	   } catch (IOException e) {
	       e.printStackTrace();
	   }
	   return content;
	}


	// write files after maintaining
	public void writeFile(String fileName, String writeText)
	{
	   File file = new File(fileName);
	   try {
		   BufferedWriter bufferedWriter =
	                new BufferedWriter(new FileWriter(fileName));
		   bufferedWriter.write(writeText);
		   bufferedWriter.newLine();
		// Always close files.
           bufferedWriter.close();

	   } catch (IOException e) {
	       e.printStackTrace();
	   }
	   // what should go here? ;
	}
	
	public void writeConfig(String minP, String maxP, String minS, String maxS,String configD, String dataD)
	{
		File configFile = new File(homeDir+"/psconfig.cfg");
		System.out.println("Config file to write is: "+homeDir+"/psconfig.cfg");
		 
		try {
			System.out.println("Trying to write config");
		    Properties props = new Properties();
		    props.setProperty("MIN_PARA", minP);
		    props.setProperty("MAX_PARA", maxP);
		    props.setProperty("MIN_SENT", minS);
		    props.setProperty("MAX_SENT", maxS);
		    props.setProperty("DATA_DIR", dataD);
		    props.setProperty("CONFIG_DIR", configD);
		    FileWriter writer = new FileWriter(configFile);
		    props.store(writer, "Party Story Config");
		    writer.close();
		} catch (FileNotFoundException ex) {
		    // file does not exist
		} catch (IOException ex) {
		    // I/O error
		}
	}

	// read files to Arrays for use
	public String[] readFileToArray(String fileName)
	{
	   String content = null;
	   File readfile = new File(fileName);
	   try {BufferedReader in = new BufferedReader(
	       new FileReader(readfile));
	       int numberOfLine = 0;
	       while (in.readLine() != null)
	    	   {
	    	       numberOfLine++;
	    	   }
	       linesFile = new String[numberOfLine];
	       numberOfLine = 0;
	       in.close();
	       in = new BufferedReader(new FileReader(readfile));     
	       while ((line = in.readLine()) != null)
	       {
	           linesFile[numberOfLine] = line;
	           numberOfLine++;
	       }
	       in.close();
	   } catch (IOException e) {
	       e.printStackTrace();
	   }
	   return linesFile;
	}

	
	public String initModel() {
		// Why am I even doing this?
		// I want to read in all files to model arrays?
		//System.out.println("Initializing Model");
		//psADs = readFileToArray("/home/teak/psad.txt");
		//psAVs = readFileToArray("/home/teak/psav.txt");
		//psCJs = readFileToArray("/home/teak/pscj.txt");
		//psNNs = readFileToArray("/home/teak/psnn.txt");
		//psPNs = readFileToArray("/home/teak/pspn.txt");
		//psPPs = readFileToArray("/home/teak/pspp.txt");
		//psPRs = readFileToArray("/home/teak/pspr.txt");
		//psVBs = readFileToArray("/home/teak/psvb.txt");
		//psSSs = readFileToArray("/home/teak/psss.txt");
		//System.out.println("Initializing Model - data files read  in");
		//String testPrint = "First adjective: "+psADs[0]+", first adverb: "+psAVs[0]+".";
		//System.out.println(testPrint);
		return null;
	}

	
	public String fillSentence(String sentStru) {
		
		String newSent;
		String sentence, front, tword, back;
		int lbreak;
		sentence = sentStru;
		//System.out.println("Filling sentence. The passed in Structure is:\n");
		//System.out.println(sentence+" ----passed in done\n");
		newSent = "";
		do {
			lbreak = sentence.indexOf("{");
			String testPrint = "lbreak: "+lbreak+"...\n";
			//System.out.println(testPrint);
			front = sentence.substring(0,lbreak);
			testPrint = "front: "+front+"...\n";
			//System.out.println(testPrint);
			tword = sentence.substring(lbreak+1,lbreak+3);
			testPrint = "tword: "+tword+"...\n";
			//System.out.println(testPrint);
			back = sentence.substring(lbreak+4);
			testPrint = "back: "+back+"...\n";
			//System.out.println(testPrint);
			newSent += front;
			String chosenWord = chword(tword);
			testPrint = "chosenWord: "+chosenWord+"...\n";
			//System.out.println(testPrint);
			newSent += chosenWord;
			sentence = back;
		} while (sentence.indexOf("{") > 0);
		newSent += back;
		return newSent;
		
	}


	private String chword(String ptword) {
		// something is currently wrong in here, the IFs never succeed.
		String rword, tword;
		int choose;
		rword = "";
		tword = ptword;
		
		//System.out.println("Trying to choose a random word. for tword: "+tword+"\n");

		if (tword.equals("AD"))
		{
			//System.out.println("Tested positive for AD.\n");
			choose = chrand(psADs.length);
			rword = psADs[choose];
		} else if (tword.equals("AV"))
		{
			//System.out.println("Tested positive for AV.\n");
			choose = chrand(psAVs.length);
			rword = psAVs[choose];
		}else if (tword.equals("CJ"))
		{
			//System.out.println("Tested positive for CJ.\n");
			choose = chrand(psCJs.length);
			rword = psCJs[choose];
		}else if (tword.equals("NN"))
		{
			//System.out.println("Tested positive for NN.\n");
			//System.out.println("Trying to choose a random noun.\n");
			choose = chrand(psNNs.length);
			rword = psNNs[choose];
		}else if (tword.equals("PN"))
		{
			//System.out.println("Tested positive for PN.\n");
			choose = chrand(psPNs.length);
			rword = psPNs[choose];
		}else if (tword.equals("PP"))
		{
			//System.out.println("Tested positive for PP.\n");
			choose = chrand(psPPs.length);
			rword = psPPs[choose];
		}else if (tword.equals("PR"))
		{
			//System.out.println("Tested positive for PR.\n");
			choose = chrand(psPRs.length);
			rword = psPRs[choose];
		}else if (tword.equals("VB"))
		{
			//System.out.println("Tested positive for VB.\n");
			choose = chrand(psVBs.length);
			rword = psVBs[choose];
		}else
		{
			System.out.println("Should never fail all tests.\n");
		}
		return rword;
	}


	private int chrand(int aLength) {
		int randomInt = randomGenerator.nextInt(aLength);
		return randomInt;
	}


	public void WriteStory() {
		// OK, what to do here
		// set number of paragraphs in story - get from config file  later
		numPar = randomGenerator.nextInt((Integer.parseInt(maxParagraphs)-Integer.parseInt(minParagraphs)))+Integer.parseInt(minParagraphs);
		System.out.println("Random Paragraphs chosen:"+numPar);
		// let's write those numPar
		currentStory = "";
		//System.out.print("in the model.WriteStory area.\n");
	      String newParagraph = "";
		for(int x = 1; x <= numPar; x = x+1) {
	          newParagraph = writeParagraph();
	          currentStory += newParagraph;
	       }
	      //currentStory += newParagraph;
		
	}


	private String writeParagraph() {
		// OK, what to do here?
		//System.out.print("in the model.WriteParagraph area\n");
		numSentPar = randomGenerator.nextInt(9)+3;
		String newSentence = "";
		String currentParagraph = "";
		// System.out.print("Number of sentences for this paragraph is: "+numSentPar+".");
	    for(int x = 1; x <= numSentPar; x = x+1) {
	    	newSentence = writeSentence();
	    	currentParagraph += newSentence;
	    }
	    currentParagraph +="\n\n";
	    // System.out.print("\n\n");
	    return currentParagraph;
	}


	private String writeSentence() {
		// OK,what do we do here
		// I think this whole thing is way too convoluted
		// choose random sentence structure
		// System.out.print("In the WriteSentence area.\n");
		String ranSentStru = psSSs[randomGenerator.nextInt(psSSs.length)];
		String completeSentence = fillSentence(ranSentStru)+" ";
		String output = completeSentence.substring(0, 1).toUpperCase() + completeSentence.substring(1);
		completeSentence = output;
		//System.out.print(completeSentence);
		return completeSentence;
		
	}

	public String getCurrentStory() {
		return this.currentStory;
	}

	public String getMinParagraphs() {
		return this.minParagraphs;
	}
	
	public String getMaxParagraphs() {
		return this.maxParagraphs;
	}
	
	public String getMinSentences() {
		return this.minSentences;
	}
	
	public String getMaxSentences() {
		return this.maxSentences;
	}
	
	public String getConfigDir() {
		return this.configDir;
	}

	public String getDataDir() {
		return this.dataDir;
	}

}

