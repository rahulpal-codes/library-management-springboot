package com.rahul.library_management.service;

import java.util.List;

import com.rahul.library_management.entity.Loan;

public interface LoanService {
    Loan issueBook(Long bookId, Long memberId);
    Loan returnBook(Long loanId);
    List<Loan> getAllLoans();
    List<Loan> getLoansByMember(Long memberId);
}