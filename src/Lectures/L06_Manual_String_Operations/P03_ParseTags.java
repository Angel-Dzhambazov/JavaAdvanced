package Lectures.L06_Manual_String_Operations;

import javafx.beans.binding.When;
import jdk.nashorn.internal.ir.WhileNode;

import java.util.Scanner;

/** ti li si ?
 *
 * Created by fluch on 7/25/2017.
 */
public class P03_ParseTags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String upcase = "<upcase>";
        String upcaseClose = "</upcase>";

        while (input.contains(upcase)) {
            int indexOfStart = input.indexOf(upcase);
            int indexOfEnd = input.indexOf(upcaseClose);
            String reminder = input.substring(indexOfStart + upcase.length(), indexOfEnd);

        }
    }
}
