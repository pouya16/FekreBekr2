import java.util.Scanner;
import java.util.Random;

public class FekreBekr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner read = new Scanner(System.in);
		int i = 1;
		int a = 0;
		String s = "";
		while(i!=-1) {
			a=0;
			System.out.println("please enter number of iteration:\n");
			if(read.hasNextInt()) {
				a = read.nextInt();
				s = colorMaker(5);
				System.out.println("s is : " + s + "\n");
				System.out.println("press -1 to end or other numbers to retry\n");
			}else {
				System.out.println("try to enter correct iteration it should be a Number greater than ZERO\n");
			}
		}

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
