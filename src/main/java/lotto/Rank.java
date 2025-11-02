package lotto;

public enum Rank {
    FIFTH(3, false, 5_000L, "3개 일치 (5,000원)"),
    FOURTH(4, false, 50_000L, "4개 일치 (50,000원)"),
    THIRD(5, false, 1_500_000L, "5개 일치 (1,500,000원)"),
    SECOND(5, true, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, false, 2_000_000_000L, "6개 일치 (2,000,000,000원)"),
    NONE(0, false, 0L, "");

    private final int matchCnt;
    private final boolean bonusMatch;
    private final long reward;
    private final String message;

    Rank(int matchCnt, boolean bonusMatch, long reward, String message) {
        this.matchCnt = matchCnt;
        this.bonusMatch = bonusMatch;
        this.reward = reward;
        this.message = message;
    }

    public static Rank getRank(int matchCnt, boolean bonusMatch){
        for(Rank rank : values()){
            if(matchCnt == rank.matchCnt && bonusMatch == rank.bonusMatch){
                return rank;
            }
        }

        for(Rank rank : values()){
            if(matchCnt == rank.matchCnt && bonusMatch != rank.bonusMatch){
                return rank;
            }
        }

        return NONE;
    }

    public long getReward() {
        return reward;
    }

    public String getMessage() {
        return message;
    }
}
