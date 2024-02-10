package seminars.third.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
class MoodAnalyserTest {

    //3.5. Red-Green-Refactor
    @Test
    void analyseMood() {
        MoodAnalyser moodAnalyser=new MoodAnalyser();

        assertThat(moodAnalyser.analyseMood("Хорошо")).isEqualTo("green");
        assertThat(moodAnalyser.analyseMood("Плохо")).isEqualTo("red");
        assertThat(moodAnalyser.analyseMood("Никак")).isEqualTo("blue");
        assertThat(moodAnalyser.analyseMood("Spring")).isEqualTo("?");
    }
}