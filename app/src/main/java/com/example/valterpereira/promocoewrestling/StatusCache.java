package com.example.valterpereira.promocoewrestling;

/**
 * Created by Valter Pereira on 14/02/2018.
 */

public class StatusCache {
    static TitlesFragment portrait;
    static TitlesFragment landscape;
    static DetailsFragment landscapeDet;

    public static TitlesFragment getPortrait() {
        if (null == portrait) portrait = new TitlesFragment();
        return portrait;
    }

    public static TitlesFragment getLandscape1() {
        if (null == landscape) landscape = new TitlesFragment();
        return landscape;
    }

    public static DetailsFragment getLandscape2() {
        if (null == landscapeDet) landscapeDet = new DetailsFragment();
        return landscapeDet;
    }
}
