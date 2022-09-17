// Hannah Ahmed
// 6th December 2021
// Version 1
// Write a chat bot procedural program that can have realistic conversations with people about films.

import java.util.Scanner; // Needed to make Scanner available

// Creates a new record type called 'film'
class film
{
    String horror; // Collection of data types are stored in a single record value
    String action;
}

class chatbot 
{
    public static void main (String [] a)
    {
        call_methods(); // Method call
        System.exit(0); // Allows program to terminate
    }
    
    // Allows the user to enter a string input
    public static String inputString (String information)
    {
        Scanner keyboard = new Scanner(System.in); // Scanner scans for inputs from the user
        String userInput;
    
        System.out.println(information);
        userInput = keyboard.nextLine(); // Stores the string input the user enters in the variable 'userInput'
    
    
    // Program will terminate when the user inputs 'goodbye' or 'bye'
    while (userInput.equals("goodbye") || userInput.equals("Goodbye") || userInput.equals("bye") || userInput.equals("Bye"))
    {
        System.out.println("Goodbye, it was nice talking to you!");
        System.exit(0); // Allows program to terminate
    }
    
    return userInput;
    }
    
    // Allows the chatbot to have an initial conversion with the user
    public static String introduction ()
    {
        String name;
        String usersFeeling;
        name = inputString("Hi, my name is ChatBot!" + "\n" + "What's your name?"); // Stores the user's input
        usersFeeling = inputString("How are you, " + name + "?");
    
        return usersFeeling; // Returns the value stored in 'usersFeeling'
    }
    
    // Allows the chatbot and user to have a short conversation about films
    public static String chatbots_interests ()
    {
        String favouriteFilm;
        System.out.println("I love to watch films");
        favouriteFilm = inputString("What's your favourite film?");
        System.out.println(favouriteFilm + " sounds like a good film!");
    
        return favouriteFilm; // Returns the user's answer
    }
    
    
    // Defines an abstract data type of 'film'
    // Operations:
    // create a record, given the chatbot's responses to the user
    // store the chatbot's response when the user replies with 'horror' to a specific question
    // store the chatbot's response when the user replies with 'action' to a specific question
    // get the chatbot's response when the user replies with 'horror' to a specific question
    // get the chatbot's response when the user replies with 'action' to a specific question
    
    
    // Creates a new record called 'response' of type 'film'
    public static film createFilmRecord ()
    {
        film response = new film(); 
    
        return response;
    }
    
    // Returns the chatbot's response (when the user inputs 'horror' as the film genre) that is stored in the record 'response'
    public static String getResponseToHorror (film response)
    {
        return response.horror; // Returns the string response stored in the record
    }
    
    // Returns the chatbot's response (when the user inputs 'action') which is stored in the record 'response'
    public static String getResponseToAction (film response)
    {
        return response.action; // Returns the string response stored in the record
    }
    
    // Stores the chatbot's response, when the user inputs 'horror', which is stored in the record 'response'
    public static film setResponseToHorror (film response, String h)
    {
        response.horror = h;
    
        return response; // Returns the updated record value
    }
    
    // Stores the chatbot's response, when the user inputs 'action', in a record AFTER being given the appropriate response
    public static film setResponseToAction (film response, String a)
    {
        response.action = a;
    
        return response; // Returns the updated record value
    }
    
    // Stores the responses that will be outputted after the user answers a specific question
    public static film store_responses ()
    {  
        film response = createFilmRecord(); // Calls the 'createFilmRecord()' method to access the method to create the 'film' record
        response = setResponseToHorror(response, "I don't watch horror films often, as I get scared easily");
        response = setResponseToAction(response, "I love action films!");
    
        return response;
    }
    
    // Asks the user what genre their favourite film is then gives their opinion on it

    public static String ask_genre (String favouriteFilm, film response) // Passes parameters into the method
    {
        String filmGenre;
        filmGenre = inputString("What genre of film is " + favouriteFilm + "?");
    
        if (filmGenre.equals("Horror") || filmGenre.equals("horror")) // Checks if the user's input is equal to a specific input
        { // Code is executed if the conditions for the if statement are true
            System.out.println(getResponseToHorror(response)); // Gets and prints the value stored in the 'horror' field of the record 'response' by calling an accessor method
        }
    
        else if (filmGenre.equals("Action") || filmGenre.equals("action"))
        {
            System.out.println(getResponseToAction(response));
        }
    
        else
        { // Code is executed if none of the conditions for the if, else-if statements are true
            System.out.println("I haven't watched " + filmGenre + " films before");
        }
    
        return filmGenre;
    }
    
