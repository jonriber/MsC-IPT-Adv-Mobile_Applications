import "package:flutter/material.dart";
import "package:pomodoro/utils.dart";

class PomodoroPage extends StatelessWidget {
  @override
  Widget build(BuildContext context){
    return Scaffold(
      appBar: AppBar(
        elevation: 0,
        backgroundColor: Colors.redAccent,
        title: Text("Pomodoro Timer", style: textStyle(25, Colors.white, FontWeight.w700)),
      ),
    );
  }
}