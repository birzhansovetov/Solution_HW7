package Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Season implements Iterable<Episode> {
    private final List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public EpisodeIterator normalIterator() {
        return new SeasonIterator(episodes);
    }

    public EpisodeIterator createReverseIterator() {
        return new ReverseSeasonIterator(episodes);
    }

    public EpisodeIterator createShuffleIterator(long seed) {
        return new ShuffleSeasonIterator(episodes, seed);
    }

    @Override
    public Iterator<Episode> iterator() {
        return episodes.iterator();
    }
}

