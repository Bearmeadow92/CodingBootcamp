import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return "Hello " + name + " Lovely to see you.";
    }

    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date date = new Date();
        return "It is currently " + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        ;
        System.out.println(conversation.indexOf("Alexis"));
        if (conversation.indexOf("Alexis") >= 0){
        return "Right away, sir. She certainly isn't sophisticated enough for that";
        }
        else if (conversation.indexOf("Alfred") >=0){
        return "At your service. As you wish, naturally.";
        }
        else{ 
            return "Right. And with that I shall retire";
        }
    }
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

