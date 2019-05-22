package com.vmware.talentboost.spring;

import com.vmware.talentboost.spring.impl.AccountManager;
import com.vmware.talentboost.spring.impl.ConsolePlayer;
import com.vmware.talentboost.spring.impl.HardCodedRepository;
import com.vmware.talentboost.spring.impl.QuestionManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String... args) {
        // Task 1: Instantiate all the classes and run the game.
        IRepository repository = new HardCodedRepository();
        IAccountManager accountManager = new AccountManager(repository);
        IQuestionManager questionManager = new QuestionManager(repository);
        IPlayer player = new ConsolePlayer();
        Game game = new Game(accountManager, questionManager, player);
        //game.run();

        // Task 2: Involve Spring...
        //		- Include the required libs to the project
        //		- Create the XML configuration file
        //		- In the main method create an application context
        //			and get the game from it.
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/vmware/talentboost/spring/application-config.xml");
        Game game1 = (Game) applicationContext.getBean("game");
        game1.run();

        // Task 3*: Switch to annotation based configuration
        //		- Use @Autowired instead of constructor-arg
        //		- Enable automatic component scan

        System.out.println("Hello World!");
    }
}
