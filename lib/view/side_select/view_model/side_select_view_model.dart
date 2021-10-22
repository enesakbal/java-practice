import 'dart:convert';
import 'package:http/http.dart' as http;

import 'package:dio/dio.dart';
import 'package:lineupsforvalorant/core/base/model/base_view_model.dart';
import 'package:lineupsforvalorant/core/constants/path/url_path_constants.dart';
import 'package:lineupsforvalorant/core/models/response_class.dart';
import 'package:mobx/mobx.dart';
import 'package:flutter/material.dart';
part 'side_select_view_model.g.dart';

class SideSelectViewModel = _SideSelectViewModelBase with _$SideSelectViewModel;

abstract class _SideSelectViewModelBase with Store, BaseViewModel{

  @observable
  List<ResponseClass> currentResponse = [];
  
    @override
  void init() {
    // TODO: implement init
  }

  @override
  void setContext(BuildContext context){
    this.context = context;
  }

  //  @action
  // Future getInfo(String agent, String map, String side) async {
  //    Response response;
  //     var dio = Dio();
  //     var postMap = {
  //       'agent': agent,
  //       'map': map,
  //       'side': side
  //     };
  //     print(postMap);

  //     response = await dio.post(PathConstants.GET_DATA,
  //         data: postMap,
  //         );

  //     Map parse = json.decode(response.toString());
  //     return parse;

  // }

  @action
  Future<void> getInfo(String agent, String map, String side) async {
    await Future.delayed(Duration(milliseconds:400));
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