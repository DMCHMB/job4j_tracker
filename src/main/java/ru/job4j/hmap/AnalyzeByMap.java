package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double score = 0;
        int subjectsCount = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectsCount++;
                score += subject.score();
            }
        }
        return score / subjectsCount;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double allSubjectsScore = 0;
            for (Subject subject : pupil.subjects()) {
                allSubjectsScore += subject.score();
            }
            labels.add(new Label(pupil.name(), allSubjectsScore / pupil.subjects().size()));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> subjectScores = calculateSubjectScores(pupils);
        for (String name : subjectScores.keySet()) {
            labels.add(
                    new Label(name, (double) subjectScores.get(name) / pupils.size())
            );
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double pupilScore = 0;
            for (Subject subject : pupil.subjects()) {
                pupilScore += subject.score();
            }
            labels.add(new Label(pupil.name(), pupilScore));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> subjectScores = calculateSubjectScores(pupils);
        for (String s : subjectScores.keySet()) {
            labels.add(new Label(s, subjectScores.get(s)));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    private static Map<String, Integer> calculateSubjectScores(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScores.put(
                        subject.name(), subjectScores.getOrDefault(subject.name(), 0) + subject.score()
                );
            }
        }
        return subjectScores;
    }
}
