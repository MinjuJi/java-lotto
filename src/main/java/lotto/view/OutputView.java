package lotto.view;

import lotto.domain.UserLotto;

import java.util.List;

public class OutputView {
    public void printAskBuyingPrice() {
        System.out.println("구입 금액을 입력해주세요.");
    }

    public void printBuyingQuantityOfLotto(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void printUserLottos(List<UserLotto> userLottos) {
//      userLottos.stream().forEach(System.out::println); 아래와 같은지 확인
        userLottos.stream().forEach(lotto -> printLotto(lotto.getLotto()));
    }

    public void printLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public void printAskCorrectNumbers(){
        System.out.println("당첨 번호를 입력해주세요.");
    }

    public void printResult(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
