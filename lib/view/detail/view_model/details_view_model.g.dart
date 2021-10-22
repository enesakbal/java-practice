// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'details_view_model.dart';

// **************************************************************************
// StoreGenerator
// **************************************************************************

// ignore_for_file: non_constant_identifier_names, unnecessary_brace_in_string_interps, unnecessary_lambdas, prefer_expression_function_bodies, lines_longer_than_80_chars, avoid_as, avoid_annotating_with_dynamic

mixin _$DetailsViewModel on _DetailsViewModelBase, Store {
  final _$pageIndexAtom = Atom(name: '_DetailsViewModelBase.pageIndex');

  @override
  int get pageIndex {
    _$pageIndexAtom.reportRead();
    return super.pageIndex;
  }

  @override
  set pageIndex(int value) {
    _$pageIndexAtom.reportWrite(value, super.pageIndex, () {
      super.pageIndex = value;
    });
  }

  final _$controllerAtom = Atom(name: '_DetailsViewModelBase.controller');

  @override
  PageController get controller {
    _$controllerAtom.reportRead();
    return super.controller;
  }

  @override
  set controller(PageController value) {
    _$controllerAtom.reportWrite(value, super.controller, () {
      super.controller = value;
    });
  }

  final _$currentResponseAtom =
      Atom(name: '_DetailsViewModelBase.currentResponse');

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

  final _$_controllerAtom = Atom(name: '_DetailsViewModelBase._controller');

  @override
  YoutubePlayerController get _controller {
    _$_controllerAtom.reportRead();
    return super._controller;
  }

  @override
  set _controller(YoutubePlayerController value) {
    _$_controllerAtom.reportWrite(value, super._controller, () {
      super._controller = value;
    });
  }

  final _$getInfoAsyncAction = AsyncAction('_DetailsViewModelBase.getInfo');

  @override
  Future<void> getInfo(String agent, String map, String side) {
    return _$getInfoAsyncAction.run(() => super.getInfo(agent, map, side));
  }

  @override
  String toString() {
    return '''
pageIndex: ${pageIndex},
controller: ${controller},
currentResponse: ${currentResponse}
    ''';
  }
}
