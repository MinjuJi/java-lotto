# 로또 게임 기능 목록 순서

1. 로또 구매
    - 로도의 가격은 1000원
    - 구매 시 중복 없는 랜덤 넘버 6개 생성 후 리스트에 저장
    - 구매한 로또의 총액을 저장

2. 당첨 번호 및 보너스 번호 입력
    - 당첨 번호 입력 받기
    - 보너스 번호 입력 받기
    - 당첨 번호와 보너스 번호 사이에 중복은 없는지 예외처리 진행
    - 당첨 번호들이 1~45의 범위 안에 들어가있는지 예외처리 진행

3. 당첨 확인 및 통계
    - 구매한 것 중 당첨된 것을 카운팅
    - 전체 수익금 계산
    - 수익률 계산
    - view를 통해 사용자에게 출력

---

# 프로젝트 구조 및 상세 구현 목록

## :file_folder: domain

- Lotto
    - 당첨 번호 6개 입력 + 보너스 번호 입력 후 저장
- User
    - 로또 구매 및 저장

## :file_folder: enum

- LottoPrize
    - 로또 등수 별 상금

## :file_folder: util

- GenerateLottoNumbers
    - 유저가 로또 구매시 번호 추출 및 정렬
- RoundToTwoDecimalParser
    - 수익률 소수점 둘째 자리에서 반올림
- SeparatedByCommas
    - 유저 입력 시 ',' 기준으로 분리

## :file_folder: exception

- UserBuyLottoException
    - 로또 구입 금액 입력 시 1000원 단위인지 확인
- UserInputLottoNumbersException
    - 1~45 숫자인지 확인
    - 보너스 번호 입력 시 중복 확인
    - 입력 값 ',' 구분 확인

## :file_folder: service

- LottoViewService
    - view를 통해 입력받은 값을 도메인에 저장
    - view를 통해 계산 값을 출력
- LottoClaculateService
    - 로또 당첨 확인 및 수익률을 계산

## :file_folder: controller

- LottoController
    - service를 통해 로또의 구입 및 입력, 츨력을 명령

## :file_folder: view

- InputView
    - 유저의 구입 금액을 입력받음
    - 로또 당첨 번호를 입력받음
- OutputView
    - 로또 구매 시, 랜덤으로 생성된 번호 출력
    - 당첨 통계 출력