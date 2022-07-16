package codegym.repository;

import codegym.model.Mailbox;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailboxRepository implements IMailboxRepository {
    private static List<Mailbox> mailboxList = new ArrayList<>();
   private static List<String> language = new ArrayList<>();
   private static List<String> size = new ArrayList<>();
   static {
       mailboxList.add(new Mailbox("Languages","5",true,"Nội dung"));
       language.add("Languages");
       language.add("Vietnamese");
       language.add("Japanese");
       language.add("Chinese");

       size.add("5");
       size.add("10");
       size.add("15");
       size.add("20");
       size.add("50");
       size.add("100");
   }

    @Override
    public List<Mailbox> findAll() {
        return mailboxList;
    }

    @Override
    public void save(Mailbox mailbox) {
        mailboxList.add(mailbox);
    }

    @Override
    public List<String> language() {
        return language;
    }

    @Override
    public List<String> size() {
        return size;
    }
}
