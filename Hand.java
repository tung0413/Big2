/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Evonne
 */
import java.util.ArrayList;

public class Hand {

    public Hand() {
    }

    //sort hand by rank
    public static ArrayList<ArrayList<Card>> rankSort(ArrayList<Card> cards) {
        ArrayList<ArrayList<Card>> sort1 = new ArrayList<ArrayList<Card>>();
        for (int i = 0; i < 13; i++) {
            sort1.add(new ArrayList<Card>());
        }
        for (Card card : cards) {
            sort1.get(card.getRank()).add(card);
        }
        return sort1;
    }

    //sort hand by suit
    public static ArrayList<ArrayList<Card>> suitSort(ArrayList<Card> cards) {
        ArrayList<ArrayList<Card>> sort2 = new ArrayList<ArrayList<Card>>();
        for (int i = 0; i < 4; i++) {
            sort2.add(new ArrayList<Card>());
        }

        for (Card card : cards) {
            sort2.get(card.getSuit()).add(card);
        }
        return sort2;
    }

    public void findAll(ArrayList<Card> cards) {
        ArrayList<ArrayList<Card>> pair = findPairs(cards);
        var str = "";
        for (ArrayList<Card> arrayList : pair) {
            for (Card card : arrayList) {
                str += " " + card.toString();
            }
            str += "\n";
        }
        if (str.isEmpty()) {
            str += "None!\n";
        }
        System.out.println("Pairs:\n" + str);

        ArrayList<ArrayList<Card>> triple = findTriples(cards);
        str = "";
        for (ArrayList<Card> arrayList : triple) {
            for (Card card : arrayList) {
                str += " " + card.toString();
            }
            str += "\n";
        }
        if (str.isEmpty()) {
            str += "None!\n";
        }
        System.out.println("Triples:\n" + str);

        ArrayList<ArrayList<Card>> quad = findQuads(cards);
        str = "";
        for (ArrayList<Card> arrayList : quad) {
            int quadRank = arrayList.get(0).getRank();
            for (Card singleCard : cards) {
                if (singleCard.getRank() != quadRank) {
                    for (Card card : arrayList) {
                        str += " " + card.toString();
                    }
                    str += " " + singleCard.toString();
                    str += "\n";
                }
            }
        }
        if (str.isEmpty()) {
            str += "None!\n";
        }
        System.out.println("Quads:\n" + str);

        ArrayList<ArrayList<Card>> flush = findFlushs(cards);
        str = "";
        for (ArrayList<Card> arrayList : flush) {
            for (Card card : arrayList) {
                str += " " + card.toString();
            }
            str += "\n";
        }
        if (str.isEmpty()) {
            str += "None!\n";
        }
        System.out.println("Flushs:\n" + str);

        ArrayList<ArrayList<Card>> fullhouse = findfullHouses(cards);
        str = "";
        for (ArrayList<Card> arrayList : fullhouse) {
            for (Card card : arrayList) {
                str += " " + card.toString();
            }
            str += "\n";
        }
        if (str.isEmpty()) {
            str += "None!\n";
        }
        System.out.println("FullFouses:\n" + str);

        ArrayList<ArrayList<Card>> straight = findStraights(cards);
        str = "";
        for (ArrayList<Card> arrayList : straight) {
            for (Card card : arrayList) {
                str += " " + card.toString();
            }
            str += "\n";
        }
        if (str.isEmpty()) {
            str += "None!\n";
        }
        System.out.println("Straights:\n" + str);

        ArrayList<ArrayList<Card>> straightflush = findStraightFlush(cards);
        str = "";
        for (ArrayList<Card> arrayList : straightflush) {
            for (Card card : arrayList) {
                str += " " + card.toString();
            }
            str += "\n";
        }
        if (str.isEmpty()) {
            str += "None!\n";
        }
        System.out.println("StraightFlushs:\n" + str);
    }

    public static ArrayList<ArrayList<Card>> findPairs(ArrayList<Card> cards) {
        ArrayList<ArrayList<Card>> pairs = new ArrayList<ArrayList<Card>>();
        ArrayList<ArrayList<Card>> sort = rankSort(cards);
        for (int i = 0; i < sort.size(); i++) {
            if (sort.get(i).size() > 1) {
                for (int j = 0; j < sort.get(i).size() - 1; j++) {
                    for (int k = j + 1; k < sort.get(i).size(); k++) {
                        ArrayList<Card> tmp = new ArrayList();
                        tmp.add(sort.get(i).get(j));
                        tmp.add(sort.get(i).get(k));
                        pairs.add(tmp);
                    }
                }
            }
        }
        return pairs;
    }

