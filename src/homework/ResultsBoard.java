package homework;

import homework.exeptions.InvalidInputData;


import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

class ResultsBoard {

    TreeSet<Line> set = new TreeSet<Line>();

    public ResultsBoard() {
    };

    void addStudent(String name, Float score) throws InvalidInputData {
        if (name == null || score == null) {
            throw new InvalidInputData("Name or score is null.");
        }
        Line line = new Line();
        line.name = name;
        line.score = score;
        set.add(line);
    }

    List<String> top3(int n) throws InvalidInputData {
        if(n < 0) {
          throw   new InvalidInputData("Given a negative number.");
        }
        if(n > set.size()) {
            n = set.size();
        }


        return set.stream()
                .sorted(Comparator.reverseOrder())
                .map(Line::getName)
                .limit(n)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        ResultsBoard resultsBoard = new ResultsBoard();

        try {
            resultsBoard.addStudent("Ivan Ivanov", 4.3f);
            resultsBoard.addStudent("Vera Swetlova", 4.5f);
            resultsBoard.addStudent("Kir Primakov", 3.2f);
            resultsBoard.addStudent("Kira Dobrina", 4.7f);
            String string = null;
            Float score = null;
            resultsBoard.addStudent(string, score);
        } catch (InvalidInputData e) {
           System.out.println("Name or score is null.");
        }



        System.out.println(resultsBoard.set);

        try {
            System.out.println(resultsBoard.top3( 3));
            System.out.println(resultsBoard.top3(- 3));
        } catch (InvalidInputData e) {
            System.out.println("Given a negative number.");
        }
        System.out.println(resultsBoard.set);
    }
}

class Line implements Comparable<Line> {
    String name;
    Float score;

    @Override
    public int compareTo(Line o) {
        return Float.compare(score, o.score);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Line{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}


