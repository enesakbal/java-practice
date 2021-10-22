import 'package:flutter/material.dart';
import 'package:lineupsforvalorant/core/base/model/base_view_model.dart';
import 'package:mobx/mobx.dart';
part 'map_select_view_model.g.dart';

class MapSelectViewModel = _MapSelectViewModelBase with _$MapSelectViewModel;

abstract class _MapSelectViewModelBase with Store, BaseViewModel {

  @override
  void init() {
  }
  
  @override
  void setContext(BuildContext context){
  }
  
}