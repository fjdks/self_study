# SSAFY 공통 프로젝트 DOGDACK - 리팩토링

## Setting

1. Flutter 설치
   - https://flutter.dev/docs/development/tools/sdk/releases?tab=windows
   - 다운로드 폴더는 경로에 한글이 없는 C드라이브 폴더
     - C:\flutter
2. android studio 설치
3. android studio plugin 설치
   - flutter
   - dart
4. sdk manager
   - sdk tools 의 Android SDK Command-line tools 부분 체크하고 적용
   - ![My Screenshot](assets/sdk_tools_screenshot.png)
5. 환경변수 등록
   - 시스템 환경 변수 편집 -> 환경변수 -> User에 대한 사용자 변수 편집 -> flutter\bin 경로 등록
6. 환경 테스트
   - powershell 실행
   - flutter doctor 입력
   - 발생한 각 에러 해결
     7. Firebase 연동
        - Web에서 Firebase 콘솔에 접속
        - 프로젝트 생성
        - android studio terminal에 다음 명령어 입력
          - npm(node.js) 버전 업데이트
          - 시스템 환경 변수 -> 시스템 변수 -> path 에 nodejs 파일의 정확한 경로 추가 (C:\Program Files\nodejs)
          - npm install -g firebase-tools
          - firebase login
          - dart pub global activate flutterfire_cli
            -> 경고 메세지 뜨면 환경변수에 경로 추가(ex : C:\Users\User\AppData\Local\Pub\Cache\bin)
          - flutter pub add firebase_core
          - androidstudio(or cmd 등) 재시작
          - flutterfire configure
            - 이전에 생성한 firebase 프로젝트 선택
            - main.dart 파일에 있는 main 함수를 다음과 같이 수정
            - ![My Screenshot](assets/voidmain_before.png)
              ![My Screenshot](assets/voidmain_after.png)
        - 

## Developing

1. 기존 S08P12A503 폴더의 DogDack 프로젝트를 분석 후 리팩토링한다.
