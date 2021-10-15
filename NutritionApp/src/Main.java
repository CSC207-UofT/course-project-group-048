import java.util.*;


public class Main {
    public static void main(String[] args) {
        UserInformation userinfo = new UserInformation();
        System.out.println("Welcome to Fitness 4 Life");
        Scanner sc= new Scanner(System.in);
        System.out.println("Are you a new or existing User: (Type 'new' or 'existing')");
        String type= sc.nextLine();
        boolean success = false;

        while (!success) {
            if (type.equals("new")) {
                System.out.println("Please enter a username");
                String username = sc.nextLine();
                System.out.println("Please enter a password");
                String password = sc.nextLine();
                if (userinfo.addPerson(username, password)) {
                    System.out.println("Now, we will ask you a few questions to get you started on your journey!");
                    success = true;
                } else {
                    System.out.println("Try another username!");
                }
            }
            else if (type.equals("existing")) {
                System.out.println("Please enter your username");
                String username = sc.nextLine();
                System.out.println("Please enter your password");
                String password = sc.nextLine();
                if (userinfo.checkPassword(username, password)) {
                    System.out.println("Authentication Successful");
                    success = true;
                } else {
                    System.out.println("Incorrect Password!");
                }
            }
            else {
                System.out.println("Please enter 'new' or 'existing': ");
                type = sc.nextLine();
            }
        }
    }
}
