package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class MusicControllerTest {

    private int i = 0;

    @Test
    void main() {
        ArrayList<String> strs = new ArrayList<>(List.of("ali", "hosein", "amir"));

        for (int j= 0; j < strs.size(); j++) {

            if (i == 1)
                strs.add(2, "mohesn");
            System.out.println(strs.get(j));
            i++;
        }
    }

}