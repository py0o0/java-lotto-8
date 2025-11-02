package lotto.controller;

import lotto.LottoGame;
import lotto.LottoGenerator;
import lotto.Rank;
import lotto.WinningNumber;
import lotto.view.Input;
import lotto.view.Output;

import java.util.Map;

public class LottoController {
    private final Input input;
    private final Output output;
    private final LottoGenerator lottoGenerator;
    private final LottoGame lottoGame;
    private final WinningNumber winningNumber;

    public LottoController() {
        this.input = new Input();
        this.output = new Output();
        this.lottoGenerator = new LottoGenerator();
        this.lottoGame = new LottoGame();
        this.winningNumber = new WinningNumber();
    }

    public void run(){
        input.readPrice();
        lottoGenerator.generate(input.getRowPrice());
        output.printLottoList(lottoGenerator.getLottoList());
        input.readWiningNumber();
        winningNumber.setWinningNumber(input.getRowWinningNumbers(), input.getRowBonusNumber());

        Map<Rank, Integer> result =  lottoGame.run(lottoGenerator.getLottoList(), winningNumber.getWinningNumbers(), winningNumber.getBonusNumber());
        double profitRate = lottoGame.calculateProfitRate(result, lottoGenerator.getPrice());
        output.endGame(result, profitRate);
    }
}
