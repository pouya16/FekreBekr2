import java.util.Scanner;
import java.util.Random;

public class FekreBekr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner read = new Scanner(System.in);
		int a = 0;
		String s = "";
        System.out.println("Lotfan tedat talash ta javab ra vared konid:\n");
        a = read.nextInt();
        s = passwordmaker(5);

        System.out.println("s is : " + s);

	}
	private static String passwordmaker(int size){
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
