import 'dart:async';
import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter_blue_plus/flutter_blue_plus.dart';
import 'package:get/get.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';
import 'package:latlong2/latlong.dart' as ll;
// import 'package:location/location.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/gestures.dart';

import '../../../controllers/walk_controller.dart';

class myMap extends StatefulWidget {
  late final String title;
  late String receiveData = '';

  // Map? location;

  @override
  _MapState createState() => _MapState();
}

class _MapState extends State<myMap> {
  // late GoogleMapController _controller;
  Color grey = const Color.fromARGB(255, 80, 78, 91);
  Color violet = const Color.fromARGB(255, 100, 92, 170);
  Color violet2 = const Color.fromARGB(255, 160, 132, 202);

  final Completer<GoogleMapController> _controller = Completer();
  final walkController = Get.put(WalkController());

  late CameraPosition? _initialPosition;

  // 지도 클릭 시 표시할 장소에 대한 마커 목록
  final List<Marker> markers = [];

  List<LatLng> latlng = [];

  final ll.Distance distance = const ll.Distance();
  late LatLng temp;
  // RxDouble? totalDistance = 0.0.obs;

  // LocationData? currentLocation;

  addMarker(cordinate) {
    setState(() {
      markers.add(Marker(
          position: cordinate, markerId: MarkerId(cordinate.toString())));
    });
  }

  @override
  void initState() {
    print("init state map");
    // 이 값은 지도가 시작될 때 첫 번째 위치입니다.
    _initialPosition = CameraPosition(
      target: LatLng(walkController.lat, walkController.lon),
      zoom: 17,
    );
    // updatePosition(); // GPS 모듈
    // getCurrentLocation();
  }

  // void updatePosition() async {
  //   print('update');
  //   GoogleMapController googleMapController = await _controller.future;
  //   for (BluetoothService service in walkController.services!) {
  //     print('service: ${service}');
  //     if (service.uuid.toString() == walkController.serviceUUID) {
  //       print('service ok');
  //       for (BluetoothCharacteristic characteristic
  //           in service.characteristics) {
  //         if (characteristic.uuid.toString() ==
  //             walkController.characteristicUUID) {
  //           print('characteristic ok');
  //           await characteristic.setNotifyValue(true);
  //           String stringValue = '';
  //           characteristic.value.listen((value) {
  //             print('listen: ${value}');
  //             try {
  //               stringValue = utf8.decode(value).toString();
  //             } catch (e) {
  //               print('Error in decoding(my_map.dart): $e');
  //             }
  //
  //             widget.receiveData += stringValue;
  //             print('receiveData: ${widget.receiveData}');
  //             // 한번 갱신 될 때마다
  //             // 시작 전
  //             if (!walkController.isRunning.value) {
  //               widget.receiveData = '';
  //             } else if (widget.receiveData.contains('{') &&
  //                 widget.receiveData.contains('}')) {
  //               // 시작 후
  //               try {
  //                 int start = widget.receiveData.indexOf('{');
  //                 int end = widget.receiveData.indexOf('}') + 1;
  //
  //                 widget.receiveData = widget.receiveData.substring(start, end);
  //
  //                 widget.location = jsonDecode(widget.receiveData);
  //                 walkController.setCurrentLocation(
  //                     widget.location!['lat'], widget.location!["lon"]);
  //                 print(
  //                     'walkController location: ${walkController.lat} ${walkController.lon}');
  //                 widget.receiveData = '';
  //                 LatLng currentPosition = LatLng(
  //                   walkController.lat,
  //                   walkController.lon,
  //                 );
  //                 googleMapController.animateCamera(
  //                   CameraUpdate.newCameraPosition(
  //                     CameraPosition(
  //                       zoom: 17,
  //                       target: currentPosition,
  //                     ),
  //                   ),
  //                 );
  //
  //                 if (latlng.length > 1) {
  //                   totalDistance = totalDistance! +
  //                       calTotalDistance(
  //                           ll.LatLng(
  //                               latlng.last.latitude, latlng.last.longitude),
  //                           ll.LatLng(currentPosition.latitude,
  //                               currentPosition.longitude));
  //                   walkController.distance = totalDistance;
  //                 }
  //
  //                 latlng.add(currentPosition);
  //                 walkController.addData(
  //                     currentPosition.latitude, currentPosition.longitude);
  //                 print('totaldistance: $totalDistance');
  //                 setState(() {});
  //               } catch (e) {
  //                 print('Error in set position - $e');
  //               }
  //             }
  //           });
  //         }
  //       }
  //     }
  //   }
  // }

