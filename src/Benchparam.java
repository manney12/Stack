// import java file reader
import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Benchparam {
    // public main for the project 

    public static void main(String[] args) throws IOException {

        // stack named Jp  fill in the spaces
        Stack<Character> Jp;
        Jp = new Stack <>();
// This is for the file name with string
        String fileName;
        // The scanner asking for files 
        Scanner keyboard = new Scanner(System.in);


        // import the  file    
        File f = new File("tryout.txt");
        Scanner fin = new Scanner(f);
        // boolean declaration for  if it is good then it is ok 
        boolean good = true;


        //process the file to  do the while loop that  will add the following braces 
//while loop to access the file  and if it is true do this
        while (fin.hasNext() && good) {
            String her = fin.next();
            // for loop goes through the  string and  picks out the character and puts them in the stack 
            // This is nested in the while loop
            // for loop to process with a character call read  with the 
            for (int i = 0; i < her.length(); i++) {
                char read = her.charAt(i);

                

// switch state to  identify the character to and pick up '[' '{' '(' and push them  into the stack 
                switch (read) {
                    case '[':
                        Jp.push(read);
                        break;
                    case '{':
                        Jp.push(read);
                        break;
                    case '(':
                        Jp.push(read);
                        break;
// if else statement that  uses the stack to to see if '}' ']' ')'   starts without the opening partner then the bolean statement false
// the next if else statements are checking the different charater  '}' ']' ')'and if '}' ']' ')' are before   
// '[' '{' '(' then it will be  pop or removed                        
                }
                    if((read==']' || read==')' || read=='}') &&Jp.isEmpty()){
                    good=false;
                }
                    else if (read == '}' && Jp.peek() == '{') {
                    Jp.pop();
                } 
                    else  if (read == ')' && Jp.peek() == '(') {
                    Jp.pop();
                }
                    else if (read == ']' && Jp.peek() == '[') {
                    Jp.pop();

                }


            }
        }
    // this statement checks if the stack is  empty  then the boolean good is false 
        if(!Jp.isEmpty()){
            good=false;
        }
            // check if the  stack is not empty and with the above rule it will print out  
        // everything matches and if the characters do not match then they do not match
        if (good){
            System.out.println("everything matches");
        }else {
            System.out.println("Things dont match");
        }
            
    }
}
