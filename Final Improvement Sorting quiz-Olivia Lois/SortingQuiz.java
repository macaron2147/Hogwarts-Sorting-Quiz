/*
Name(s): Olivia Chan, Lois Zan
Teacher: Mr. Guglielmi
Date: November 18, 2020
Assignment: Outputs a Hogwarts sorting hat quiz - where the user can do an 11 question quiz to determine their house, view history, descriptions(11 randomnly chosen questions out of a library of 50 questions)
*/
import java.awt.*; // gives access to java command libraries
import hsa.Console; // gives access to Console class file
import java.io.*; //import utilities for using files
import java.awt.image.*; //import utilites for importing images
import javax.imageio.ImageIO; //import utilites for importing images
import javax.swing.*; //import utilities for using JFrame(error boxes)

// The "SortingQuiz" class
public class SortingQuiz  // creates a new class called SortingQuiz
{
    //Decleration Section
    Console c; // class so the output window can be made
    int[] responseNum = new int [11]; //int[] responseNum - an array to store the index number of each of the 11 random questions(unique indexes in the right order)
    String[] names = {"", "", "", "", "", "", "", "", "", ""}; //String[] names - an array with 10 indexes to store the past 10 people who did the quiz
    String[] houses = {"", "", "", "", "", "", "", "", "", ""}; //String[] houses - an array with 10 indexes to store the past 10 people's hogwarts house
    int counter; //int counter - a field to store the "score" of a user. Each hogwarts house falls between a specific range
    JFrame f = new JFrame (); //Creates a new JFrame object

    //Colours
    Color lightBlue = new Color (220, 217, 255);
    Color navy = new Color (14, 34, 69);
    Color violet = new Color (166, 133, 255);
    Color lightYellow = new Color (243, 237, 199);
    Color brown = new Color (69, 14, 7, 190);
    Color lightGrey = new Color (144, 159, 178, 80);
    Color white = new Color (144, 159, 178, 80);
    Color black = new Color (0, 0, 0);

    public SortingQuiz ()  // SortingQuiz class constructor
    {
	c = new Console (28, 85, "Sorting Hat Quiz"); // creates a new Console object window
    }


    //Method to output a graphics splash screen
    //arguments: none
    //returns: none
    public void splashScreen ()
    {
	background (navy); //Executes background method
	stars (); //Executes stars method
	importImage (10, 10, "menubg.jpg"); //Executes importImage method
	splashText (); //Executes splashText method
	loadingBar (); //Executes loadingBar method
    }


    //Method to output text on the splashScreen
    //arguments: none
    //returns: none
    public void splashText ()
    {
	c.setFont (new Font ("Baskerville Old Face", Font.BOLD, 75));
	for (int i = 0 ; i <= 255 ; i += 2) //Loop to adjust colour of text(changes from white-ish to blue-ish)
	{
	    lightBlue = new Color (220 - i / 5, 217 - i / 20, 255, 10 + i / 5);
	    c.setColor (lightBlue);
	    c.drawString ("Find out your", 160, 170);
	    c.drawString ("Hogwarts", 300, 260);
	    c.drawString ("house", 410, 350);
	}
    }


    //Method to output a background colour
    //arguments: Color
    //returns: none
    public void background (Color colour)
    {
	c.setColor (colour);
	c.fillRect (10, 10, 670, 550);
    }


