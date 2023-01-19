# [Java]

1. **Java**

   Sun Micro Systems에서 만든 프로그래밍 언어

   여러 플랫폼에서 실행되는 프로그램을 한 번만 작성하기 위해서 플랫폼 독립적인 언어를 개발하기 위해서 탄생

   C++ 과 가장 큰 차이점

   - C++
     플랫폼 종속적으로 운영체제 별로 소스 코드를 다르게 작성해야 한다.
     컴파일러가 운영체제에서 실행되는 코드를 생성(운영체제가 달라지면 다르게 작성)
   - Java
     플랫폼 독립적으로 여러 운영체제에서 실행되는 프로그램을 한 번만 작성
     컴파일러가 JRE(JVM)가 이해할 수 있는 코드를 생성(운영체제 별로 별도의 JRE를 설치해서 JRE가 해석한 후 운영체제에서 실행되는 프로그램을 생성하고 실행)

   1. Java를 사용하는 이유
      - 오픈 소스 프로젝트가 많이 구현되어 있음 - 뛰어난 Echo System
        자바 개발에 편리한 라이브러리 - `apache common`
        서버 개발에 편리한 프레임워크 - `spring`, `struts`
        검색 엔진 - `Lucene`
        NoSQL - `Cassandra`
        분산 파일 시스템 - `Haddop`
      - 플랫폼으로서의 역할(JVM 기반의 언어가 많음)
        Jython, Scala, Kotlin, Closure, Jruby, Groovy 등
        소소 코드를 작성한 후 컴파일을 하면 JRE가 이해할 수 있는 코드로 번역
   2. Java 개발 플랫폼
      - J2SE(Standard Edition)
        PC용 애플리케이션 개발을 위한 플랫폼
        기본적으로 웹 프로그래밍을 할 수 없으나 J2EE에서 웹 관련 API를 가져오면 되는데 `WAS` 나 `Spring` 같은 프레임워크가 제공.
      - J2ME(Micro Edition)
        embedded 관련 애플리케이션 개발을 위한 플랫폼으로 J2SE에서 많은 기능을 제거
      - J2EE(Enterprise Edition)
        가장 많은 기능을 가진 유료 버전이었는데 지금은 `Eclipse` 재단으로 소유권이 이전되면서 Open Source가 됨.
   3. Java 환경
      - JDK(Java Development Kit)
        자바 개발 도구
        - Java API
          Java로 프로그램을 만들 수 있도록 제공되는 클래스의 집합
        - JVM(Java Virtual Machine)
          Java Program을 실행할 수 있도록 추상화한 영역, Java Program이 실행될 때 메모리 영역(Register, Stack, Heap, Method 영역 등)을 구분해서 확보
        - 개발에 관련된 프로그램
          bin 디렉토리
      - JRE(Java Runtime Envirionment)
        자바 실행 환경, 자바로 만든 프로그램을 실행하기 위한 플랫폼
        - JVM
          JVM이 라이센스가 있는데 `Oracle의 Hot Spot` 과 Open Source 버전인 `OpenJDK`
        - glue
          플랫폼 고유의 라이브러리와 JNI
        - byte code
          JDK를 이용해서 개발한 후 Compile을 하게 되면 생성되는 JRE가 이해가능한 코드, Kotlin도 동일한 byte code를 생성
   4. JVM 구성
      - Native Method 영역
        운영 체제에게 전달할 메서드를 소유한 영역
      - Register 영역
        CPU에게 전달할 코드 영역
      - Stack 영역
        메서드를 호출했을 때 메서드에게 할당되는 영역
      - Heap 영역(Young Generation, Old Generation - Garbage Collection의 대상이 되지만 실제 Garbage Collector는 이 영역을 Young 역역보다 적게 참조, Permanent - 클래스 정보)
        객체가 사용하는 메모리 영역
      - Method 영역
        클래스의 메서드가 사용하는 영역
        static한 영역이라고도 하고 Class 영역이라고도 함.

2. **개발 환경**

   1. JDK

      SE 버전을 설치

      버전 번호는 현재는 8, 11, 17 버전을 많이 사용

      확인은 터미널에서 수행 - path 설정을 한 경우에는 터미널을 다시 열어야 한다. `java --version` 은 JRE 버전을 확인하는 명령어고 `javac --version` 은 JDK 버전을 확인하는 명령어이다.

      - Java 8
        람다와 스트림이 적용, 전자 정부 프레임워크가 이 버전 기반
      - Java 11
        Spring이 사용하는 버전, 최신 Eclipse도 이 버전부터 사용 가능
      - Java 17
        최신 버전

   2. IDE
      - Eclipse
        Open Source
        플로그 인 형태로 별도의 라이브러리를 가진 형태로 제공되기도 함 - 전자 정부 프레임워크, Spring Tool Suite, 애니 프레임워크
      - Intelli J
        상업용 버전이 별도로 존재
        웹 프로그래밍은 상업용 버전에서만 가능

