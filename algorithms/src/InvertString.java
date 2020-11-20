public class InvertString {
    public static void main(String[] args) {
        System.out.println(stringBuilderInverter("samme"));
        System.out.println(stringReverser("samme"));


    }

    //using stringbuilder
    public static String stringBuilderInverter(String str){
        String reversedStr = new StringBuilder(str).reverse().toString();


        return reversedStr;
    }

    //not using stringBuilder
    public static String stringReverser(String str){
        char[] stringToChar = str.toCharArray();
        char[] charReversed = new char[str.length()];
        for (int i = str.length()-1, j = 0; i >= 0; i--,j++) {
            charReversed[j] = stringToChar[i];
        }




        return new String(charReversed);
    }

}
