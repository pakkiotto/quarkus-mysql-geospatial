package it.redhat.web;

import it.redhat.entity.Expense;
import it.redhat.repository.ExpenseRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/expenses")
public class ExpenseWeb {

    private final ExpenseRepository expenseRepository;

    public ExpenseWeb(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Expense> getAllExpenses() {
        return expenseRepository.listAll();
    }
}
