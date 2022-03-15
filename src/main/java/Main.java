import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;


public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException{
        JDABuilder jda = new JDABuilder(AccountType.BOT);
        String token = "OTUyOTY4MjYyODg5NjM1ODkw.Yi9u2w.J9FWz4Ul90gUQiiaEBjI1pWE2q8";
        jda.setToken(token);
        jda.addEventListener(new Main());
        jda.buildAsync();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        System.out.println("A message received from " + event.getAuthor().getName() + " :\n " +
                event.getMessage().getContentDisplay());

        if(event.getMessage().getContentRaw().equals("is here")){
            // queue sends replay message
            event.getChannel().sendMessage(event.getAuthor().getName()+" : Welcome to the life boat. Thank you for joining.");
        }

        if(event.getAuthor().isBot()){
            return;
        }
    }
}