3. **작성 및 실행**

   1. 과정
      - source code 작성(파일의 확장자는 java)
      - PC에서 실행되는 Application을 만들 때는 `static void main` 메서드(`entry point`)를 가진 클래스가 있어야 함.
      - compile 수행(`javac 명령`)
        JVM이 인식할 수 있는 코드를 만들어주는 과정
        문법 검사를 수행
        compile이 실패하면 문법적인 오류
      - build(`javaw 명령`)
        운영체제나 하드웨어가 인식할 수 있는 코드를 만들어주는 과정
        여기서 실패하면 구조적인 문제
      - run(`java 명령`)
        메모리 할당을 한 후 실행
        오류가 발생하면 메모리 오류나 예외가 발생
   2. IDE 사용

      모든 과정을 한 번에 수행

      코드를 작성하고 저장을 하는 순간마다 compile을 수행해서 문법적인 오류가 발생하면 특별한 표시를 해준다.

   3. 소스코드 작성

      Java는 완전한 객체 지향 언어라서 모든 코드가 클래스 안에 들어가야 하고 클래스 이름과 파일 이름이 일치해야 함.

      구조

      - pckage 자신이 속한 패키지 이름 - 생략되거나 한 번만 나와야 함
      - import 이름을 줄여쓸 패키지나 클래스 이름 - 0번 이상 무제한
      - class 클래스 이름 { 코드 }

   4. 작성 시 유의 사항
      - 대소문자 구별
      - 한 번에 실행되어야 하는 문장의 끝은 세미콜론
        하지만 블럭을 만드는 명령(`클래스, 메서드, 제어 블럭, try ~ catch 등`)에는 세미콜론을 마지막에 하지 않아도 된다.(즉, 중괄호 뒤에는 하지 않아도 된다.)
      - 행의 개념이 없으므로 한 줄에 여러 개의 명령어를 사용해도 된다.
      - 블럭(영역)의 생성은 { }

4. **명명 규칙**

   데이터와 메서드, 클래스에 붙이는 이름(Identifier)을 만드는 규칙

   - 예약어는 이름으로 만들 수 없음
   - 동일한 영역에 이름을 중복해서 만들 수는 없음.
     package > class > 변수와 메서드의 원형 > 메서드 안에 변수와 블럭

     ```jsx
     void method()
     void method(int) // 원형이 다르기 떄문에 가능

     void method1(int x)
     void method1(int y) // 원형까지 같기 때문에 불가능
     ```

5. **구성 요소**
   - Keyword: java가 정해준 기능
   - 데이터
     **variable**(데이터에 이름을 붙이고 데이터를 변경할 수 있는 것)과 **constant**(데이터에 이름을 붙였는데 데이터를 변경하지 못하도록 해놓은 것), **literal**(사용자가 직접 입력하는 데이터)
     variable은 소문자로 시작하지만 constant는 모두 대문자로 한다.
   - Operator
   - Control Statement
   - Array: 동일한 모양을 갖는 데이터의 연속적인 모임
   - Class와 Instance, Interface: 데이터와 Method(기능)을 같이 소유하고 있는 것
   - Annotaion: @로 시작하는 명령어로 자주 사용하거나 복잡한 구문을 하나의 이름으로 대신 사용할 수 있도록 만든 것인데 java에서는 class로 취급.
   - Comment: 주석
6. **Console 출력하는 메서드**

   - System.out.print(String Message): 메시지를 출력하고 다음 메시지를 이어서 출력
   - System.out.println(String Message): 메시지를 출력하고 다음 메시지를 줄 바꿈을 해서 출력
   - System.out.printf(String format, …data): format에 맞춰서 data를 출력한다.

   Java의 모든 객체는 toString이라는 메서드를 소유하고 있는데 이 메서드는 객체를 문자열로 표현해주는 메서드이다. 출력하는 메서드에 객체의 참조를 대입하면 toString 메서드를 호출한 결과를 사용한다.

   Java는 String과 다른 종류의 데이터를 + 연산을 할 수 있는데 이 경우 데이터의 toString 메서드를 호출해서 그 결과와 결합을 한다.

   “Message” + 10 ⇒ “Message” + “10” ⇒ Message10

   toString의 기본적인 내용은 `자신의 클래스 이름` 과 `해시코드` 의 결합이다. 그 이외의 내용이 나오는 경우는 Overriding해서 내용을 수정한 것.

   서식(printf)은 데이터를 출력하는 모양을 지정할 수 있다. 자릿수를 확보해서 출력을 하거나 소수 출력 범위를 지정하는 것 등이다.

