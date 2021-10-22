import 'dart:async';
import 'dart:developer';
import 'package:http/http.dart' as http;

import 'package:flutter/services.dart';
import 'package:lineupsforvalorant/core/constants/path/url_path_constants.dart';
import 'package:lineupsforvalorant/core/models/response_class.dart';
import 'package:youtube_player_iframe/src/player_value.dart';
import 'package:youtube_player_iframe/youtube_player_iframe.dart';

List<ResponseClass> currentResponse = [];

Future<void> getInfo(String agent, String map, String side) async {
  final json = <String, dynamic>{
    'agent': agent.toLowerCase(),
    'map': map.toLowerCase(),
    'side': side.toLowerCase(),
  };
  print(json);

  final response =
      await http.post(Uri.parse(PathConstants.GET_DATA), body: json);
  //await Future.delayed(Duration(milliseconds: 100));
  print(response.body);
  print(response.statusCode);
  currentResponse = responseClassFromJson(response.body);
  print(currentResponse.length);
}

class CustomVideoPlayerController {
  final String videoID;
  late YoutubePlayerController controller;
  CustomVideoPlayerController(this.videoID);

  YoutubePlayerController getController() {
    controller = YoutubePlayerController(
      initialVideoId: videoID,
      params: YoutubePlayerParams(
        playlist: [
          videoID,
        ],
        mute: true,
        showControls: true,
        showFullscreenButton: true,
        strictRelatedVideos: false,
        playsInline: true,
        showVideoAnnotations: false,
        enableJavaScript: true,
        privacyEnhanced: true,
        loop: true,
        enableCaption: false,
        desktopMode: true,
        autoPlay: false,
        useHybridComposition: false,
      ),
    );
    controller.onEnterFullscreen = () {
      SystemChrome.setPreferredOrientations([
        DeviceOrientation.landscapeLeft,
        DeviceOrientation.landscapeRight,
      ]);
      log('Entered Fullscreen');
    };

    controller.onExitFullscreen = () {
      log('Exited Fullscreen');

      controller.play();
    };

    controller.listen((event) {});

    return controller;
  }
}
