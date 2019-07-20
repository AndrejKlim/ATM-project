package atm.project;

import atm.project.repository.AccountFileSystemRepoImpl;
import atm.project.service.ATMService;
import atm.project.service.ATMServiceImpl;
import atm.project.ui.UI;

public class Main {
    public static void main(String[] args) {
        String fileName = "C://Users//andre//IdeaProjects//ATMtest//src//main//resourses//Acc.txt";
        AccountFileSystemRepoImpl rep = new AccountFileSystemRepoImpl(fileName);
        ATMService atm = new ATMServiceImpl(rep,3000000);
        UI ui = new UI(rep, atm);
        ui.start();
    }
}
