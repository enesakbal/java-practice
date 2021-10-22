import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:lineupsforvalorant/core/base/state/base_state.dart';
import 'package:lineupsforvalorant/core/base/view/base_view.dart';
import 'package:lineupsforvalorant/core/constants/agent_constants.dart';
import 'package:lineupsforvalorant/core/constants/app/app_constants.dart';
import 'package:lineupsforvalorant/core/models/agent_model.dart';
import 'package:lineupsforvalorant/core/theme/app_colors.dart';
import 'package:lineupsforvalorant/view/agent_select/view_model/agent_select_view_model.dart';
import 'package:lineupsforvalorant/view/map_select/view/map_select_view.dart';
import 'package:sizer/sizer.dart';

class AgentSelectView extends StatefulWidget {
  AgentSelectView({Key? key}) : super(key: key);

  @override
  _AgentSelectViewState createState() => _AgentSelectViewState();
}

class _AgentSelectViewState extends BaseState<AgentSelectView> {
  late AgentSelectViewModel viewModel;
  @override
  Widget build(BuildContext context) {
    return BaseView<AgentSelectViewModel>(
        viewModel: AgentSelectViewModel(),
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
          'Select an Agent',
          style: TextStyle(fontFamily: 'valorant', fontSize: 20.sp),
        ),
        centerTitle: true,
        elevation: 15,
        toolbarHeight: ApplicationConstants.APPBAR_HEIGHT
      ),
      body: buildGridView(),
    );
  }

  GridView buildGridView() {
    return GridView.count(
      crossAxisCount: 2,
      padding: EdgeInsets.only(top: 5.h),
      children: List.generate(agentsList.length, (index) {
        return Container(
          decoration: BoxDecoration(color: Colors.transparent),
          child: Center(
            child: buildContainer(agentsList[index]),
          ),
        );
      }),
    );
  }

  Column buildContainer(Agent agent) {
    return Column(
      children: [
        InkWell(
          child: ClipRRect(
              borderRadius: BorderRadius.all(Radius.circular(3.h)),
              child: Container(
                  decoration: BoxDecoration(color: Colors.grey.shade400),
                  child: Image.asset(
                    agent.getImagePath(),
                    fit: BoxFit.fill,
                    height: 17.h,
                    width: 17.h,
                  ))),
          onTap: () {
            Navigator.push(
                context,
                MaterialPageRoute(
                    builder: (context) => MapSelectView(
                          currentAgent: agent,
                        )));
          },
        ),
        Text(
          agent.agentName,
          style: GoogleFonts.athiti(
            fontSize: 15.sp,
            fontWeight: FontWeight.bold,
            color: appcolor2,
          ),
        ),
      ],
    );
  }
}
