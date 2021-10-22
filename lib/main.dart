import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:lineupsforvalorant/core/theme/app_colors.dart';
import 'package:lineupsforvalorant/view/agent_select/view/agent_select_view.dart';
import 'package:sizer/sizer.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  SystemChrome.setPreferredOrientations(
      [DeviceOrientation.portraitUp, DeviceOrientation.portraitDown]);
  runApp(Sizer(builder: (context, orientation, devicetype) {
    return MyApp();
  }));
}

class MyApp extends StatefulWidget {
  MyApp({Key? key}) : super(key: key);

  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        theme: ThemeData(
            accentColor: appcolor1,
            textButtonTheme: TextButtonThemeData(
                style: ButtonStyle(backgroundColor: MaterialStateProperty.resolveWith((states) => Colors.transparent)))),
        home: Scaffold(
          body: AgentSelectView(),
        ));
  }
}
