import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:intl/intl.dart';

import '../../../../controllers/input_controller.dart';

class DayWidget extends StatefulWidget {
  @override
  State<DayWidget> createState() => _DayWidgetState();
}

class _DayWidgetState extends State<DayWidget> {

  final controller = Get.put(InputController());

  List<String> days = [];

  TextStyle style = TextStyle(
      fontSize: 14,
      fontFamily: 'bmjua',
      color: Color.fromARGB(255, 80, 78, 91));

  void fillDate() {
    days = [];
    for (int i = 0; i < 7; i++) {
      days.add(DateFormat.E('ko_KR')
          .format(Timestamp.now().toDate().subtract(Duration(days: 6 - i))));
    }
  }

  @override
  Widget build(BuildContext context) {
    fillDate();

    Size screenSize = MediaQuery.of(context).size;
    double width = screenSize.width;
    int index = 0;
    return Container(
        width: width * 0.7,
        child: Center(
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: <Widget>[
              Container(
                child: Text("${days[index++]}", style: style),
              ),
              Container(
                child: Text("${days[index++]}", style: style),
              ),
              Container(
                child: Text("${days[index++]}", style: style),
              ),
              Container(
                child: Text("${days[index++]}", style: style),
              ),
              Container(
                child: Text("${days[index++]}", style: style),
              ),
              Container(
                child: Text("${days[index++]}", style: style),
              ),
              Container(
                child: Text("${days[index++]}", style: style),
              )
            ],
          ),
        ));
  }
}

class WeekWidget extends StatefulWidget {
  @override
  State<WeekWidget> createState() => _WeekWidgetState();
}

class _WeekWidgetState extends State<WeekWidget> {
  List<String> days = [];

  TextStyle style = TextStyle(
      fontSize: 14,
      fontFamily: 'bmjua',
      color: Color.fromARGB(255, 80, 78, 91));

  @override
  Widget build(BuildContext context) {
    for (int i = 0; i < 28; i += 7) {
      days.add(DateFormat('MM/dd')
          .format(Timestamp.now().toDate().subtract(Duration(days: 30 - i))));
    }
    days.add(DateFormat('MM/dd').format(Timestamp.now().toDate()));

    Size screenSize = MediaQuery.of(context).size;
    double width = screenSize.width;
    int index = 0;
    return Container(
        width: width * 0.7,
        child: Center(
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: <Widget>[
              Container(
                child: Text("${days[index++]}", style: style),
              ),
              Container(
                child: Text("${days[index++]}", style: style),
              ),
              Container(
                child: Text("${days[index++]}", style: style),
              ),
              Container(
                child: Text("${days[index++]}", style: style),
              ),
              Container(
                child: Text("${days[index++]}", style: style),
              ),
            ],
          ),
        ));
  }
}