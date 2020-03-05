import java.util.Scanner;
import java.io.IOException;
import java.util.Random;

public class FekreBekr {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		int i = 1;
		int a = 0;
		boolean finalCheck = false;
		String s = "";
		while(i!=-1) {
			//define result string : 
			String result = "";
			//define the string that user is guess
			String guess = "";
			a=0;
			int n=5;
			// get length of guess from user:
			System.out.println("please pick length of play:");
			n = read.nextInt();
			//get number of iteration from user
			System.out.println("please enter number of iteration:");
			if(read.hasNextInt()) {
				a = read.nextInt();
				//produce a random color string as a sample
				s = colorMaker(n);
				System.out.println("please enter 1 for help 0 for exit or pick "+ n + " color : (O)range,(Y)ellow,(P)ink,(B)lue,(R)ed,(W)hite,(G)reen,(P)urple\n");
				//loop for number of iteration goes from zero to number of iteration
				for(int j=0;j<a;j++) {
					//get user guess in each iteration
					System.out.print("guess: ");
					guess = read.next();
					//check that user enter correct length of guess
					if(guess.length()==n){
						//check if user just enter colors and no more wrong chars
						if(checkGuessString(guess)) {
							//function that check the answer for correct or show result of wrong guees
							if(checkAnswer(guess,s)) {
								finalCheck = true;
								System.out.println("That's right =)");
								j=a;
							}
						}else {
							System.out.println("check your color pick we have : (O)range,(Y)ellow,(P)ink,(B)lue,(R)ed,(W)hite,(G)reen,(P)urple\n");
							j--;
						}
						//handling 1 for show guide or 0 to exit: 
					}else if(guess.length()==1){
						try {
							int function = Integer.parseInt(guess);
							if(function==1) {
								showAnswer(s);
							}else if(function==0) {
								System.out.println("You end this game successfully");
								j=a;
							}else {
								System.out.println("Your answer should be 0 or 1 or five chars for prediction");
								j--;
							}
							
						}catch(Exception e) {
							System.out.println("Your answer should be 0 or 1 or five chars for prediction");
							j--;
						}
						
					}else {
						System.out.println("Your answer should be 0 or 1 or " + n +  " chars for prediction");
						j--;
					}
				}
				//injaham agar tedade talashamoon tamam shode bud va karbar dorost hads nazade bud ke behesh migim bakhti.
				if(!finalCheck) {
					System.out.println("YOU LOOSE\n");
				}
				System.out.println("press -1 to end or other numbers to retry\n");
				i = read.nextInt();
			}else {
				System.out.println("try to enter correct iteration it should be a Number greater than ZERO\n");
			}
		}

	}
	
	// function parts of program: 
	
	//this function show answer for 1 second
	private static void showAnswer(String s) throws IOException {
		System.out.print(s);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("\b\b\b\b");	
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");	
	}
	
	//this function check the answer if it is true return true and user win
	//if the answer is wrong it is guide user for his next guess with # , + , -
	private static boolean checkAnswer(String guess,String s) {
		if(guess.compareTo(s)==0) {
			System.out.print("     : #####\n");	
			return true;
		}else {
			String showingTest = "     : ";
			for(int i=0;i<guess.length();i++) {
				if(guess.charAt(i)==s.charAt(i)) {
					showingTest = showingTest + "#";
				}else if(s.indexOf(guess.charAt(i))>=0) {
					showingTest = showingTest + "+";
				}else {
					showingTest = showingTest + "-";
				}
			}
			System.out.print(showingTest + "\n");
		}
		return false;
	}
	
	//this function check user dont enter wrong starter colors
	private static boolean checkGuessString(String guess) {
		String alphabets = "OYPBRWGP";
		for(int i = 0;i<guess.length();i++) {
			if(alphabets.indexOf(guess.charAt(i))<0){
				return false;
			}
		}
		return true;
	}
	
	//this function get a number for input and produce a random color set with the length of input number:
	private static String colorMaker(int size){
        String s="";
        String alphabets = "OYPBRWGP";
        Random random = new Random();
        char[] randomArray = new char[size];
        for(int i=0;i<size;i++){
            randomArray[i] = '`';
        }
        for(int i = 0; i <size;i++){
            if(randomArray[i]=='`'){
                int randomNum = Math.abs(random.nextInt()%(alphabets.length()));
                randomArray[i] = alphabets.charAt(randomNum);
            }
            s = s +randomArray[i];
        }
        return s;
    }

}
