package ch.heigvd.amt.mvcsimple.business;

import ch.heigvd.amt.mvcsimple.model.Quote;

import java.util.ArrayList;
import java.util.List;

public class QuoteGenerator {

    public List<Quote> generateQuotes() {
        List<Quote> result = new ArrayList<>();
        result.add(new Quote("Dr. Seuss", "Don't cry because it's over, smile because it happened."));
        result.add(new Quote("Oscar Wilde", "Be yourself; everyone else is already taken."));
        result.add(new Quote("Albert Einstein", "Two things are infinite: the universe and human stupidity; and I'm not sure about the universe."));
        result.add(new Quote("Adolf Hitler", "Do not compare yourself to others. If you do so, you are insulting yourself."));
        return result;
    }
}