7. **Data Type**
   1. Data의 분류
      - 변경 가능 여부에 따른 분류
        - Immutable(read only) Data
          생성하면 수정할 수 없는 데이터
          - **Literal**
            프로그래밍 언어가 데이터를 표현하기 위해서 정해준 방식, 직접 입력하는 데이터
          - **Constant**
            개발자가 의도적으로 읽기 전용으로 만든 데이터
            `final DataType 이름 = 초기값`
        - Mutable Data
          생성한 후 상황에 따라 다른 데이터의 참조를 저장할 수 있는 데이터
          - **Variable**
            `DataType 이름`
            `DataType 이름 = 초기값`
      - 저장되는 데이터의 종류에 따른 분류(요즘은 없어지는 추세)
        - **Value Type**
          실제 데이터를 저장하는 타입
        - **Reference Type**
          데이터의 참조(address나 hash code라고 하기도 하는데 요즘은 hash code라고 하는 경우가 많다.)를 저장하는 타입
      - 저장되는 데이터의 개수에 따른 분류
        - **Scala Type**
          하나의 데이터만 저장하는 자료형인데 자바에서는 Primitive Type이라고 한다.
        - **Collection(Vector) Type**
          0개 이상의 데이터를 저장하는 자료형으로 자바에서는 Primitive Type을 제외하면 전부 Vector Type
      - Data Type 기재 방법에 따른 분류
        - **Static Type**
          변수나 상수를 선언할 때 자료형을 결정해야하는 Type
          소스 코드 작성 단계에서 타입 불일치와 같은 오류를 검출할 수 있음.
          Kotlin이나 Swift같은 언어는 Dynamic Type처럼 선언하지만 실제로는 Static Type 언어.
          Template Programming을 이용해서 인스턴스를 생성할 때 Data Type을 결정하는 지원 - Java에서는 이러한 기능을 `Generic` 이라고 한다. (`Generator` 와는 다른 개념!)
        - **Dynamic Type**
          변수나 상수를 선언할 때 자료형을 기재하지 않고 데이터의 참조를 대입할 때 결정하는 Type
          JavaScript와 Python이 Dynamic Type 언어.
          코드의 양이 줄어듬
   2. Java의 자료형
      - 자료형의 분류
        - **Primitive Type(기본형)**
          하나의 데이터를 저장하기 위한 자료형
        - **NonPrimitive Type**
          0개 이상의 데이터를 대표하는 참조를 저장하기 위한 자료형
      - 생성
        `자료형 식별자이름;`
        `자료형 식별자이름 = 초기데이터;`
      - 사용
        식별자 이름을 이용해서 데이터에 접근
        Primitive 타입은 이름 자체가 데이터를 의미하고 NonPrimitive Type은 이름이 데이터를 대표하는 위치를 의미
        초기값을 설정하지 않으면 초기값 설정만 가능하고 다른 용도로 사용하면 에러가 발생
      - 명명 규칙
        - **Camel Case**
          클래스나 인터페이스 이름은 대문자로 시작
          속성과 메서드 이름은 소문자로 시작
          두 개 단어 이상의 조합일 때 두 번째 단어의 시작은 대문자
        - **Snake Case**
          상수의 이름은 모두 대문자로 표현
        - 첫 글자는 영문이나 한글 그리고 $와 \_가능
        - 한글은 가능하지만 인코딩 문제 때문에 잘 사용하지 않음.
        - 중간에 공백 불가능
      - 변수나 상수의 유효 범위에 따른 분류
        - **Local Variable**
          메서드 안에서 만들어진 변수로 데이터 저장 공간이 Stack
          메서드 안에서만 사용 가능하고 메서드의 작업이 끝나면 메모리와 함께 소멸된다.
          자신이 만들어진 블럭 안에서만 사용 가능하다.
        - **Member(Instance) Variable**
          클래스 안 그리고 메서드 바깥에 static이라는 keyword 없이 만들어진 변수
          데이터의 저장 공간은 Heap에 생성되고 인스턴스를 통해서만 접근이 가능하다.
          인스턴스가 소멸되면 같이 소멸된다.
          인스턴스는 자신을 참조하는 데이터가 없으면 메모리 정리 대상이 된다.
        - **Static Variable**
          클래스 안 그리고 메서드 바깥에 static 이라는 keyword와 함께 만들어진 변수
          데이터의 저장 공간은 Class(Static) 영역이 되고 클래스를 통해서 접근이 가능한데 자바에서는 인스턴스를 통해서도 접근이 가능.
          클래스는 한 번 로드되면 메모리에서 소멸되지 않기 때문에 한 번 만들어지면 애플리케이션이 종료될 때 까지 소멸되지 않는다.
      - 자바의 기본 자료형
        - boolean
          true나 false만 저장 가능한 자료형, 다른 자료형과 호환이 되지 않는다.
        - byte
          1byte, ~128 ~ 127까지 저장 가능
        - short
          2byte, ~32768 ~32767까지 저장 가능
        - char
          2byte, 0 ~ 65535까지 저장 가능, 저장을 할 때는 정수로 저장하고 출력을 할 때 문자로 출력
        - int
          4byte, 21억 정도의 음수와 양수 저장 가능, 정수 리터럴의 기준형
          정수 리터럴은 그냥 숫자만 사용하면 10진 정수로 판단하고 int가 된다.
          정수 뒤에 L을 붙이면 long형 리터럴이 된다.
          byte, short, char, int, long은 자신의 표현 범위보다 큰 데이터는 저장할 수 없다.
          long형 리터럴은 long에만 저장 가능.
          천단위 구분 기호는 \_ 이다.(123_456_789L)
          정수 앞에 0을 붙이면 8진수가 되는데 앞에 0으로 시작하는 숫자를 사용할 때는 주의
          정수 앞에 0x를 붙이면 16진수가 된다.
        - long
          8byte
        - float
          4byte, 10의 38승 정도를 저장할 수 있고 정밀도는 소수 7자리 정도
          float형 리터럴을 만들 때는 뒤에 f를 붙여야 한다.
        - double
          8byte, 10의 308승 정도를 저장할 수 있고 정밀도는 소수 15자리 정도, 실수 리터럴의 기준형
          double형 리터럴을 만들 때는 뒤에 d를 붙여도 되고 붙이지 않아도 된다.
          실제 저장이 될 때는 부동 소수점 형태로 저장되기 때문에 부호가수지수 형태로 작성이 가능하다.
          3.14 ⇒ +0.314E001 형태로 작성해도 됨.
          지금의 컴퓨너는 CPU 안에 수치 연산 보조 프로세서가 존재해서 연산을 double 단위로 수행함.
          즉 float을 써도 double로 바꿔서 하기 때문에 float은 안쓰는 것이 좋다.
        - 문자 저장
          문자 리터럴은 ‘’ 안에 하나의 문자를 기재하면 된다.
          자바는 유니코드를 사용하기 때문에 char가 2byte이다.
          문자에 해당하는 정수 코드를 설정해도 된다.
          - 문자 0은 48
          - 문자 A는 65
          - 문자 a는 97
            문자는 모든 경우에 정수로 취급하고 출력할 때만 문자로 취급
            대입할 땐 ₩ 다음에 8진수 3자리로 대입 가능하고 ₩u 다음에 16진수로 4자리로 대입 가능하다.
            ‘A’ + 1은 66이다.
        - 제어 문자
          ₩ 다음에 하나의 문자를 추가해서 특별한 기능을 갖도록 한 문자.
          ₩n, ₩t, ₩₩, ₩’, ₩’’, ₩0
        - Overflow와 Underflow
          Overflow는 표현 범위를 위쪽으로 넘어선 경우로 앞쪽의 데이터를 잘라버리기 때문에 넘어가면 가장 작은 숫자부터 다시 시작하게 되고 Underflow는 반대의 경우로 가장 큰 숫자부터 다시 시작한다.
        - boolean 데이터
          true 아니면 false만 저장
          Java API 메서드 중에서 이름이 is로 시작하면 return은 boolean
          boolean으로 변수를 생성할 때도 앞에 is를 붙이는 것이 일반적.
          이 자료형은 문자열로 변환하거나 문자열을 이 자료형으로 변한하는 것 이외의 다른 자료형과의 호환은 안됨.
      - String
        0개 이상의 문자열을 저장할 때 사용할 수 있는 클래스
        기본형은 아니지만 기본형처럼 사용
        인스턴스를 생성할 때 리터럴을 이용할 수 있음.
        문자열 리터럴은 “ “ 안에 기재
        `String 이름 = "문자열"`
        toString 메서드는 저장하고 있는 문자열을 리턴하도록 만들어져 있어서 바로 출력이 가능
      - 서식을 이용한 데이터 출력 - System.out.printf 이용
        첫 번째 매개변수로 문자열 형태로 서식을 설정
        서식을 설정할 때는 %와 포맷문자를 조합해서 데이터를 서식에 맞춰서 출력
        두 번째 매개변수부터는 앞의 서식 문자와 매핑되는 데이터를 나열한다.
        서식 문자
        - %d: 10진수
        - %x: 16진수
        - %o: 8진수
        - %i: 10진수
        - %f: 실수
        - %e: 지수 형태로 출력
        - %c: 하나의 문자
        - %b: boolean
        - %s: 문자열
          서식 문자 앞에 숫자를 추가해서 자릿수를 확보 가능
          %10d: 10자리를 확보해서 출력
          %010d: 10자리를 확보해서 출력하고 남는 자리는 0
          %전체자리수.소수자리수f: 전체 자리를 확보하고 소수 자릿수만큼 소수를 출력 - 반올림
          전체 자리수를 생략하고 .소수 자리수 형태로 설정 가능
          정수 부분은 실제 데이터의 길이보다 적은 자리수를 설정해도 숫자는 잘리지 않고 전부 출력
