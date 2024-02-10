package seminars.third.tdd;

public class MoodAnalyser {

    public String analyseMood(String message) {
        if (message.contains("Хорошо")) {
            return "green";
        }
        if (message.contains("Плохо")) {
            return "red";
        }
        if (message.contains("Никак")) {
            return "blue";
        }
        return "?";
    }

}