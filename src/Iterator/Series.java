package Iterator;

import java.util.*;

public class Series {
    private final List<Season> seasons = new ArrayList<>();

    public void addSeason(Season s) {
        seasons.add(s);
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public EpisodeIterator createBingeIterator() {
        return new BingeIterator(seasons);
    }
}