8. **Operator(연산자)**

   1. 연산의 분류
      - 연산의 결과 또는 연산될 때 데이터에 따른 분류
        - Arithemetic Operation
          숫자 데이터의 연산
        - Logical Operation
          boolean 데이터의 연산
      - 피연산자의 개수에 따른 분류
        - Unary
          데이터가 2개이면 수행되는 연산
        - Binary
          데이터가 2개이면 수행되는 연산
        - Ternary
          데이터가 3개이면 수행되는 연산
      - 용도에 따른 연산 및 우선 순위
        - 최우선 연산자
          ( ), [ ], { }
        - 단항 연산자
          ++, --, 부호 +, 부호 -, (자료형), !, ~
        - 이항 산술 연산자
          %, /, \*, +, -
        - shift 연산자
          > > ,<<,>>>
          > > 이항 산술로 취급하기도 함.
        - 논리 연산자
          <. <=, >, >=, instance of, ==, !=
          앞에 4개는 숫자 데이터만 가능하고, ==와 !=는 모든 자료형에 사용 가능하며, instance of만 데이터가 인스턴스와 클래스이다.
        - 정수 데이터를 가지고 2진수의 비트 단위로 연산을 해서 정수 데이터로 리턴하는 연산자
          &, ^, |
        - boolean 데이터를 가지고 연산을 수행한 후 결과도 boolean으로 리턴하는 연산자
          &&, ||
        - 삼항 연산자
          ? :
        - 할당 연산자
          =, 연산자 =
        - 콤마 연산자
          ,
   2. 최우선 연산자
      - ( )
        연산의 우선 순위를 변경하기 위해서 사용하는 연산자
      - [ ], { }
        [ ] 는 배열의 크기나 인덱스를 설정할 떄 사용하고, { }는 배열을 생성할 때 사용
      - ~
        1의 보수를 구해주는 연산자
        정수 데이터의 모든 비트를 반전하는 연산자
        양수에 붙이면 부호는 음수가 되고, 절대값은 1 증가
        음수에 붙이면 부호는 양수가 되고, 절대값은 1 감소
        숫자 연산으로는 큰 의미가 없고 비트 반전에만 사용
      - !
        boolean 데이터에만 사용 가능한데, boolean 데이터 반전에만 사용
      - 부호 +, - +는 대부분 생략하는 것이고, -는 음수로 보는데, 실제로는 2의 보수를 구해주는 연산자
      - 증감 연산자
        ++와 --
        정수 변수 데이터에만 사용
        변수의 데이터를 1 증가 시키거나 감소 시키는 연산자
        데이터의 앞(prefix)과 뒤(postfix) 모두에 사용 가능.
   3. 산술 연산자
      - %
        정수 데이터를 가지고 나머지를 구해주는 연산자
      - /, \*, -, +
        숫자 데이터를 가지고 사칙 연산을 수행
      - Java에서는 산술 연산의 최소 단위가 int
        byte, short, char는 int로 변환되어서 산술 연산을 수행하고 결과를 int로 리턴.
        2개의 서로 다른 숫자 자료형끼리 연산을 하면 더 큰 자료형으로 변환해서 연산을 수행하고 결과도 큰 자료형으로 리턴
        byte < short, char < int < long < float < double<
      - 데이터 입력 도중 한 글자 오류가 나는걸 ‘transcription error’ 라고 함.
        이를 방지하는 법 중 하나는 데이터 몇 개를 추가해서 특정한 숫자로 나누었을 때 나머지가 0이 되도록 하는 방법을 사용
        주민등록번호나 신용카드 번호 또는 계좌번호 등이 이 원리를 이용
        숫자 3자리로 구분을 하고자 하는 경우 숫자 1개를 추가해서 4자리로 구성하는데 3자리는 직접 입력하도록 하고 1자리는 연산을 해서 설정
        mod 10을 사용
   4. shift 연산자

      정수 데이터에만 사용 가능

      2진수를 가지고 비트 단위로 밀어내는 연산자

      32번 이상 밀어내도록 하면 32로 나눈 나머지만큼 밀어낸다. 32번 이상 shift하지 않음.

      shift는 특정 비트가 1인지 확인하고자할 때 많이 사용한다.

      컴퓨터 내부적으로는 곱하기와 나누기를 할 때 사용

      - <<
        첫 번째 비트를 제외하고 나머지 비트를 왼쪽에서 제거하고 뒤에 0을 삽입하는 구조로 부호가 변경되지 않음.
      - > > 뒤에서 밀어내는데 맨 앞에 추가되는 비트는 첫 번째 비트를 계속해서 추가하고 부호가 변경되지 않음.
      - > > > 맨 앞에 0을 추가하면서 밀어내는 연산자로 음수를 가지고 수행하게 되면 양수가 만들어진다.

   5. 크기 비교 연산자
      - > , >=, <, <=
        > 숫자 데이터에만 사용할 수 있고, 결과는 boolean
      - 동일성 여부
        - ==: 해시 코드를 비교해서 일치하면 true
        - !=: 해시 코드를 비교해서 일치하지 않으면 false
          저장하고 있는 데이터가 일치하는지 확인하고자 하는 경우는 equals 메서드를 재정의해서 사용
   6. instance of

      어떤 인스턴스가 클래스의 인스턴스인지 확인하는 연산자

      클래스는 상위 클래스이면 된다.

      일반 프로그래밍에서는 잘 사용되지 않고 Generic이 적용되는 경우에 사용된다.

      대입되는 데이터가 특정 클래스 타입인지 확인하고자 할 때 사용

   7. 논리 연산자
      - &&
        boolean 데이터에만 적용이 가능한데 둘 다 true일 때만 true가 나오는 연산자
      - ||
        boolean 데이터에만 적용이 가능한데 둘 다 false일 때만 false가 나오는 연산자
      - &&가 우선순위가 높음
      - &&는 앞의 결과가 false이면 뒤의 결과를 확인하지 않는다.
      - ||는 앞의 결과가 true이면 뒤의 결과를 확인하지 않는다.
      - java는 boolean 데이터 이외는 boolean으로 간주하지 않는다.
   8. 비트 논리 연산자

      - 정수 데이터를 가지고 연산을 수행하는데 비트 단위로 논리 연산을 수행한 후 정수로 결과를 리턴한다.
      - ~
        단항 연산자로 1의 보수를 리턴하는 연산자
      - &
        and 연산자로 둘 다 1인 경우만 1
      - |
        or 연산자로 두 다 0인 경우만 0
      - ^
        eXclusive OR로 같으면 0 다르면 1

      예시

      - 20
        00000000 00000000 00000000 00010100
      - 17
        00000000 00000000 00000000 00010001
      - 20 & 17
        00000000 00000000 00000000 00010000 ⇒ 16
      - 20 | 17
        00000000 00000000 00000000 00010101 ⇒ 21
      - 20 ^ 17
        00000000 00000000 00000000 00000101 ⇒ 5

   9. 삼항 연산자

      조건식 ? 조건식이 true일 때 남는 식: 조건식이 false일 때 남는 식

      `자바는 반드시 boolean을 리턴해야 함.`

   10. 할당 연산자

       오른쪽의 데이터를 왼쪽의 변수가 가리키도록 하는 연산자

       - 연산자=
         왼쪽의 데이터와 오른쪽의 데이터를 연산자를 이용해서 연산을 수행하고 그 결과를 왼쪽의 변수가 가리키도록 함.

   11. 문자열의 + 연산자

       문자열은 모든 데이터와 + 연산이 가능

       기본형 데이터의 경우는 문자열로 형 변환을 해서 결합을 하고 나머지 데이터는 toString 메서드를 호출해서 그 결과를 결합하는 방식을 취하게 됨.

       문자열 리터럴은 static 영역에 저장되기 때문에 내용 변경이 안된다.

       문자열을 +로 결합하게 되면 메모리 낭비가 발생할 수 있다.

       문자열 + 연산은 자주 사용하지 않는 것을 권장하고 `String.format`이나 `StringBuilder`를 사용하는 것을 권장하는데 Java 1.7 버전부터는 문자열의 `+ 연산을 자바가 내부적으로 StringBuilder를 이용해서 수행하기 떄문에 크게 관계없다.`