    public static ArrayList<ArrayList<Card>> findTriples(ArrayList<Card> cards) {
        ArrayList<ArrayList<Card>> triples = new ArrayList<ArrayList<Card>>();
        ArrayList<ArrayList<Card>> sort = rankSort(cards);
        for (int i = 0; i < sort.size(); i++) {
            if (sort.get(i).size() > 2) {
                for (int j = 0; j < sort.get(i).size() - 2; j++) {
                    for (int k = j + 1; k < sort.get(i).size() - 1; k++) {
                        for (int l = k + 1; l < sort.get(i).size(); l++) {
                            ArrayList<Card> tmp = new ArrayList();
                            tmp.add(sort.get(i).get(j));
                            tmp.add(sort.get(i).get(k));
                            tmp.add(sort.get(i).get(l));
                            triples.add(tmp);
                        }
                    }
                }
            }
        }
        return triples;
    }

    public static ArrayList<ArrayList<Card>> findQuads(ArrayList<Card> cards) {
        ArrayList<ArrayList<Card>> quads = new ArrayList<ArrayList<Card>>();
        ArrayList<ArrayList<Card>> sort = rankSort(cards);
        for (int i = 0; i < sort.size(); i++) {
            if (sort.get(i).size() > 3) {
                ArrayList<Card> tmp = new ArrayList();
                tmp.add(sort.get(i).get(0));
                tmp.add(sort.get(i).get(1));
                tmp.add(sort.get(i).get(2));
                tmp.add(sort.get(i).get(3));
                quads.add(tmp);
            }
        }
        return quads;
    }

    public static ArrayList<ArrayList<Card>> findFlushs(ArrayList<Card> cards) {
        ArrayList<ArrayList<Card>> flushs = new ArrayList<ArrayList<Card>>();
        ArrayList<ArrayList<Card>> sort = suitSort(cards);
        for (int i = 0; i < sort.size(); i++) {
            if (sort.get(i).size() > 4) {
                for (int j = 0; j < sort.get(i).size() - 4; j++) {
                    for (int k = j + 1; k < sort.get(i).size() - 3; k++) {
                        for (int l = k + 1; l < sort.get(i).size() - 2; l++) {
                            for (int m = l + 1; m < sort.get(i).size() - 1; m++) {
                                for (int n = m + 1; n < sort.get(i).size(); n++) {
                                    ArrayList<Card> tmp = new ArrayList();
                                    tmp.add(sort.get(i).get(j));
                                    tmp.add(sort.get(i).get(k));
                                    tmp.add(sort.get(i).get(l));
                                    tmp.add(sort.get(i).get(m));
                                    tmp.add(sort.get(i).get(n));
                                    flushs.add(tmp);
                                }
                            }
                        }
                    }
                }
            }
        }
        return flushs;
    }

    public static ArrayList<ArrayList<Card>> findfullHouses(ArrayList<Card> cards) {
        ArrayList<ArrayList<Card>> fullhouses = new ArrayList<ArrayList<Card>>();
        for (int i = 0; i < findTriples(cards).size(); i++) {
            for (int j = 0; j < findPairs(cards).size(); j++) {
                ArrayList<Card> tmp = new ArrayList();
                int tripleRank = findTriples(cards).get(i).get(2).getRank();
                if (tripleRank != findPairs(cards).get(j).get(0).getRank()) {
                    tmp.add(findTriples(cards).get(i).get(0));
                    tmp.add(findTriples(cards).get(i).get(1));
                    tmp.add(findTriples(cards).get(i).get(2));
                    tmp.add(findPairs(cards).get(j).get(0));
                    tmp.add(findPairs(cards).get(j).get(1));
                    fullhouses.add(tmp);
                }
            }
        }
        return fullhouses;
    }

