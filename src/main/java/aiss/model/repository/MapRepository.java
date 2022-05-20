package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import aiss.model.Booklist;
import aiss.model.User;
import aiss.model.Book;


public class MapRepository implements BooklistRepository, UserRepository{

	Map<String, Booklist> booklistMap;
	Map<String, Book> bookMap;
	Map<String, User> userMap;
	private static MapRepository instance=null;
	private int idBL=0;
	private int idB=0;
	private int idU=0;
	
	
	public static MapRepository getInstance() {
		
		if (instance==null) {
			instance = new MapRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		
		booklistMap = new HashMap<String,Booklist>();
		bookMap = new HashMap<String,Book>();
		userMap = new HashMap<String, User>();
		
		// Create books
		Book fundamentalsofWavelets = new Book();
		fundamentalsofWavelets.setTitle("Fundamentals of Wavelets");
		fundamentalsofWavelets.setAuthor("Goswami, Jaideva");
		fundamentalsofWavelets.setGenre("signal_processing");
		fundamentalsofWavelets.setYear(2018);
		fundamentalsofWavelets.setRate(0.);
		fundamentalsofWavelets.setPagNumber(228);
		fundamentalsofWavelets.setPublisher("Wiley");
		addBook(fundamentalsofWavelets);

		Book dataSmart = new Book();
		dataSmart.setTitle("Data Smart");
		dataSmart.setAuthor("Foreman, John");
		dataSmart.setGenre("data_science");
		dataSmart.setYear(2019);
		dataSmart.setRate(0.);
		dataSmart.setPagNumber(235);
		dataSmart.setPublisher("Wiley");
		addBook(dataSmart);

		Book godCreatedtheIntegers = new Book();
		godCreatedtheIntegers.setTitle("God Created the Integers");
		godCreatedtheIntegers.setAuthor("Hawking, Stephen");
		godCreatedtheIntegers.setGenre("mathematics");
		godCreatedtheIntegers.setYear(2019);
		godCreatedtheIntegers.setRate(0.);
		godCreatedtheIntegers.setPagNumber(197);
		godCreatedtheIntegers.setPublisher("Penguin");
		addBook(godCreatedtheIntegers);

		Book superfreakonomics = new Book();
		superfreakonomics.setTitle("Superfreakonomics");
		superfreakonomics.setAuthor("Dubner, Stephen");
		superfreakonomics.setGenre("economics");
		superfreakonomics.setYear(2018);
		superfreakonomics.setRate(0.);
		superfreakonomics.setPagNumber(179);
		superfreakonomics.setPublisher("HarperCollins");
		addBook(superfreakonomics);

		Book orientalism = new Book();
		orientalism.setTitle("Orientalism");
		orientalism.setAuthor("Said, Edward");
		orientalism.setGenre("history");
		orientalism.setYear(2017);
		orientalism.setRate(0.);
		orientalism.setPagNumber(197);
		orientalism.setPublisher("Penguin");
		addBook(orientalism);

		Book natureofStatisticalLearningTheoryThe = new Book();
		natureofStatisticalLearningTheoryThe.setTitle("Nature of Statistical Learning Theory, The");
		natureofStatisticalLearningTheoryThe.setAuthor("Vapnik, Vladimir");
		natureofStatisticalLearningTheoryThe.setGenre("data_science");
		natureofStatisticalLearningTheoryThe.setYear(2017);
		natureofStatisticalLearningTheoryThe.setRate(0.);
		natureofStatisticalLearningTheoryThe.setPagNumber(230);
		natureofStatisticalLearningTheoryThe.setPublisher("Springer");
		addBook(natureofStatisticalLearningTheoryThe);

		Book integrationoftheIndianStates = new Book();
		integrationoftheIndianStates.setTitle("Integration of the Indian States");
		integrationoftheIndianStates.setAuthor("Menon, V P");
		integrationoftheIndianStates.setGenre("history");
		integrationoftheIndianStates.setYear(2019);
		integrationoftheIndianStates.setRate(0.);
		integrationoftheIndianStates.setPagNumber(217);
		integrationoftheIndianStates.setPublisher("Orient Blackswan");
		addBook(integrationoftheIndianStates);

		Book drunkardsWalkThe = new Book();
		drunkardsWalkThe.setTitle("Drunkard's Walk, The");
		drunkardsWalkThe.setAuthor("Mlodinow, Leonard");
		drunkardsWalkThe.setGenre("science");
		drunkardsWalkThe.setYear(2020);
		drunkardsWalkThe.setRate(0.);
		drunkardsWalkThe.setPagNumber(197);
		drunkardsWalkThe.setPublisher("Penguin");
		addBook(drunkardsWalkThe);

		Book imageProcessingMathematicalMorphology = new Book();
		imageProcessingMathematicalMorphology.setTitle("Image Processing & Mathematical Morphology");
		imageProcessingMathematicalMorphology.setAuthor("Shih, Frank");
		imageProcessingMathematicalMorphology.setGenre("signal_processing");
		imageProcessingMathematicalMorphology.setYear(2022);
		imageProcessingMathematicalMorphology.setRate(0.);
		imageProcessingMathematicalMorphology.setPagNumber(241);
		imageProcessingMathematicalMorphology.setPublisher("CRC");
		addBook(imageProcessingMathematicalMorphology);

		Book howtoThinkLikeSherlockHolmes = new Book();
		howtoThinkLikeSherlockHolmes.setTitle("How to Think Like Sherlock Holmes");
		howtoThinkLikeSherlockHolmes.setAuthor("Konnikova, Maria");
		howtoThinkLikeSherlockHolmes.setGenre("psychology");
		howtoThinkLikeSherlockHolmes.setYear(2020);
		howtoThinkLikeSherlockHolmes.setRate(0.);
		howtoThinkLikeSherlockHolmes.setPagNumber(240);
		howtoThinkLikeSherlockHolmes.setPublisher("Penguin");
		addBook(howtoThinkLikeSherlockHolmes);

		Book dataScientistsatWork = new Book();
		dataScientistsatWork.setTitle("Data Scientists at Work");
		dataScientistsatWork.setAuthor("Sebastian Gutierrez");
		dataScientistsatWork.setGenre("data_science");
		dataScientistsatWork.setYear(2021);
		dataScientistsatWork.setRate(0.);
		dataScientistsatWork.setPagNumber(230);
		dataScientistsatWork.setPublisher("Apress");
		addBook(dataScientistsatWork);

		Book slaughterhouseFive = new Book();
		slaughterhouseFive.setTitle("Slaughterhouse Five");
		slaughterhouseFive.setAuthor("Vonnegut, Kurt");
		slaughterhouseFive.setGenre("fiction");
		slaughterhouseFive.setYear(2021);
		slaughterhouseFive.setRate(0.);
		slaughterhouseFive.setPagNumber(198);
		slaughterhouseFive.setPublisher("Random House");
		addBook(slaughterhouseFive);

		Book birthofaTheorem = new Book();
		birthofaTheorem.setTitle("Birth of a Theorem");
		birthofaTheorem.setAuthor("Villani, Cedric");
		birthofaTheorem.setGenre("mathematics");
		birthofaTheorem.setYear(2021);
		birthofaTheorem.setRate(0.);
		birthofaTheorem.setPagNumber(234);
		birthofaTheorem.setPublisher("Bodley Head");
		addBook(birthofaTheorem);

		Book structureInterpretationofComputerPrograms = new Book();
		structureInterpretationofComputerPrograms.setTitle("Structure & Interpretation of Computer Programs");
		structureInterpretationofComputerPrograms.setAuthor("Sussman, Gerald");
		structureInterpretationofComputerPrograms.setGenre("computer_science");
		structureInterpretationofComputerPrograms.setYear(2022);
		structureInterpretationofComputerPrograms.setRate(0.);
		structureInterpretationofComputerPrograms.setPagNumber(240);
		structureInterpretationofComputerPrograms.setPublisher("MIT Press");
		addBook(structureInterpretationofComputerPrograms);

		Book ageofWrathThe = new Book();
		ageofWrathThe.setTitle("Age of Wrath, The");
		ageofWrathThe.setAuthor("Eraly, Abraham");
		ageofWrathThe.setGenre("history");
		ageofWrathThe.setYear(2022);
		ageofWrathThe.setRate(0.);
		ageofWrathThe.setPagNumber(238);
		ageofWrathThe.setPublisher("Penguin");
		addBook(ageofWrathThe);

		Book trialThe = new Book();
		trialThe.setTitle("Trial, The");
		trialThe.setAuthor("Kafka, Frank");
		trialThe.setGenre("fiction");
		trialThe.setYear(2022);
		trialThe.setRate(0.);
		trialThe.setPagNumber(198);
		trialThe.setPublisher("Random House");
		addBook(trialThe);

		Book statisticalDecisionTheory = new Book();
		statisticalDecisionTheory.setTitle("Statistical Decision Theory'");
		statisticalDecisionTheory.setAuthor("Pratt, John");
		statisticalDecisionTheory.setGenre("data_science");
		statisticalDecisionTheory.setYear(2020);
		statisticalDecisionTheory.setRate(0.);
		statisticalDecisionTheory.setPagNumber(236);
		statisticalDecisionTheory.setPublisher("MIT Press");
		addBook(statisticalDecisionTheory);

		Book dataMiningHandbook = new Book();
		dataMiningHandbook.setTitle("Data Mining Handbook");
		dataMiningHandbook.setAuthor("Nisbet, Robert");
		dataMiningHandbook.setGenre("data_science");
		dataMiningHandbook.setYear(2020);
		dataMiningHandbook.setRate(0.);
		dataMiningHandbook.setPagNumber(242);
		dataMiningHandbook.setPublisher("Apress");
		addBook(dataMiningHandbook);

		Book newMachiavelliThe = new Book();
		newMachiavelliThe.setTitle("New Machiavelli, The");
		newMachiavelliThe.setAuthor("Wells, H. G.");
		newMachiavelliThe.setGenre("fiction");
		newMachiavelliThe.setYear(2020);
		newMachiavelliThe.setRate(0.);
		newMachiavelliThe.setPagNumber(180);
		newMachiavelliThe.setPublisher("Penguin");
		addBook(newMachiavelliThe);

		Book physicsPhilosophy = new Book();
		physicsPhilosophy.setTitle("Physics & Philosophy");
		physicsPhilosophy.setAuthor("Heisenberg, Werner");
		physicsPhilosophy.setGenre("science");
		physicsPhilosophy.setYear(2020);
		physicsPhilosophy.setRate(0.);
		physicsPhilosophy.setPagNumber(197);
		physicsPhilosophy.setPublisher("Penguin");
		addBook(physicsPhilosophy);

		Book makingSoftware = new Book();
		makingSoftware.setTitle("Making Software");
		makingSoftware.setAuthor("Oram, Andy");
		makingSoftware.setGenre("computer_science");
		makingSoftware.setYear(2019);
		makingSoftware.setRate(0.);
		makingSoftware.setPagNumber(232);
		makingSoftware.setPublisher("O'Reilly");
		addBook(makingSoftware);

		Book analysisVolI = new Book();
		analysisVolI.setTitle("Analysis, Vol I");
		analysisVolI.setAuthor("Tao, Terence");
		analysisVolI.setGenre("mathematics");
		analysisVolI.setYear(2019);
		analysisVolI.setRate(0.);
		analysisVolI.setPagNumber(248);
		analysisVolI.setPublisher("HBA");
		addBook(analysisVolI);

		Book machineLearningforHackers = new Book();
		machineLearningforHackers.setTitle("Machine Learning for Hackers");
		machineLearningforHackers.setAuthor("Conway, Drew");
		machineLearningforHackers.setGenre("data_science");
		machineLearningforHackers.setYear(2018);
		machineLearningforHackers.setRate(0.);
		machineLearningforHackers.setPagNumber(233);
		machineLearningforHackers.setPublisher("O'Reilly");
		addBook(machineLearningforHackers);

		Book signalandtheNoiseThe = new Book();
		signalandtheNoiseThe.setTitle("Signal and the Noise, The");
		signalandtheNoiseThe.setAuthor("Silver, Nate");
		signalandtheNoiseThe.setGenre("data_science");
		signalandtheNoiseThe.setYear(2019);
		signalandtheNoiseThe.setRate(0.);
		signalandtheNoiseThe.setPagNumber(233);
		signalandtheNoiseThe.setPublisher("Penguin");
		addBook(signalandtheNoiseThe);

		Book pythonforDataAnalysis = new Book();
		pythonforDataAnalysis.setTitle("Python for Data Analysis");
		pythonforDataAnalysis.setAuthor("McKinney, Wes");
		pythonforDataAnalysis.setGenre("data_science");
		pythonforDataAnalysis.setYear(0);
		pythonforDataAnalysis.setRate(0.);
		pythonforDataAnalysis.setPagNumber(233);
		pythonforDataAnalysis.setPublisher("O'Reilly");
		addBook(pythonforDataAnalysis);

		Book introductiontoAlgorithms = new Book();
		introductiontoAlgorithms.setTitle("Introduction to Algorithms");
		introductiontoAlgorithms.setAuthor("Cormen, Thomas");
		introductiontoAlgorithms.setGenre("computer_science");
		introductiontoAlgorithms.setYear(2016);
		introductiontoAlgorithms.setRate(0.);
		introductiontoAlgorithms.setPagNumber(234);
		introductiontoAlgorithms.setPublisher("MIT Press");
		addBook(introductiontoAlgorithms);

		Book beautifulandtheDamnedThe = new Book();
		beautifulandtheDamnedThe.setTitle("Beautiful and the Damned, The");
		beautifulandtheDamnedThe.setAuthor("Deb, Siddhartha");
		beautifulandtheDamnedThe.setGenre("nonfiction");
		beautifulandtheDamnedThe.setYear(2017);
		beautifulandtheDamnedThe.setRate(0.);
		beautifulandtheDamnedThe.setPagNumber(198);
		beautifulandtheDamnedThe.setPublisher("Penguin");
		addBook(beautifulandtheDamnedThe);

		Book outsiderThe = new Book();
		outsiderThe.setTitle("Outsider, The");
		outsiderThe.setAuthor("Camus, Albert");
		outsiderThe.setGenre("fiction");
		outsiderThe.setYear(2018);
		outsiderThe.setRate(0.);
		outsiderThe.setPagNumber(198);
		outsiderThe.setPublisher("Penguin");
		addBook(outsiderThe);

		Book completeSherlockHolmesTheVolI = new Book();
		completeSherlockHolmesTheVolI.setTitle("Complete Sherlock Holmes, The - Vol I");
		completeSherlockHolmesTheVolI.setAuthor("Doyle, Arthur Conan");
		completeSherlockHolmesTheVolI.setGenre("fiction");
		completeSherlockHolmesTheVolI.setYear(2019);
		completeSherlockHolmesTheVolI.setRate(0.);
		completeSherlockHolmesTheVolI.setPagNumber(176);
		completeSherlockHolmesTheVolI.setPublisher("Random House");
		addBook(completeSherlockHolmesTheVolI);

		Book completeSherlockHolmesTheVolII = new Book();
		completeSherlockHolmesTheVolII.setTitle("Complete Sherlock Holmes, The - Vol II");
		completeSherlockHolmesTheVolII.setAuthor("Doyle, Arthur Conan");
		completeSherlockHolmesTheVolII.setGenre("fiction");
		completeSherlockHolmesTheVolII.setYear(0);
		completeSherlockHolmesTheVolII.setRate(0.);
		completeSherlockHolmesTheVolII.setPagNumber(176);
		completeSherlockHolmesTheVolII.setPublisher("Random House");
		addBook(completeSherlockHolmesTheVolII);

		Book wealthofNationsThe = new Book();
		wealthofNationsThe.setTitle("Wealth of Nations, The");
		wealthofNationsThe.setAuthor("Smith, Adam");
		wealthofNationsThe.setGenre("economics");
		wealthofNationsThe.setYear(0);
		wealthofNationsThe.setRate(0.);
		wealthofNationsThe.setPagNumber(175);
		wealthofNationsThe.setPublisher("Random House");
		addBook(wealthofNationsThe);

		Book pillarsoftheEarthThe = new Book();
		pillarsoftheEarthThe.setTitle("Pillars of the Earth, The");
		pillarsoftheEarthThe.setAuthor("Follett, Ken");
		pillarsoftheEarthThe.setGenre("fiction");
		pillarsoftheEarthThe.setYear(0);
		pillarsoftheEarthThe.setRate(0.);
		pillarsoftheEarthThe.setPagNumber(176);
		pillarsoftheEarthThe.setPublisher("Random House");
		addBook(pillarsoftheEarthThe);

		Book meinKampf = new Book();
		meinKampf.setTitle("Mein Kampf");
		meinKampf.setAuthor("Hitler, Adolf");
		meinKampf.setGenre("nonfiction");
		meinKampf.setYear(0);
		meinKampf.setRate(0.);
		meinKampf.setPagNumber(212);
		meinKampf.setPublisher("Rupa");
		addBook(meinKampf);

		Book taoofPhysicsThe = new Book();
		taoofPhysicsThe.setTitle("Tao of Physics, The");
		taoofPhysicsThe.setAuthor("Capra, Fritjof");
		taoofPhysicsThe.setGenre("science");
		taoofPhysicsThe.setYear(0);
		taoofPhysicsThe.setRate(0.);
		taoofPhysicsThe.setPagNumber(179);
		taoofPhysicsThe.setPublisher("Penguin");
		addBook(taoofPhysicsThe);

		Book surelyYoureJokingMrFeynman = new Book();
		surelyYoureJokingMrFeynman.setTitle("Surely You're Joking Mr Feynman");
		surelyYoureJokingMrFeynman.setAuthor("Feynman, Richard");
		surelyYoureJokingMrFeynman.setGenre("science");
		surelyYoureJokingMrFeynman.setYear(0);
		surelyYoureJokingMrFeynman.setRate(0.);
		surelyYoureJokingMrFeynman.setPagNumber(198);
		surelyYoureJokingMrFeynman.setPublisher("Random House");
		addBook(surelyYoureJokingMrFeynman);

		Book farewelltoArmsA = new Book();
		farewelltoArmsA.setTitle("Farewell to Arms, A");
		farewelltoArmsA.setAuthor("Hemingway, Ernest");
		farewelltoArmsA.setGenre("fiction");
		farewelltoArmsA.setYear(0);
		farewelltoArmsA.setRate(0.);
		farewelltoArmsA.setPagNumber(179);
		farewelltoArmsA.setPublisher("Rupa");
		addBook(farewelltoArmsA);

		Book veteranThe = new Book();
		veteranThe.setTitle("Veteran, The");
		veteranThe.setAuthor("Forsyth, Frederick");
		veteranThe.setGenre("fiction");
		veteranThe.setYear(0);
		veteranThe.setRate(0.);
		veteranThe.setPagNumber(177);
		veteranThe.setPublisher("Transworld");
		addBook(veteranThe);

		Book falseImpressions = new Book();
		falseImpressions.setTitle("False Impressions");
		falseImpressions.setAuthor("Archer, Jeffery");
		falseImpressions.setGenre("fiction");
		falseImpressions.setYear(0);
		falseImpressions.setRate(0.);
		falseImpressions.setPagNumber(177);
		falseImpressions.setPublisher("Pan");
		addBook(falseImpressions);

		Book lastLectureThe = new Book();
		lastLectureThe.setTitle("Last Lecture, The");
		lastLectureThe.setAuthor("Pausch, Randy");
		lastLectureThe.setGenre("nonfiction");
		lastLectureThe.setYear(0);
		lastLectureThe.setRate(0.);
		lastLectureThe.setPagNumber(197);
		lastLectureThe.setPublisher("Hyperion");
		addBook(lastLectureThe);

		Book returnofthePrimitive = new Book();
		returnofthePrimitive.setTitle("Return of the Primitive");
		returnofthePrimitive.setAuthor("Rand, Ayn");
		returnofthePrimitive.setGenre("philosophy");
		returnofthePrimitive.setYear(0);
		returnofthePrimitive.setRate(0.);
		returnofthePrimitive.setPagNumber(202);
		returnofthePrimitive.setPublisher("Penguin");
		addBook(returnofthePrimitive);

		Book jurassicPark = new Book();
		jurassicPark.setTitle("Jurassic Park");
		jurassicPark.setAuthor("Crichton, Michael");
		jurassicPark.setGenre("fiction");
		jurassicPark.setYear(0);
		jurassicPark.setRate(0.);
		jurassicPark.setPagNumber(174);
		jurassicPark.setPublisher("Random House");
		addBook(jurassicPark);

		Book russianJournalA = new Book();
		russianJournalA.setTitle("Russian Journal, A");
		russianJournalA.setAuthor("Steinbeck, John");
		russianJournalA.setGenre("nonfiction");
		russianJournalA.setYear(0);
		russianJournalA.setRate(0.);
		russianJournalA.setPagNumber(196);
		russianJournalA.setPublisher("Penguin");
		addBook(russianJournalA);

		Book talesofMysteryandImagination = new Book();
		talesofMysteryandImagination.setTitle("Tales of Mystery and Imagination");
		talesofMysteryandImagination.setAuthor("Poe, Edgar Allen");
		talesofMysteryandImagination.setGenre("fiction");
		talesofMysteryandImagination.setYear(0);
		talesofMysteryandImagination.setRate(0.);
		talesofMysteryandImagination.setPagNumber(172);
		talesofMysteryandImagination.setPublisher("HarperCollins");
		addBook(talesofMysteryandImagination);

		Book freakonomics = new Book();
		freakonomics.setTitle("Freakonomics");
		freakonomics.setAuthor("Dubner, Stephen");
		freakonomics.setGenre("economics");
		freakonomics.setYear(0);
		freakonomics.setRate(0.);
		freakonomics.setPagNumber(197);
		freakonomics.setPublisher("Penguin");
		addBook(freakonomics);

		Book hiddenConnectionsThe = new Book();
		hiddenConnectionsThe.setTitle("Hidden Connections, The");
		hiddenConnectionsThe.setAuthor("Capra, Fritjof");
		hiddenConnectionsThe.setGenre("science");
		hiddenConnectionsThe.setYear(0);
		hiddenConnectionsThe.setRate(0.);
		hiddenConnectionsThe.setPagNumber(197);
		hiddenConnectionsThe.setPublisher("HarperCollins");
		addBook(hiddenConnectionsThe);

		Book storyofPhilosophyThe = new Book();
		storyofPhilosophyThe.setTitle("Story of Philosophy, The");
		storyofPhilosophyThe.setAuthor("Durant, Will");
		storyofPhilosophyThe.setGenre("philosophy");
		storyofPhilosophyThe.setYear(0);
		storyofPhilosophyThe.setRate(0.);
		storyofPhilosophyThe.setPagNumber(170);
		storyofPhilosophyThe.setPublisher("Pocket");
		addBook(storyofPhilosophyThe);

		Book asamiAsami = new Book();
		asamiAsami.setTitle("Asami Asami");
		asamiAsami.setAuthor("Deshpande, P L");
		asamiAsami.setGenre("fiction");
		asamiAsami.setYear(0);
		asamiAsami.setRate(0.);
		asamiAsami.setPagNumber(205);
		asamiAsami.setPublisher("Mauj");
		addBook(asamiAsami);

		Book journalofaNovel = new Book();
		journalofaNovel.setTitle("Journal of a Novel");
		journalofaNovel.setAuthor("Steinbeck, John");
		journalofaNovel.setGenre("fiction");
		journalofaNovel.setYear(0);
		journalofaNovel.setRate(0.);
		journalofaNovel.setPagNumber(196);
		journalofaNovel.setPublisher("Penguin");
		addBook(journalofaNovel);

		Book onceThereWasaWar = new Book();
		onceThereWasaWar.setTitle("Once There Was a War");
		onceThereWasaWar.setAuthor("Steinbeck, John");
		onceThereWasaWar.setGenre("nonfiction");
		onceThereWasaWar.setYear(0);
		onceThereWasaWar.setRate(0.);
		onceThereWasaWar.setPagNumber(196);
		onceThereWasaWar.setPublisher("Penguin");
		addBook(onceThereWasaWar);

		Book moonisDownThe = new Book();
		moonisDownThe.setTitle("Moon is Down, The");
		moonisDownThe.setAuthor("Steinbeck, John");
		moonisDownThe.setGenre("fiction");
		moonisDownThe.setYear(0);
		moonisDownThe.setRate(0.);
		moonisDownThe.setPagNumber(196);
		moonisDownThe.setPublisher("Penguin");
		addBook(moonisDownThe);

		Book brethrenThe = new Book();
		brethrenThe.setTitle("Brethren, The");
		brethrenThe.setAuthor("Grisham, John");
		brethrenThe.setGenre("fiction");
		brethrenThe.setYear(0);
		brethrenThe.setRate(0.);
		brethrenThe.setPagNumber(174);
		brethrenThe.setPublisher("Random House");
		addBook(brethrenThe);

		Book inaFreeState = new Book();
		inaFreeState.setTitle("In a Free State");
		inaFreeState.setAuthor("Naipaul, V. S.");
		inaFreeState.setGenre("fiction");
		inaFreeState.setYear(0);
		inaFreeState.setRate(0.);
		inaFreeState.setPagNumber(196);
		inaFreeState.setPublisher("Rupa");
		addBook(inaFreeState);

		Book catch22 = new Book();
		catch22.setTitle("Catch 22");
		catch22.setAuthor("Heller, Joseph");
		catch22.setGenre("fiction");
		catch22.setYear(0);
		catch22.setRate(0.);
		catch22.setPagNumber(178);
		catch22.setPublisher("Random House");
		addBook(catch22);

		Book completeMastermindThe = new Book();
		completeMastermindThe.setTitle("Complete Mastermind, The");
		completeMastermindThe.setAuthor("BBC");
		completeMastermindThe.setGenre("nonfiction");
		completeMastermindThe.setYear(0);
		completeMastermindThe.setRate(0.);
		completeMastermindThe.setPagNumber(178);
		completeMastermindThe.setPublisher("BBC");
		addBook(completeMastermindThe);

		Book dylanonDylan = new Book();
		dylanonDylan.setTitle("Dylan on Dylan");
		dylanonDylan.setAuthor("Dylan, Bob");
		dylanonDylan.setGenre("nonfiction");
		dylanonDylan.setYear(0);
		dylanonDylan.setRate(0.);
		dylanonDylan.setPagNumber(197);
		dylanonDylan.setPublisher("Random House");
		addBook(dylanonDylan);

		Book softComputingIntelligentSystems = new Book();
		softComputingIntelligentSystems.setTitle("Soft Computing & Intelligent Systems");
		softComputingIntelligentSystems.setAuthor("Gupta, Madan");
		softComputingIntelligentSystems.setGenre("data_science");
		softComputingIntelligentSystems.setYear(0);
		softComputingIntelligentSystems.setRate(0.);
		softComputingIntelligentSystems.setPagNumber(242);
		softComputingIntelligentSystems.setPublisher("Elsevier");
		addBook(softComputingIntelligentSystems);

		Book textbookofEconomicTheory = new Book();
		textbookofEconomicTheory.setTitle("Textbook of Economic Theory");
		textbookofEconomicTheory.setAuthor("Stonier, Alfred");
		textbookofEconomicTheory.setGenre("economics");
		textbookofEconomicTheory.setYear(0);
		textbookofEconomicTheory.setRate(0.);
		textbookofEconomicTheory.setPagNumber(242);
		textbookofEconomicTheory.setPublisher("Pearson");
		addBook(textbookofEconomicTheory);

		Book econometricAnalysis = new Book();
		econometricAnalysis.setTitle("Econometric Analysis");
		econometricAnalysis.setAuthor("Greene, W. H.");
		econometricAnalysis.setGenre("economics");
		econometricAnalysis.setYear(0);
		econometricAnalysis.setRate(0.);
		econometricAnalysis.setPagNumber(242);
		econometricAnalysis.setPublisher("Pearson");
		addBook(econometricAnalysis);

		Book learningOpenCV = new Book();
		learningOpenCV.setTitle("Learning OpenCV");
		learningOpenCV.setAuthor("Bradsky, Gary");
		learningOpenCV.setGenre("data_science");
		learningOpenCV.setYear(0);
		learningOpenCV.setRate(0.);
		learningOpenCV.setPagNumber(232);
		learningOpenCV.setPublisher("O'Reilly");
		addBook(learningOpenCV);

		Book dataStructuresUsingCC = new Book();
		dataStructuresUsingCC.setTitle("Data Structures Using C & C++");
		dataStructuresUsingCC.setAuthor("Tanenbaum, Andrew");
		dataStructuresUsingCC.setGenre("computer_science");
		dataStructuresUsingCC.setYear(0);
		dataStructuresUsingCC.setRate(0.);
		dataStructuresUsingCC.setPagNumber(235);
		dataStructuresUsingCC.setPublisher("Prentice Hall");
		addBook(dataStructuresUsingCC);

		Book computerVisionAModernApproach = new Book();
		computerVisionAModernApproach.setTitle("Computer Vision, A Modern Approach");
		computerVisionAModernApproach.setAuthor("Forsyth, David");
		computerVisionAModernApproach.setGenre("data_science");
		computerVisionAModernApproach.setYear(0);
		computerVisionAModernApproach.setRate(0.);
		computerVisionAModernApproach.setPagNumber(255);
		computerVisionAModernApproach.setPublisher("Pearson");
		addBook(computerVisionAModernApproach);

		Book principlesofCommunicationSystems = new Book();
		principlesofCommunicationSystems.setTitle("Principles of Communication Systems");
		principlesofCommunicationSystems.setAuthor("Taub, Schilling");
		principlesofCommunicationSystems.setGenre("computer_science");
		principlesofCommunicationSystems.setYear(0);
		principlesofCommunicationSystems.setRate(0.);
		principlesofCommunicationSystems.setPagNumber(240);
		principlesofCommunicationSystems.setPublisher("TMH");
		addBook(principlesofCommunicationSystems);

		Book letUsC = new Book();
		letUsC.setTitle("Let Us C");
		letUsC.setAuthor("Kanetkar, Yashwant");
		letUsC.setGenre("computer_science");
		letUsC.setYear(0);
		letUsC.setRate(0.);
		letUsC.setPagNumber(213);
		letUsC.setPublisher("Prentice Hall");
		addBook(letUsC);

		Book amuletofSamarkandThe = new Book();
		amuletofSamarkandThe.setTitle("Amulet of Samarkand, The");
		amuletofSamarkandThe.setAuthor("Stroud, Jonathan");
		amuletofSamarkandThe.setGenre("fiction");
		amuletofSamarkandThe.setYear(0);
		amuletofSamarkandThe.setRate(0.);
		amuletofSamarkandThe.setPagNumber(179);
		amuletofSamarkandThe.setPublisher("Random House");
		addBook(amuletofSamarkandThe);

		Book crimeandPunishment = new Book();
		crimeandPunishment.setTitle("Crime and Punishment");
		crimeandPunishment.setAuthor("Dostoevsky, Fyodor");
		crimeandPunishment.setGenre("fiction");
		crimeandPunishment.setYear(0);
		crimeandPunishment.setRate(0.);
		crimeandPunishment.setPagNumber(180);
		crimeandPunishment.setPublisher("Penguin");
		addBook(crimeandPunishment);

		Book angelsDemons = new Book();
		angelsDemons.setTitle("Angels & Demons");
		angelsDemons.setAuthor("Brown, Dan");
		angelsDemons.setGenre("fiction");
		angelsDemons.setYear(0);
		angelsDemons.setRate(0.);
		angelsDemons.setPagNumber(178);
		angelsDemons.setPublisher("Random House");
		addBook(angelsDemons);

		Book argumentativeIndianThe = new Book();
		argumentativeIndianThe.setTitle("Argumentative Indian, The");
		argumentativeIndianThe.setAuthor("Sen, Amartya");
		argumentativeIndianThe.setGenre("nonfiction");
		argumentativeIndianThe.setYear(0);
		argumentativeIndianThe.setRate(0.);
		argumentativeIndianThe.setPagNumber(209);
		argumentativeIndianThe.setPublisher("Picador");
		addBook(argumentativeIndianThe);

		Book seaofPoppies = new Book();
		seaofPoppies.setTitle("Sea of Poppies");
		seaofPoppies.setAuthor("Ghosh, Amitav");
		seaofPoppies.setGenre("fiction");
		seaofPoppies.setYear(0);
		seaofPoppies.setRate(0.);
		seaofPoppies.setPagNumber(197);
		seaofPoppies.setPublisher("Penguin");
		addBook(seaofPoppies);

		Book ideaofJusticeThe = new Book();
		ideaofJusticeThe.setTitle("Idea of Justice, The");
		ideaofJusticeThe.setAuthor("Sen, Amartya");
		ideaofJusticeThe.setGenre("nonfiction");
		ideaofJusticeThe.setYear(0);
		ideaofJusticeThe.setRate(0.);
		ideaofJusticeThe.setPagNumber(212);
		ideaofJusticeThe.setPublisher("Penguin");
		addBook(ideaofJusticeThe);

		Book raisinintheSunA = new Book();
		raisinintheSunA.setTitle("Raisin in the Sun, A");
		raisinintheSunA.setAuthor("Hansberry, Lorraine");
		raisinintheSunA.setGenre("fiction");
		raisinintheSunA.setYear(0);
		raisinintheSunA.setRate(0.);
		raisinintheSunA.setPagNumber(175);
		raisinintheSunA.setPublisher("Penguin");
		addBook(raisinintheSunA);

		Book allthePresidentsMen = new Book();
		allthePresidentsMen.setTitle("All the President's Men");
		allthePresidentsMen.setAuthor("Woodward, Bob");
		allthePresidentsMen.setGenre("history");
		allthePresidentsMen.setYear(0);
		allthePresidentsMen.setRate(0.);
		allthePresidentsMen.setPagNumber(177);
		allthePresidentsMen.setPublisher("Random House");
		addBook(allthePresidentsMen);

		Book prisonerofBirthA = new Book();
		prisonerofBirthA.setTitle("Prisoner of Birth, A");
		prisonerofBirthA.setAuthor("Archer, Jeffery");
		prisonerofBirthA.setGenre("fiction");
		prisonerofBirthA.setYear(0);
		prisonerofBirthA.setRate(0.);
		prisonerofBirthA.setPagNumber(176);
		prisonerofBirthA.setPublisher("Pan");
		addBook(prisonerofBirthA);

		Book scoop = new Book();
		scoop.setTitle("Scoop!");
		scoop.setAuthor("Nayar, Kuldip");
		scoop.setGenre("history");
		scoop.setYear(0);
		scoop.setRate(0.);
		scoop.setPagNumber(216);
		scoop.setPublisher("HarperCollins");
		addBook(scoop);

		Book aheManoharTari = new Book();
		aheManoharTari.setTitle("Ahe Manohar Tari");
		aheManoharTari.setAuthor("Deshpande, Sunita");
		aheManoharTari.setGenre("nonfiction");
		aheManoharTari.setYear(0);
		aheManoharTari.setRate(0.);
		aheManoharTari.setPagNumber(213);
		aheManoharTari.setPublisher("Mauj");
		addBook(aheManoharTari);

		Book lastMughalThe = new Book();
		lastMughalThe.setTitle("Last Mughal, The");
		lastMughalThe.setAuthor("Dalrymple, William");
		lastMughalThe.setGenre("history");
		lastMughalThe.setYear(0);
		lastMughalThe.setRate(0.);
		lastMughalThe.setPagNumber(199);
		lastMughalThe.setPublisher("Penguin");
		addBook(lastMughalThe);

		Book socialChoiceWelfareVol39No1 = new Book();
		socialChoiceWelfareVol39No1.setTitle("Social Choice & Welfare, Vol 39 No. 1");
		socialChoiceWelfareVol39No1.setAuthor("Various");
		socialChoiceWelfareVol39No1.setGenre("economics");
		socialChoiceWelfareVol39No1.setYear(0);
		socialChoiceWelfareVol39No1.setRate(0.);
		socialChoiceWelfareVol39No1.setPagNumber(235);
		socialChoiceWelfareVol39No1.setPublisher("Springer");
		addBook(socialChoiceWelfareVol39No1);

		Book radiowarilBhashaneShrutika = new Book();
		radiowarilBhashaneShrutika.setTitle("Radiowaril Bhashane & Shrutika");
		radiowarilBhashaneShrutika.setAuthor("Deshpande, P L");
		radiowarilBhashaneShrutika.setGenre("nonfiction");
		radiowarilBhashaneShrutika.setYear(0);
		radiowarilBhashaneShrutika.setRate(0.);
		radiowarilBhashaneShrutika.setPagNumber(213);
		radiowarilBhashaneShrutika.setPublisher("Mauj");
		addBook(radiowarilBhashaneShrutika);

		Book gunGayinAwadi = new Book();
		gunGayinAwadi.setTitle("Gun Gayin Awadi");
		gunGayinAwadi.setAuthor("Deshpande, P L");
		gunGayinAwadi.setGenre("nonfiction");
		gunGayinAwadi.setYear(0);
		gunGayinAwadi.setRate(0.);
		gunGayinAwadi.setPagNumber(212);
		gunGayinAwadi.setPublisher("Mauj");
		addBook(gunGayinAwadi);

		Book aghalPaghal = new Book();
		aghalPaghal.setTitle("Aghal Paghal");
		aghalPaghal.setAuthor("Deshpande, P L");
		aghalPaghal.setGenre("nonfiction");
		aghalPaghal.setYear(0);
		aghalPaghal.setRate(0.);
		aghalPaghal.setPagNumber(212);
		aghalPaghal.setPublisher("Mauj");
		addBook(aghalPaghal);

		Book maqtaeGhalib = new Book();
		maqtaeGhalib.setTitle("Maqta-e-Ghalib");
		maqtaeGhalib.setAuthor("Garg, Sanjay");
		maqtaeGhalib.setGenre("fiction");
		maqtaeGhalib.setYear(0);
		maqtaeGhalib.setRate(0.);
		maqtaeGhalib.setPagNumber(221);
		maqtaeGhalib.setPublisher("Mauj");
		addBook(maqtaeGhalib);

		Book beyondDegrees = new Book();
		beyondDegrees.setTitle("Beyond Degrees");
		beyondDegrees.setAuthor("?");
		beyondDegrees.setGenre("nonfiction");
		beyondDegrees.setYear(0);
		beyondDegrees.setRate(0.);
		beyondDegrees.setPagNumber(222);
		beyondDegrees.setPublisher("HarperCollins");
		addBook(beyondDegrees);

		Book manasa = new Book();
		manasa.setTitle("Manasa");
		manasa.setAuthor("Kale, V P");
		manasa.setGenre("nonfiction");
		manasa.setYear(0);
		manasa.setRate(0.);
		manasa.setPagNumber(213);
		manasa.setPublisher("Mauj");
		addBook(manasa);

		Book indiafromMidnighttoMilennium = new Book();
		indiafromMidnighttoMilennium.setTitle("India from Midnight to Milennium");
		indiafromMidnighttoMilennium.setAuthor("Tharoor, Shashi");
		indiafromMidnighttoMilennium.setGenre("history");
		indiafromMidnighttoMilennium.setYear(0);
		indiafromMidnighttoMilennium.setRate(0.);
		indiafromMidnighttoMilennium.setPagNumber(198);
		indiafromMidnighttoMilennium.setPublisher("Penguin");
		addBook(indiafromMidnighttoMilennium);

		Book worldsGreatestTrialsThe = new Book();
		worldsGreatestTrialsThe.setTitle("World's Greatest Trials, The");
		worldsGreatestTrialsThe.setAuthor("?");
		worldsGreatestTrialsThe.setGenre("history");
		worldsGreatestTrialsThe.setYear(0);
		worldsGreatestTrialsThe.setRate(0.);
		worldsGreatestTrialsThe.setPagNumber(210);
		worldsGreatestTrialsThe.setPublisher("?");
		addBook(worldsGreatestTrialsThe);

		Book greatIndianNovelThe = new Book();
		greatIndianNovelThe.setTitle("Great Indian Novel, The");
		greatIndianNovelThe.setAuthor("Tharoor, Shashi");
		greatIndianNovelThe.setGenre("fiction");
		greatIndianNovelThe.setYear(0);
		greatIndianNovelThe.setRate(0.);
		greatIndianNovelThe.setPagNumber(198);
		greatIndianNovelThe.setPublisher("Penguin");
		addBook(greatIndianNovelThe);

		Book oJerusalem = new Book();
		oJerusalem.setTitle("O Jerusalem!");
		oJerusalem.setAuthor("Lapierre, Dominique");
		oJerusalem.setGenre("history");
		oJerusalem.setYear(0);
		oJerusalem.setRate(0.);
		oJerusalem.setPagNumber(217);
		oJerusalem.setPublisher("vikas");
		addBook(oJerusalem);

		Book cityofJoyThe = new Book();
		cityofJoyThe.setTitle("City of Joy, The");
		cityofJoyThe.setAuthor("Lapierre, Dominique");
		cityofJoyThe.setGenre("fiction");
		cityofJoyThe.setYear(0);
		cityofJoyThe.setRate(0.);
		cityofJoyThe.setPagNumber(177);
		cityofJoyThe.setPublisher("vikas");
		addBook(cityofJoyThe);

		Book freedomatMidnight = new Book();
		freedomatMidnight.setTitle("Freedom at Midnight");
		freedomatMidnight.setAuthor("Lapierre, Dominique");
		freedomatMidnight.setGenre("history");
		freedomatMidnight.setYear(0);
		freedomatMidnight.setRate(0.);
		freedomatMidnight.setPagNumber(167);
		freedomatMidnight.setPublisher("vikas");
		addBook(freedomatMidnight);

		Book winterofOurDiscontentThe = new Book();
		winterofOurDiscontentThe.setTitle("Winter of Our Discontent, The");
		winterofOurDiscontentThe.setAuthor("Steinbeck, John");
		winterofOurDiscontentThe.setGenre("fiction");
		winterofOurDiscontentThe.setYear(0);
		winterofOurDiscontentThe.setRate(0.);
		winterofOurDiscontentThe.setPagNumber(196);
		winterofOurDiscontentThe.setPublisher("Penguin");
		addBook(winterofOurDiscontentThe);

		Book onEducation = new Book();
		onEducation.setTitle("On Education");
		onEducation.setAuthor("Russell, Bertrand");
		onEducation.setGenre("philosophy");
		onEducation.setYear(0);
		onEducation.setRate(0.);
		onEducation.setPagNumber(203);
		onEducation.setPublisher("Routledge");
		addBook(onEducation);

		Book freeWill = new Book();
		freeWill.setTitle("Free Will");
		freeWill.setAuthor("Harris, Sam");
		freeWill.setGenre("philosophy");
		freeWill.setYear(0);
		freeWill.setRate(0.);
		freeWill.setPagNumber(203);
		freeWill.setPublisher("FreePress");
		addBook(freeWill);

		Book booklessinBaghdad = new Book();
		booklessinBaghdad.setTitle("Bookless in Baghdad");
		booklessinBaghdad.setAuthor("Tharoor, Shashi");
		booklessinBaghdad.setGenre("nonfiction");
		booklessinBaghdad.setYear(0);
		booklessinBaghdad.setRate(0.);
		booklessinBaghdad.setPagNumber(206);
		booklessinBaghdad.setPublisher("Penguin");
		addBook(booklessinBaghdad);

		Book caseoftheLameCanaryThe = new Book();
		caseoftheLameCanaryThe.setTitle("Case of the Lame Canary, The");
		caseoftheLameCanaryThe.setAuthor("Gardner, Earle Stanley");
		caseoftheLameCanaryThe.setGenre("fiction");
		caseoftheLameCanaryThe.setYear(0);
		caseoftheLameCanaryThe.setRate(0.);
		caseoftheLameCanaryThe.setPagNumber(179);
		caseoftheLameCanaryThe.setPublisher("?");
		addBook(caseoftheLameCanaryThe);

		Book theoryofEverythingThe = new Book();
		theoryofEverythingThe.setTitle("Theory of Everything, The");
		theoryofEverythingThe.setAuthor("Hawking, Stephen");
		theoryofEverythingThe.setGenre("science");
		theoryofEverythingThe.setYear(0);
		theoryofEverythingThe.setRate(0.);
		theoryofEverythingThe.setPagNumber(217);
		theoryofEverythingThe.setPublisher("Jaico");
		addBook(theoryofEverythingThe);

		Book newMarketsOtherEssays = new Book();
		newMarketsOtherEssays.setTitle("New Markets & Other Essays");
		newMarketsOtherEssays.setAuthor("Drucker, Peter");
		newMarketsOtherEssays.setGenre("economics");
		newMarketsOtherEssays.setYear(0);
		newMarketsOtherEssays.setRate(0.);
		newMarketsOtherEssays.setPagNumber(176);
		newMarketsOtherEssays.setPublisher("Penguin");
		addBook(newMarketsOtherEssays);

		Book electricUniverse = new Book();
		electricUniverse.setTitle("Electric Universe");
		electricUniverse.setAuthor("Bodanis, David");
		electricUniverse.setGenre("science");
		electricUniverse.setYear(0);
		electricUniverse.setRate(0.);
		electricUniverse.setPagNumber(201);
		electricUniverse.setPublisher("Penguin");
		addBook(electricUniverse);

		Book hunchbackofNotreDameThe = new Book();
		hunchbackofNotreDameThe.setTitle("Hunchback of Notre Dame, The");
		hunchbackofNotreDameThe.setAuthor("Hugo, Victor");
		hunchbackofNotreDameThe.setGenre("fiction");
		hunchbackofNotreDameThe.setYear(0);
		hunchbackofNotreDameThe.setRate(0.);
		hunchbackofNotreDameThe.setPagNumber(175);
		hunchbackofNotreDameThe.setPublisher("Random House");
		addBook(hunchbackofNotreDameThe);

		Book burningBright = new Book();
		burningBright.setTitle("Burning Bright");
		burningBright.setAuthor("Steinbeck, John");
		burningBright.setGenre("fiction");
		burningBright.setYear(0);
		burningBright.setRate(0.);
		burningBright.setPagNumber(175);
		burningBright.setPublisher("Penguin");
		addBook(burningBright);

		Book ageofDiscontuinityThe = new Book();
		ageofDiscontuinityThe.setTitle("Age of Discontuinity, The");
		ageofDiscontuinityThe.setAuthor("Drucker, Peter");
		ageofDiscontuinityThe.setGenre("economics");
		ageofDiscontuinityThe.setYear(0);
		ageofDiscontuinityThe.setRate(0.);
		ageofDiscontuinityThe.setPagNumber(178);
		ageofDiscontuinityThe.setPublisher("Random House");
		addBook(ageofDiscontuinityThe);

		Book doctorintheNude = new Book();
		doctorintheNude.setTitle("Doctor in the Nude");
		doctorintheNude.setAuthor("Gordon, Richard");
		doctorintheNude.setGenre("fiction");
		doctorintheNude.setYear(0);
		doctorintheNude.setRate(0.);
		doctorintheNude.setPagNumber(179);
		doctorintheNude.setPublisher("Penguin");
		addBook(doctorintheNude);

		Book downandOutinParisLondon = new Book();
		downandOutinParisLondon.setTitle("Down and Out in Paris & London");
		downandOutinParisLondon.setAuthor("Orwell, George");
		downandOutinParisLondon.setGenre("nonfiction");
		downandOutinParisLondon.setYear(0);
		downandOutinParisLondon.setRate(0.);
		downandOutinParisLondon.setPagNumber(179);
		downandOutinParisLondon.setPublisher("Penguin");
		addBook(downandOutinParisLondon);

		Book identityViolence = new Book();
		identityViolence.setTitle("Identity & Violence");
		identityViolence.setAuthor("Sen, Amartya");
		identityViolence.setGenre("philosophy");
		identityViolence.setYear(0);
		identityViolence.setRate(0.);
		identityViolence.setPagNumber(219);
		identityViolence.setPublisher("Penguin");
		addBook(identityViolence);

		Book beyondtheThreeSeas = new Book();
		beyondtheThreeSeas.setTitle("Beyond the Three Seas");
		beyondtheThreeSeas.setAuthor("Dalrymple, William");
		beyondtheThreeSeas.setGenre("history");
		beyondtheThreeSeas.setYear(0);
		beyondtheThreeSeas.setRate(0.);
		beyondtheThreeSeas.setPagNumber(197);
		beyondtheThreeSeas.setPublisher("Random House");
		addBook(beyondtheThreeSeas);

		Book worldsGreatestShortStoriesThe = new Book();
		worldsGreatestShortStoriesThe.setTitle("World's Greatest Short Stories, The");
		worldsGreatestShortStoriesThe.setAuthor("?");
		worldsGreatestShortStoriesThe.setGenre("fiction");
		worldsGreatestShortStoriesThe.setYear(0);
		worldsGreatestShortStoriesThe.setRate(0.);
		worldsGreatestShortStoriesThe.setPagNumber(217);
		worldsGreatestShortStoriesThe.setPublisher("Jaico");
		addBook(worldsGreatestShortStoriesThe);

		Book talkingStraight = new Book();
		talkingStraight.setTitle("Talking Straight");
		talkingStraight.setAuthor("Iacoca, Lee");
		talkingStraight.setGenre("nonfiction");
		talkingStraight.setYear(0);
		talkingStraight.setRate(0.);
		talkingStraight.setPagNumber(175);
		talkingStraight.setPublisher("?");
		addBook(talkingStraight);

		Book maughamsCollectedShortStoriesVol3 = new Book();
		maughamsCollectedShortStoriesVol3.setTitle("Maugham's Collected Short Stories, Vol 3");
		maughamsCollectedShortStoriesVol3.setAuthor("Maugham, William S");
		maughamsCollectedShortStoriesVol3.setGenre("fiction");
		maughamsCollectedShortStoriesVol3.setYear(0);
		maughamsCollectedShortStoriesVol3.setRate(0.);
		maughamsCollectedShortStoriesVol3.setPagNumber(171);
		maughamsCollectedShortStoriesVol3.setPublisher("Vintage");
		addBook(maughamsCollectedShortStoriesVol3);

		Book phantomofManhattanThe = new Book();
		phantomofManhattanThe.setTitle("Phantom of Manhattan, The");
		phantomofManhattanThe.setAuthor("Forsyth, Frederick");
		phantomofManhattanThe.setGenre("fiction");
		phantomofManhattanThe.setYear(0);
		phantomofManhattanThe.setRate(0.);
		phantomofManhattanThe.setPagNumber(180);
		phantomofManhattanThe.setPublisher("?");
		addBook(phantomofManhattanThe);

		Book ashendenofTheBritishAgent = new Book();
		ashendenofTheBritishAgent.setTitle("Ashenden of The British Agent");
		ashendenofTheBritishAgent.setAuthor("Maugham, William S");
		ashendenofTheBritishAgent.setGenre("fiction");
		ashendenofTheBritishAgent.setYear(0);
		ashendenofTheBritishAgent.setRate(0.);
		ashendenofTheBritishAgent.setPagNumber(160);
		ashendenofTheBritishAgent.setPublisher("Vintage");
		addBook(ashendenofTheBritishAgent);

		Book zenTheArtofMotorcycleMaintenance = new Book();
		zenTheArtofMotorcycleMaintenance.setTitle("Zen & The Art of Motorcycle Maintenance");
		zenTheArtofMotorcycleMaintenance.setAuthor("Pirsig, Robert");
		zenTheArtofMotorcycleMaintenance.setGenre("philosophy");
		zenTheArtofMotorcycleMaintenance.setYear(0);
		zenTheArtofMotorcycleMaintenance.setRate(0.);
		zenTheArtofMotorcycleMaintenance.setPagNumber(172);
		zenTheArtofMotorcycleMaintenance.setPublisher("Vintage");
		addBook(zenTheArtofMotorcycleMaintenance);

		Book greatWarforCivilizationThe = new Book();
		greatWarforCivilizationThe.setTitle("Great War for Civilization, The");
		greatWarforCivilizationThe.setAuthor("Fisk, Robert");
		greatWarforCivilizationThe.setGenre("history");
		greatWarforCivilizationThe.setYear(0);
		greatWarforCivilizationThe.setRate(0.);
		greatWarforCivilizationThe.setPagNumber(197);
		greatWarforCivilizationThe.setPublisher("HarperCollins");
		addBook(greatWarforCivilizationThe);

		Book wetheLiving = new Book();
		wetheLiving.setTitle("We the Living");
		wetheLiving.setAuthor("Rand, Ayn");
		wetheLiving.setGenre("fiction");
		wetheLiving.setYear(0);
		wetheLiving.setRate(0.);
		wetheLiving.setPagNumber(178);
		wetheLiving.setPublisher("Penguin");
		addBook(wetheLiving);

		Book artistandtheMathematicianThe = new Book();
		artistandtheMathematicianThe.setTitle("Artist and the Mathematician, The");
		artistandtheMathematicianThe.setAuthor("Aczel, Amir");
		artistandtheMathematicianThe.setGenre("science");
		artistandtheMathematicianThe.setYear(0);
		artistandtheMathematicianThe.setRate(0.);
		artistandtheMathematicianThe.setPagNumber(186);
		artistandtheMathematicianThe.setPublisher("HighStakes");
		addBook(artistandtheMathematicianThe);

		Book historyofWesternPhilosophy = new Book();
		historyofWesternPhilosophy.setTitle("History of Western Philosophy");
		historyofWesternPhilosophy.setAuthor("Russell, Bertrand");
		historyofWesternPhilosophy.setGenre("philosophy");
		historyofWesternPhilosophy.setYear(0);
		historyofWesternPhilosophy.setRate(0.);
		historyofWesternPhilosophy.setPagNumber(213);
		historyofWesternPhilosophy.setPublisher("Routledge");
		addBook(historyofWesternPhilosophy);

		Book selectedShortStories = new Book();
		selectedShortStories.setTitle("Selected Short Stories");
		selectedShortStories.setAuthor("?");
		selectedShortStories.setGenre("fiction");
		selectedShortStories.setYear(0);
		selectedShortStories.setRate(0.);
		selectedShortStories.setPagNumber(215);
		selectedShortStories.setPublisher("Jaico");
		addBook(selectedShortStories);

		Book rationalityFreedom = new Book();
		rationalityFreedom.setTitle("Rationality & Freedom");
		rationalityFreedom.setAuthor("Sen, Amartya");
		rationalityFreedom.setGenre("economics");
		rationalityFreedom.setYear(0);
		rationalityFreedom.setRate(0.);
		rationalityFreedom.setPagNumber(213);
		rationalityFreedom.setPublisher("Springer");
		addBook(rationalityFreedom);

		Book clashofCivilizationsandRemakingoftheWorldOrder = new Book();
		clashofCivilizationsandRemakingoftheWorldOrder.setTitle("Clash of Civilizations and Remaking of the World Order");
		clashofCivilizationsandRemakingoftheWorldOrder.setAuthor("Huntington, Samuel");
		clashofCivilizationsandRemakingoftheWorldOrder.setGenre("history");
		clashofCivilizationsandRemakingoftheWorldOrder.setYear(0);
		clashofCivilizationsandRemakingoftheWorldOrder.setRate(0.);
		clashofCivilizationsandRemakingoftheWorldOrder.setPagNumber(228);
		clashofCivilizationsandRemakingoftheWorldOrder.setPublisher("Simon&Schuster");
		addBook(clashofCivilizationsandRemakingoftheWorldOrder);

		Book uncommonWisdom = new Book();
		uncommonWisdom.setTitle("Uncommon Wisdom");
		uncommonWisdom.setAuthor("Capra, Fritjof");
		uncommonWisdom.setGenre("nonfiction");
		uncommonWisdom.setYear(0);
		uncommonWisdom.setRate(0.);
		uncommonWisdom.setPagNumber(197);
		uncommonWisdom.setPublisher("Fontana");
		addBook(uncommonWisdom);

		Book one = new Book();
		one.setTitle("One");
		one.setAuthor("Bach, Richard");
		one.setGenre("nonfiction");
		one.setYear(0);
		one.setRate(0.);
		one.setPagNumber(172);
		one.setPublisher("Dell");
		addBook(one);

		Book karlMarxBiography = new Book();
		karlMarxBiography.setTitle("Karl Marx Biography");
		karlMarxBiography.setAuthor("?");
		karlMarxBiography.setGenre("nonfiction");
		karlMarxBiography.setYear(0);
		karlMarxBiography.setRate(0.);
		karlMarxBiography.setPagNumber(162);
		karlMarxBiography.setPublisher("?");
		addBook(karlMarxBiography);

		Book toSirWithLove = new Book();
		toSirWithLove.setTitle("To Sir With Love");
		toSirWithLove.setAuthor("Braithwaite");
		toSirWithLove.setGenre("fiction");
		toSirWithLove.setYear(0);
		toSirWithLove.setRate(0.);
		toSirWithLove.setPagNumber(197);
		toSirWithLove.setPublisher("Penguin");
		addBook(toSirWithLove);

		Book halfALife = new Book();
		halfALife.setTitle("Half A Life");
		halfALife.setAuthor("Naipaul, V S");
		halfALife.setGenre("fiction");
		halfALife.setYear(0);
		halfALife.setRate(0.);
		halfALife.setPagNumber(196);
		halfALife.setPublisher("?");
		addBook(halfALife);

		Book discoveryofIndiaThe = new Book();
		discoveryofIndiaThe.setTitle("Discovery of India, The");
		discoveryofIndiaThe.setAuthor("Nehru, Jawaharlal");
		discoveryofIndiaThe.setGenre("history");
		discoveryofIndiaThe.setYear(0);
		discoveryofIndiaThe.setRate(0.);
		discoveryofIndiaThe.setPagNumber(230);
		discoveryofIndiaThe.setPublisher("?");
		addBook(discoveryofIndiaThe);

		Book apulki = new Book();
		apulki.setTitle("Apulki");
		apulki.setAuthor("Deshpande, P L");
		apulki.setGenre("nonfiction");
		apulki.setYear(0);
		apulki.setRate(0.);
		apulki.setPagNumber(211);
		apulki.setPublisher("?");
		addBook(apulki);

		Book unpopularEssays = new Book();
		unpopularEssays.setTitle("Unpopular Essays");
		unpopularEssays.setAuthor("Russell, Bertrand");
		unpopularEssays.setGenre("philosophy");
		unpopularEssays.setYear(0);
		unpopularEssays.setRate(0.);
		unpopularEssays.setPagNumber(198);
		unpopularEssays.setPublisher("?");
		addBook(unpopularEssays);

		Book deceiverThe = new Book();
		deceiverThe.setTitle("Deceiver, The");
		deceiverThe.setAuthor("Forsyth, Frederick");
		deceiverThe.setGenre("fiction");
		deceiverThe.setYear(0);
		deceiverThe.setRate(0.);
		deceiverThe.setPagNumber(178);
		deceiverThe.setPublisher("?");
		addBook(deceiverThe);

		Book veilSecretWarsoftheCIA = new Book();
		veilSecretWarsoftheCIA.setTitle("Veil: Secret Wars of the CIA");
		veilSecretWarsoftheCIA.setAuthor("Woodward, Bob");
		veilSecretWarsoftheCIA.setGenre("history");
		veilSecretWarsoftheCIA.setYear(0);
		veilSecretWarsoftheCIA.setRate(0.);
		veilSecretWarsoftheCIA.setPagNumber(171);
		veilSecretWarsoftheCIA.setPublisher("?");
		addBook(veilSecretWarsoftheCIA);

		Book charShabda = new Book();
		charShabda.setTitle("Char Shabda");
		charShabda.setAuthor("Deshpande, P L");
		charShabda.setGenre("nonfiction");
		charShabda.setYear(0);
		charShabda.setRate(0.);
		charShabda.setPagNumber(214);
		charShabda.setPublisher("?");
		addBook(charShabda);

		Book rosyisMyRelative = new Book();
		rosyisMyRelative.setTitle("Rosy is My Relative");
		rosyisMyRelative.setAuthor("Durrell, Gerald");
		rosyisMyRelative.setGenre("fiction");
		rosyisMyRelative.setYear(0);
		rosyisMyRelative.setRate(0.);
		rosyisMyRelative.setPagNumber(176);
		rosyisMyRelative.setPublisher("?");
		addBook(rosyisMyRelative);

		Book moonandSixpenceThe = new Book();
		moonandSixpenceThe.setTitle("Moon and Sixpence, The");
		moonandSixpenceThe.setAuthor("Maugham, William S");
		moonandSixpenceThe.setGenre("fiction");
		moonandSixpenceThe.setYear(0);
		moonandSixpenceThe.setRate(0.);
		moonandSixpenceThe.setPagNumber(180);
		moonandSixpenceThe.setPublisher("?");
		addBook(moonandSixpenceThe);

		Book politicalPhilosophers = new Book();
		politicalPhilosophers.setTitle("Political Philosophers");
		politicalPhilosophers.setAuthor("?");
		politicalPhilosophers.setGenre("philosophy");
		politicalPhilosophers.setYear(0);
		politicalPhilosophers.setRate(0.);
		politicalPhilosophers.setPagNumber(162);
		politicalPhilosophers.setPublisher("?");
		addBook(politicalPhilosophers);

		Book shortHistoryoftheWorldA = new Book();
		shortHistoryoftheWorldA.setTitle("Short History of the World, A");
		shortHistoryoftheWorldA.setAuthor("Wells, H G");
		shortHistoryoftheWorldA.setGenre("history");
		shortHistoryoftheWorldA.setYear(0);
		shortHistoryoftheWorldA.setRate(0.);
		shortHistoryoftheWorldA.setPagNumber(197);
		shortHistoryoftheWorldA.setPublisher("?");
		addBook(shortHistoryoftheWorldA);

		Book tremblingofaLeafThe = new Book();
		tremblingofaLeafThe.setTitle("Trembling of a Leaf, The");
		tremblingofaLeafThe.setAuthor("Maugham, William S");
		tremblingofaLeafThe.setGenre("fiction");
		tremblingofaLeafThe.setYear(0);
		tremblingofaLeafThe.setRate(0.);
		tremblingofaLeafThe.setPagNumber(205);
		tremblingofaLeafThe.setPublisher("?");
		addBook(tremblingofaLeafThe);

		Book doctorontheBrain = new Book();
		doctorontheBrain.setTitle("Doctor on the Brain");
		doctorontheBrain.setAuthor("Gordon, Richard");
		doctorontheBrain.setGenre("fiction");
		doctorontheBrain.setYear(0);
		doctorontheBrain.setRate(0.);
		doctorontheBrain.setPagNumber(204);
		doctorontheBrain.setPublisher("?");
		addBook(doctorontheBrain);

		Book simpsonsTheirMathematicalSecrets = new Book();
		simpsonsTheirMathematicalSecrets.setTitle("Simpsons & Their Mathematical Secrets");
		simpsonsTheirMathematicalSecrets.setAuthor("Singh, Simon");
		simpsonsTheirMathematicalSecrets.setGenre("science");
		simpsonsTheirMathematicalSecrets.setYear(0);
		simpsonsTheirMathematicalSecrets.setRate(0.);
		simpsonsTheirMathematicalSecrets.setPagNumber(233);
		simpsonsTheirMathematicalSecrets.setPublisher("?");
		addBook(simpsonsTheirMathematicalSecrets);

		Book patternClassification = new Book();
		patternClassification.setTitle("Pattern Classification");
		patternClassification.setAuthor("Duda, Hart");
		patternClassification.setGenre("data_science");
		patternClassification.setYear(0);
		patternClassification.setRate(0.);
		patternClassification.setPagNumber(241);
		patternClassification.setPublisher("?");
		addBook(patternClassification);

		Book fromBeiruttoJerusalem = new Book();
		fromBeiruttoJerusalem.setTitle("From Beirut to Jerusalem");
		fromBeiruttoJerusalem.setAuthor("Friedman, Thomas");
		fromBeiruttoJerusalem.setGenre("history");
		fromBeiruttoJerusalem.setYear(0);
		fromBeiruttoJerusalem.setRate(0.);
		fromBeiruttoJerusalem.setPagNumber(202);
		fromBeiruttoJerusalem.setPublisher("?");
		addBook(fromBeiruttoJerusalem);

		Book codeBookThe = new Book();
		codeBookThe.setTitle("Code Book, The");
		codeBookThe.setAuthor("Singh, Simon");
		codeBookThe.setGenre("science");
		codeBookThe.setYear(0);
		codeBookThe.setRate(0.);
		codeBookThe.setPagNumber(197);
		codeBookThe.setPublisher("?");
		addBook(codeBookThe);

		Book ageoftheWarriorThe = new Book();
		ageoftheWarriorThe.setTitle("Age of the Warrior, The");
		ageoftheWarriorThe.setAuthor("Fisk, Robert");
		ageoftheWarriorThe.setGenre("history");
		ageoftheWarriorThe.setYear(0);
		ageoftheWarriorThe.setRate(0.);
		ageoftheWarriorThe.setPagNumber(197);
		ageoftheWarriorThe.setPublisher("?");
		addBook(ageoftheWarriorThe);

		Book finalCrisis = new Book();
		finalCrisis.setTitle("Final Crisis");
		finalCrisis.setAuthor("?");
		finalCrisis.setGenre("comic");
		finalCrisis.setYear(0);
		finalCrisis.setRate(0.);
		finalCrisis.setPagNumber(257);
		finalCrisis.setPublisher("?");
		addBook(finalCrisis);

		Book killingJokeThe = new Book();
		killingJokeThe.setTitle("Killing Joke, The");
		killingJokeThe.setAuthor("?");
		killingJokeThe.setGenre("comic");
		killingJokeThe.setYear(0);
		killingJokeThe.setRate(0.);
		killingJokeThe.setPagNumber(283);
		killingJokeThe.setPublisher("?");
		addBook(killingJokeThe);

		Book flashpoint = new Book();
		flashpoint.setTitle("Flashpoint");
		flashpoint.setAuthor("?");
		flashpoint.setGenre("comic");
		flashpoint.setYear(0);
		flashpoint.setRate(0.);
		flashpoint.setPagNumber(265);
		flashpoint.setPublisher("?");
		addBook(flashpoint);

		Book batmanEarthOne = new Book();
		batmanEarthOne.setTitle("Batman Earth One");
		batmanEarthOne.setAuthor("?");
		batmanEarthOne.setGenre("comic");
		batmanEarthOne.setYear(0);
		batmanEarthOne.setRate(0.);
		batmanEarthOne.setPagNumber(265);
		batmanEarthOne.setPublisher("?");
		addBook(batmanEarthOne);

		Book crisisonInfiniteEarths = new Book();
		crisisonInfiniteEarths.setTitle("Crisis on Infinite Earths");
		crisisonInfiniteEarths.setAuthor("?");
		crisisonInfiniteEarths.setGenre("comic");
		crisisonInfiniteEarths.setYear(0);
		crisisonInfiniteEarths.setRate(0.);
		crisisonInfiniteEarths.setPagNumber(258);
		crisisonInfiniteEarths.setPublisher("?");
		addBook(crisisonInfiniteEarths);

		Book numbersBehindNumb3rsThe = new Book();
		numbersBehindNumb3rsThe.setTitle("Numbers Behind Numb3rs, The");
		numbersBehindNumb3rsThe.setAuthor("Devlin, Keith");
		numbersBehindNumb3rsThe.setGenre("science");
		numbersBehindNumb3rsThe.setYear(0);
		numbersBehindNumb3rsThe.setRate(0.);
		numbersBehindNumb3rsThe.setPagNumber(202);
		numbersBehindNumb3rsThe.setPublisher("?");
		addBook(numbersBehindNumb3rsThe);

		Book supermanEarthOne1 = new Book();
		supermanEarthOne1.setTitle("Superman Earth One - 1");
		supermanEarthOne1.setAuthor("?");
		supermanEarthOne1.setGenre("comic");
		supermanEarthOne1.setYear(0);
		supermanEarthOne1.setRate(0.);
		supermanEarthOne1.setPagNumber(259);
		supermanEarthOne1.setPublisher("?");
		addBook(supermanEarthOne1);

		Book supermanEarthOne2 = new Book();
		supermanEarthOne2.setTitle("Superman Earth One - 2");
		supermanEarthOne2.setAuthor("?");
		supermanEarthOne2.setGenre("comic");
		supermanEarthOne2.setYear(0);
		supermanEarthOne2.setRate(0.);
		supermanEarthOne2.setPagNumber(258);
		supermanEarthOne2.setPublisher("?");
		addBook(supermanEarthOne2);

		Book justiceLeagueThroneofAtlantis = new Book();
		justiceLeagueThroneofAtlantis.setTitle("Justice League: Throne of Atlantis");
		justiceLeagueThroneofAtlantis.setAuthor("?");
		justiceLeagueThroneofAtlantis.setGenre("comic");
		justiceLeagueThroneofAtlantis.setYear(0);
		justiceLeagueThroneofAtlantis.setRate(0.);
		justiceLeagueThroneofAtlantis.setPagNumber(258);
		justiceLeagueThroneofAtlantis.setPublisher("?");
		addBook(justiceLeagueThroneofAtlantis);

		Book justiceLeagueTheVillainsJourney = new Book();
		justiceLeagueTheVillainsJourney.setTitle("Justice League: The Villain's Journey");
		justiceLeagueTheVillainsJourney.setAuthor("?");
		justiceLeagueTheVillainsJourney.setGenre("comic");
		justiceLeagueTheVillainsJourney.setYear(0);
		justiceLeagueTheVillainsJourney.setRate(0.);
		justiceLeagueTheVillainsJourney.setPagNumber(258);
		justiceLeagueTheVillainsJourney.setPublisher("?");
		addBook(justiceLeagueTheVillainsJourney);

		Book deathofSupermanThe = new Book();
		deathofSupermanThe.setTitle("Death of Superman, The");
		deathofSupermanThe.setAuthor("?");
		deathofSupermanThe.setGenre("comic");
		deathofSupermanThe.setYear(0);
		deathofSupermanThe.setRate(0.);
		deathofSupermanThe.setPagNumber(258);
		deathofSupermanThe.setPublisher("?");
		addBook(deathofSupermanThe);

		Book historyoftheDCUniverse = new Book();
		historyoftheDCUniverse.setTitle("History of the DC Universe");
		historyoftheDCUniverse.setAuthor("?");
		historyoftheDCUniverse.setGenre("comic");
		historyoftheDCUniverse.setYear(0);
		historyoftheDCUniverse.setRate(0.);
		historyoftheDCUniverse.setPagNumber(258);
		historyoftheDCUniverse.setPublisher("?");
		addBook(historyoftheDCUniverse);

		Book batmanTheLongHalloween = new Book();
		batmanTheLongHalloween.setTitle("Batman: The Long Halloween");
		batmanTheLongHalloween.setAuthor("?");
		batmanTheLongHalloween.setGenre("comic");
		batmanTheLongHalloween.setYear(0);
		batmanTheLongHalloween.setRate(0.);
		batmanTheLongHalloween.setPagNumber(258);
		batmanTheLongHalloween.setPublisher("?");
		addBook(batmanTheLongHalloween);

		Book lifeinLettersA = new Book();
		lifeinLettersA.setTitle("Life in Letters, A");
		lifeinLettersA.setAuthor("Steinbeck, John");
		lifeinLettersA.setGenre("nonfiction");
		lifeinLettersA.setYear(0);
		lifeinLettersA.setRate(0.);
		lifeinLettersA.setPagNumber(196);
		lifeinLettersA.setPublisher("?");
		addBook(lifeinLettersA);

		Book informationThe = new Book();
		informationThe.setTitle("Information, The");
		informationThe.setAuthor("Gleick, James");
		informationThe.setGenre("science");
		informationThe.setYear(0);
		informationThe.setRate(0.);
		informationThe.setPagNumber(233);
		informationThe.setPublisher("?");
		addBook(informationThe);

		Book journalofEconomicsvol106No3 = new Book();
		journalofEconomicsvol106No3.setTitle("Journal of Economics, vol 106 No 3");
		journalofEconomicsvol106No3.setAuthor("?");
		journalofEconomicsvol106No3.setGenre("economics");
		journalofEconomicsvol106No3.setYear(0);
		journalofEconomicsvol106No3.setRate(0.);
		journalofEconomicsvol106No3.setPagNumber(235);
		journalofEconomicsvol106No3.setPublisher("?");
		addBook(journalofEconomicsvol106No3);

		Book elementsofInformationTheory = new Book();
		elementsofInformationTheory.setTitle("Elements of Information Theory");
		elementsofInformationTheory.setAuthor("Thomas, Joy");
		elementsofInformationTheory.setGenre("data_science");
		elementsofInformationTheory.setYear(0);
		elementsofInformationTheory.setRate(0.);
		elementsofInformationTheory.setPagNumber(229);
		elementsofInformationTheory.setPublisher("?");
		addBook(elementsofInformationTheory);

		Book powerElectronicsRashid = new Book();
		powerElectronicsRashid.setTitle("Power Electronics - Rashid");
		powerElectronicsRashid.setAuthor("Rashid, Muhammad");
		powerElectronicsRashid.setGenre("computer_science");
		powerElectronicsRashid.setYear(0);
		powerElectronicsRashid.setRate(0.);
		powerElectronicsRashid.setPagNumber(235);
		powerElectronicsRashid.setPublisher("?");
		addBook(powerElectronicsRashid);

		Book powerElectronicsMohan = new Book();
		powerElectronicsMohan.setTitle("Power Electronics - Mohan");
		powerElectronicsMohan.setAuthor("Mohan, Ned");
		powerElectronicsMohan.setGenre("computer_science");
		powerElectronicsMohan.setYear(0);
		powerElectronicsMohan.setRate(0.);
		powerElectronicsMohan.setPagNumber(237);
		powerElectronicsMohan.setPublisher("?");
		addBook(powerElectronicsMohan);

		Book neuralNetworks = new Book();
		neuralNetworks.setTitle("Neural Networks");
		neuralNetworks.setAuthor("Haykin, Simon");
		neuralNetworks.setGenre("data_science");
		neuralNetworks.setYear(0);
		neuralNetworks.setRate(0.);
		neuralNetworks.setPagNumber(240);
		neuralNetworks.setPublisher("?");
		addBook(neuralNetworks);

		Book grapesofWrathThe = new Book();
		grapesofWrathThe.setTitle("Grapes of Wrath, The");
		grapesofWrathThe.setAuthor("Steinbeck, John");
		grapesofWrathThe.setGenre("fiction");
		grapesofWrathThe.setYear(0);
		grapesofWrathThe.setRate(0.);
		grapesofWrathThe.setPagNumber(196);
		grapesofWrathThe.setPublisher("?");
		addBook(grapesofWrathThe);

		Book vyaktianiValli = new Book();
		vyaktianiValli.setTitle("Vyakti ani Valli");
		vyaktianiValli.setAuthor("Deshpande, P L");
		vyaktianiValli.setGenre("nonfiction");
		vyaktianiValli.setYear(0);
		vyaktianiValli.setRate(0.);
		vyaktianiValli.setPagNumber(211);
		vyaktianiValli.setPublisher("?");
		addBook(vyaktianiValli);

		Book statisticalLearningTheory = new Book();
		statisticalLearningTheory.setTitle("Statistical Learning Theory");
		statisticalLearningTheory.setAuthor("Vapnik, Vladimir");
		statisticalLearningTheory.setGenre("data_science");
		statisticalLearningTheory.setYear(0);
		statisticalLearningTheory.setRate(0.);
		statisticalLearningTheory.setPagNumber(228);
		statisticalLearningTheory.setPublisher("?");
		addBook(statisticalLearningTheory);

		Book empireoftheMughalTheTaintedThrone = new Book();
		empireoftheMughalTheTaintedThrone.setTitle("Empire of the Mughal - The Tainted Throne");
		empireoftheMughalTheTaintedThrone.setAuthor("Rutherford, Alex");
		empireoftheMughalTheTaintedThrone.setGenre("history");
		empireoftheMughalTheTaintedThrone.setYear(0);
		empireoftheMughalTheTaintedThrone.setRate(0.);
		empireoftheMughalTheTaintedThrone.setPagNumber(180);
		empireoftheMughalTheTaintedThrone.setPublisher("?");
		addBook(empireoftheMughalTheTaintedThrone);

		Book empireoftheMughalBrothersatWar = new Book();
		empireoftheMughalBrothersatWar.setTitle("Empire of the Mughal - Brothers at War");
		empireoftheMughalBrothersatWar.setAuthor("Rutherford, Alex");
		empireoftheMughalBrothersatWar.setGenre("history");
		empireoftheMughalBrothersatWar.setYear(0);
		empireoftheMughalBrothersatWar.setRate(0.);
		empireoftheMughalBrothersatWar.setPagNumber(180);
		empireoftheMughalBrothersatWar.setPublisher("?");
		addBook(empireoftheMughalBrothersatWar);

		Book empireoftheMughalRuleroftheWorld = new Book();
		empireoftheMughalRuleroftheWorld.setTitle("Empire of the Mughal - Ruler of the World");
		empireoftheMughalRuleroftheWorld.setAuthor("Rutherford, Alex");
		empireoftheMughalRuleroftheWorld.setGenre("history");
		empireoftheMughalRuleroftheWorld.setYear(0);
		empireoftheMughalRuleroftheWorld.setRate(0.);
		empireoftheMughalRuleroftheWorld.setPagNumber(180);
		empireoftheMughalRuleroftheWorld.setPublisher("?");
		addBook(empireoftheMughalRuleroftheWorld);

		Book empireoftheMughalTheSerpentsTooth = new Book();
		empireoftheMughalTheSerpentsTooth.setTitle("Empire of the Mughal - The Serpent's Tooth");
		empireoftheMughalTheSerpentsTooth.setAuthor("Rutherford, Alex");
		empireoftheMughalTheSerpentsTooth.setGenre("history");
		empireoftheMughalTheSerpentsTooth.setYear(0);
		empireoftheMughalTheSerpentsTooth.setRate(0.);
		empireoftheMughalTheSerpentsTooth.setPagNumber(180);
		empireoftheMughalTheSerpentsTooth.setPublisher("?");
		addBook(empireoftheMughalTheSerpentsTooth);

		Book empireoftheMughalRaidersfromtheNorth = new Book();
		empireoftheMughalRaidersfromtheNorth.setTitle("Empire of the Mughal - Raiders from the North");
		empireoftheMughalRaidersfromtheNorth.setAuthor("Rutherford, Alex");
		empireoftheMughalRaidersfromtheNorth.setGenre("history");
		empireoftheMughalRaidersfromtheNorth.setYear(0);
		empireoftheMughalRaidersfromtheNorth.setRate(0.);
		empireoftheMughalRaidersfromtheNorth.setPagNumber(180);
		empireoftheMughalRaidersfromtheNorth.setPublisher("?");
		addBook(empireoftheMughalRaidersfromtheNorth);

		Book mossad = new Book();
		mossad.setTitle("Mossad");
		mossad.setAuthor("Baz-Zohar, Michael");
		mossad.setGenre("history");
		mossad.setYear(0);
		mossad.setRate(0.);
		mossad.setPagNumber(236);
		mossad.setPublisher("?");
		addBook(mossad);

		Book jimCorbettOmnibus = new Book();
		jimCorbettOmnibus.setTitle("Jim Corbett Omnibus");
		jimCorbettOmnibus.setAuthor("Corbett, Jim");
		jimCorbettOmnibus.setGenre("nonfiction");
		jimCorbettOmnibus.setYear(0);
		jimCorbettOmnibus.setRate(0.);
		jimCorbettOmnibus.setPagNumber(223);
		jimCorbettOmnibus.setPublisher("?");
		addBook(jimCorbettOmnibus);

		Book leaguesUndertheSea = new Book();
		leaguesUndertheSea.setTitle("20000 Leagues Under the Sea");
		leaguesUndertheSea.setAuthor("Verne, Jules");
		leaguesUndertheSea.setGenre("fiction");
		leaguesUndertheSea.setYear(0);
		leaguesUndertheSea.setRate(0.);
		leaguesUndertheSea.setPagNumber(190);
		leaguesUndertheSea.setPublisher("?");
		addBook(leaguesUndertheSea);

		Book batatyachiChal = new Book();
		batatyachiChal.setTitle("Batatyachi Chal");
		batatyachiChal.setAuthor("Deshpande P L");
		batatyachiChal.setGenre("fiction");
		batatyachiChal.setYear(0);
		batatyachiChal.setRate(0.);
		batatyachiChal.setPagNumber(200);
		batatyachiChal.setPublisher("?");
		addBook(batatyachiChal);

		Book hafasavnuk = new Book();
		hafasavnuk.setTitle("Hafasavnuk");
		hafasavnuk.setAuthor("Deshpande P L");
		hafasavnuk.setGenre("fiction");
		hafasavnuk.setYear(0);
		hafasavnuk.setRate(0.);
		hafasavnuk.setPagNumber(211);
		hafasavnuk.setPublisher("?");
		addBook(hafasavnuk);

		Book urlasurla = new Book();
		urlasurla.setTitle("Urlasurla");
		urlasurla.setAuthor("Deshpande P L");
		urlasurla.setGenre("fiction");
		urlasurla.setYear(0);
		urlasurla.setRate(0.);
		urlasurla.setPagNumber(211);
		urlasurla.setPublisher("?");
		addBook(urlasurla);

		Book pointersinC = new Book();
		pointersinC.setTitle("Pointers in C");
		pointersinC.setAuthor("Kanetkar, Yashwant");
		pointersinC.setGenre("computer_science");
		pointersinC.setYear(0);
		pointersinC.setRate(0.);
		pointersinC.setPagNumber(213);
		pointersinC.setPublisher("?");
		addBook(pointersinC);

		Book cathedralandtheBazaarThe = new Book();
		cathedralandtheBazaarThe.setTitle("Cathedral and the Bazaar, The");
		cathedralandtheBazaarThe.setAuthor("Raymond, Eric");
		cathedralandtheBazaarThe.setGenre("computer_science");
		cathedralandtheBazaarThe.setYear(0);
		cathedralandtheBazaarThe.setRate(0.);
		cathedralandtheBazaarThe.setPagNumber(217);
		cathedralandtheBazaarThe.setPublisher("?");
		addBook(cathedralandtheBazaarThe);

		Book designwithOpAmps = new Book();
		designwithOpAmps.setTitle("Design with OpAmps");
		designwithOpAmps.setAuthor("Franco, Sergio");
		designwithOpAmps.setGenre("computer_science");
		designwithOpAmps.setYear(0);
		designwithOpAmps.setRate(0.);
		designwithOpAmps.setPagNumber(240);
		designwithOpAmps.setPublisher("?");
		addBook(designwithOpAmps);

		Book thinkComplexity = new Book();
		thinkComplexity.setTitle("Think Complexity");
		thinkComplexity.setAuthor("Downey, Allen");
		thinkComplexity.setGenre("data_science");
		thinkComplexity.setYear(0);
		thinkComplexity.setRate(0.);
		thinkComplexity.setPagNumber(230);
		thinkComplexity.setPublisher("?");
		addBook(thinkComplexity);

		Book devilsAdvocateThe = new Book();
		devilsAdvocateThe.setTitle("Devil's Advocate, The");
		devilsAdvocateThe.setAuthor("West, Morris");
		devilsAdvocateThe.setGenre("fiction");
		devilsAdvocateThe.setYear(0);
		devilsAdvocateThe.setRate(0.);
		devilsAdvocateThe.setPagNumber(178);
		devilsAdvocateThe.setPublisher("?");
		addBook(devilsAdvocateThe);

		Book aynRandAnswers = new Book();
		aynRandAnswers.setTitle("Ayn Rand Answers");
		aynRandAnswers.setAuthor("Rand, Ayn");
		aynRandAnswers.setGenre("philosophy");
		aynRandAnswers.setYear(0);
		aynRandAnswers.setRate(0.);
		aynRandAnswers.setPagNumber(203);
		aynRandAnswers.setPublisher("?");
		addBook(aynRandAnswers);

		Book philosophyWhoNeedsIt = new Book();
		philosophyWhoNeedsIt.setTitle("Philosophy: Who Needs It");
		philosophyWhoNeedsIt.setAuthor("Rand, Ayn");
		philosophyWhoNeedsIt.setGenre("philosophy");
		philosophyWhoNeedsIt.setYear(0);
		philosophyWhoNeedsIt.setRate(0.);
		philosophyWhoNeedsIt.setPagNumber(171);
		philosophyWhoNeedsIt.setPublisher("?");
		addBook(philosophyWhoNeedsIt);

		Book worldsGreatThinkersThe = new Book();
		worldsGreatThinkersThe.setTitle("World's Great Thinkers, The");
		worldsGreatThinkersThe.setAuthor("?");
		worldsGreatThinkersThe.setGenre("philosophy");
		worldsGreatThinkersThe.setYear(0);
		worldsGreatThinkersThe.setRate(0.);
		worldsGreatThinkersThe.setPagNumber(189);
		worldsGreatThinkersThe.setPublisher("?");
		addBook(worldsGreatThinkersThe);

		Book dataAnalysiswithOpenSourceTools = new Book();
		dataAnalysiswithOpenSourceTools.setTitle("Data Analysis with Open Source Tools");
		dataAnalysiswithOpenSourceTools.setAuthor("Janert, Phillip");
		dataAnalysiswithOpenSourceTools.setGenre("data_science");
		dataAnalysiswithOpenSourceTools.setYear(0);
		dataAnalysiswithOpenSourceTools.setRate(0.);
		dataAnalysiswithOpenSourceTools.setPagNumber(230);
		dataAnalysiswithOpenSourceTools.setPublisher("?");
		addBook(dataAnalysiswithOpenSourceTools);

		Book brocasBrain = new Book();
		brocasBrain.setTitle("Broca's Brain");
		brocasBrain.setAuthor("Sagan, Carl");
		brocasBrain.setGenre("science");
		brocasBrain.setYear(0);
		brocasBrain.setRate(0.);
		brocasBrain.setPagNumber(174);
		brocasBrain.setPublisher("?");
		addBook(brocasBrain);

		Book menofMathematics = new Book();
		menofMathematics.setTitle("Men of Mathematics");
		menofMathematics.setAuthor("Bell, E T");
		menofMathematics.setGenre("mathematics");
		menofMathematics.setYear(0);
		menofMathematics.setRate(0.);
		menofMathematics.setPagNumber(217);
		menofMathematics.setPublisher("?");
		addBook(menofMathematics);

		Book oxfordbookofModernScienceWriting = new Book();
		oxfordbookofModernScienceWriting.setTitle("Oxford book of Modern Science Writing");
		oxfordbookofModernScienceWriting.setAuthor("Dawkins, Richard");
		oxfordbookofModernScienceWriting.setGenre("science");
		oxfordbookofModernScienceWriting.setYear(0);
		oxfordbookofModernScienceWriting.setRate(0.);
		oxfordbookofModernScienceWriting.setPagNumber(240);
		oxfordbookofModernScienceWriting.setPublisher("?");
		addBook(oxfordbookofModernScienceWriting);

		Book justiceJudiciaryandDemocracy = new Book();
		justiceJudiciaryandDemocracy.setTitle("Justice, Judiciary and Democracy");
		justiceJudiciaryandDemocracy.setAuthor("Ranjan, Sudhanshu");
		justiceJudiciaryandDemocracy.setGenre("philosophy");
		justiceJudiciaryandDemocracy.setYear(0);
		justiceJudiciaryandDemocracy.setRate(0.);
		justiceJudiciaryandDemocracy.setPagNumber(224);
		justiceJudiciaryandDemocracy.setPublisher("?");
		addBook(justiceJudiciaryandDemocracy);

		Book arthashastraThe = new Book();
		arthashastraThe.setTitle("Arthashastra, The");
		arthashastraThe.setAuthor("Kautiyla");
		arthashastraThe.setGenre("philosophy");
		arthashastraThe.setYear(0);
		arthashastraThe.setRate(0.);
		arthashastraThe.setPagNumber(214);
		arthashastraThe.setPublisher("?");
		addBook(arthashastraThe);

		Book wethePeople = new Book();
		wethePeople.setTitle("We the People");
		wethePeople.setAuthor("Palkhivala");
		wethePeople.setGenre("philosophy");
		wethePeople.setYear(0);
		wethePeople.setRate(0.);
		wethePeople.setPagNumber(216);
		wethePeople.setPublisher("?");
		addBook(wethePeople);

		Book wetheNation = new Book();
		wetheNation.setTitle("We the Nation");
		wetheNation.setAuthor("Palkhivala");
		wetheNation.setGenre("philosophy");
		wetheNation.setYear(0);
		wetheNation.setRate(0.);
		wetheNation.setPagNumber(216);
		wetheNation.setPublisher("?");
		addBook(wetheNation);

		Book courtroomGeniusThe = new Book();
		courtroomGeniusThe.setTitle("Courtroom Genius, The");
		courtroomGeniusThe.setAuthor("Sorabjee");
		courtroomGeniusThe.setGenre("nonfiction");
		courtroomGeniusThe.setYear(0);
		courtroomGeniusThe.setRate(0.);
		courtroomGeniusThe.setPagNumber(217);
		courtroomGeniusThe.setPublisher("?");
		addBook(courtroomGeniusThe);

		Book dongritoDubai = new Book();
		dongritoDubai.setTitle("Dongri to Dubai");
		dongritoDubai.setAuthor("Zaidi, Hussain");
		dongritoDubai.setGenre("nonfiction");
		dongritoDubai.setYear(0);
		dongritoDubai.setRate(0.);
		dongritoDubai.setPagNumber(216);
		dongritoDubai.setPublisher("?");
		addBook(dongritoDubai);

		Book historyofEnglandFoundation = new Book();
		historyofEnglandFoundation.setTitle("History of England, Foundation");
		historyofEnglandFoundation.setAuthor("Ackroyd, Peter");
		historyofEnglandFoundation.setGenre("history");
		historyofEnglandFoundation.setYear(0);
		historyofEnglandFoundation.setRate(0.);
		historyofEnglandFoundation.setPagNumber(197);
		historyofEnglandFoundation.setPublisher("?");
		addBook(historyofEnglandFoundation);

		Book cityofDjinns = new Book();
		cityofDjinns.setTitle("City of Djinns");
		cityofDjinns.setAuthor("Dalrymple, William");
		cityofDjinns.setGenre("history");
		cityofDjinns.setYear(0);
		cityofDjinns.setRate(0.);
		cityofDjinns.setPagNumber(198);
		cityofDjinns.setPublisher("?");
		addBook(cityofDjinns);

		Book indiasLegalSystem = new Book();
		indiasLegalSystem.setTitle("India's Legal System");
		indiasLegalSystem.setAuthor("Nariman");
		indiasLegalSystem.setGenre("nonfiction");
		indiasLegalSystem.setYear(0);
		indiasLegalSystem.setRate(0.);
		indiasLegalSystem.setPagNumber(177);
		indiasLegalSystem.setPublisher("?");
		addBook(indiasLegalSystem);

		Book moreTearstoCry = new Book();
		moreTearstoCry.setTitle("More Tears to Cry");
		moreTearstoCry.setAuthor("Sassoon, Jean");
		moreTearstoCry.setGenre("fiction");
		moreTearstoCry.setYear(0);
		moreTearstoCry.setRate(0.);
		moreTearstoCry.setPagNumber(235);
		moreTearstoCry.setPublisher("?");
		addBook(moreTearstoCry);

		Book ropemakerThe = new Book();
		ropemakerThe.setTitle("Ropemaker, The");
		ropemakerThe.setAuthor("Dickinson, Peter");
		ropemakerThe.setGenre("fiction");
		ropemakerThe.setYear(0);
		ropemakerThe.setRate(0.);
		ropemakerThe.setPagNumber(196);
		ropemakerThe.setPublisher("?");
		addBook(ropemakerThe);

		Book judgeThe = new Book();
		judgeThe.setTitle("Judge, The");
		judgeThe.setAuthor("?");
		judgeThe.setGenre("fiction");
		judgeThe.setYear(0);
		judgeThe.setRate(0.);
		judgeThe.setPagNumber(170);
		judgeThe.setPublisher("?");
		addBook(judgeThe);

		Book attorneyThe = new Book();
		attorneyThe.setTitle("Attorney, The");
		attorneyThe.setAuthor("?");
		attorneyThe.setGenre("fiction");
		attorneyThe.setYear(0);
		attorneyThe.setRate(0.);
		attorneyThe.setPagNumber(170);
		attorneyThe.setPublisher("?");
		addBook(attorneyThe);

		Book princeThe = new Book();
		princeThe.setTitle("Prince, The");
		princeThe.setAuthor("Machiavelli");
		princeThe.setGenre("philosophy");
		princeThe.setYear(0);
		princeThe.setRate(0.);
		princeThe.setPagNumber(173);
		princeThe.setPublisher("?");
		addBook(princeThe);

		Book eyelessinGaza = new Book();
		eyelessinGaza.setTitle("Eyeless in Gaza");
		eyelessinGaza.setAuthor("Huxley, Aldous");
		eyelessinGaza.setGenre("fiction");
		eyelessinGaza.setYear(0);
		eyelessinGaza.setRate(0.);
		eyelessinGaza.setPagNumber(180);
		eyelessinGaza.setPublisher("?");
		addBook(eyelessinGaza);

		Book talesofBeedletheBard = new Book();
		talesofBeedletheBard.setTitle("Tales of Beedle the Bard");
		talesofBeedletheBard.setAuthor("Rowling, J K");
		talesofBeedletheBard.setGenre("fiction");
		talesofBeedletheBard.setYear(0);
		talesofBeedletheBard.setRate(0.);
		talesofBeedletheBard.setPagNumber(184);
		talesofBeedletheBard.setPublisher("?");
		addBook(talesofBeedletheBard);

		Book girlwiththeDragonTattoo = new Book();
		girlwiththeDragonTattoo.setTitle("Girl with the Dragon Tattoo");
		girlwiththeDragonTattoo.setAuthor("Larsson, Steig");
		girlwiththeDragonTattoo.setGenre("fiction");
		girlwiththeDragonTattoo.setYear(0);
		girlwiththeDragonTattoo.setRate(0.);
		girlwiththeDragonTattoo.setPagNumber(179);
		girlwiththeDragonTattoo.setPublisher("?");
		addBook(girlwiththeDragonTattoo);

		Book girlwhokickedtheHornetsNest = new Book();
		girlwhokickedtheHornetsNest.setTitle("Girl who kicked the Hornet's Nest");
		girlwhokickedtheHornetsNest.setAuthor("Larsson, Steig");
		girlwhokickedtheHornetsNest.setGenre("fiction");
		girlwhokickedtheHornetsNest.setYear(0);
		girlwhokickedtheHornetsNest.setRate(0.);
		girlwhokickedtheHornetsNest.setPagNumber(179);
		girlwhokickedtheHornetsNest.setPublisher("?");
		addBook(girlwhokickedtheHornetsNest);

		Book girlwhoplayedwithFire = new Book();
		girlwhoplayedwithFire.setTitle("Girl who played with Fire");
		girlwhoplayedwithFire.setAuthor("Larsson, Steig");
		girlwhoplayedwithFire.setGenre("fiction");
		girlwhoplayedwithFire.setYear(0);
		girlwhoplayedwithFire.setRate(0.);
		girlwhoplayedwithFire.setPagNumber(179);
		girlwhoplayedwithFire.setPublisher("?");
		addBook(girlwhoplayedwithFire);

		Book batmanHandbook = new Book();
		batmanHandbook.setTitle("Batman Handbook");
		batmanHandbook.setAuthor("?");
		batmanHandbook.setGenre("comic");
		batmanHandbook.setYear(0);
		batmanHandbook.setRate(0.);
		batmanHandbook.setPagNumber(270);
		batmanHandbook.setPublisher("?");
		addBook(batmanHandbook);

		Book murphysLaw = new Book();
		murphysLaw.setTitle("Murphy's Law");
		murphysLaw.setAuthor("?");
		murphysLaw.setGenre("nonfiction");
		murphysLaw.setYear(0);
		murphysLaw.setRate(0.);
		murphysLaw.setPagNumber(178);
		murphysLaw.setPublisher("?");
		addBook(murphysLaw);

		Book structureandRandomness = new Book();
		structureandRandomness.setTitle("Structure and Randomness");
		structureandRandomness.setAuthor("Tao, Terence");
		structureandRandomness.setGenre("mathematics");
		structureandRandomness.setYear(0);
		structureandRandomness.setRate(0.);
		structureandRandomness.setPagNumber(252);
		structureandRandomness.setPublisher("?");
		addBook(structureandRandomness);

		Book imageProcessingwithMATLAB = new Book();
		imageProcessingwithMATLAB.setTitle("Image Processing with MATLAB");
		imageProcessingwithMATLAB.setAuthor("Eddins, Steve");
		imageProcessingwithMATLAB.setGenre("signal_processing");
		imageProcessingwithMATLAB.setYear(0);
		imageProcessingwithMATLAB.setRate(0.);
		imageProcessingwithMATLAB.setPagNumber(241);
		imageProcessingwithMATLAB.setPublisher("?");
		addBook(imageProcessingwithMATLAB);

		Book animalFarm = new Book();
		animalFarm.setTitle("Animal Farm");
		animalFarm.setAuthor("Orwell, George");
		animalFarm.setGenre("fiction");
		animalFarm.setYear(0);
		animalFarm.setRate(0.);
		animalFarm.setPagNumber(180);
		animalFarm.setPublisher("?");
		addBook(animalFarm);

		Book idiotThe = new Book();
		idiotThe.setTitle("Idiot, The");
		idiotThe.setAuthor("Dostoevsky, Fyodor");
		idiotThe.setGenre("fiction");
		idiotThe.setYear(0);
		idiotThe.setRate(0.);
		idiotThe.setPagNumber(197);
		idiotThe.setPublisher("?");
		addBook(idiotThe);

		Book christmasCarolA = new Book();
		christmasCarolA.setTitle("Christmas Carol, A");
		christmasCarolA.setAuthor("Dickens, Charles");
		christmasCarolA.setGenre("fiction");
		christmasCarolA.setYear(0);
		christmasCarolA.setRate(0.);
		christmasCarolA.setPagNumber(196);
		christmasCarolA.setPublisher("?");
		addBook(christmasCarolA);
		
		// Create booklists
		Booklist booklist1=new Booklist();
		booklist1.setName("AISSBookList");
		booklist1.setDescription("AISS Book List");
		addBooklist(booklist1);
		
		Booklist booklist2 = new Booklist();
		booklist2.setName("Favourites");
		booklist2.setDescription("A sample booklist");
		addBooklist(booklist2);
		
		Booklist booklist3 = new Booklist();
		booklist3.setName("Read");
		booklist3.setDescription("Books I have read");
		addBooklist(booklist3);
		
		// Create users
		User belen = new User();
		belen.setName("Belen Fraga");
		belen.setUserName("bel_fra");
		belen.setEmail("belenFra@mail.com");
		addUser(belen);
		
		User carlos = new User();
		carlos.setName("Carlos Fuentes");
		carlos.setUserName("carl_fuen");
		carlos.setEmail("carlFuent@mail.com");
		addUser(carlos);
		
		User justa = new User();
		justa.setName("Justa Soto");
		justa.setUserName("just_soto");
		justa.setEmail("justSoto@mail.com");
		addUser(justa);
		
		User biel = new User();
		biel.setName("Biel Pulido");
		biel.setUserName("biel_pul");
		biel.setEmail("bielPul@mail.com");
		addUser(biel);
		
		User mateo = new User();
		mateo.setName("Mateo del Campo");
		mateo.setUserName("mate_camp");
		mateo.setEmail("mateoDelCamp@mail.com");
		addUser(mateo);
		
		// Add books to booklists
		addBook(booklist1.getId(), fundamentalsofWavelets.getId());
		addBook(booklist1.getId(), dataSmart.getId());
		addBook(booklist1.getId(), godCreatedtheIntegers.getId());
		addBook(booklist1.getId(), superfreakonomics.getId());
		
		addBook(booklist2.getId(), superfreakonomics.getId());
		addBook(booklist2.getId(), orientalism.getId());
		
		addBook(booklist3.getId(), dataSmart.getId());
		addBook(booklist3.getId(), godCreatedtheIntegers.getId());
		addBook(booklist3.getId(), fundamentalsofWavelets.getId());
		
		
		// Add wishes to user
		addWish(belen.getId(), booklist1.getId());
		addWish(belen.getId(), booklist2.getId());
		
		addWish(carlos.getId(), booklist2.getId());
		
		addWish(justa.getId(), booklist1.getId());
		addWish(justa.getId(), booklist3.getId());
		addWish(justa.getId(), booklist2.getId());
		
		addWish(biel.getId(), booklist1.getId());
	}
	
	// Booklist related operations
	@Override
	public void addBooklist(Booklist bl) {
		String id = "bl" + idBL++;	
		bl.setId(id);
		booklistMap.put(id,bl);
	}
	
	@Override
	public Collection<Booklist> getAllBooklists() {
			return booklistMap.values();
	}

	@Override
	public Booklist getBooklist(String id) {
		return booklistMap.get(id);
	}
	
	@Override
	public void updateBooklist(Booklist p) {
		booklistMap.put(p.getId(),p);
	}

	@Override
	public void deleteBooklist(String id) {	
		booklistMap.remove(id);
	}

	@Override
	public void addBook(String booklistId, String bookId) {
		Booklist booklist = getBooklist(booklistId);
		booklist.addBook(bookMap.get(bookId));
	}

	@Override
	public Collection<Book> getAll(String booklistId) {
		return getBooklist(booklistId).getBooks();
	}

	@Override
	public void removeBook(String booklistId, String bookId) {
		getBooklist(booklistId).deleteBook(bookId);
	}
	
	// Book related operations
	
	@Override
	public void addBook(Book b) {
		String id = "b" + idB++;
		b.setId(id);
		bookMap.put(id, b);
	}
	
	@Override
	public Collection<Book> getAllBooks() {
			return bookMap.values();
	}

	@Override
	public Book getBook(String bookId) {
		return bookMap.get(bookId);
	}

	@Override
	public void updateBook(Book b) {
		Book book = bookMap.get(b.getId());
		book.setTitle(b.getTitle());
		book.setAuthor(b.getAuthor());
		book.setGenre(b.getGenre());
		book.setYear(b.getYear());
		book.setRate(b.getRate());
		book.setPagNumber(b.getPagNumber());
		book.setPublisher(b.getPublisher());
	}

	@Override
	public void deleteBook(String bookId) {
		bookMap.remove(bookId);
	}
	
	// User related operation
	
	@Override
	public void addUser(User u) {
		String id = "u" + idU++;
		u.setId(id);
		userMap.put(id, u);
	}
	
	@Override
	public Collection<User> getAllUsers() {
			return userMap.values();
	}
	
	@Override
	public User getUser(String userId) {
		return userMap.get(userId);
	}
	
	@Override
	public void updateUser(User u) {
		userMap.put(u.getId(),u);
	}
	
	@Override
	public void deleteUser(String userId) {
		userMap.remove(userId);
	}
	
	@Override
	public Collection<String> getAllWishes(String userId) {
		return getUser(userId).getWishList();
	}
	
	@Override
	public void addWish(String userId, String wishId) {
		User user = getUser(userId);
		user.addWish(wishId);
	}
	
	@Override
	public void removeWish(String userId, String wishId) {
		getUser(userId).deleteWish(wishId);
	}
	

	
	
}
