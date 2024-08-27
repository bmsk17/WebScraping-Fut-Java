/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteExemplos;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Bernardo
 */
public class Teste2 {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("http://www.seminarbewertung.de/seminar-bewertungen?id=3448").get();
    //we retrieve the buttons
    Elements select = document.select("input.rating_expand");
    //we go for the first
    Element element = select.get(0);
    //we pick the id
    String ratingId = element.attr("rating_id");

    //the Ajax call
    Document document2 = Jsoup.connect("http://www.seminarbewertung.de/bewertungs-details-abfragen")
            .header("Accept", "*/*")
            .header("X-Requested-With", "XMLHttpRequest")
            .data("rating_id", ratingId)
            .post();

    //we find the comment, and we are done
    //note that this selector is only as a demo, feel free to adjust to your needs
    Elements select2 = document2.select("div.ratingbox div.panel-body.text-center");
    //We are done!
    System.out.println(select2.text());
    }
    
}
