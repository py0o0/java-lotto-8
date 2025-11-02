package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningNumber {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final String ERROR_SIZE = "[ERROR] 로또 번호는 " + LOTTO_SIZE + "개여야 합니다.";
    private static final String ERROR_NOT_INTEGER = "[ERROR] 로또 번호는 정수여야 합니다.";
    private static final String ERROR_RANGE = "[ERROR] 로또 번호는 " + MIN_NUMBER + "~" + MAX_NUMBER + " 사이여야 합니다.";
    private static final String ERROR_DUPLICATE = "[ERROR] 중복된 번호가 있습니다.";

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void setWinningNumber(String rowWinningNumbers, String rowBonusNumber) {
        setWinningNumbers(rowWinningNumbers);
        setBonusNumber(rowBonusNumber);
    }

    private void setWinningNumbers(String rowWinningNumbers){
        String[] tokens = rowWinningNumbers.split(",");
        if(tokens.length != 6){
            throw new IllegalArgumentException(ERROR_SIZE);
        }

        this.winningNumbers = new ArrayList<>();
        for(String token : tokens){
            winningNumbers.add(validate(token));
        }

        Collections.sort(winningNumbers);
    }

    private void setBonusNumber(String rowBonusNumber){
        bonusNumber = validate(rowBonusNumber);
    }

    private int validate(String input) {
        int number;
        try {
            number = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER);
        }

        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_RANGE);
        }

        return number;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
