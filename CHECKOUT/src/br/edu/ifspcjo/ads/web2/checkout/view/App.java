package br.edu.ifspcjo.ads.web2.checkout.view;

import br.edu.ifspcjo.ads.web2.checkout.model.Buy;
import br.edu.ifspcjo.ads.web2.checkout.model.Card;
import br.edu.ifspcjo.ads.web2.checkout.model.Checkout;
import br.edu.ifspcjo.ads.web2.checkout.model.CieloOperator;
import br.edu.ifspcjo.ads.web2.checkout.model.EpsonPrinter;
import br.edu.ifspcjo.ads.web2.checkout.model.Operator;

public class App {
    public static void main(String[] args) throws Exception {
        Operator operator = new CieloOperator();
        EpsonPrinter printer = new EpsonPrinter();
        Card card = new Card("Carolina Oliveira", "1234.5678");
        Buy buy = new Buy("Carolina Oliveira", 1000.00, "Fone de Ouvido");
        Checkout checkout = new Checkout(printer, operator);
        checkout.closeBuy(buy, card);
    }
