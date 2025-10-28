package ch.tbz.financemanager.service;

import ch.tbz.financemanager.model.Transaction;
import ch.tbz.financemanager.report.ReportGenerator;
import ch.tbz.financemanager.report.ReportStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    public String generateReport(List<Transaction> transactions, ReportStrategy strategy) {
        ReportGenerator generator = new ReportGenerator(strategy, transactions);
        return generator.generateReport();
    }
}
