package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class ResultsBoard {

    TreeSet<Line> set = new TreeSet<Line>();

    public ResultsBoard() {
    };

    void addStudent(String name, Float score) {
        Line line = new Line();
        line.name = name;
        line.score = score;
        set.add(line);
    }

    List<String> top3() {
        TreeSet<Line> copySet = new TreeSet<>(set);
        List<String> result = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            result.add(copySet.pollLast().name);
        }
        return result;
    }

    public static void main(String[] args) {
        ResultsBoard resultsBoard = new ResultsBoard();
        resultsBoard.addStudent("Ivan Ivanov", 4.3f);
        resultsBoard.addStudent("Vera Swetlova", 4.5f);
        resultsBoard.addStudent("Kir Primakov", 3.2f);
        resultsBoard.addStudent("Kira Dobrina", 4.7f);
        System.out.println(resultsBoard.set);
        System.out.println(resultsBoard.top3());
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

    @Override
    public String toString() {
        return "Line{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
