package Iterator;

import java.util.*;

public class Main {
        public static void main(String[] args) {
                Series series = new Series();

                Season season1 = new Season();
                season1.addEpisode(new Episode("S1E1", 1200));
                season1.addEpisode(new Episode("S1E2", 1300));

                Season season2 = new Season();
                season2.addEpisode(new Episode("S2E1", 1250));
                season2.addEpisode(new Episode("S2E2", 1350));

                series.addSeason(season1);
                series.addSeason(season2);

                System.out.println("=== Binge Watch Mode ===");
                EpisodeIterator binge = series.createBingeIterator();
                while (binge.hasNext()) {
                        System.out.println(binge.next().getTitle());
                }

                System.out.println("\n=== Reverse Iterator: Season 1 ===");
                EpisodeIterator rev = season1.createReverseIterator();
                while (rev.hasNext()) {
                        System.out.println(rev.next().getTitle());
                }

                System.out.println("\n=== Shuffle Iterator: Season 2 ===");
                EpisodeIterator shuf = season2.createShuffleIterator(42);
                while (shuf.hasNext()) {
                        System.out.println(shuf.next().getTitle());
                }

                System.out.println("\n=== Skip Intro (90 sec) Binge ===");
                SkipIntroIterator skip = new SkipIntroIterator(series.createBingeIterator(), 90);
                while (skip.hasNext()) {
                        skip.next().play();
                }
        }
}