    public static ArrayList<ArrayList<Card>> findStraights(ArrayList<Card> cards) {
        ArrayList<ArrayList<Card>> straights = new ArrayList<ArrayList<Card>>();
        ArrayList<ArrayList<Card>> sort = rankSort(cards);
        for (int i = 0; i < sort.size() - 4; i++) {
            if (sort.get(i).size() > 0 && sort.get(i + 1).size() > 0 && sort.get(i + 2).size() > 0 && sort.get(i + 3).size() > 0 && sort.get(i + 4).size() > 0) {
                for (int j = 0; j < sort.get(i).size(); j++) {
                    for (int k = 0; k < sort.get(i + 1).size(); k++) {
                        for (int l = 0; l < sort.get(i + 2).size(); l++) {
                            for (int m = 0; m < sort.get(i + 3).size(); m++) {
                                for (int n = 0; n < sort.get(i + 4).size(); n++) {
                                    ArrayList<Card> tmp = new ArrayList();
                                    tmp.add(sort.get(i).get(j));
                                    tmp.add(sort.get(i + 1).get(k));
                                    tmp.add(sort.get(i + 2).get(l));
                                    tmp.add(sort.get(i + 3).get(m));
                                    tmp.add(sort.get(i + 4).get(n));
                                    straights.add(tmp);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (sort.get(9).size() > 0 && sort.get(10).size() > 0 && sort.get(11).size() > 0 && sort.get(12).size() > 0 && sort.get(0).size() > 0) {
            for (int j = 0; j < sort.get(9).size(); j++) {
                for (int k = 0; k < sort.get(10).size(); k++) {
                    for (int l = 0; l < sort.get(11).size(); l++) {
                        for (int m = 0; m < sort.get(12).size(); m++) {
                            for (int n = 0; n < sort.get(0).size(); n++) {
                                ArrayList<Card> tmp = new ArrayList();
                                tmp.add(sort.get(9).get(j));
                                tmp.add(sort.get(10).get(k));
                                tmp.add(sort.get(11).get(l));
                                tmp.add(sort.get(12).get(m));
                                tmp.add(sort.get(0).get(n));
                                straights.add(tmp);
                            }
                        }
                    }
                }
            }
        }
        return straights;
    }

    public static ArrayList<ArrayList<Card>> findStraightFlush(ArrayList<Card> cards) {
        ArrayList<ArrayList<Card>> straightflushs = new ArrayList<ArrayList<Card>>();
        ArrayList<ArrayList<Card>> sort = rankSort(cards);
        for (int i = 0; i < sort.size() - 4; i++) {
            if (sort.get(i).size() > 0 && sort.get(i + 1).size() > 0 && sort.get(i + 2).size() > 0 && sort.get(i + 3).size() > 0 && sort.get(i + 4).size() > 0) {
                for (int j = 0; j < sort.get(i).size(); j++) {
                    for (int k = 0; k < sort.get(i + 1).size(); k++) {
                        for (int l = 0; l < sort.get(i + 2).size(); l++) {
                            for (int m = 0; m < sort.get(i + 3).size(); m++) {
                                for (int n = 0; n < sort.get(i + 4).size(); n++) {
                                    if (sort.get(i).get(j).getSuit() == sort.get(i + 1).get(k).getSuit()
                                            && sort.get(i + 1).get(k).getSuit() == sort.get(i + 2).get(l).getSuit()
                                            && sort.get(i + 2).get(l).getSuit() == sort.get(i + 3).get(m).getSuit()
                                            && sort.get(i + 3).get(m).getSuit() == sort.get(i + 4).get(n).getSuit()) {
                                        ArrayList<Card> tmp = new ArrayList();
                                        tmp.add(sort.get(i).get(j));
                                        tmp.add(sort.get(i + 1).get(k));
                                        tmp.add(sort.get(i + 2).get(l));
                                        tmp.add(sort.get(i + 3).get(m));
                                        tmp.add(sort.get(i + 4).get(n));
                                        straightflushs.add(tmp);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (sort.get(9).size() > 0 && sort.get(10).size() > 0 && sort.get(11).size() > 0 && sort.get(12).size() > 0 && sort.get(0).size() > 0) {
                for (int j = 0; j < sort.get(9).size(); j++) {
                    for (int k = 0; k < sort.get(10).size(); k++) {
                        for (int l = 0; l < sort.get(11).size(); l++) {
                            for (int m = 0; m < sort.get(12).size(); m++) {
                                for (int n = 0; n < sort.get(0).size(); n++) {
                                    if (sort.get(9).get(j).getRank() == sort.get(10).get(k).getRank()
                                            && sort.get(10).get(k).getRank() == sort.get(11).get(l).getRank()
                                            && sort.get(11).get(l).getRank() == sort.get(12).get(m).getRank()
                                            && sort.get(12).get(m) == sort.get(0).get(n)) {
                                        ArrayList<Card> tmp = new ArrayList();
                                        tmp.add(sort.get(9).get(j));
                                        tmp.add(sort.get(10).get(k));
                                        tmp.add(sort.get(11).get(l));
                                        tmp.add(sort.get(12).get(m));
                                        tmp.add(sort.get(0).get(n));
                                        straightflushs.add(tmp);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return straightflushs;
    }
}
