package ch.tbz.financemanager;

import ch.tbz.financemanager.controller.AccountController;

public class DemoApplication {
    public static void main(String[] args) {
        new AccountController().startMenu();
    }
}
