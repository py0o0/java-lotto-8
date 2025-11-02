package lotto.view;

import lotto.Lotto;
import lotto.Rank;

import java.util.List;
import java.util.Map;

public class Output {
    private static final String PURCHASED_LOTTO_MESSAGE = "개를 구매했습니다.";

    private static final String WINNING_STATISTICS_TITLE = "\n당첨 통계";
    private static final String WINNING_STATISTICS_SEPARATOR = "---------";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.%n";

    public void printLottoList(List<Lotto> lottoList) {
        System.out.println();
        System.out.println(lottoList.size() + PURCHASED_LOTTO_MESSAGE);
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void endGame(Map<Rank, Integer> result, double profitRate) {
        System.out.println(WINNING_STATISTICS_TITLE);
        System.out.println(WINNING_STATISTICS_SEPARATOR);

        for(Rank rank : Rank.values()) {
            if(rank == Rank.NONE) continue;
            int cnt = result.getOrDefault(rank, 0);
            System.out.println(rank.getMessage() + " - " + cnt + "개");
        }
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }
}