9. **Type Casting(자료형 변환)**

   데이터의 자료형을 변경하는 것

   1. 종류
      - 자동 형 변환
        묵시적으로 이루어지는 형 변환
        산술 연산에 int보다 작은 숫자 자료형을 사용한 경우 int로 자동 형 변환
        서로 다른 자료형끼리 산술 연산을 수행하는 경우 더 큰 자료형으로 자동 형 변환해서 연산을 수행
      - 강제 형 변환
        명시적으로 형 변환을 수행하는 것
        (자료형이름)데이터 - 데이터의 자료형이 ( ) 안의 자료형으로 변환됨.
        숫자 데이터끼리 강제 형 변환이 가능하고 인스턴스 끼리는 상속 관계인 경우만 가능
        숫자 데이터와 문자 데이터끼리는 강제 형 변환은 안되지만 메서드가 제공됨.
        문자열을 숫자 데이터로 변환할 때는 `Wrapper 클래스` 를 이용하면 되고 숫자 데이터를 문자 데이터로 변경할 때는 String의 메서드를 이용해도 되고 빈 문자열과 + 연산을 수행해도 됨.
        강제 형 변환을 하는 이유는 원하는 결과를 만들기 위해서
        실수를 정수로 강제 형 변환할 때는 소수 부분이 사라짐.
        큰 자료형에서 작은 자료형으로 형 변환할 때는 데이터의 손실이 있을 수 있음.
        언어마다 숫자를 다루는 방식이 다르므로 숫자 연산을 수행하기 전에 그 언어의 숫자 데이터를 다루는 부분을 알아두어야 한다.

