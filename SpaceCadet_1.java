import java.io.*;
import java.util.*;
import java.net.*;

class SpaceCadet_1 {
    public static void main(String args[]) throws IOException {
        StringBuffer sb = new StringBuffer(); //String buffer for later
        Scanner input = new Scanner(System.in); //Used to extract user input
        System.out.println("Enter the Email id:");

        String id = input.nextLine(); //Takes the input and concatenates to the website Url
        String url = "https://www.ecs.soton.ac.uk/people/" + id;


        URL obj = new URL(url); //Starts the URL class
        URLConnection con = obj.openConnection(); //connects to the internet

        InputStream in1 = con.getInputStream(); //extracts the ENTIRE SOURCE CODE of that page LETTER BY LETTER
        //     >.<
        //    ಥ_ಥ
        //  ლ(ಠ_ಠლ)
        // ( ╯°□°）╯︵ ┻━┻

        int i; //used to store the ASCII of said letters
        do {
            i = in1.read(); //sets i to the ascii values and does this for every letter in the ENTIRE PAGE
            if(i != -1){
                sb.append((char)i); //each of these values are added to a string buffer

            }

        }

        while (i != -1); //terminates when no characters are left

        Integer StringSliceStart = sb.toString().indexOf("<title>");//The Title (the TAB) is one area the names appear so
        //I string sliced between the <title></title> tags
        Integer StringSliceEnd = sb.toString().indexOf("</title>");//Got rid of the
        String Title = sb.substring(StringSliceStart,StringSliceEnd);
        if(Title.contains("<title>")){ //personal checking this is a guarantee
            System.out.println("True");
            Title = Title.substring(Title.indexOf(">")+1,Title.indexOf("|")); //further string slicing
            System.out.print(Title); //Final Product
        }
        //In hindsight CTRL-F would have made the string slicing a much easier task
        //Because of this line of code "class="uos-page-title uos-main-title uos-page-title-compressed" property="name">Professor Stephen Beeby<em"
        //You can string slice between "name" and "<em"
        //Regardless, I spent waaay too long looking at source code and I'm throwing in the towel :-(

    }
}