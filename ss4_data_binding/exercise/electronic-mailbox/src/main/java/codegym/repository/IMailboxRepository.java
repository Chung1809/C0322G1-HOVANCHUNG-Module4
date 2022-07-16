package codegym.repository;

import codegym.model.Mailbox;

import java.util.List;

public interface IMailboxRepository {
    List<Mailbox> findAll();
    void save(Mailbox mailbox);
    List<String> language();
    List<String> size();

}
