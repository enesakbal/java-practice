import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:lineupsforvalorant/core/base/state/base_state.dart';
import 'package:lineupsforvalorant/core/base/view/base_view.dart';
import 'package:lineupsforvalorant/core/constants/map_constants.dart';
import 'package:lineupsforvalorant/core/models/agent_model.dart';
import 'package:lineupsforvalorant/core/models/map_model.dart';
import 'package:lineupsforvalorant/core/theme/app_colors.dart';
import 'package:lineupsforvalorant/view/map_select/view_model/map_select_view_model.dart';
import 'package:lineupsforvalorant/view/side_select/view/side_select_view.dart';
import 'package:sizer/sizer.dart';

class MapSelectView extends StatefulWidget {
  MapSelectView({Key? key, required this.currentAgent}) : super(key: key);

  Agent currentAgent;
  @override
  _MapSelectViewState createState() => _MapSelectViewState();
}

class _MapSelectViewState extends BaseState<MapSelectView> {
  late MapSelectViewModel viewModel;
  @override
  Widget build(BuildContext context) {
    return BaseView<MapSelectViewModel>(
        viewModel: MapSelectViewModel(),
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
          'Select a Map for\n${widget.currentAgent.agentName}',
          style: TextStyle(fontFamily: 'valorant', fontSize: 20.sp),
          textAlign: TextAlign.center,
        ),
        centerTitle: true,
        elevation: 15,
        toolbarHeight: 10.h,
      ),
      body: buildListView(),
    );
  }

  Widget buildListView() {
    return ListView(
      children: List.generate(valorantMapList.length, (index) {
        return Container(
          decoration: BoxDecoration(color: Colors.transparent),
          child: buildContainer(valorantMapList[index]),
        );
      }),
    );
  }

  Widget buildContainer(ValorantMap currentMap) {
    return Column(
      children: [
        SizedBox(
          height: 3.h,
        ),
        ClipRRect(
          borderRadius: BorderRadius.all(Radius.circular(25)),
          child: InkWell(
            child: Container(
              height: 22.5.h,
              width: 80.w,
              decoration: BoxDecoration(color: Colors.red),
              child: FittedBox(
                
                fit: BoxFit.fill,
                child: Image.asset(
                  currentMap.getImagePath(),
                ),
              ),
            ),
            onTap: () {
              Navigator.push(
                  context,
                  MaterialPageRoute(
                      builder: (context) => SideSelectView(
                            currentAgent: widget.currentAgent,
                            currentMap: currentMap,
                          )));
            },
          ),
        ),
        Padding(
          padding: const EdgeInsets.only(top: 8),
          child: Text(
            currentMap.mapName.toUpperCase(),
            textAlign: TextAlign.center,
            style: GoogleFonts.cambay(
              fontSize: 15.sp,
              fontWeight: FontWeight.bold,
              color: Colors.black,
            ),
          ),
        ),
        Divider(
          thickness: 0.25.h,
        ),
      ],
    );
  }
}
