import java.util.Comparator;
import java.util.Arrays;

/**
 * MaxPlanet.java
 */

public class MaxPlanet {

    /** Returns the Planet with the maximum value according to Comparator c. */
    public static Planet maxPlanet(Planet[] planets, Comparator<Planet> c) {
        Arrays.sort(planets, c);
        int N = planets.length;
        return planets[N - 1];
    }
}