package it.redhat.web;

import it.redhat.entity.Expense;
import it.redhat.repository.ExpenseRepository;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import java.util.List;
import java.util.Random;
import java.util.UUID;

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

    @GET
    @Path("new")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response saveExpense() throws ParseException {

        //Geometry location = new WKTReader().read("POINT (40.8522 14.2681)");

        GeometryFactory geometryFactory = new GeometryFactory();
        Point location = geometryFactory.createPoint(new Coordinate(40.8522, 14.2681));

        // Creazione dell'entità Expense
        Expense exp = new Expense();
        exp.setName(UUID.randomUUID().toString());
        exp.setPrice(40D);
        exp.setLocation((Point) location);

        // Salvataggio nel database
        expenseRepository.persist(exp);
/*
        Geometry point = new WKTReader().read("POINT (16.85 25.26)");


        Expense exp = new Expense();
        exp.setName("From Interface");
        exp.setPrice(new Random().nextDouble());
        exp.setLocation((Point) point);

        expenseRepository.persist(exp);
*/

        return Response.status(Response.Status.CREATED).entity(exp).build();
    }
}
