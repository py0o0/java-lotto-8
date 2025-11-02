package lotto;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    public Map<Rank, Integer> run(List<Lotto> lottoList, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> result = new LinkedHashMap<>();
        for(Lotto lotto : lottoList) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int matchCnt = match(lottoNumbers, winningNumbers);
            boolean bonusMatch = lottoNumbers.contains(bonusNumber);
            Rank rank = Rank.getRank(matchCnt, bonusMatch);

            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    private int match(List<Integer> lotto, List<Integer> winningNumbers) {
        int cnt = 0;
        for(int winningNumber : winningNumbers) {
            if(lotto.contains(winningNumber)) {
                cnt++;
            }
        }
        return cnt;
    }

    public double calculateProfitRate(Map<Rank, Integer> result, int price) {
        long profit = 0;

        for(Rank rank : result.keySet()){
            profit += result.get(rank) * rank.getReward();
        }

        return (profit / (double) price) * 100.0;
    }
}
