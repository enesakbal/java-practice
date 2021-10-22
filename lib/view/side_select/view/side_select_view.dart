import 'package:flutter/material.dart';
import 'package:lineupsforvalorant/core/base/state/base_state.dart';
import 'package:lineupsforvalorant/core/base/view/base_view.dart';
import 'package:lineupsforvalorant/core/constants/app/app_constants.dart';
import 'package:lineupsforvalorant/core/models/agent_model.dart';
import 'package:lineupsforvalorant/core/models/map_model.dart';
import 'package:lineupsforvalorant/core/models/side_model.dart';
import 'package:lineupsforvalorant/core/theme/app_colors.dart';
import 'package:lineupsforvalorant/view/detail/view/details_view.dart';
import 'package:lineupsforvalorant/view/side_select/view_model/side_select_view_model.dart';
import 'package:lineupsforvalorant/view/video_player.dart';
import 'package:sizer/sizer.dart';

class SideSelectView extends StatefulWidget {
  SideSelectView(
      {Key? key, required this.currentMap, required this.currentAgent})
      : super(key: key);
  Agent currentAgent;
  ValorantMap currentMap;
  @override
  _SideSelectViewState createState() => _SideSelectViewState();
}

class _SideSelectViewState extends BaseState<SideSelectView> {
  late SideSelectViewModel viewModel;

  @override
  Widget build(BuildContext context) {
    return BaseView<SideSelectViewModel>(
        viewModel: SideSelectViewModel(),
        onPageBuilder: (context, model) => buildScaffold(),
        onModelReady: (model) {
          model.init();
          model.setContext(context);
          viewModel = model;
        });
  }

  Widget buildScaffold() {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: appcolor1,
        title: Text(
          'Select a Side for\n${widget.currentMap.mapName}',
          style: TextStyle(fontFamily: 'valorant', fontSize: 20.sp),
          textAlign: TextAlign.center,
        ),
        centerTitle: true,
        elevation: 15,
        toolbarHeight: ApplicationConstants.APPBAR_HEIGHT,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: widget.currentMap.mapName == 'haven'
              ? [
                  _sideBox(Side(side: 'A')),
                  _sideBox(Side(side: 'B')),
                  _sideBox(Side(side: 'C'))
                ]
              : [_sideBox(Side(side: 'A')), _sideBox(Side(side: 'B'))],
        ),
      ),
    );
  }

  Widget _sideBox(
    Side value,
  ) {
    return Center(
      child: InkWell(
        onTap: () async {
          await getInfo(widget.currentAgent.agentName,
              widget.currentMap.mapName, value.side);
          //await getInfo('sova ', 'icebox', 'b');
          //print(currentResponse[0].url.toString());
          await Navigator.push(
              context,
              MaterialPageRoute(
                  builder: (context) => DetailsView(
                        currentAgent: widget.currentAgent,
                        currentMap: widget.currentMap,
                        currentSide: value,
                      )));
        },
        child: Padding(
          padding: EdgeInsets.symmetric(vertical: 3.h),
          child: Container(
            height: 15.h,
            width: 25.h,
            decoration: BoxDecoration(
                color: appcolor1,
                borderRadius: BorderRadius.all(Radius.circular(25))),
            child: Center(
              child: Text(
                value.side + ' Side',
                style: TextStyle(fontFamily: 'valorant', fontSize: 15.sp),
              ),
            ),
          ),
        ),
      ),
    );
  }
}
