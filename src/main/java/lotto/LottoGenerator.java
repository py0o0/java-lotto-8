package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final String ERROR_NOT_INTEGER = "[ERROR] 구입 금액은 정수여야 합니다.";
    private static final String ERROR_NOT_MULTIPLE_OF_THOUSAND = "[ERROR] 구입 금액은 1000의 배수여야 합니다.";

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private List<Lotto> lottoList;
    private List<List<Integer>> fixedNumbers; // 테스트용
    private int price;

    public LottoGenerator() {

    }

    public LottoGenerator(List<List<Integer>> fixedNumbers) {
        this.fixedNumbers = fixedNumbers;
    }

    public void generate(String rowPrice) {
        try {
            validate(rowPrice);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        lottoList = new ArrayList<>();
        for(int i = 0; i < price / 1000; i++){

            lottoList.add(new Lotto(generateRandomNumber(i)));
        }
    }

    private void validate(String rowPrice){
        try{
            price = Integer.parseInt(rowPrice);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ERROR_NOT_INTEGER);
        }

        if(price % 1000 != 0){
            throw new IllegalArgumentException(ERROR_NOT_MULTIPLE_OF_THOUSAND);
        }
    }

    private List<Integer> generateRandomNumber(int i){
        if (fixedNumbers != null && i < fixedNumbers.size()) {
            return fixedNumbers.get(i);
        }
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getPrice() {
        return price;
    }
}
