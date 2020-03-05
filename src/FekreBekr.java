import java.util.Scanner;
import java.util.Random;

public class FekreBekr {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		int i = 1;
		int a = 0;
		String s = "";
		while(i!=-1) {
			String result = "";
			String guess = "";
			a=0;
			System.out.println("please enter number of iteration:\n");
			if(read.hasNextInt()) {
				a = read.nextInt();
				s = colorMaker(5);
				System.out.println("s is : " + s + "\n");
				for(int j=0;j<a;j++) {
					System.out.print("guess: ");
					guess = read.next();
					if(guess.length()==5){
						if(checkGuessString(guess)) {
							if(checkAnswer(guess,s)) {
								System.out.println("That's right =)");
								j=a;
							}
						}else {
							System.out.println("check your color pick we have : (O)range,(Y)ellow,(P)ink,(B)lue,(R)ed,(W)hite,(G)reen,(P)urple");
							j--;
						}
						
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
						System.out.println("Your answer should be 0 or 1 or five chars for prediction");
						j--;
					}
				}			
				
				System.out.println("press -1 to end or other numbers to retry\n");
				i = read.nextInt();
			}else {
				System.out.println("try to enter correct iteration it should be a Number greater than ZERO\n");
			}
		}

	}
	
	private static void showAnswer(String s) {
		System.out.print(s);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("\b\b\b\b\b");	
	}
	
	private static boolean checkAnswer(String guess,String s) {
		boolean i = false;
		return i;
	}
	
	private static boolean checkGuessString(String guess) {
		String alphabets = "OYPBRWGP";
		for(int i = 0;i<guess.length();i++) {
			if(alphabets.indexOf(guess.charAt(i))<0){
				return false;
			}
		}
		return true;
	}
	
	
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
