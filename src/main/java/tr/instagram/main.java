package tr.instagram;

import java.util.Scanner;

public class main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please enter your username : ");
        String username = input.nextLine();
        System.out.println("Please enter your pasword : ");
        String password = input.nextLine();
        System.out.println("Please enter target profile name : ");
        String targetProfileName = input.nextLine();

        App app = new App();
        app.loginWith(username, password);
        app.navigateToTargetProfile(targetProfileName);
        app.clickFirstPost();
        app.likePost(app.getPostCount());
        app.driver.quit();
        System.out.println("ters");

    }
}
