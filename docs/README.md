# 기능 구현 목록

---

## 기능 흐름

1. 사용자로부터 로또 구입 금액을 받는다.
2. 사용자의 로또 구입 금액 n원을 바탕으로 랜덤한 로또 번호를 (n/1000)개 생성한다.
3. 사용자의 로또 구매 장 수와, 로또 번호 n개를 출력해준다.
4. 로또 당첨 번호를 입력받는다.
5. 보너스 번호를 입력받는다.
6. 당첨내역을 출력한다.
7. 수익률을 출력한다.

---

## 패키지 별 기능 구현

### :file_folder: controller

- LottoController
    - view를 이용하여 입출력을 하고, 도메인의 값을 넣어준다. 전반적인 게임의 흐름은 컨트롤러 내에서 이루어진다.

### :file_folder: domain

- Lotto
    - 당첨 번호 관리한다.
    - 보너스 번호 관리한다.
- UserLotto
    - 유저의 로또를 한장 단위로 관리한다.
- USer
    - 로또 n장을 UserLotto를 통해 관리한다.
    - 구매 금액을 관리한다.
    - 수익금을 관리한다.

### :file_folder: view

- InputView
    - 유저의 로또 구매금액을 입력받는다.
    - 당첨번호와 보너스 번호를 입력받는다.
- OutputView
    - 전반적인 출력을 담당한다.
    - 유저가 구매한 로또의 번호를 출력해준다.

### :file_folder: exception

- UserException
    - 유저의 구입 금액 입력 예외처리를 담당한다.
- LottoException
    - 당첨 번호와 보너스 번호 예외처리를 담당한다.

### :file_folder: util

- LottoGenerator
    - 로또 랜덤 넘버 생성을 해준다.
- InputParser
    - 유저가 입력한 값들의 타입을 바꿔준다.