import 'package:flutter/material.dart';
import 'package:lineupsforvalorant/core/theme/app_colors.dart';
import 'package:sizer/sizer.dart';

class CustomTextButton extends StatefulWidget {
  final String title;
  final IconData icon;
  final VoidCallback onPressed;

  const CustomTextButton({
    Key? key,
    required this.title,
    required this.icon,
    required this.onPressed,
  }) : super(key: key);

  @override
  _CustomTextButtonState createState() => _CustomTextButtonState();
}

class _CustomTextButtonState extends State<CustomTextButton> {
  @override
  Widget build(BuildContext context) {
    return TextButton(
        style: ButtonStyle(
          foregroundColor:
              MaterialStateProperty.resolveWith((states) => Colors.transparent),
          overlayColor:
              MaterialStateProperty.resolveWith((states) => Colors.transparent),
          backgroundColor:
              MaterialStateProperty.resolveWith((states) => Colors.transparent),
        ),
        onPressed: () {},
        child: Column(
          children: [
            IconButton(
              onPressed: widget.onPressed,
              icon: Icon(
                widget.icon,
                color: Colors.black,
                
              ),
              //tooltip: 'Previous Video',
              iconSize: 7.5.h,
            ),
            Text(widget.title.toString(),
                style: TextStyle(
                    fontFamily: 'valorant', color: appcolor2, fontSize: 15.sp))
          ],
        ));
  }
}