    // Creates an empty string array of length 3 and stores questions in each element of it. The chatbot will choose a random question to ask from this array
    public static String[] question_array ()
    {
        final int ARRAYSIZE = 3;
        String [] questions = new String[ARRAYSIZE]; // Declares a new string array with 3 storage spaces
    
        questions[0] = ("Do you like comedy films?"); // Stores string values in different elements of the array
        questions[1] = ("What is your favourite film genre?");
        questions[2] = ("What was the last film you watched?");
    
        return questions;
    }
    
    // Generates a random number between 0 and 2
    public static int generate_random_number ()
    {
        double generateRandom = Math.random(); // Calls a method to generate a random number
    
        int randomNumber = (int) (generateRandom * 4 - 1); // Sets the number generated to be in the range 0-2
    
        return randomNumber;
    }
    
    // Chooses a random question from the array, prints it, then allows the user to respond to it
    public static void choose_random_question (String [] questions)
    {
        String userAnswer;
        int randomNumber = generate_random_number(); //Calls a method that generates a random number
    
        userAnswer = inputString(questions[randomNumber]); // Prints a random question from the array, whose position is equal to the random integer number generated. Stores the user's response.
    
        if (randomNumber == 0)
        {
            System.out.println("I like to watch comedy films when I'm feeling sad"); // Different response is printed depending on what question the chatbot asked
        }
    
        if (randomNumber == 1)
        {
            System.out.println("I've watched quite a few " + userAnswer + " films before, but I wouldn't say they're my favourite!");
        }
    
        else if (randomNumber == 2)
        {
            System.out.println("I've watched " + userAnswer + " before and I really liked it!");
        }
    
        return;
    }
    
    // Chatbot gets the user to enter some film recommendations

    public static void film_recommendations ()
    {
        String usersFirstRecommendation;
        String userRecommendations;
    
        System.out.println("I really need some new films to watch");
        usersFirstRecommendation = inputString("Can you recommend a good film?");
        System.out.println("That sounds like a great film! I'll be sure to add that to my watch list");
    
        for (int i = 0; i <= 1; i++)
        {
            userRecommendations = inputString("Can you recommend another film?");
        
            for (int n = 0; n <= 0; n++) // Nested for loop
            {
                System.out.println("I will add that to my watch list as well");
            } 
        }
    
        System.out.println("Thanks for the recommendations, I think that's enough!");
    
        return;
    }
    
    // Gets the string values the user entered for 'actor' and 'filmActor', then sorts them in alphabetical order
    public static boolean sorting_algorithm ()
    {
        String actor = inputString("Who is your favourite film actor?");
        System.out.println(actor + " is a great actor!");
        String filmActor = inputString("What is the name of a film he/she was in?");
        System.out.println("Oh, I haven't watched " + filmActor + " before");
        int shortest;
        int length1 = actor.length(); // Obtains the length of the variable stored in 'actor' and stores it in a variable
        int length2 = filmActor.length(); 
    
        // Checks which string value has the shortest length
        if (length1 < length2)
            shortest = length1; // If the length of the string value stored in 'length1' is shorter than the one in 'length2', it becomes the shortest string of the two
        else
            shortest = length2; 
    
        // Checks each character of each string one by one and sorts them alphabetically
        for (int i = 0; i < shortest; i++)
        {
            if (actor.charAt(i) < filmActor.charAt(i)) 
                return true; // If the next character in the string stored in 'length1' comes before the one in 'length'2, the string in 'length1' becomes the shortest value
            else if (actor.charAt(i) > filmActor.charAt(i))
                return false; 
        }
    
        // Checks if the string values are in the same alphabetical order or which one comes before the other alphabetically
        if (length1 == length2)
            return false; 
        else if (length1 < length2)
            return true; // Returns true if the string value stored in 'length1' comes before the one in 'length2' alphabetically
        else
            return false; 
    }
    
        // Declares a method allows the chatbot to say goodbye to the user
        public static void goodbye ()
        {
            System.out.println("It was nice to meet you, but sorry I have to go");
            System.out.println("Goodbye!");
    
            return;
        }
    
    // Declares a method that calls all previously declared methods in a specified order
    public static void call_methods ()
    { 
        introduction(); // Methods that contains the code to be executed are called sequentially
        String favouriteFilm = chatbots_interests();
        film response = store_responses();
        ask_genre(favouriteFilm, response);
        String [] questions = question_array();
        generate_random_number();
        choose_random_question(questions);
        sorting_algorithm();
        goodbye();
    }
    
} // END class