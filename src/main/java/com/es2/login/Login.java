package com.es2.login;

public class Login {

    // this method is just for testing JaCoCo and Junit
    public boolean isPalindrome(String inputString) {
        if (inputString.length() == 0) {
            return true;
        } else {
            char firstChar = inputString.charAt(0);
            char lastChar = inputString.charAt(inputString.length() - 1);
            String mid = inputString.substring(1, inputString.length() - 1);
            return (firstChar == lastChar) && isPalindrome(mid);
        }
    }


    static void printPath(Registry _registry, Registry _registry2) {
        System.out.println(_registry.getPath());
        System.out.println(_registry2.getPath());
    }

    public static void main(String[] args) {

    }

    // just for coverage testing
    public String getMessage(String name) {

        StringBuilder result = new StringBuilder();

        if (name == null || name.trim().length() == 0) {

            result.append("Please provide a name!");

        } else {

            result.append("Hello " + name);

        }
        return result.toString();
    }

}
