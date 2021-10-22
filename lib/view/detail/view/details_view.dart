import 'dart:ui';
import 'package:flutter/material.dart';
import 'package:flutter_mobx/flutter_mobx.dart';
import 'package:lineupsforvalorant/core/base/state/base_state.dart';
import 'package:lineupsforvalorant/core/base/view/base_view.dart';
import 'package:lineupsforvalorant/core/components/custom_text_button.dart';
import 'package:lineupsforvalorant/core/constants/app/app_constants.dart';
import 'package:lineupsforvalorant/core/models/agent_model.dart';
import 'package:lineupsforvalorant/core/models/map_model.dart';
import 'package:lineupsforvalorant/core/models/side_model.dart';
import 'package:lineupsforvalorant/core/temp_data.dart';
import 'package:lineupsforvalorant/core/theme/app_colors.dart';
import 'package:lineupsforvalorant/view/detail/view_model/details_view_model.dart';
import 'package:lineupsforvalorant/view/video_player.dart';
import 'package:sizer/sizer.dart';
import 'package:youtube_player_iframe/youtube_player_iframe.dart';

class DetailsView extends StatefulWidget {
  const DetailsView(
      {Key? key,
      required this.currentAgent,
      required this.currentMap,
      required this.currentSide})
      : super(key: key);

  @override
  _DetailsViewState createState() => _DetailsViewState();
  final Agent currentAgent;
  final ValorantMap currentMap;
  final Side currentSide;
}

class _DetailsViewState extends BaseState<DetailsView>
    with TickerProviderStateMixin {
  late DetailsViewModel viewModel;
  late AnimationController _controller;
  late Animation<double> _animation;
  @override
  Widget build(BuildContext context) {
    _controller =
        AnimationController(duration: Duration(seconds: 5), vsync: this)
          ..repeat(reverse: true);

    _animation = Tween<double>(begin: 0, end: 1).animate(_controller);
    return BaseView<DetailsViewModel>(
        viewModel: DetailsViewModel(),
        onPageBuilder: (context, model) => _buildScaffold(),
        onModelReady: (model) {
          model.init();
          model.setContext(context);
          viewModel = model;
        });
  }

  Widget _buildScaffold() {
    return Scaffold(
      appBar: _appBar(),
      body: FadeTransition(opacity: _animation, child: _body()),
    );
  }

  AppBar _appBar() {
    return AppBar(
      toolbarHeight: ApplicationConstants.APPBAR_HEIGHT + 2.5.h,
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
    );
  }

  Widget _body() {
    return Column(
      children: [
        Expanded(
          flex: 18,
          child: PageView.builder(
              itemCount: currentResponse.length,
              scrollDirection: Axis.horizontal,
              allowImplicitScrolling: true,
              controller: viewModel.controller,
              onPageChanged: (index) {
                viewModel.pageIndex = index;
              },
              itemBuilder: (context, index) {
                var player = YoutubePlayerIFrame();
                return YoutubePlayerControllerProvider(
                    controller: CustomVideoPlayerController(
                            currentResponse[index].url.toString())
                        .getController(),
                    child: Column(
                      children: [
                        Expanded(
                          child: player,
                          flex: 10,
                        ),
                        Expanded(
                          flex: 1,
                          child: Center(
                            child: Container(
                              decoration: BoxDecoration(color: appcolor2),
                              width: 100.w,
                              child: Center(
                                child: Text(
                                  currentResponse[index].description.toString(),
                                  maxLines: 2,
                                  textAlign: TextAlign.center,
                                  style: TextStyle(
                                    color: Colors.white,
                                    fontSize: 15.sp,
                                    fontFamily: 'valorant',
                                  ),
                                ),
                              ),
                            ),
                          ),
                        ),
                      ],
                    ));
              }),
        ),
        videoSelectBar(),
        //buttons(),
      ],
    );
  }

  Expanded videoSelectBar() {
    return Expanded(
      flex: 2,
      child: Container(
        width: 100.w,
        color: appcolor2,
        child: Center(
          child: ListView.separated(
              scrollDirection: Axis.horizontal,
              shrinkWrap: true,
              itemBuilder: (_, index) {
                return Padding(
                  padding: EdgeInsets.all(3.sp),
                  child: CircleAvatar(
                    child: TextButton(
                      onPressed: () {
                        viewModel.controller.jumpToPage(index);
                        viewModel.pageIndex = index;
                      },
                      child: Center(child: Observer(builder: (_) {
                        return Text(
                          (index + 1).toString(),
                          style: TextStyle(
                              color: viewModel.pageIndex == index
                                  ? Colors.white
                                  : Colors.black,
                              fontFamily: 'valorant'),
                        );
                      })),
                    ),
                    backgroundColor: appcolor1,
                  ),
                );
              },
              separatorBuilder: (context, index) {
                return SizedBox(width: 5);
              },
              itemCount: currentResponse.length),
        ),
      ),
    );
  }

  Expanded buttons() {
    return Expanded(
        flex: 6,
        child: Padding(
          padding: EdgeInsets.symmetric(vertical: 6.h),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.center,
            mainAxisSize: MainAxisSize.max,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Expanded(
                  child: CustomTextButton(
                      title: 'Previous',
                      icon: Icons.navigate_before,
                      onPressed: () async {
                        if (viewModel.pageIndex < list_of_URL.length) {
                          await viewModel.controller.previousPage(
                              duration: Duration(milliseconds: 10),
                              curve: Curves.linear);
                          viewModel.pageIndex--;
                        } else {
                          viewModel.pageIndex = 0;
                          viewModel.controller.jumpToPage(0);
                        }
                      })),
              Expanded(
                  child: CustomTextButton(
                title: 'Next',
                icon: Icons.navigate_next,
                onPressed: () async {
                  if (viewModel.pageIndex < list_of_URL.length) {
                    viewModel.pageIndex++;

                    await viewModel.controller.nextPage(
                        duration: Duration(milliseconds: 100),
                        curve: Curves.easeInSine);
                    print('data');
                  } else {
                    viewModel.pageIndex = 0;
                    viewModel.controller.jumpToPage(0);
                  }
                },
              ))
            ],
          ),
        ));
  }
}
