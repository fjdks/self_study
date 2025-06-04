import 'package:flutter/material.dart';

import 'firebase_options.dart';
import 'package:firebase_core/firebase_core.dart';

import 'package:get/get.dart';

Future <void> main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(options: DefaultFirebaseOptions.currentPlatform,
  );
  runApp(
    GetMaterialApp(
      title: 'dogdack',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        appBarTheme: const AppBarTheme(
          backgroundColor: Color.fromARGB(255, 100, 92, 170),
        ),
        primaryColor: const Color.fromARGB(255, 100, 92, 170),
        fontFamily: 'bmjua',
        //textButtonTheme:,
        textTheme: const TextTheme(
          titleLarge: TextStyle(
            fontWeight: FontWeight.w600,
            fontSize: 20,
            color: Color.fromARGB(255, 80, 78, 91),
          ),
          displayMedium: TextStyle(
            fontSize: 16,
            color: Color.fromARGB(255, 100, 92, 170),
          ),
          bodyMedium: TextStyle(
            fontSize: 16,
            color: Color.fromARGB(255, 80, 78, 91),
          ),
        ),
      ),
      home: MyApp(),
    ),
  );
}

class MyApp extends StatefulWidget {
  MyApp({Key? key}) : super(key: key);
  bool isFinish = false;

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('도그닥 홈'),
        centerTitle: true,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              '반갑습니다!',
              style: Theme.of(context).textTheme.titleLarge,
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                // 버튼 누르면 다음 페이지나 액션 수행 가능
              },
              child: Text('시작하기'),
            ),
          ],
        ),
      ),
    );
  }
}