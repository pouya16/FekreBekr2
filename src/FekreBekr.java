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
								System.out.println("answer is right");
								j=a;
							}
						}else {
							System.out.println("check your color pick we have : (O)range,(Y)ellow,(P)ink,(B)lue,(R)ed,(W)hite,(G)reen,(P)urple");
							j--;
						}
						
					}else if(guess.length()==1){
						
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
	
	private static boolean checkGuessString(String guess) {
		boolean i = false;
		return i;
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
