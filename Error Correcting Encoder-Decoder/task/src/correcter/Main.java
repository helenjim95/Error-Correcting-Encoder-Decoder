package correcter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputMsg = scanner.nextLine();
        System.out.println(inputMsg);
        String tripletMsg = tripleSymbols(inputMsg);
        System.out.println(tripletMsg);
        String randomizedMsg =  encode(tripletMsg);
        System.out.println(randomizedMsg);
        String decodedMsg =  decode(randomizedMsg);
        System.out.println(decodedMsg);

    }

    public static String tripleSymbols(String message) {
        final int NumberOfChar = 3;
        List<String> msgList = new ArrayList<>();
        for (int i = 0; i < message.length(); i++) {
            for (int j = 0; j < NumberOfChar; j++) {
                msgList.add(String.valueOf(message.charAt(i)));
            }
        }
        return String.join("", msgList);
    }

    public static String randomize() {
        Random random = new Random();
        return Character.toString((char)(random.nextBoolean() ?
                random.nextInt(91 - 65) + 65 : random.nextInt(123 - 97) + 97));
    }
    public static String encode(String message) {
        String[] messageArray = message.split("");
        if (messageArray.length <= 3) {
            String randomString = randomize();
            messageArray[0] = randomString;
        } else {
            for (int i = 0; i < messageArray.length - 2; i = i + 3) {
                String randomString = randomize();
//            System.out.println("i " + i);
//            System.out.println("randomString: " + randomString);
                messageArray[i] = randomString;
            }
        }
        return String.join("", messageArray);
    }

    public static String decode(String message) {
        String[] messageArray = message.split("");
        List<String> messageArrayList = new ArrayList<>();
        for (int i = 0; i < messageArray.length - 2; i = i + 3) {
            if (Objects.equals(messageArray[i], messageArray[i + 1]) || Objects.equals(messageArray[i], messageArray[i + 2])) {
                messageArrayList.add(messageArray[i]);
            } else if (Objects.equals(messageArray[i + 1], messageArray[i + 2])) {
                messageArrayList.add(messageArray[i + 1]);
            }
        }
        return String.join("", messageArrayList);
    }
}
