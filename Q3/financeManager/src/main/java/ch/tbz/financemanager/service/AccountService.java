package ch.tbz.financemanager.service;

import ch.tbz.financemanager.model.Account;
import ch.tbz.financemanager.model.Transaction;
import ch.tbz.financemanager.repository.AccountRepository;
import ch.tbz.financemanager.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account addTransaction(Long accountId, Transaction transaction) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        account.addTransaction(transaction);
        transactionRepository.save(transaction);
        return accountRepository.save(account);
    }
}
