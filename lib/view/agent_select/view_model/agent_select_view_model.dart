import 'package:flutter/material.dart';
import 'package:lineupsforvalorant/core/base/model/base_view_model.dart';
import 'package:mobx/mobx.dart';
part 'agent_select_view_model.g.dart';

class AgentSelectViewModel = _AgentSelectViewModelBase
    with _$AgentSelectViewModel;

abstract class _AgentSelectViewModelBase with Store, BaseViewModel {
  @override
  void init() {}
  @override
  void setContext(BuildContext context) {}
}