10. **제어문**

    1. Java에서의 import

       java는 애플리케이션을 실행하면 jdk가 제공하는 클래스들은 jre가 제공을 해주고 우리가 만든 모든 클래스를 jvm에 로딩을 해서 실행한다.

       근본적으로 자바에서는 import 과정이 필요없음.

       `java에서 import는 메모리에 가져오는 개념이 아니고 줄여쓰기 위한 개념이다.`

       ```java
       import java.util.BufferReader;
       // 앞으로 BufferReader라고 쓰면 java.util.BufferREader를
       // 사용한다는 의미이다.

       import java.util.*;
       // java.util 패지키에 있는 모든 클래스를 줄여쓰기를 하겠다는 의미이다.
       // *을 쓰는 것은 별로 좋지 않은게 서로 다른 패키지에 동일한 메서드가
       // 있을 수 있기 때문이다. 대표적인 예로 Date
       ```

    2. 콘솔에서 입력받기
       - java.io.BufferReader 클래스 이용
         ```java
         BufferdReader br = new BufferedReader(new InputStreamReader(System.in));
         String str = br.readLine(); // 한 줄의 문자열을 입력받아서 str에 대입
         // 이 방법을 선호하지 않는 것은 예외처리를 강제한다.
         ```
       - java.util.Scanner 클래스 이용
         ```java
         Scanner sc = new Scanner(System.in);
         자료형 변수이름 = sc.next자료형(); // 문자열을 받아서 자료형으로 변환한 후 리턴
         ```
    3. if

       표현식: 변수, 상수(리터럴은 제외), 연산식, 메서드 호출 구문

       - 기본 형식

         ```java
         if(boolean이 리턴되는 표현식) {
         	표현식이 true일 때 수행할 내용
         } else if(boolean이 리턴되는 표현식) {

         ```

         if는 1 번만 나와야 한다.
         if는 필수
         else if 는 0번 이상 여러 번 작성 가능하다.
         elsie if를 만들 대 주의할 점은 dead code(결코 수행되지 않는 code) 조건을 만들면 안된다.
         else는 0번이나 한 번만 작성
         else if와 else가 같이 사용되는 경우에는 else에서 예외적인 상황을 처리해주는 것잊 좋다.
         예전 try ~ catch가 없었을 때는 else를 가지고 예외처리를 수행하였다.

    4. switch ~ case

       값에 의한 분기

       사용 가능한 데이터는 정수와 문자열

       ```java
       switch(정수나 문자열 표현식):
       	case 값1:
       					값1일 때 수행할 내용
       					(break;)
       	case 값2:
       					값2일 때 수행할 내용
       					(break;)
       	...
       	default:
       					수행할 내용
       					(break;)
       ```

       case의 개수는 제한없음.

       case에 사용하는 데이터는 상수만 가능하다.

       break가 없으면 break를 만날 때 까지 모든 구문을 전부 수행.

    5. while

       ```java
       while(boolean 표현식) {
       	boolean 표현식이 false가 아니면 수행을 내용
       }
       ```

       boolean 표현식이 false가 될 때까지 내용을 반복

    6. for

       ```java
       for(초기식; boolean 표현식; 두 번째 부터 수행할 내용 {
       	boolean 표현식이 false가 아닌 경우 수행할 내용
       }
       ```

       각 식은 생략 가능

       각 식에는 2개 이상의 문장을 사용해도 되는데, 이 경우 ,로 구분한다.

       - 배열을 순회하면서 수행
         ```java
         for(임시변수: 배열) {
         	배열의 데이터를 임시변수에 하나씩 대입하면서 수행할 내용
         }
         ```

    7. 제어문 사용

       실행할 내용이 한 줄이면 { } 이면 생략 가능

       () 다음에 ;을 하게 되면 제어문은 사용하지 않은 형태가 딘다.

       제어문은 별도의 블럭을 생성하는데 이전 블럭에 만든 것을 다시 만들 수는 없고 자신의 블럭 안에 만든 것은 자신의 블럭에서만 사용 가능하고 제어문이 종료되면 블럭은 소멸된다.

       switch의 case에서 변수를 만드는 것은 수행될지 안될지를 모르기 때문에 안된다.

    8. break와 continue

       반복문 안에서 사용되면 일반적으로 if와 함께 사용됨.

       break 다음에 수행할 내용이 없다면 break 대신에 자신을 호출한 메서드에게 제어권을 넘기는 return으로 작성해도 된다.

       - break
         switch와 반복문 안에서 switch와 반목문을 종료하는 기능
       - continue
         반복문 안에서 더 이상 아래로 내려가지 않고 다음 반복으로 넘어가는 기능

    9. 무한 반복 만들기

       while(true){무한반복}

       do{무한반복}while(true);

       for(;;){무한반복}

    10. 반복문에 레이블 사용

        `레이블:반복문{}`

        break나 continue를 할 때 뒤에 레이블을 붙일 수 있음.

        반복문 안에 반복문이 있을 때 바깥쪽 반복문을 종료하거나 넘어가고자 할 때 사용.

