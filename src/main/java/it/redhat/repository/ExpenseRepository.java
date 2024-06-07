package it.redhat.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import it.redhat.entity.Expense;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExpenseRepository implements PanacheRepository<Expense> {
}
