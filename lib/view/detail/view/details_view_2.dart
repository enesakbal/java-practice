/*import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:lineupsforvalorant/core/base/state/base_state.dart';
import 'package:lineupsforvalorant/core/base/view/base_view.dart';
import 'package:lineupsforvalorant/core/models/agent_model.dart';
import 'package:lineupsforvalorant/core/models/map_model.dart';
import 'package:lineupsforvalorant/core/models/side_model.dart';
import 'package:lineupsforvalorant/core/theme/app_colors.dart';
import 'package:lineupsforvalorant/view/detail/view_model/details_view_model.dart';
import 'package:sizer/sizer.dart';
import 'package:youtube_player_iframe/youtube_player_iframe.dart';

import '../../video_player.dart';

class DetailsView2 extends StatefulWidget {
  DetailsView2(
      {Key? key,
      required this.currentAgent,
      required this.currentMap,
      required this.currentSide})
      : super(key: key);

  final Agent currentAgent;
  final ValorantMap currentMap;
  final Side currentSide;

  @override
  _DetailsViewState createState() => _DetailsViewState();
}

class _DetailsViewState extends BaseState<DetailsView2>
    with SingleTickerProviderStateMixin {
  late DetailsViewModel viewModel;

  @override
  Widget build(BuildContext context) {
    return BaseView<DetailsViewModel>(
      viewModel: DetailsViewModel(),
      onModelReady: (model) {
        model.setContext(context);
        viewModel = model;

        model.init();
      },
      onPageBuilder: (context, model) => buildScaffold(),
    );
  }

  Widget buildScaffold() {
    return Scaffold(
      appBar: _appbar(),
      body: Padding(
        padding: EdgeInsets.symmetric(horizontal: 1.5.h, vertical: 1.h),
        child: _body(),
      ),
    );
  }

  AppBar _appbar() {
    return AppBar(
      backgroundColor: appcolor1,
      title: Text(
        widget.currentAgent.agentName +
            '\n' +
            widget.currentMap.mapName +
            '\n' +
            widget.currentSide.side +
            ' Side',
        style: TextStyle(
          fontFamily: 'valorant',
          fontSize: 20.sp,
        ),
        textAlign: TextAlign.center,
      ),
      centerTitle: true,
      toolbarHeight: 12.5.h,
    );
  }

// YoutubePlayerIFrame(
//                   controller:
//                       CustomVideoPlayer(currentResponse[index].url.toString())
//                           .getController(),aspectRatio: 8/3,)

  Widget _body() {
    const player = YoutubePlayerIFrame();
    return PageView.builder(
        itemCount: viewModel.currentResponse.length,
        itemBuilder: (_, index) {
          return Text('wdasdsadasdasdsa');
        });
  }
}
*/