import 'package:flutter/material.dart';

// GetX
import 'package:get/get.dart';

// Firebase
import 'package:cloud_firestore/cloud_firestore.dart';

// model
import '../models/dog_data.dart';

enum MyPageStateType {
  //MyPage 상태를 정의합니다.
  View, // 사용자 정보 및 반려견 목록 보기 화면
  Create, // 반려견 정보 신규 생성 화면
  Edit, // 반려견 정보 수정 화면
}

class MyPageStateController extends GetxController {
  //MyPage 상태를 정의합니다.
  MyPageStateType myPageStateType = MyPageStateType.View;
}

class PetController extends GetxController {
  //My Page 에서 슬라이더로 선택된 Pet 의 정보 : 반려견 정보 수정 화면에서 기존 데이터를 가져올 때 활용
  String selectedPetID = ''; // 해당 반려견의 Firebase Document ID
  String selectedPetImageUrl = '';
  String selectedPetImageFileName = ''; // 해당 반려견 이미지의 Firebase storage 저장된 파일명
  String selectedPetName = '';
  String selectedPetGender = '';
  String selectedPetBirth = '';
  String selectedPetKategorie = '';
  String selectedPetBreed = '';
  num selectedPetWeight = 0;
  num selectedPetRecommend = 0;
  int selectedPetScrollIndex = 0; // 해당 반려견의 슬라이더 인덱스

  List<String> petNameList = [];

  // 슬라이더 인덱스로 선택한 반려견의 정보를 갱신
  updateSelectedPetInfo(AsyncSnapshot<QuerySnapshot<DogData>> snapshot, PetController petController, int index) {
    petController.selectedPetID = snapshot.data!.docs[index].id;
    petController.selectedPetImageUrl = snapshot.data!.docs[index].get('imageUrl');
    petController.selectedPetImageFileName = snapshot.data!.docs[index].get('imageFileName');
    petController.selectedPetName = snapshot.data!.docs[index].get('name');
    petController.selectedPetGender = snapshot.data!.docs[index].get('gender');
    petController.selectedPetBirth = snapshot.data!.docs[index].get('birth');
    petController.selectedPetBreed = snapshot.data!.docs[index].get('breed');
    petController.selectedPetKategorie = snapshot.data!.docs[index].get('kategorie');
    petController.selectedPetWeight = snapshot.data!.docs[index].get('weight');
    petController.selectedPetRecommend = snapshot.data!.docs[index].get('recommend');
    petController.selectedPetScrollIndex = index;
  }
}

class HomePageSliderController extends GetxController {
  int sliderIdx = 0;
}

class HomePageWalkCalculatorController extends GetxController {
  int compPercent = 0;

  getTodayWalkPercent() {
      update();
  }
}
