package ch.heigvd.amt.projectone.business;

import ch.heigvd.amt.projectone.model.Quote;

import java.util.ArrayList;
import java.util.List;

public class QuoteGenerator {

    public List<Quote> generateQuotes() {
        List<Quote> result = new ArrayList<>();
        result.add(new Quote("Dr. Seuss", "Don't cry because it's over, smile because it happened."));
        result.add(new Quote("Robel Teklehaimanot", "My mind is telling me nooooooo"));
        result.add(new Quote("Oscar Wilde", "Be yourself; everyone else is already taken."));
        result.add(new Quote("Albert Einstein", "Two things are infinite: the universe and human stupidity; and I'm not sure about the universe."));
        return result;
    }
}