  // void getCurrentLocation() async {
  //   print('getCurLocation');
  //   Location myLocation = Location();
  //   myLocation.getLocation().then(
  //     (location) {
  //       currentLocation = location;
  //     },
  //   );
  //
  //   print(currentLocation);
  //   GoogleMapController googleMapController = await _controller.future;
  //   myLocation.onLocationChanged.listen(
  //     (newLoc) {
  //       currentLocation = newLoc;
  //       googleMapController.animateCamera(
  //         CameraUpdate.newCameraPosition(
  //           CameraPosition(
  //             zoom: 17,
  //             target: LatLng(
  //               newLoc.latitude!,
  //               newLoc.longitude!,
  //             ),
  //           ),
  //         ),
  //       );
  //       if (walkController.isStart && walkController.isRunning.value) {
  //         if (latlng.length > 1) {
  //           walkController.totalDistance.value =
  //               walkController.totalDistance.value +
  //                   calTotalDistance(
  //                       ll.LatLng(latlng.last.latitude, latlng.last.longitude),
  //                       ll.LatLng(currentLocation!.latitude!,
  //                           currentLocation!.longitude!));
  //         }
  //
  //         latlng.add(
  //             LatLng(currentLocation!.latitude!, currentLocation!.longitude!));
  //
  //         setState(() {});
  //       }
  //     },
  //   );
  // }

  double calTotalDistance(ll.LatLng p1, ll.LatLng p2) {
    return distance.as(ll.LengthUnit.Meter, p1, p2);
  }

  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 15),
      child: Scaffold(
        body: Stack(
          children: [
            ClipRRect(
              borderRadius: BorderRadius.circular(15),
              child: GoogleMap(
                  // liteModeEnabled: true,
                  gestureRecognizers: Set()
                    ..add(Factory<PanGestureRecognizer>(
                        () => PanGestureRecognizer())),
                  zoomControlsEnabled: false,
                  initialCameraPosition: _initialPosition!,
                  mapType: MapType.normal,
                  onMapCreated: (mapController) {
                    if (_controller.isCompleted == false) {
                      _controller.complete(mapController);
                    }
                  },
                  markers: markers.toSet(),
                  polylines: {
                    Polyline(
                      polylineId: const PolylineId('route'),
                      visible: true,
                      width: 5,
                      points: latlng,
                      color: Colors.blue,
                    ),
                  }),
            ),
            Padding(
              padding: EdgeInsets.fromLTRB(size.height * 0.01,
                  size.height * 0.52, size.height * 0.01, 0),
              child: Container(
                decoration: BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.circular(10),
                    border: Border.all(
                      color: violet2,
                      width: 3,
                    )),
                height: size.height * 0.1,
                // color: Colors.white,
                child: Obx(
                  () => Stack(
                    children: <Widget>[
                      // 재생버튼
                      Align(
                        alignment: Alignment(
                          Alignment.center.x,
                          Alignment.center.y,
                        ),
                        child: OutlineCircleButton(
                            radius: 50.0,
                            borderSize: 5.0,
                            onTap: () async {
                              _clickPlayButton();
                            },
                            child: walkController.isRunning.value
                                ? Icon(Icons.pause, color: violet2)
                                : Icon(Icons.play_arrow, color: violet2)),
                      ),
                          // 산책 시간
                          Align(
                            alignment: Alignment(
                              Alignment.centerLeft.x + size.width * 0.0005,
                              Alignment.center.y,
                            ),
                            child: Text(
                              '${walkController.timeCount ~/ 3600} : ${walkController.timeCount ~/ 60} : ${walkController.timeCount % 60}',
                              // (_timeCount ~/ 100).toString() + ' 초',
                              style: const TextStyle(
                                  fontSize: 25,
                                  color: Color.fromARGB(255, 80, 78, 91)),
                            ),
                          ),
                          // 산책 거리
                          Align(
                            alignment: Alignment(
                              Alignment.centerRight.x - size.width * 0.0005,
                              Alignment.center.y,
                            ),
                            child: Text(
                              '${walkController.totalDistance} m',
                          // 'data',
                          style: const TextStyle(
                              fontSize: 25,
                              color: Color.fromARGB(255, 80, 78, 91)),
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            )
          ],
        ),
      ),
    );
  }

  void _clickPlayButton() {
    walkController.updateWalkingState();

    if (walkController.isRunning.value) {
      print('timer start');
      walkController.startTimer();
    } else {
      print('timer stop');
      walkController.pauseTimer();
      walkController.latlng = latlng;
      // walkController.latlng.addAll(latlng);
    }
  }
}

class OutlineCircleButton extends StatelessWidget {
  const OutlineCircleButton({
    Key? key,
    this.onTap,
    this.borderSize = 0.5,
    this.radius = 20.0,
    this.borderColor = const Color.fromARGB(255, 160, 132, 202),
    this.foregroundColor = Colors.white,
    this.child,
  }) : super(key: key);

  final onTap;
  final radius;
  final borderSize;
  final borderColor;
  final foregroundColor;
  final child;

  @override
  Widget build(BuildContext context) {
    return ClipOval(
      child: Container(
        width: radius,
        height: radius,
        decoration: BoxDecoration(
          border: Border.all(color: borderColor, width: borderSize),
          color: foregroundColor,
          shape: BoxShape.circle,
        ),
        child: Material(
          color: Colors.transparent,
          child: InkWell(
              child: child ?? const SizedBox(),
              onTap: () async {
                if (onTap != null) {
                  onTap();
                }
              }),
        ),
      ),
    );
  }
}
