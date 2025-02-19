# 로또 미션

---

## 프로젝트 개요
- 로또 게임을 시뮬레이션할 수 있는 프로젝트입니다.
- 희망 구매 금액을 입력하여 로또를 자동으로 구입합니다.
- 이후 당첨번호와 보너스번호를 차례대로 입력합니다.
- 입력한 당첨번호와 보너스번호를 토대로 당첨된 자동발매 로또결과를 확인합니다.

---

## 📋 구현 기능 목록

<br/>

### 로또게임 사전 준비 기능
#### 로또 구매 기능
- ✅***구매희망 금액 입력 기능***
  - ✅ 입력된 금액이 1000원 단위인지 검증하는 기능
  - ✅ 1000원 미만, 10만원 초과 금액은 예외 처리하는 기능


- ✅ ***구매 가능한 개수만큼 로또번호를 발급하는 기능***


- ✅ ***구매내역 확인 기능***
  - ✅ 로또를 몇 개 구입했는지 출력하는 기능
  - ✅ 구매한 로또 번호들을 출력하는 기능


- ✅ ***로또번호 생성 기능***
  - ✅ 지정 범위 내에서 원하는 개수의 수를 무작위 생성하는 기능
    - ✅ 숫자 리스트 내 숫자들이 특정 범위 안의 값인지 검증하는 기능
      - ✅ 하나의 숫자가 특정 범위 안의 값인지 검증하는 기능
    - ✅ 숫자 리스트 내에 중복 값이 있는지 검증하는 기능
    - ✅ 숫자 리스트가 정해진 길이의 리스트인지 검증하는 기능
    - ✅ 숫자 리스트를 오름차순으로 정렬하는 기능

<br/><br/>

### 로또게임 시작 기능
#### 당첨번호 입력 기능
- ✅ ***당첨 번호 숫자 6개를 입력받는 기능***
  - ✅ 입력 문자열을 숫자 리스트로 변환하는 기능
  - ✅ 6자리 번호가 쉼표를 기준으로 형식을 지켜서 입력되었는지 검증하는 기능
  - ✅ 입력받은 문자열 리스트 요소들이 숫자로 이루어져있는지 검증하는 기능
    - ✅ 단일 문자열이 숫자로 이루어져 있는지 검증하는 기능
  - ✅ 입력받은 6자리 번호 중 중복되는 수는 없는지 검증하는 기능
  - ✅ 입력받은 당첨번호가 6자리인지 검증하는 기능

#### 보너스 번호 입력 기능
- ✅ ***보너스번호 1개를 입력받는 기능***
  - ✅ 보너스번호와 당첨번호 간 중복이 없는지 검증하는 기능
  - ✅ 보너스번호가 1~45의 범위를 가지는 자연수인지 검증하는 기능

<br/><br/>

### 로또게임 결과 조회 기능
#### 당첨 통계결과 출력 기능
- ✅ ***당첨된 로또 개수가 몇 개인지 등수별로 저장하는 기능***
  - ✅ 당첨 기준에 따라 로또를 1~5등까지 순위 매기는 기능
    - ✅ 구매한 로또 번호와 당첨번호가 몇 개 일치하는지 확인하는 기능
      - ✅ 두 리스트를 비교하여 공통으로 포함하는 요소들의 개수를 확인하는 기능
    - ✅ 구매한 로또 번호에 보너스 번호가 포함되는지 확인하는 기능


- ✅ ***구매자의 로또 수익률을 계산하는 기능***
  - ✅ 소수점 둘째 자리에서 반올림하는 기능

<br/>

### 예외처리
- ✅ 모든 에러 문구는 [ERROR]로 출력하는 기능
