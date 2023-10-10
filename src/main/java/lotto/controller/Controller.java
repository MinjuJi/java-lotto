package lotto.controller;

import lotto.service.Service;

public class Controller {
    Service service = new Service(); // 접근제어자, static, final 붙이지 않는 이유

    public void run() {
        startLottoGame();
    }

    public void startLottoGame() {
        service.initBuyer();
        service.buyAllLotto();
        service.showBuyingResult();
    }
}
