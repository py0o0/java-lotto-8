package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    static final String START_MESSAGE = "구입금액을 입력해 주세요.";

    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private String rowPrice;
    private String rowWinningNumbers;
    private String rowBonusNumber;
    
    public void readPrice() {
        System.out.println(START_MESSAGE);
        rowPrice = Console.readLine();
    }

    public String getRowPrice() {
        return rowPrice;
    }

    public void readWiningNumber() {
        readNumberList();
        readBonusNumber();
    }

    public String getRowWinningNumbers() {
        return rowWinningNumbers;
    }

    public String getRowBonusNumber() {
        return rowBonusNumber;
    }

    private void readNumberList(){
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        rowWinningNumbers = Console.readLine();
    }

    private void readBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        rowBonusNumber = Console.readLine();
    }
}