    //Method to output stars
    //arguments: none
    //returns: none
    public void stars ()
    {
	c.setColor (Color.white);
	for (int i = 0 ; i < 150 ; i++) //Loop to outputs random twinkling stars
	{
	    int xValue = ((int) (700 * Math.random () + 1)); //int xValue - A field to store the value of a random x value
	    int yValue = ((int) (700 * Math.random () + 1)); //int yValue - A field to store the value of a random y value
	    int starSize = ((int) (5 * Math.random () + 1)); //int starSize - A field to store the value of a random star size
	    c.fillOval (xValue, yValue, starSize, starSize); //Outputs each star
	    try
	    {
		Thread.sleep (20); //Delays for each star output(gives twinkling effect)
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    //Method to output a loading bar
    //arguments: none
    //returns: none
    public void loadingBar ()
    {
	for (int i = 0 ; i <= 583 ; i += 5) //Loop for animation of loading bar
	{
	    if (i <= 255) //Makes sure it loop number doesn't go out of range(for colour)
	    {
		lightBlue = new Color (220 - i / 5, 217 - i / 20, 255, 10 + i / 5); //Colour changes as it loads
	    }
	    c.setColor (lightBlue);
	    c.fillRect (60, 480, i, 25); //Moving rectangle of the loading bar
	    c.drawRect (60, 480, 580, 25);
	    c.setFont (new Font ("Baskerville Old Face", Font.BOLD, 15));
	    c.drawString ("Loading...", 320, 530);
	}
	for (int i = 0 ; i < 100 ; i += 3) //Loop to change bar colour to violet after loading
	{
	    violet = new Color (166 - i / 10, 133, 255, 40);
	    c.setColor (violet);
	    c.drawRect (60, 480, 580, 25);
	    c.fillRect (60, 480, 580, 25);
	}
    }


    //Method to output a screen that shows what the program does
    //arguments: none
    //returns: none
    public void instructions ()
    {
	importImage (10, 10, "bluepink.jpg"); //Executes importImage method
	cornerMotif (Color.white, 0); //Executes cornerMotif method
	c.setFont (new Font ("Baskerville Old Face", Font.BOLD, 40));
	c.drawString ("instructions", 180, 120);
	c.setFont (new Font ("Baskerville Old Face", Font.BOLD, 30));
	c.drawString ("instructions", 330, 400);
	c.setFont (new Font ("Courier", Font.PLAIN, 15));
	c.drawString ("The sorting hat quiz simulates the Sorting", 150, 150);
	c.drawString ("Ceremony from the Wizarding World of Harry", 150, 180);
	c.drawString ("Potter! Are you a Gryffindor, Slytherin,", 150, 210);
	c.drawString ("Hufflepuff, or Ravenclaw? Find out which of", 150, 240);
	c.drawString ("the four Hogwarts houses you belong to by ", 150, 270);
	c.drawString ("answering eleven questions about yourself. ", 150, 300);
	c.drawString ("Basic knowledge of the Wizarding World is ", 150, 330);
	c.drawString ("recommended for accurate results.", 150, 360);
	c.drawRect (130, 110, 420, 300); //Border of text
	c.drawRect (120, 120, 440, 280); //Border of text
	try
	{
	    Thread.sleep (1000); //delays output of pauseProgram
	}
	catch (Exception e)
	{
	}
	pauseProgram (Color.white, 20, 225, 460); //Executes pauseProgram method
    }


    //Method to display choices the user can make(menu options)
    //arguments: none
    //returns: none
    public void mainMenu ()
    {
	boolean running = true; //boolean running - a field to determine whether the program will continue to run(default is true)
	char menuChoice;  //char menuChoice - a field to store the menu choice option entered by the user        
	lightBlue = new Color (220, 217, 255); //sets lightBlue to default value of colour
	do
	{
	    importImage (10, 10, "menubg.jpg"); //Executes importImage method
	    cornerMotif (lightBlue, 0); //Executes cornerMotif method
	    lightBlue = new Color (220, 217, 255);
	    c.drawRoundRect (190, 130, 300, 40, 40, 40); //Outputs menu buttons
	    c.drawRoundRect (190, 190, 300, 40, 40, 40);
	    c.drawRoundRect (190, 250, 300, 40, 40, 40);
	    c.drawRoundRect (190, 310, 300, 40, 40, 40);
	    c.drawRoundRect (190, 370, 300, 40, 40, 40);
	    c.setFont (new Font ("Baskerville Old Face", Font.BOLD, 35));
	    c.drawString ("menu", 230, 130);
	    c.drawString ("options", 340, 310);
	    c.setFont (new Font ("Courier", Font.PLAIN, 16));
	    c.drawString ("1.Try the sorting hat quiz", 210, 155);
	    c.drawString ("2.View history", 210, 215);
	    c.drawString ("3.View house descriptions", 210, 275);
	    c.drawString ("4.See instructions", 210, 335);
	    c.drawString ("5.Exit the quiz", 210, 395);

	    menuChoice = c.getChar (); //gets a char for menu option
	    c.setColor (lightGrey);
	    readFile (); //Executes readFile method - For when there is already prior input in the data file
	    //Conditional for menu options
	    if (menuChoice == '1') //Option 1: Complete the quiz
	    {
		c.fillRoundRect (190, 130, 300, 40, 40, 40); //Outputs transparent shape over button(user can see which button they clicked)
		pauseProgram (lightBlue, 20, 225, 480); //Executes pauseProgram method
		askName (); //Executes askName method
		questions (); //Executes questions method
		pauseProgram (Color.white, 15, 265, 530); //Executes pauseProgram method
		display (); //Executes display method
		writeFile (); //Executes writeFile method - writes to the data file after quiz is completed
		readFile (); //Executes readFile method - data from file is read into arrays
	    }
	    else if (menuChoice == '2') //Option 2: View history of last 10 people
	    {
		c.fillRoundRect (190, 190, 300, 40, 40, 40); //Outputs transparent shape over button(user can see which button they clicked)
		pauseProgram (lightBlue, 20, 225, 480);  //Executes pauseProgram method
		history (); //Executes history method
	    }
	    else if (menuChoice == '3') //Option 3: View hogwarts house descriptions
	    {
		c.fillRoundRect (190, 250, 300, 40, 40, 40); //Outputs transparent shape over button(user can see which button they clicked)
		pauseProgram (lightBlue, 20, 225, 480);  //Executes pauseProgram method
		houseMenu (); //Executes houseMenu method
	    }
	    else if (menuChoice == '4') //Option 4: View instructions again
	    {
		c.fillRoundRect (190, 310, 300, 40, 40, 40); //Outputs transparent shape over button(user can see which button they clicked)
		pauseProgram (lightBlue, 20, 225, 480);  //Executes pauseProgram method
		instructions (); //Executes instructions method
	    }
	    else if (menuChoice == '5') //Option 5: Exit the program
	    {
		c.fillRoundRect (190, 370, 300, 40, 40, 40); //Outputs transparent shape over button(user can see which button they clicked)
		pauseProgram (lightBlue, 20, 225, 480);  //Executes pauseProgram method
		running = false; //running is set to false(doesn't repeat if exit is chosen)
	    }
	    else
	    {
		JOptionPane.showMessageDialog (f, "Invalid input. Please try again."); //Outputs error message if input is invalid
	    }
	}
	while (running); //If option 5 is chosen program will exit
	goodbye (); //Executes goodbye method
    }


    //Method to ask for the user's name
    //arguments: none
    //returns: none
    public void askName ()
    {
	boolean running = true; //boolean running - a field to determine whether the program will continue to run(default is true)
	String name = ""; //String name - a field to store the name of the current person     
	for (int i = 9 ; i >= 1 ; i--) //Loop for setting all array values to next value in array - since history stores most recent 10 people
	{
	    names [i] = names [i - 1]; //e.g. index 9 is set to value in index 8, 8 to 7, 7 to 6, etc..(this is why I have prior values set up globally)
	}
	do //Question will get input again if input is invalid
	{
	    c.setFont (new Font ("Baskerville Old Face", Font.BOLD, 20));
	    c.setTextColor (Color.white);
	    c.setTextBackgroundColor (Color.black);
	    importImage (10, 10, "menubg.jpg"); //Executes importImage method
	    cornerMotif (Color.white, 0); //Executes cornerMotif method
	    c.setColor (Color.black);
	    c.fillRect (10, 250, 710, 80);
	    c.setColor (Color.white);
	    c.drawString ("Please enter your name:", 230, 240);
	    c.setCursor (14, 30);
	    name = c.readLine (); //Gets the name of the user
	    names [0] = name; //First index is set to the new name entered

	    if (name.length () > 22) //Error if name entered is more than 22 characters(has to fit within the screen when outputted)
	    {
		JOptionPane.showMessageDialog (f, "Please enter a name less than 25 characters."); //Outputs error message when invalid input entered
	    }
	    else
	    {
		running = false; //running is set to false when name is valid(exits loop)
	    }
	}
	while (running);
	pauseProgram (Color.white, 20, 225, 480); //Executes pauseProgram method
    }


    //Method to make sure the same random index isn't chosen twice
    //arguments: int
    //returns: boolean
    private boolean askRandom (int questionNum)
    {
	//boolean found - a field to store whether the string has been found in the array
	//int index - a field to store the index of the array
	boolean found = false; //flag for the loop
	int index = 0; //start at first location in the array

	//loop through the array until we find the value or reach the end
	while (!found && index < 11)
	{
	    //check to see if we found the value we are looking for
	    if (responseNum [index] != -1 && responseNum [index] == questionNum) //If that index contains the same number
	    {
		found = true; //set the flag to end the loop
	    }
	    else
	    {
		index++; //if we didn't find it, move on to the next position
	    }
	}
	//returns true if the same random number is chosen twice - or false if all the indexes chosen are unique
	return found;
    }


    //Method to reset the values in the responseNum array(default)
    //arguments: none
    //returns: none
    public void resetQuestions ()
    {
	//I set all the values to -1 as the default since 0 is a valid index
	for (int i = 0 ; i < 11 ; i++) //For all indexes in the responseNum[] array
	{
	    responseNum [i] = -1;
	}
    }


    //Method to display and ask 11 random questions(quiz)
    //arguments: none
    //returns: none
    public void questions ()
    {
	resetQuestions (); //executes resetQuestions method(values for quiz are reset every time the quiz is completed)     
	int questionNum; //int questionNum - a field to store the random index of the selected questions to be outputted
	char response; //char response - a field to store the temporary response for each of the 11 quetions
	counter = 0; //default counter value is set to 0
	boolean error = true; //Sets error to true
	boolean running = true; //boolean running - a field to determine whether the program will continue to run(default is true)

	//String[] questions - an array to store the list of 50 questions
	//String[] answer1 - an array to store the 1st choice to all 50 questions(adds 1 to counter, spacing is adjusted for correct output in each question)
	//String[] answer2 - an array to store the 2nd choice to all 50 questions(adds 2 to counter, spacing is adjusted for correct output in each question)
	//String[] answer3 - an array to store the 3rd choice to all 50 questions(adds 3 to counter, spacing is adjusted for correct output in each question)
	//String[] answer4 - an array to store the 4th choice to all 50 questions(adds 4 to counter, spacing is adjusted for correct output in each question)
	//String[] choiceBook - an array to store all of the correct input for all the choices(as spacing is edited for the seperate 4 choice arrays for correct output - this array stores the proper spacing for outputting input)
	//String[] inputDisplay - an array to store all the input choices(strings) to be outputted after quiz is completed

	String[] questions = {"What color/pattern would you want your       Hogwarts pet to be?", "Of the following classes at Hogwarts, which  one would you excel at?", "Of the following classes at Hogwarts, which  one would you perform the worst in?", "What do you see yourself doing after Hogwarts?", "What was your first impression of Slytherin?", "What was your first impression of Gryffindor?", "What was your first impression of Hufflepuff?", "What was your first impression of Ravenclaw?", "You have a test in an hour that you forgot   about! What do you do?", "Oh no! You forgot your textbooks at your dorm! There's only 20 minutes until class. What do you do?", "What do you see in the mirror of erised, that shows your heart's desires?", "You now possess Marauder's map, and know the location of everything at Hogwarts!   What do you do?", "What is/would be your patronus, the animal   embodiment of your happiness?", "Choose your favourite spell listed below:", "You are an Animagus! Which animal do you     transform into?", "An unknown spell was shot at you! Quick, what spell do you shoot back?", "You are shown four doors, with only one  leading to your heart's desire. Which one do you choose?", "Which of the following do you consider the   highest form of praise? Being told you are:", "North, South, East or West?", "You are about to die, and must carve a   secret message on your gravestone for your children. How do you do it?", "Somehow, you have gotten hold of the     most powerful wand, the elder wand! What  do you do with it?", "Self sort time! Which house would you sort   yourself in?", "What instrument from the following pleases   you the most?", "The flutterby bush attracts prey by luring   them in with scent. What would you smell?", "You're running late for the Hogwarts express! What is your reason?", "Which of the following do you consider the   biggest insult?", "Based off instinct, which one of these wand  cores call to you?", "What types of spells do you see yourself     specializing in?", "In your opinion, how are goals reached?", "Which of the elements do you connect most    with?", "Would you choose to play quidditch?", "You have entered an enchanted garden!        What do you investigate first?", "How would you explore the forbidden forest?", "You have an excursion with your friends, but a bout of existential crisis strikes  you. How do you tell them?", "How would you describe your friendship circle?", "Think of your living room walls. What stands out? ", "Choose from the superpowers below:", "How do you imagine yourself travelling?", "What would you usually do in the common      rooms?", "What would you do if someone shared a secret with you?", "What kind of jokes do you usually tell?", "What sound do you consider most calming?", "You were assigned to write a book. What best describes its style?", "What kind of companion would you like your   pet to be?", "You are presented with a locked door. How do you enter?", "What season do you identify with the most?", "Out of these fears, which is most prominent  in you?", "Close family is coming over for the holidays! What food will they eat?", "What kind of historical figure would you use as a role model?", "Which house do you think that you will       NOT be sorted in?"};
	String[] answer1 = {"A. Ginger", "A. Defense Against the Dark Arts", "A. Astronomy", "A. Travelling the world", "A. An ambitious, respectable      house", "A. A house full of brave,         chivalrous souls", "A. A house with valuable judgement if they were able to voice it", "A. A wise house that lacks        experience in the field", "A. Cram, cram cram", "A. Sprint back to the dorms!", "A. Doing what is right", "A. Return the map", "A. A large mammal", "A. Expelliarmus, to disarm ", "A. Stallion", "A. Protego, the shield charm", "A. The large, white doors with    golden lining", "A. Inspiring", "A. West", "A. I will carve a simple code, like converting a number to its    corresponding alphabet", "A. Share it with a few trusted    loved ones", "A. Gryffindor, bold and heroic", "A. Piano", "A. The smell of a huge dinner", "A. You got on the wrong train", "A. Spreading bad rumors about you", "A. Vine", "A. Combat", "A. Through taking risks", "A. Fire", "A. Yes, as a team player", "A. Noise that seems to come from thebottom of a lake. You're not  sure if it's laughing or crying", "A. By myself, well-equipped", "A. Tell them upfront. You don't   want to go", "A. I have a few close friends, a few friends, and a few           acquaintances", "A. Portraits", "A. Superhuman speed and strength", "A. Broomstick", "A. Stare off into space", "A. It depends on the importance.    Sometimes I share, sometimes Idon't.", "A. Inappropriate jokes", "A. The swishing of a broomstick in the wind", "A. Character-driven plot, spanning series", "A. The adventurous type that will   always return to me, maybe    bring a souvenir", "A. Use brute force", "A. Summer", "A. Autophobia, the fear of being  alone", "A. I will try and learn a         complicated dish", "A. One that is heroic", "A. Ravenclaw"};
	String[] answer2 = {"B. Tabby", "B. Herbology", "B. History of Magic", "B. Settling down", "B. A house with issues in how it  raises its wizards", "B. An amiable, though reckless    house", "B. A nice house", "B. A booksmart, hardworking house", "B. Give up. I'm going to fail     anyways", "B. Share with a classmate", "B. Living a quiet life with loved ones", "B. Organize a secret group        expedition of Hogwarts!", "B. A small mammal", "B. Lumos, to illuminate", "B. Dog", "B. Reducto, reduction curse", "B. The hand-carved oak door,        decorated with drawings made  in chalk", "B. Hardworking", "B. East", "B. My children will figure it out on their own, it's fine", "B. Give it to a higher, more      responsible authority figure(s)", "B. Hufflepuff, fair and hardworking", "B. Cello", "B. The burning of a bonfire", "B. You spent too much time saying goodbye to family and friends ", "B. Taking advantage of you", "B. Silver lime", "B. Defense", "B. Through hard work and          perseverance", "B. Earth", "B. No, I will cheer from the      sidelines", "B. The conversing trees that seem to smile", "B. With a group of friends", "B. Go anyways", "B. I'm friends with pretty much   everyone!", "B. Plants", "B. Speak all human and animal        languages", "B. Take the magical metro bus", "B. Chat with peers", "B. I would keep it for so long    that I forget", "B. Dad jokes", "B. The soft twinkles of charms    being cast", "B. An emotional rollercoaster with a dash of wholesome", "B. The cute, clingy type that will  be by your side at the drop ofa hat ", "B. Knock", "B. Spring", "B. Allodoxaphobia, the fear of    other's opinions", "B. I will make warm, home         -cooked meals", "B. One that is kind", "B. Slytherin"};
	String[] answer3 = {"C. White", "C. Charms", "C. Potions", "C. Explore careers in the muggle  world", "C. A house that can be blind to   the destruction it causes", "C. A boisterous, somewhat annoying house", "C. A tranquil, sometimes sedentary house, comforting to be around", "C. A house full of intellectuals, with endless potential", "C. This wouldn't happen. I'm      always on top of my schedule", "C. Tell the teacher you forgot", "C. Exploring all that is to be    explored", "C. Visit all there is to visit    whenever I have the time", "C. A bird", "C. Obliviate, to forget", "C. Crow", "C. Expelliarmus, the disarming    spell ", "C. The tall, steel door that seems  to have ancient scripts etchedinto its surface ", "C. Intelligent", "C. South", "C. I will spend hours researching   codes in order to come up with something perfect", "C. Disguise it as a normal wand to  help me in class, and slowly  unveil its power", "C. Ravenclaw, witty and wise", "C. Organ", "C. The smell of the library", "C. You accidentally read 9 ¾ as   nine times three quarters", "C. Underestimating you", "C. Alder", "C. Divination", "C. Through methodical planning    and action", "C. Air", "C. I have no interest in quidditch", "C. The statue of an old scholar,  with something shiny in his eye", "C. I wouldn't ", "C. Make up an excuse about having something more serious", "C. I have tight, small circle of  relationships", "C. Paintings", "C. Change the past", "C. Take the muggle way", "C. Study", "C. I take all my secrets to the   grave", "C. Smart or witty jokes", "C. The whisper of ancient pages   being turned", "C. Poetic words and hard, solid   worldbuilding", "C. The curious, gullible type that is always open to learning", "C. Find the key", "C. Fall", "C. Atelophobia, the fear of       imperfection", "C. All of their meals will be       carefully planned, with       balanced nutrients", "C. One that is wise ", "C. Gryffindor"};
	String[] answer4 = {"D. Black", "D.  Transfiguration", "D. Herbology", "D. Explore careers in the wizarding world", "D. A house that is most mature and wise", "D. A heroic but foolhardy house", "D. A house that lacks drive and    ambitions", "D. An excellent house to partner   with, and use", "D. Cheat on the test", "D. Steal from a classmate", "D. The world being proud of my     achievements", "D. Plot down all the secrets onto another sheet of paper, then    give back the map", "D. A reptile", "D. Alohomora, to open locks", "D. Cat", "D. Avada Kedavra, the killing curse", "D. The battered, wooden doors,      almost consumed by all types  of nature", "D. Wise", "D. North", "D. I don't have any secret messages,but I will carve some         gibberish for bamboozling purposes", "D. Use it to immediately become an important figure!", "D. Slytherin, cunning and ambitious", "D. Drums", "D. The fall morning air", "D. You got the dates and times     switched up", "D. Labeling you as useless", "D. Maple", "D. Any", "D. Through doing whatever it takes", "D. Water", "D. Yes, extremely competitively", "D. A path paved in gold and silver, leading to a distant castle", "D. By instruction from someone     with experience", "D. Simply ghost", "D. My relationships are very       blurred", "D. They're bare ", "D. Change forms at will ", "D. I don't travel, I can apparte", "D. Pursue a personal hobby", "D. I might consider using it to my advantage", "D. Dark jokes", "D. The clinking of potion bottles", "D. Realistic stories, fished from  personal experiences", "D. The quiet, low-maintenance type, who can preferably catch      pests", "D. Pick the lock", "D. Winter", "D. Atychiphobia, the fear of       failure", "D. We will mainly eat out, at      restaurants and such", "D. One that has achieved great     things", "D. Hufflepuff"};
	String[] choiceBook = {"A. Ginger", "A. Defense Against the Dark Arts", "A. Astronomy", "A. Travelling the world", "A. An ambitious, respectable house", "A. A house full of brave, chivalrous souls", "A. A house with valuable judgement if they were able to voice it", "A. A wise house that lacks experience in the field", "A. Cram, cram cram", "A. Sprint back to the dorms!", "A. Doing what is right", "A. Return the map", "A. A large mammal", "A. Expelliarmus, to disarm", "A. Stallion", "A. Protego, the shield charm", "A. The large, white doors with golden lining", "A. Inspiring", "A. West", "A. I will carve a simple code, like converting a number to its corresponding alphabet", "A. Share it with a few trusted loved ones", "A. Gryffindor, bold and heroic", "A. Piano", "A. The smell of a huge dinner", "A. You got on the wrong train", "A. Spreading bad rumors about you", "A. Vine", "A. Combat", "A. Through taking risks", "A. Fire", "A. Yes, as a team player", "A. Noise that seems to come from the bottom of a lake. You're not sure if it's       laughing or crying", "A. By myself, well-equipped", "A. Tell them upfront. You don't want to go", "A. I have a few close friends, a few friends, and a few acquaintances", "A. Portraits", "A. Superhuman speed and strength", "A. Broomstick", "A. Stare off into space", "A. It depends on the importance. Sometimes I share, sometimes I don't.", "A. Inappropriate jokes", "A. The swishing of a broomstick in the wind", "A. Character-driven plot, spanning series", "A. The adventurous type that will always return to me, maybe bring a souvenir", "A. Use brute force", "A. Summer", "A. Autophobia, the fear of being  alone", "A. I will try and learn a complicated dish", "A. One that is heroic", "A. Ravenclaw", "B. Tabby", "B. Herbology", "B. History of Magic", "B. Settling down", "B. A house with issues in how it  raises its wizards", "B. An amiable, though reckless house", "B. A nice house", "B. A booksmart, hardworking house", "B. Give up. I'm going to fail anyways", "B. Share with a classmate", "B. Living a quiet life with loved ones", "B. Organize a secret group expedition of Hogwarts!", "B. A small mammal", "B. Lumos, to illuminate", "B. Dog", "B. Reducto, reduction curse", "B. The hand-carved oak door, decorated with drawings made  in chalk", "B. Hardworking", "B. East", "B. My children will figure it out on their own, it's fine", "B. Give it to a higher, more responsible authority figure(s)", "B. Hufflepuff, fair and hardworking", "B. Cello", "B. The burning of a bonfire", "B. You spent too much time saying goodbye to family and friends", "B. Taking advantage of you", "B. Silver lime", "B. Defense", "B. Through hard work and perseverance", "B. Earth", "B. No, I will cheer from the sidelines", "B. The conversing trees that seem to smile", "B. With a group of friends", "B. Go anyways", "B. I'm friends with pretty much everyone!", "B. Plants", "B. Speak all human and animal languages", "B. Take the magical metro bus", "B. Chat with peers", "B. I would keep it for so long that I forget", "B. Dad jokes", "B. The soft twinkles of charms being cast", "B. An emotional rollercoaster with a dash of wholesome", "B. The cute, clingy type that will be by your side at the drop of a hat ", "B. Knock", "B. Spring", "B. Allodoxaphobia, the fear of other's opinions", "B. I will make warm, home-cooked meals", "B. One that is kind", "B. Slytherin", "C. White", "C. Charms", "C. Potions", "C. Explore careers in the muggle world", "C. A house that can be blind to the destruction it causes", "C. A boisterous, somewhat annoying house", "C. A tranquil, sometimes sedentary house, comforting to be around", "C. A house full of intellectuals, with endless potential", "C. This wouldn't happen. I'm always on top of my schedule", "C. Tell the teacher you forgot", "C. Exploring all that is to be explored", "C. Visit all there is to visit whenever I have the time", "C. A bird", "C. Obliviate, to forget", "C. Crow", "C. Expelliarmus, the disarming spell ", "C. The tall, steel door that seems to have ancient scripts etched into its surface", "C. Intelligent", "C. South", "C. I will spend hours researching codes in order to come up with something perfect", "C. Disguise it as a normal wand to  help me in class, and slowly unveil its power", "C. Ravenclaw, witty and wise", "C. Organ", "C. The smell of the library", "C. You accidentally read 9 ¾ as  nine times three quarters", "C. Underestimating you", "C. Alder", "C. Divination", "C. Through methodical planning and action", "C. Air", "C. I have no interest in quidditch", "C. The statue of an old scholar,  with something shiny in his eye", "C. I wouldn't ", "C. Make up an excuse about having something more serious", "C. I have tight, small circle of relationships", "C. Paintings", "C. Change the past", "C. Take the muggle way", "C. Study", "C. I take all my secrets to the grave", "C. Smart or witty jokes", "C. The whisper of ancient pages being turned", "C. Poetic words and hard, solid worldbuilding", "C. The curious, gullible type that is always open to learning", "C. Find the key", "C. Fall", "C. Atelophobia, the fear of imperfection", "C. All of their meals will be carefully planned, with balanced nutrients", "C. One that is wise ", "C. Gryffindor", "D. Black", "D.  Transfiguration", "D. Herbology", "D. Explore careers in the wizarding world", "D. A house that is most mature and wise", "D. A heroic but foolhardy house", "D. A house that lacks drive and ambitions", "D. An excellent house to partner with, and use", "D. Cheat on the test", "D. Steal from a classmate", "D. The world being proud of my achievements", "D. Plot down all the secrets onto another sheet of paper, then give back the map", "D. A reptile", "D. Alohomora, to open locks", "D. Cat", "D. Avada Kedavra, the killing curse", "D. The battered, wooden doors, almost consumed by all types of nature", "D. Wise", "D. North", "D. I don't have any secret messages, but I will carve some gibberish for bamboozling purposes", "D. Use it to immediately become an important figure!", "D. Slytherin, cunning and ambitious", "D. Drums", "D. The fall morning air", "D. You got the dates and times switched up", "D. Labeling you as useless", "D. Maple", "D. Any", "D. Through doing whatever it takes", "D. Water", "D. Yes, extremely competitively", "D. A path paved in gold and silver, leading to a distant castle", "D. By instruction from someone with experience", "D. Simply ghost", "D. My relationships are very blurred", "D. They're bare ", "D. Change forms at will ", "D. I don't travel, I can apparte", "D. Pursue a personal hobby", "D. I might consider using it to my advantage", "D. Dark jokes", "D. The clinking of potion bottles", "D. Realistic stories, fished from personal experiences", "D. The quiet, low-maintenance type, who can preferably catch pests", "D. Pick the lock", "D. Winter", "D. Atychiphobia, the fear of failure", "D. We will mainly eat out, at restaurants and such", "D. One that has achieved great things", "D. Hufflepuff"};
	String[] inputDisplay = new String [11];

	for (int i = 0 ; i < 11 ; i++) //Loops for each of 11 questions
	{
	    running = true; //running is set to true every time it loops
	    error = true; //error is set to true
	    response = ' '; //response is set to a default value after each input(temporary values)
	    //Check for repetitions when choosing random question
	    while (error) //While error is true
	    {
		questionNum = ((int) (49 * Math.random ())); //Picks a random index from 0-49(50 questions), 11 times(has to be unique index each time)
		if (askRandom (questionNum) == false) //Calls the askRandom method - if the index is greater or equal than 0, that means the string exists in the array
		{
		    responseNum [i] = questionNum; //random index is stored in the responseNum array
		    error = false; //error is set to false(so that it doesn't ask for the same index input again
		}
	    }
	    do
	    {
		//Outputs different background image for each question
		if (i == 0 || i == 5 || i == 10)
		{
		    importImage (10, 10, "askbg1.PNG"); //Executes importImage method
		}
		else if (i == 1 || i == 6)
		{
		    importImage (10, 10, "askbg2.PNG"); //Executes importImage method
		}
		else if (i == 2 || i == 7)
		{
		    importImage (10, 10, "askbg3.PNG"); //Executes importImage method
		}
		else if (i == 3 || i == 8)
		{
		    importImage (10, 10, "askbg4.PNG"); //Executes importImage method
		}
		else if (i == 4 || i == 9)
		{
		    importImage (10, 10, "askbg5.PNG"); //Executes importImage method
		}

		//Draws option boxes darker
		c.setColor (black);
		c.fillRect (45, 45, 598, 230);
		c.fillRoundRect (20, 320, 320, 80, 40, 40);
		c.fillRoundRect (350, 320, 320, 80, 40, 40);
		c.fillRoundRect (20, 415, 320, 80, 40, 40);
		c.fillRoundRect (350, 415, 320, 80, 40, 40);

		//White border around option boxes
		cornerMotif (Color.white, 250); //Executes cornerMotif method
		c.drawRoundRect (20, 320, 320, 80, 40, 40);
		c.drawRoundRect (20, 415, 320, 80, 40, 40);
		c.drawRoundRect (350, 320, 320, 80, 40, 40);
		c.drawRoundRect (350, 415, 320, 80, 40, 40);

		//Outputs the count number in roman numerals
		c.setFont (new Font ("Baskerville Old Face", Font.PLAIN, 18));
		if (i == 0)
		{
		    c.drawString ("I - XI", 25, 35);
		}
		else if (i == 1)
		{
		    c.drawString ("II - XI", 25, 35);
		}
		else if (i == 2)
		{
		    c.drawString ("III - XI", 25, 35);
		}
		else if (i == 3)
		{
		    c.drawString ("IV - XI", 25, 35);
		}
		else if (i == 4)
		{
		    c.drawString ("V - XI", 25, 35);
		}
		else if (i == 5)
		{
		    c.drawString ("VI - XI", 25, 35);
		}
		else if (i == 6)
		{
		    c.drawString ("VII - XI", 25, 35);
		}
		else if (i == 7)
		{
		    c.drawString ("VIII - XI", 25, 35);
		}
		else if (i == 8)
		{
		    c.drawString ("IX - XI", 25, 35);
		}
		else if (i == 9)
		{
		    c.drawString ("X - XI", 25, 35);
		}
		else if (i == 10)
		{
		    c.drawString ("XI - XI", 25, 35);
		}

		//Question output
		c.setFont (new Font ("Baskerville Old Face", Font.PLAIN, 28));
		if (responseNum [i] == 3 || responseNum [i] == 4 || responseNum [i] == 5 || responseNum [i] == 6 || responseNum [i] == 7 || responseNum [i] == 13 || responseNum [i] == 18 || responseNum [i] == 28 || responseNum [i] == 30 || responseNum [i] == 32 || responseNum [i] == 34 || responseNum [i] == 36 || responseNum [i] == 37 || responseNum [i] == 40 || responseNum [i] == 41 || responseNum [i] == 45)
		{
		    c.drawString (questions [responseNum [i]], 90, 160); //For questions with 1 line output
		}
		else if (responseNum [i] == 9 || responseNum [i] == 11 || responseNum [i] == 16 || responseNum [i] == 19 || responseNum [i] == 20 || responseNum [i] == 33)
		{
		    c.drawString (questions [responseNum [i]].substring (0, 41), 90, 130); //For questions with 3 lines of output
		    c.drawString (questions [responseNum [i]].substring (41, 83), 90, 160);
		    c.drawString (questions [responseNum [i]].substring (83), 90, 190);
		}
		else if (responseNum [i] == 0 || responseNum [i] == 1 || responseNum [i] == 2 || responseNum [i] == 8 || responseNum [i] == 10 || responseNum [i] == 12 || responseNum [i] == 14 || responseNum [i] == 15 || responseNum [i] == 17 || responseNum [i] == 21 || responseNum [i] == 22 || responseNum [i] == 23 || responseNum [i] == 24 || responseNum [i] == 25 || responseNum [i] == 26 || responseNum [i] == 27 || responseNum [i] == 29 || responseNum [i] == 30 || responseNum [i] == 31 || responseNum [i] == 35 || responseNum [i] == 38 || responseNum [i] == 39 || responseNum [i] == 42 || responseNum [i] == 43 || responseNum [i] == 44 || responseNum [i] == 46 || responseNum [i] == 47 || responseNum [i] == 48 || responseNum [i] == 49)
		{
		    c.drawString (questions [responseNum [i]].substring (0, 45), 90, 160); //For questions with 2 lines output
		    c.drawString (questions [responseNum [i]].substring (45), 90, 190);
		}

		//Choices output
		if (answer1 [responseNum [i]].length () <= 35) //Option A output
		{
		    c.setFont (new Font ("Baskerville Old Face", Font.PLAIN, 20)); //One line output(depending on lengths of strings)
		    c.drawString (answer1 [responseNum [i]], 40, 370);
		}
		else if (answer1 [responseNum [i]].length () > 35 && answer1 [responseNum [i]].length () < 66)
		{
		    c.setFont (new Font ("Baskerville Old Face", Font.PLAIN, 20)); //Two line output
		    c.drawString (answer1 [responseNum [i]].substring (0, 34), 40, 360);
		    c.drawString (answer1 [responseNum [i]].substring (34), 40, 380);
		}
		else
		{
		    c.setFont (new Font ("Baskerville Old Face", Font.PLAIN, 18)); //Three line output
		    c.drawString (answer1 [responseNum [i]].substring (0, 36), 40, 350);
		    c.drawString (answer1 [responseNum [i]].substring (36, 66), 40, 365);
		    c.drawString (answer1 [responseNum [i]].substring (66), 40, 380);
		}

		if (answer2 [responseNum [i]].length () <= 35) //Option B output
		{
		    c.setFont (new Font ("Baskerville Old Face", Font.PLAIN, 20)); //One line output
		    c.drawString (answer2 [responseNum [i]], 370, 370);
		}
		else if (answer2 [responseNum [i]].length () > 35 && answer2 [responseNum [i]].length () < 66)
		{
		    c.setFont (new Font ("Baskerville Old Face", Font.PLAIN, 20)); //Two line output
		    c.drawString (answer2 [responseNum [i]].substring (0, 34), 370, 360);
		    c.drawString (answer2 [responseNum [i]].substring (34), 370, 380);
		}
		else
		{
		    c.setFont (new Font ("Baskerville Old Face", Font.PLAIN, 18)); //Three line output
		    c.drawString (answer2 [responseNum [i]].substring (0, 36), 370, 350);
		    c.drawString (answer2 [responseNum [i]].substring (36, 66), 370, 365);
		    c.drawString (answer2 [responseNum [i]].substring (66), 370, 380);
		}

		if (answer3 [responseNum [i]].length () <= 35) //Option C output
		{
		    c.setFont (new Font ("Baskerville Old Face", Font.PLAIN, 20)); //One line output
		    c.drawString (answer3 [responseNum [i]], 40, 465);
		}
		else if (answer3 [responseNum [i]].length () > 35 && answer3 [responseNum [i]].length () < 66)
		{
		    c.setFont (new Font ("Baskerville Old Face", Font.PLAIN, 20)); //Two line output
		    c.drawString (answer3 [responseNum [i]].substring (0, 34), 40, 455);
		    c.drawString (answer3 [responseNum [i]].substring (34), 40, 475);
		}
		else
		{
		    c.setFont (new Font ("Baskerville Old Face", Font.PLAIN, 18)); //Three line output
		    c.drawString (answer3 [responseNum [i]].substring (0, 36), 40, 445);
		    c.drawString (answer3 [responseNum [i]].substring (36, 66), 40, 460);
		    c.drawString (answer3 [responseNum [i]].substring (66), 40, 475);
		}

		if (answer4 [responseNum [i]].length () <= 35) //Option D output
		{
		    c.setFont (new Font ("Baskerville Old Face", Font.PLAIN, 20)); //One line output
		    c.drawString (answer4 [responseNum [i]], 370, 465);
		}
		else if (answer4 [responseNum [i]].length () > 35 && answer4 [responseNum [i]].length () < 66)
		{
		    c.setFont (new Font ("Baskerville Old Face", Font.PLAIN, 20)); //Two line output
		    c.drawString (answer4 [responseNum [i]].substring (0, 35), 370, 455);
		    c.drawString (answer4 [responseNum [i]].substring (35), 370, 475);
		}
		else
		{
		    c.setFont (new Font ("Baskerville Old Face", Font.PLAIN, 18)); //Three line output
		    c.drawString (answer4 [responseNum [i]].substring (0, 36), 370, 445);
		    c.drawString (answer4 [responseNum [i]].substring (36, 66), 370, 460);
		    c.drawString (answer4 [responseNum [i]].substring (66), 370, 475);
		}

		//Highlights the boxes
		response = c.getChar (); //Gets response for each question
		c.setColor (lightGrey);
		if (response == 'a')
		{
		    c.fillRoundRect (20, 320, 320, 80, 40, 40); //Transparent shape over button
		    inputDisplay [i] = choiceBook [responseNum [i]]; //indexes 0 to 49 in choiceBook contain answer1 choices
		    counter++; //answer1 choices add 1 to the counter
		    pauseProgram (Color.white, 15, 265, 530);
		    running = false; //running is set to false (valid input)
		}
		else if (response == 'b')
		{
		    c.fillRoundRect (350, 320, 320, 80, 40, 40); //Transparent shape over button
		    inputDisplay [i] = choiceBook [50 + responseNum [i]]; //indexes 50 - 99 in choiceBook contain answer1 choices
		    counter += 2; //answer2 choices add 2 to the counter
		    pauseProgram (Color.white, 15, 265, 530);
		    running = false; //running is set to false (valid input)
		}
		else if (response == 'c')
		{
		    c.fillRoundRect (20, 415, 320, 80, 40, 40); //Transparent shape over button
		    inputDisplay [i] = choiceBook [100 + responseNum [i]]; //indexes 100 to 149 in choiceBook contain answer1 choices
		    counter += 3; //answer3 choices add 3 to the counter
		    pauseProgram (Color.white, 15, 265, 530);
		    running = false; //running is set to false (valid input)
		}
		else if (response == 'd')
		{
		    c.fillRoundRect (350, 415, 320, 80, 40, 40); //Transparent shape over button
		    inputDisplay [i] = choiceBook [150 + responseNum [i]]; //indexes 150 to 199 in choiceBook contain answer1 choices
		    counter += 4; //answer4 choices add 4 to the counter
		    pauseProgram (Color.white, 15, 265, 530);
		    running = false; //running is set to false (valid input)
		}
		else
		{
		    JOptionPane.showMessageDialog (f, "Invalid input. Please try again."); //For invalid input
		}
	    }
	    while (running);
	}

	//Output user input for all 11 questions
	c.setFont (new Font ("Baskerville Old Face", Font.BOLD, 20));
	importImage (10, 10, "menubg.jpg"); //Executes importImage method
	cornerMotif (Color.white, 0); //Executes cornerMotif method
	c.drawString ("here are your 11 responses:", 230, 90);
	c.setFont (new Font ("Baskerville Old Face", Font.PLAIN, 15));
	for (int i = 1 ; i < 12 ; i++) //Loop to output choices
	{
	    String num = Integer.toString (i); //String num - a field to store the question number as a string(for output)
	    c.drawString (num, 70, 30 * (i - 1) + 120);
	    if (inputDisplay [i - 1].length () > 85) //Output for 2 line choices
	    {
		c.drawString (inputDisplay [i - 1].substring (0, 85), 100, 30 * (i - 1) + 120);
		c.drawString (inputDisplay [i - 1].substring (85), 100, 30 * (i - 1) + 130);
	    }
	    else //Output for single line choices
	    {
		c.drawString (inputDisplay [i - 1], 100, 30 * (i - 1) + 120);
	    }
	}
    }


    //Method to write a file(data file for storing names and houses)
    //arguments: none
    //returns: none
    public void writeFile ()
    {
	PrintWriter output; // definition for a PrintWriter object
	//try to open the file
	try
	{
	    output = new PrintWriter (new FileWriter ("resultData.txt"));
	    //this loop will write all the data in the array to the file, with each element on a new line
	    for (int i = 0 ; i < 10 ; i++) //Loops for all students in class
	    {
		output.println (names [i]); //Outputs name
		output.println (houses [i]); //Outputs house
	    }
	    output.close (); //this line will save the file
	}
	catch (IOException e)
	{
	}
    }


    //Method to read a file(reads data file that contains houses and names - so that it can output in history method)
    //arguments: none
    //returns: none
    public void readFile ()
    {
	BufferedReader input; //definition for a BufferedReader object
	String line = ""; //String line - a field to read data from the file
	//try to open the file and read from it
	try
	{
	    input = new BufferedReader (new FileReader ("resultData.txt"));
	    int count = 0; //int count - a field to represent the index when data is saved into arrays(default is 0)
	    line = input.readLine (); //Read next line of data
	    while (line != null)
	    { //make sure that there is data to be read
		names [count] = line; //save the data into an array
		line = input.readLine (); //read the next line
		houses [count] = line; //save the data into an array
		line = input.readLine (); //read the next line
		count++;   //go to the next position in the array
	    }
	}
	catch (IOException e)
	{
	}
    }


    //Method to display results of last 10 people who did the quiz
    //arguments: none
    //returns: none
    public void history ()
    {
	boolean running = true; //boolean running - a field to determine whether the program will continue to run(default is true)
	boolean running1 = true; //boolean running - a alternate field to determine whether the history outputs again
	char keyPress; //char keyPress - a field to store the char entered        
	do
	{
	    do
	    {
		importImage (10, 10, "menubg.jpg"); //Executes importImage method
		c.setFont (new Font ("Baskerville Old Face", Font.BOLD, 35));
		cornerMotif (Color.white, 0); //Executes cornerMotif method
		c.drawString ("history", 230, 95);
		c.setFont (new Font ("Courier", Font.PLAIN, 12));
		c.drawString ("latest entries", 495, 94);
		c.drawString ("earliest entries", 495, 494);
		c.setFont (new Font ("Courier", Font.PLAIN, 30));
		c.drawRoundRect (80, 95, 530, 30, 30, 30); //Outputs a chart
		c.drawRoundRect (60, 135, 570, 30, 30, 30);
		c.drawRoundRect (80, 175, 530, 30, 30, 30);
		c.drawRoundRect (60, 215, 570, 30, 30, 30);
		c.drawRoundRect (80, 255, 530, 30, 30, 30);
		c.drawRoundRect (60, 295, 570, 30, 30, 30);
		c.drawRoundRect (80, 335, 530, 30, 30, 30);
		c.drawRoundRect (60, 375, 570, 30, 30, 30);
		c.drawRoundRect (80, 415, 530, 30, 30, 30);
		c.drawRoundRect (60, 455, 570, 30, 30, 30);
		c.drawLine (350, 95, 350, 125);
		c.drawLine (350, 135, 350, 165);
		c.drawLine (350, 175, 350, 205);
		c.drawLine (350, 215, 350, 245);
		c.drawLine (350, 255, 350, 285);
		c.drawLine (350, 295, 350, 325);
		c.drawLine (350, 335, 350, 365);
		c.drawLine (350, 375, 350, 405);
		c.drawLine (350, 415, 350, 445);
		c.drawLine (350, 455, 350, 485);
		c.setFont (new Font ("Courier", Font.PLAIN, 15));
		for (int i = 0 ; i < 10 ; i++) //Outputs names and houses in chart
		{
		    c.drawString (names [i], 150, 115 + 40 * i);
		    c.drawString (houses [i], 420, 115 + 40 * i);
		}
		//Options for continuing or clearing history
		c.setFont (new Font ("Baskerville Old Face", Font.PLAIN, 15));
		c.drawRoundRect (145, 510, 195, 30, 30, 30); //Outputs button based on size
		c.drawRoundRect (355, 510, 195, 30, 30, 30); //Outputs button based on size
		c.drawString ("   Press space to continue", 160, 530);
		c.drawString (" Press 'c' to clear history", 380, 530);

		keyPress = c.getChar (); //gets any char value
		if (keyPress == ' ') //If the key entered is space - program will continue properly
		{
		    running1 = false; //running1 is set to false  - exits inner loop first
		    running = false; //running is set to false - exits outer loop second(goes back to main menu)
		}
		else if (keyPress == 'c') //If 'c' is entered history clears
		{
		    for (int i = 0 ; i < 10 ; i++) //Sets array values to all empty
		    {
			names [i] = " ";
			houses [i] = " ";
		    }
		    running1 = false; //Exits the inner loop so that the history outputs again(with cleared values)
		}
		else
		{
		    JOptionPane.showMessageDialog (f, "Invalid input. Please try again."); //invalid input
		}
	    }
	    while (running1);
	}
	while (running);
	writeFile (); //Executes the writeFile method - to write values of array to the file(clears if that option was chosen)
    }


    //Method to return personality type(Black box return)
    //arguments: int
    //returns: String
    private String calcResult (int score)
    {
	String houseResult = ""; //String houseResult - a field to store the house a user is in
	if (score >= 11 && score <= 18) //Range 11 - 18
	{
	    houseResult = "Gryffindor";
	}
	else if (score >= 19 && score <= 26) //Range 19 - 26
	{
	    houseResult = "Hufflepuff";
	}
	else if (score >= 27 && score <= 35) //Range 27 - 35
	{
	    houseResult = "Ravenclaw";
	}
	else if (score >= 36 && score <= 44) //Range 36 - 44
	{
	    houseResult = "Slytherin";
	}
	return houseResult;
    }


    //Method to display the correct output(after quiz)
    //arguments: none
    //returns: none
    public void display ()
    {
	if (calcResult (counter).equals ("Gryffindor"))//Checks if the return value from black box return method is one of the 4 houses
	{
	    gryffindor (); //Executes gryffindor method
	}
	else if (calcResult (counter).equals ("Hufflepuff"))
	{
	    hufflepuff (); //Executes hufflepuff method
	}
	else if (calcResult (counter).equals ("Ravenclaw"))
	{
	    ravenclaw (); //Executes ravenclaw method
	}
	else if (calcResult (counter).equals ("Slytherin"))
	{
	    slytherin (); //Executes slytherin method
	}
	for (int i = 9 ; i >= 1 ; i--) //Loop for adding new house values to the houses array (Most recent 10 inputs)
	{
	    houses [i] = houses [i - 1]; //All index values move up one(e.g. index 9 stores value of index 8)
	}
	houses [0] = calcResult (counter); //New house is stored in the first index
    }


    ///Method to display a menu for house descriptions
    //arguments: none
    //returns: none
    public void houseMenu ()
    {        
	boolean running = true; //boolean running - a field to determine whether the program will continue to run(default is true)
	char menuChoice; //char menuChoice - a field to store the menu choice option entered by the user
	do
	{
	    importImage (10, 10, "menubg.jpg"); //Executes importImage method
	    lightBlue = new Color (220, 217, 255);
	    cornerMotif (lightBlue, 0); //Executes cornerMotif method
	    c.drawRoundRect (190, 130, 300, 40, 40, 40); //Outputs buttons for menu
	    c.drawRoundRect (190, 190, 300, 40, 40, 40);
	    c.drawRoundRect (190, 250, 300, 40, 40, 40);
	    c.drawRoundRect (190, 310, 300, 40, 40, 40);
	    c.setFont (new Font ("Baskerville Old Face", Font.BOLD, 35));
	    c.drawString ("house", 230, 130);
	    c.drawString ("descriptions", 280, 310);
	    c.setFont (new Font ("Courier", Font.PLAIN, 16));
	    c.drawString ("1.Gryffindor", 210, 155);
	    c.drawString ("2.Slytherin", 210, 215);
	    c.drawString ("3.Hufflepuff", 210, 275);
	    c.drawString ("4.Ravenclaw", 210, 335);

	    menuChoice = c.getChar (); //Gets char value for menu option
	    c.setColor (lightGrey);
	    if (menuChoice == '1')
	    {
		c.fillRoundRect (190, 130, 300, 40, 40, 40); //Transparent shape over button
		pauseProgram (lightBlue, 20, 225, 460);  //Executes pauseProgram method
		gryffindor (); //Executes gryffindor method
		running = false; //running is set to false
	    }
	    else if (menuChoice == '2')
	    {
		c.fillRoundRect (190, 190, 300, 40, 40, 40); //Transparent shape over button
		pauseProgram (lightBlue, 20, 225, 460); //Executes pauseProgram method
		slytherin (); //Executes slytherin method
		running = false; //running is set to false
	    }
	    else if (menuChoice == '3')
	    {
		c.fillRoundRect (190, 250, 300, 40, 40, 40); //Transparent shape over button
		pauseProgram (lightBlue, 20, 225, 460); //Executes pauseProgram method
		hufflepuff (); //Executes hufflepuff method
		running = false; //running is set to false
	    }
	    else if (menuChoice == '4')
	    {
		c.fillRoundRect (190, 310, 300, 40, 40, 40); //Transparent shape over button
		pauseProgram (lightBlue, 20, 225, 460); //Executes pauseProgram method
		ravenclaw (); //Executes ravenclaw method
		running = false; //running is set to false
	    }
	    else
	    {
		JOptionPane.showMessageDialog (f, "Invalid input. Please try again."); //Outputs error message if input is invalid
	    }
	}
	while (running);//valid input will exit loop to return to mainMenu
    }


    //Method to display the gryffindor description
    //arguments: none
    //returns: none
    public void gryffindor ()
    {
	importImage (10, 10, "redcloud.jpg"); //Executes importImage method
	c.setColor (white);
	c.fillRoundRect (30, 30, 630, 510, 25, 25);
	cornerMotif (lightYellow, 0);
	importImage (270, 50, "gryffindorCrest.png"); //Executes importImage method
	c.setFont (new Font ("Baskerville Old Face", Font.PLAIN, 50));
	c.drawString ("GRYFFINDOR", 190, 250);
	c.setFont (new Font ("Baskerville Old Face", Font.BOLD, 23));
	c.drawString ("COURAGE - BRAVERY - DETERMINATION", 105, 290);
	c.setFont (new Font ("Courier", Font.PLAIN, 16));
	c.drawString ("You have been placed in the house of Gryffindor, a house ", 65, 320);
	c.drawString ("that values the heroic traits of courage, determination", 55, 345);
	c.drawString ("and righteousness. Use these traits sensibly, for they are", 50, 370);
	c.drawString ("as suitible for protection as they are for desctruction.", 55, 395);
	c.setFont (new Font ("Baskerville Old Face", 0, 23));
	c.drawString ("Famous Gryffindors: Harry Potter, Remus Lupin, Dumbledore", 60, 450);
	pauseProgram (lightYellow, 15, 265, 520); //Executes pauseProgram method
    }


    //Method to display the slytherin description
    //arguments: none
    //returns: none
    public void slytherin ()
    {
	importImage (10, 10, "green.jpg"); //Executes importImage method
	c.setColor (white);
	c.fillRoundRect (30, 30, 630, 510, 25, 25);
	cornerMotif (lightYellow, 0);
	importImage (270, 50, "slytherinCrest.png"); //Executes importImage method
	c.setFont (new Font ("Baskerville Old Face", Font.PLAIN, 50));
	c.drawString ("SLYTHERIN", 205, 250);
	c.setFont (new Font ("Baskerville Old Face", Font.BOLD, 23));
	c.drawString ("PRIDE - AMBITION - CUNNING", 170, 290);
	c.setFont (new Font ("Courier", Font.PLAIN, 16));
	c.drawString ("You have been placed in the house of Slytherin, a house ", 75, 320);
	c.drawString ("that values the strong traits of leadership, resourcefulness", 50, 345);
	c.drawString ("and ambition. Use these traits wisely, for they have as much", 50, 370);
	c.drawString ("potential to lead one astray as they do to lead to success.", 55, 395);
	c.setFont (new Font ("Baskerville Old Face", 0, 23));
	c.drawString ("Famous Slytherins: Severus Snape, Merlin, Salazar Slytherin", 70, 450);
	pauseProgram (lightYellow, 15, 265, 520); //Executes pauseProgram method
    }


    //Method to display the hufflepuff description
    //arguments: none
    //returns: none
    public void hufflepuff ()
    {
	importImage (10, 10, "yellow.jpg"); //Executes importImage method
	c.setColor (white);
	c.fillRoundRect (30, 30, 630, 510, 25, 25);
	cornerMotif (lightYellow, 0);
	importImage (270, 50, "hufflepuffCrest.png"); //Executes importImage method
	c.setFont (new Font ("Baskerville Old Face", Font.PLAIN, 50));
	c.drawString ("HUFFLEPUFF", 190, 250);
	c.setFont (new Font ("Baskerville Old Face", Font.BOLD, 23));
	c.drawString ("DEDICATION - PATIENCE - LOYALTY", 135, 290);
	c.setFont (new Font ("Courier", Font.PLAIN, 16));
	c.drawString ("You have been placed in the house of Hufflepuff, a house ", 65, 320);
	c.drawString ("that values the altruistic traits of loyalty, perseverance", 55, 345);
	c.drawString ("and kindness. Use these traits rationally, for they are", 50, 370);
	c.drawString ("as capable of bringing others hope as they do to you despair.", 50, 395);
	c.setFont (new Font ("Baskerville Old Face", 0, 22));
	c.drawString ("Famous Hufflepuffs: Newt Scamander, Fat Friar, Helga Hufflepuff", 60, 450);
	pauseProgram (lightYellow, 15, 265, 520); //Executes pauseProgram method

    }


    //Method to display the ravenclaw description
    //arguments: none
    //returns: none
    public void ravenclaw ()
    {
	importImage (10, 10, "blue.v2.jpg"); //Executes importImage method
	c.setColor (white);
	c.fillRoundRect (30, 30, 630, 510, 25, 25);
	cornerMotif (lightYellow, 0);
	importImage (270, 50, "raveclawCrest.png"); //Executes importImage method
	c.setFont (new Font ("Baskerville Old Face", Font.PLAIN, 50));
	c.drawString ("RAVENCLAW", 190, 250);
	c.setFont (new Font ("Baskerville Old Face", Font.BOLD, 23));
	c.drawString ("WIT - LEARNING - WISDOM", 186, 290);
	c.setFont (new Font ("Courier", Font.PLAIN, 16));
	c.drawString ("You have been placed in the house of Ravenclaw, a house ", 65, 320);
	c.drawString ("that values the astute traits of wisdom, creativity", 55, 345);
	c.drawString ("and wit. Use these traits versatilely, for there will", 50, 370);
	c.drawString ("come a day where you open your eyes to a world beyond you.", 50, 395);
	c.setFont (new Font ("Baskerville Old Face", 0, 20));
	c.drawString ("Famous Ravenclaws: Luna Lovegood, Cho Chang, Rowena Ravenclaw", 60, 450);
	pauseProgram (lightYellow, 15, 265, 520); //Executes pauseProgram method
    }


    //Method to output a corner design(for display and menu)
    //arguments: Color, int
    //returns: none
    public void cornerMotif (Color colour, int y)
    {
	//left top corner
	c.setColor (colour);
	c.drawLine (45, 60, 45, 105);
	c.drawLine (45, 60, 60, 60);
	c.drawLine (60, 60, 60, 45);
	c.drawLine (60, 45, 105, 45);
	c.drawLine (53, 53, 53, 85);
	c.drawLine (53, 53, 85, 53);
	c.drawOval (44, 44, 5, 5);
	c.drawOval (43, 112, 5, 5);
	c.drawOval (112, 43, 5, 5);

	//right top corner
	c.drawLine (643, 60, 643, 105);
	c.drawLine (643, 60, 628, 60);
	c.drawLine (628, 60, 628, 45);
	c.drawLine (628, 45, 584, 45);
	c.drawLine (636, 53, 636, 85);
	c.drawLine (636, 53, 604, 53);
	c.drawOval (641, 44, 5, 5);
	c.drawOval (641, 112, 5, 5);
	c.drawOval (573, 43, 5, 5);

	//left bottom corner
	c.drawLine (45, 509 - y, 45, 464 - y);
	c.drawLine (45, 509 - y, 60, 509 - y);
	c.drawLine (60, 509 - y, 60, 524 - y);
	c.drawLine (60, 524 - y, 105, 524 - y);
	c.drawLine (53, 516 - y, 53, 484 - y);
	c.drawLine (53, 516 - y, 85, 516 - y);
	c.drawOval (44, 521 - y, 5, 5);
	c.drawOval (43, 453 - y, 5, 5);
	c.drawOval (112, 521 - y, 5, 5);

	//right bottom corner
	c.drawLine (643, 509 - y, 643, 464 - y);
	c.drawLine (643, 509 - y, 628, 509 - y);
	c.drawLine (628, 509 - y, 628, 524 - y);
	c.drawLine (628, 524 - y, 584, 524 - y);
	c.drawLine (636, 516 - y, 636, 484 - y);
	c.drawLine (636, 516 - y, 604, 516 - y);
	c.drawOval (641, 521 - y, 5, 5);
	c.drawOval (641, 453 - y, 5, 5);
	c.drawOval (573, 521 - y, 5, 5);
    }


    //Method to import images
    //arguments: int, int, String
    //returns: none
    public void importImage (int x, int y, String fileName)
    {
	try
	{
	    BufferedImage boardPic = ImageIO.read (new File (fileName)); //Accesses the file for the image
	    c.drawImage (boardPic, x, y, null); //Outputs the image
	}
	catch (IOException e)
	{
	}
    }


    //Method to ask user to continue to next part of program
    //arguments: Color, int, int, int(colour, text size, x location, and y location)
    //returns: none
    public void pauseProgram (Color colour, int size, int x, int y)
    {
	boolean running = true; //boolean running - a field to determine whether the program will continue to run(default is true)
	char keyPress; //char keyPress - a field to store the char entered        
	c.setFont (new Font ("Baskerville Old Face", Font.PLAIN, size));
	c.setColor (colour);
	c.drawRoundRect (x - size, y - size * 4 / 3, size * 13, size * 2, size * 2, size * 2); //Outputs button based on size
	c.drawString ("    Press space to continue", x, y);
	do
	{
	    keyPress = c.getChar (); //gets any char value
	    if (keyPress == ' ') //If the key entered is space - program will continue properly
	    {
		running = false; //running is set to false
	    }
	    else
	    {
		JOptionPane.showMessageDialog (f, "Invalid input. Please press 'SPACE'."); //Anything other than space is invalid - error message
	    }
	}
	while (running);
    }


    //Method to output a goodbye message and exit the program
    //arguments: none
    //returns: none
    public void goodbye ()
    {
	importImage (10, 10, "maraudersmap.jpg"); //Executes importImage method
	c.setColor (brown);
	c.fillRoundRect (30, 150, 630, 280, 25, 25);
	c.setFont (new Font ("Baskerville Old Face", Font.BOLD, 20));
	c.setColor (lightYellow);
	c.drawString ("Thank you for trying the sorting hat quiz! This program was  ", 90, 250);
	c.drawString ("created by Olivia Chan and Lois Zan.", 200, 290);
	c.drawString ("- Press any key to exit the program -", 200, 340);
	c.getChar (); //gets char to exit
	System.exit (0); //Exits the program
    }


    public static void main (String[] args)
    {
	SortingQuiz t; //creates instance variable of SortingQuiz
	t = new SortingQuiz (); //constructs a new SortingQuiz object
	t.splashScreen (); //Executes splashScreen method
	t.mainMenu (); //Executes mainMenu method
    } // main method
} // SortingQuiz class


