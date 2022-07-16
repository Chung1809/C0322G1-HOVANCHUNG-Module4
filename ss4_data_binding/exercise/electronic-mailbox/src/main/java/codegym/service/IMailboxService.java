package codegym.service;

import codegym.model.Mailbox;

import java.util.List;

public interface IMailboxService {
    List<Mailbox> findAll();
    void save(Mailbox mailbox);
    List<String> language();
    List<String> size();
}
