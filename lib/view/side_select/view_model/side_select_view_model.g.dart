// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'side_select_view_model.dart';

// **************************************************************************
// StoreGenerator
// **************************************************************************

// ignore_for_file: non_constant_identifier_names, unnecessary_brace_in_string_interps, unnecessary_lambdas, prefer_expression_function_bodies, lines_longer_than_80_chars, avoid_as, avoid_annotating_with_dynamic

mixin _$SideSelectViewModel on _SideSelectViewModelBase, Store {
  final _$currentResponseAtom =
      Atom(name: '_SideSelectViewModelBase.currentResponse');

  @override
  List<ResponseClass> get currentResponse {
    _$currentResponseAtom.reportRead();
    return super.currentResponse;
  }

  @override
  set currentResponse(List<ResponseClass> value) {
    _$currentResponseAtom.reportWrite(value, super.currentResponse, () {
      super.currentResponse = value;
    });
  }

  final _$getInfoAsyncAction = AsyncAction('_SideSelectViewModelBase.getInfo');

  @override
  Future<void> getInfo(String agent, String map, String side) {
    return _$getInfoAsyncAction.run(() => super.getInfo(agent, map, side));
  }

  @override
  String toString() {
    return '''
currentResponse: ${currentResponse}
    ''';
  }
}
