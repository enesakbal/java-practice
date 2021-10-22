import 'package:flutter/cupertino.dart';
import 'package:lineupsforvalorant/core/base/model/base_view_model.dart';
import 'package:lineupsforvalorant/core/constants/path/url_path_constants.dart';
import 'package:lineupsforvalorant/core/models/response_class.dart';
import 'package:http/http.dart' as http;
import 'package:mobx/mobx.dart';
import 'package:youtube_player_flutter/youtube_player_flutter.dart';
part 'details_view_model.g.dart';

class DetailsViewModel = _DetailsViewModelBase with _$DetailsViewModel;

abstract class _DetailsViewModelBase with Store, BaseViewModel{
  @override
  void init() {}

  @override
  void setContext(BuildContext context) {
    this.context = context;
  }

  @observable
  int pageIndex = 0;

  @observable
  PageController controller = PageController(
    keepPage: false,
    viewportFraction: 1,
  );



/*********************************************************************************** */

  @observable
  List<ResponseClass> currentResponse = [];

  @observable
  late YoutubePlayerController _controller;

  @action
  Future<void> getInfo(String agent, String map, String side) async {
    await Future.delayed(Duration(milliseconds: 400));
    final json = <String, dynamic>{
      'agent': agent.toLowerCase(),
      'map': map.toLowerCase(),
      'side': side.toLowerCase(),
    };
    print(json);

    final response =
        await http.post(Uri.parse(PathConstants.GET_DATA), body: json);

    print(response.body);
    print(response.statusCode);
    currentResponse = responseClassFromJson(response.body);
  }
}
