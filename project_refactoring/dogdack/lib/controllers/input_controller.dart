import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:get/get.dart';

class InputController extends GetxController {
  DateTime date = Timestamp.now().toDate();
  String place = '장소';
  Timestamp startTime = Timestamp(0, 0);
  Timestamp endTime = Timestamp(0, 0);
  String distance = '0';
  RxString diary = ''.obs;
  RxBool walkCheck = false.obs;
  RxBool bath = false.obs;
  RxBool beauty = false.obs;
  List<String> imageUrl = [];
  String name = '';
  Map<String, dynamic> dognames = {};
  List<String> valueList = [];
  String selectedValue = '';
  String saveName = '';
  String time = '';
  DateTime today = Timestamp.now().toDate();

  RxMap<String, List> events = <String, List>{}.obs;

  /////////////////////////여기 한줄 영우 추가/////////////////////
  // Map dog_names = {};
  String selected_id = '';

  void setDate(selectedDate) {
    date = selectedDate;
    update();
  }
}