11. **Array(배열)**

    1. Array
       - 동일한 자료형으로 구성된 데이터의 연속적인 모임
       - 자바에서의 Array는 정적이다
         한 번 만들어지면 내부 요소의 수정은 가능하지만 크기 변경은 안된다.
       - 생성을 하면 데이터는 Heap에 생성이 된다.
       - 동일한 용도로 사용되는 데이터는 이름이 하나인게 관리하기 편리하기 때문이다.
         여러 개의 데이터를 반복문이나 iterator를 이용해서 쉽게 사용할 수 있다.
       - 배열은 하나의 public 속성을 갖는데 속성은 length
         배열 이름.length 를 호출하면 한 단계 아래 하위 데이터의 개수를 리턴한다.
       - length 속성은 읽기 전용
    2. 배열의 생성

       - 초기 데이터를 가지고 생성 - 선언할 때 1번만 가능
         ```java
         배열요소 1개의 자료형 [ ] 배열이름 = {데이터 나열...}
         ```
       - 크기만 설정

         ```java
         배열요소 1개의 자료형 [ ] 배열이름 = new 배열요소 1개의 자료형[개수];

         // 숫자의 경우는 0
         // boolean의 경우는 false
         // 나머지는 null

         // 다시 선언하는 것도 가능
         배열이름 = new 배열요소 1개의 자료형[개수];
         ```

       - []는 배열 이름 뒤에 기재해도 된다.
         자바에서는 대부분 앞에 기재한다
         `자료형[ ]: 배열`

    3. 배열의 요소 접근

       `배열이름[인덱스]` : 인덱스는 0부터 length - 1 까지

    4. 배열의 순회

       `for(임시변수: 배열이름){수행}`

    5. 배열 사용 시 많이 발생하는 예외
       - `NullPointerException` 배열의 메모리 할당이 이루어지지 않은 상태에서 사용
       - `ArrayIndexOutOfBoundsException` 인덱스 오류
    6. 다차원 배열

       - 배열 안의 요소가 배열인 형태
       - [ ]의 개수를 차원의 개수라고 한다.
       - 2차원 배열을 matrix 라고 한다. 3차원 배열이나 4차원 배열을 사용하는 경우가 있는데 머신러닝에서 주로 이용
       - 생성

         ```java
         // 초기 데이터를 가지고 생성
         자료형 [][] 배열이름 = {{데이터나열}, {데이터나열}, ...}

         // 각 행의 열 숫자가 동일한 경우
         자료형 [][] 배열이름 = new 자료형[크기][크기]

         // 열의 숫자를 다르게 생성
         자료형 [][] 배열이름 = new 자료형[크기][];
         배열이름[0] = new 자료형[크기];
         ```

       - 사용
         `배열이름[행인덱스][열인덱스]` 데이터에 접근
         `배열이름[행인덱스]` 는 배열
       - 2차원 배열에서의 length
         `배열이름.length` 행의 개수
         `배열이름[행인덱스].length` 열의 개수
       - 배열은 만들 때 마지막을 가리키기 위해서 메모리를 사용하므로 메모리를 아끼고자 할 때는 2차원 배열을 1차원 배열로 만드는 것도 생각을 해봐야 한다.

    7. 배열에 데이터 추가

       배열은 크기 변경이 불가

       배열의 크기를 변경하고자 할 때는 배열의 데이터를 복사해서 수행해야 한다.

       배열을 복사하는 방법은 직접 알고리즘을 구현해도 되고 Arrays 클래스의 static 메서드인 Arrays.copy를 이용할 수 있다.

       복사할 배열과 개수를 매개변수로 대입하면 된다.

    8. 배열의 데이터를 하나의 문자열로 만들기

       배열은 toString 메서드가 없어서 문자열로 만들고자 하는 경우에는 `Arrays.toString` 메서드에 매개변수로 대입해서 결과를 리턴받아야 한다.

       `Arrays.toString` 은 배열 안의 모든 요소에 toString을 호출해서 결합한다.

    9. **Sorting**

       배열은 데이터가 여러 개 이므로 접근을 할 때 원하는 순서대로 접근할 수 있도록 정렬을 하는 경우가 많다.

       `대부분 API가 제공하는 메서드들은 Quick Sort나 Heap 또는 Merge Sort를 주로 이용`

       선택 정렬이나 버블 정렬은 학습 단계에서 반복문을 공부할 목적으로 주로 하고 애플리케이션에서는 성능이 떨어지기 때문에 잘 사용하지 않는다.

       정렬하는 방법은 직접 알고리즘을 구현해서 할 수 있고 Arrays 클래스가 제공하는 sort라는 메서드를 이용하는 방법이 있다.

       Arrays.sort 메서드는 기본적으로 크기 비교가 가능한 메서드를 소유하고 있어야 하고 이를 직접 구현해서도 가능. 기본은 오름차순

       - Arrays.sort 메서드를 이용한 데이터의 정렬
         숫자 데이터와 문자열 그리고 Date 클래스의 배열은 별도로 메서드를 구현하지 않아도 오름차순 정렬이 가능
         `Wrapper` 클래스와 `String` 그리고 `Date` 는 `Comparable` 이라는 메서드가 구현되어있기 때문이다.
       - 선택 정렬(Selection Sort)
         첫 번째 데이터부터 마지막 바로 앞 데이터까지 자신의 뒤에 있는 모든 데이터와 비교해서 정렬해나가는 방식
         앞의 데이터가 클 때 데이터를 교환하면 오름차순 정렬이 되고 뒤의 데이터가 클 때 데이터를 교환하면 내림차순 정렬이 된다.

    10. **search(검색)**
        - 검색 알고리즘
          - 순차 검색
            데이터를 정렬화지 않은 상태에서 처음부터 끝까지 데이터를 찾을 때까지 비교해나가는 방식
          - 제어 검색
            데이터를 정렬한 상태에서 검색
            `binary search` : 중앙에 있는 데이터와 비교해서 같으면 찾은 것이고 작으면 왼쪽 부분의 배열에 다시 중앙값과 비교하고, 크면 오른쪽의 배열에서 중앙값과 비교하면서 찾는 방식.
            `fibonacci search` : 첫 번째와 두 번째는 1이고 세 번째 부터는 앞의 2개 항의 합인 수열
            `interpolation search` : 찾는 위치를 계산해서 찾는 방식.((검색값 - 최소값)/(최대값-최소값))\*(데이터개수 - 1) + 1을 해서 찾는 위치를 결정하는 방식. 데이터의 간격이 균등할 때 효과적.
            `tree search` : 데이터를 저장할 때 tree 구조로 저장해서 검색에 활용
            `block search` : 블록끼리는 정렬이 되어 있고 블럭 내부는 정렬이 되지 않은 경우 사용.
            `hasing`: 데이터에 key를 생성해서 찾아가는 방식으로 가장 빠르지만 메모리 효율은 떨어진다.