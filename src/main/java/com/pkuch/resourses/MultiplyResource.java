package com.pkuch.resourses;

import com.codahale.metrics.annotation.Timed;
import com.pkuch.core.Result;
import com.pkuch.service.CalculatorService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Path ("/calculator/multiply")
@Produces (MediaType.APPLICATION_JSON)
public class MultiplyResource {
    private final String sumTemplate;
    private final String defaultAnswer;
    private final AtomicLong counter;
    private final CalculatorService calculatorService;

    public MultiplyResource(String sumTemplate, String defaultAnswer, CalculatorService calculatorService) {
        this.sumTemplate = sumTemplate;
        this.defaultAnswer = defaultAnswer;
        this.calculatorService = calculatorService;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Result calculateSum(@QueryParam ("val") List<Integer> values) {
        Integer result = calculatorService.multiply(values);
        final String value = result != 0 ? String.format(sumTemplate, result) : defaultAnswer;
        return new Result(counter.incrementAndGet(), value);
    }
}
